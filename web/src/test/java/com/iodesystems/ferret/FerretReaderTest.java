package com.iodesystems.ferret;

import com.iodesystems.ferret.file.FerretReader;
import com.iodesystems.ferret.xsd.Ferret;
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
}
