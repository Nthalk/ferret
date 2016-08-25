package com.iodesystems.ferret;

import com.iodesystems.ferret.file.FerretReader;
import com.iodesystems.ferret.route.Routeable;
import com.iodesystems.ferret.ui.UiResolver;
import com.iodesystems.ferret.xsd.Ferret;
import com.iodesystems.fn.Fn;
import org.junit.Test;

import static org.junit.Assert.assertNull;

public class FerretReaderTest {

    @Test
    public void testEmpty() throws Exception {
        FerretReader reader = new FerretReader();
        Ferret read = reader.read(getClass().getClassLoader().getResource("ferret/empty.xml").openStream());
        assertNull(read.getData());
    }

    @Test
    public void testTypes() throws Exception {
        FerretReader reader = new FerretReader();
        Ferret read = reader.read(getClass().getClassLoader().getResource("ferret/types.xml").openStream());
    }

    @Test
    public void testRoutes() throws Exception {
        FerretReader reader = new FerretReader();
        Ferret ferret = reader.read(getClass().getClassLoader().getResource("ferret/routes.xml").openStream());
        UiResolver uiResolver = new UiResolver(ferret.getUi());
        Fn<Routeable> routeables = Fn.of(ferret.getRoute()).convert(action -> new Routeable(uiResolver, action));
        System.out.println(routeables.first().get().toString());

    }
}
