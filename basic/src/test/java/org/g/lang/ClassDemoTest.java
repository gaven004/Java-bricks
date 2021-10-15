package org.g.lang;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URL;

import org.junit.jupiter.api.Test;

class ClassDemoTest {

    @Test
    void loadResource() {
        URL url = this.getClass().getResource("META-INF/persistence.xml");
        assertNull(url);

        url = this.getClass().getResource("/META-INF/persistence.xml");
        assertNotNull(url);

        url = Thread.currentThread().getContextClassLoader().getResource("META-INF/persistence.xml");
        assertNotNull(url);

        System.class.getResource("META-INF/persistence.xml");
        assertNotNull(url);
    }
}