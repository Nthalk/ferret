package com.iodesystems.ferret.file;

import com.iodesystems.ferret.xsd.*;

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

    public Ferret readAndResolveImports(File file) throws JAXBException {
        Ferret ferret = read(file);
        for (Import anImport : ferret.getImports()) {
            File importFile = new File(anImport.getResource());
            if (!importFile.isAbsolute()) {
                importFile = new File(file.getParentFile(), anImport.getResource().toString());
            }
            Ferret ferretImport = readAndResolveImports(importFile);

            extendTypes(ferretImport.getTypes(), ferret.getTypes());
            extendData(ferretImport.getData(), ferret.getData());
            extendUi(ferretImport.getUi(), ferret.getUi());
            extendRoute(ferretImport.getRoutes(), ferret.getRoutes());
            extendSecurity(ferretImport.getSecurity(), ferret.getSecurity());
        }
        return ferret;
    }

    private void extendSecurity(Security merge, Security into) {

    }

    private void extendRoute(Routes merge, Routes into) {

    }

    private void extendTypes(Types merge, Types into) {

    }

    private void extendUi(UserInterfaces merge, UserInterfaces into) {

    }

    private void extendData(Data merge, Data into) {

    }

    public Ferret read(InputStream inputStream) throws JAXBException {
        return unmarshaller.unmarshal(new StreamSource(inputStream), Ferret.class).getValue();
    }
}
