package com.iodesystems.ferret.file;

import com.iodesystems.ferret.xsd.DataConnection;
import com.iodesystems.ferret.xsd.Ferret;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.InputStream;

public class FerretReader {

    private final Unmarshaller unmarshaller;

    public FerretReader() {
        try {
            unmarshaller = JAXBContext.newInstance(Ferret.class).createUnmarshaller();
        } catch (JAXBException e) {
            throw new RuntimeException("Could not create unmarshaller", e);
        }
    }

    public Ferret read(File file) throws JAXBException {
        return unmarshaller.unmarshal(new StreamSource(file), Ferret.class).getValue();
    }

    public Ferret read(InputStream inputStream) throws JAXBException {
        return unmarshaller.unmarshal(new StreamSource(inputStream), Ferret.class).getValue();
    }
}
