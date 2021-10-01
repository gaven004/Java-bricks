package org.g.collection;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public void createInline() {
        /**
         * This is a compact way of creating a Map. However, it is creating an extra sub-class and
         * initialiser block which is not good. Moreover, it also creates memory leak problems. Therefore,
         * It is good to avoid using this technique.
         */
        HashMap<String, String> m = new HashMap<>() {
            {
                put("key1", "value1");
                put("key2", "value2");
            }
        };

        Map<String, String> map = Collections.singletonMap("color", "black");

        /**
         * Since Java 9
         * Returns an unmodifiable map
         */
        Map<String, String> immutableMap = Map.of("color", "black", "drink","coffee");

        /**
         * Since Java 9
         * Returns an unmodifiable map
         */
        Map<String, String> ofEntries = Map.ofEntries(
                Map.entry("color", "pink"),
                Map.entry("drink", "coffee")
        );
    }
}