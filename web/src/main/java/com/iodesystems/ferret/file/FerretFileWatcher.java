package com.iodesystems.ferret.file;

import com.iodesystems.ferret.xsd.Ferret;

import java.io.File;
import java.util.Properties;

public abstract class FerretFileWatcher extends FileWatcher {

    private final FerretReader ferretReader;

    public FerretFileWatcher(FerretReader ferretReader) {
        this.ferretReader = ferretReader;
    }

    public abstract void onFerret(Ferret ferret);

    @Override
    public File getFile() throws Exception {


        Properties properties = System.getProperties();
        String ferretHome = properties.getProperty("ferret.home");
        if (ferretHome == null) {
            throw new IllegalArgumentException("Could not locate ferret.home property");
        }

        File ferretHomeDir = new File(ferretHome);
        if (!ferretHomeDir.isDirectory()) {
            throw new IllegalArgumentException("ferret.home: " + ferretHomeDir.getAbsolutePath() + " is not a directory");
        }
        File ferretXml = new File(ferretHomeDir, "ferret.xml");
        if (!ferretXml.isFile()) {
            throw new IllegalArgumentException(ferretXml.getAbsolutePath() + " is not a file");
        }
        return ferretXml;
    }

    @Override
    public void onFileChange(File file) throws Exception {
        onFerret(ferretReader.read(file));
    }
}
