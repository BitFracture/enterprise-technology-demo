package com.bitfracture.etd.resources;

import org.junit.jupiter.api.Test;

public class ResourceTests {

    @Test
    void testDateFormat() {

        DateType type = DateType.now();
        type.serialize();
    }
}
