package com.iodesystems.ferret.file;

import org.junit.Test;

import java.io.File;
import java.net.URL;

public class FerretLoaderTest {
    @Test
    public void testEmpty() throws Exception {
        URL resource = getClass().getClassLoader().getResource("ferret/empty.xml");
        FerretLoader subject = new FerretLoader(new File(resource.getFile()).getAbsolutePath());
    }

    @Test
    public void testKitchenSink() throws Exception {
        URL resource = getClass().getClassLoader().getResource("ferret/kitchen_sink.xml");
        FerretLoader subject = new FerretLoader(new File(resource.getFile()).getAbsolutePath());
    }
}