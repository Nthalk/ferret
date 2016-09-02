package com.iodesystems.ferret.file;

import com.iodesystems.ferret.xsd.Ferret;
import com.iodesystems.ferret.xsd.Route;
import com.iodesystems.ferret.xsd.RouteController;
import com.iodesystems.fn.Fn;
import org.springframework.context.annotation.Bean;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.util.List;

public class FerretLoader {

    private final Unmarshaller unmarshaller;
    private final String ferretXmlPath;

    public FerretLoader(String ferretXmlPath) {
        this.ferretXmlPath = ferretXmlPath;
        try {
            unmarshaller = JAXBContext.newInstance(Ferret.class).createUnmarshaller();
        } catch (JAXBException e) {
            throw new RuntimeException("Could not create unmarshaller", e);
        }
    }

    @Bean
    public Ferret ferret() throws JAXBException {
        return unmarshaller.unmarshal(new StreamSource(ferretXmlPath), Ferret.class).getValue();
    }

    @Bean
    public List<Route> routes(Ferret ferret) {
        return Fn
            .of(ferret.getRoutes().getRouteControllers())
            .multiply(this::routes).toList();
    }

    private Iterable<Route> routes(RouteController controller) {
        return Fn.ofNullable(controller.getCreateRoute(),
                             controller.getListRoute(),
                             controller.getShowRoute())
            .join(Fn.ofNullable(controller.getShowRoute()).multiply(
                s -> Fn
                    .ofNullable(s.getDeleteRoute(), s.getUpdateRoute())
                    .join(Fn.of(s.getControllers()).multiply(this::routes))));
    }
}
