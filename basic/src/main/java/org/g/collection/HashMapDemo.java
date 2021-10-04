package org.g.collection;

import java.util.*;
import java.util.stream.Collectors;

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
        Map<String, String> immutableMap = Map.of("color", "black", "drink", "coffee");

        /**
         * Since Java 9
         * Returns an unmodifiable map
         */
        Map<String, String> ofEntries = Map.ofEntries(
                Map.entry("color", "pink"),
                Map.entry("drink", "coffee")
        );
    }

    public void create() {
        /**
         * When new HashMap, it will set:
         *   this.loadFactor = loadFactor;
         *   this.threshold = tableSizeFor(initialCapacity);
         * See HashMap.tableSizeFor(int cap), Returns a power of two size for the given target capacity.
         *
         * When first put operation, it will allocate a table of size 100.
         *
         * When put more than threshold * loadFactor items, it will double table size
         */
        Map<String, String> map = new HashMap(100, 0.75f);
    }

    public void iterateEntries1() {
        Map<String, String> immutableMap = Map.of("color", "black", "drink", "coffee");

        for (Map.Entry<String, String> entry : immutableMap.entrySet()) {
            String k;
            String v;
            try {
                k = entry.getKey();
                v = entry.getValue();
            } catch (IllegalStateException ise) {
                // this usually means the entry is no longer in the map.
                throw new ConcurrentModificationException(ise);
            }
            System.out.println(k + " = " + v);
        }
    }

    public void iterateEntries2() {
        Map<String, String> immutableMap = Map.of("color", "black", "drink", "coffee");

        // The default implementation is equivalent to iterate1
        immutableMap.forEach((key, value)
                -> System.out.println(key + " = " + value));
    }

    public void iterateKeys() {
        Map<String, String> immutableMap = Map.of("color", "black", "drink", "coffee");

        for (String k : immutableMap.keySet()) {
            System.out.println(k);
        }
    }

    public void iterateValues() {
        Map<String, String> immutableMap = Map.of("color", "black", "drink", "coffee");

        for (String v : immutableMap.values()) {
            System.out.println(v);
        }
    }

    public void filter() {
        Map<String, Integer> employees = new HashMap<>();
        employees.put("John", 4000);
        employees.put("Alex", 5550);
        employees.put("Emma", 3850);
        employees.put("Tom", 6000);
        employees.put("Bena", 4500);

        // return a new hashmap
        Map<String, Integer> output = employees.entrySet()
                .stream()
                .filter(e -> e.getValue() > 3000 && e.getValue() < 5000)
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));

        System.out.println(output);
    }

    public void remove() {
        Map<String, Integer> employees = new HashMap<>();
        employees.put("John", 4000);
        employees.put("Alex", 5550);
        employees.put("Emma", 3850);
        employees.put("Tom", 6000);
        employees.put("Bena", 4500);

        System.out.println(employees);

        List<String> keysToRemove = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : employees.entrySet()) {
            String k;
            Integer v;
            try {
                k = entry.getKey();
                v = entry.getValue();
            } catch (IllegalStateException ise) {
                // this usually means the entry is no longer in the map.
                throw new ConcurrentModificationException(ise);
            }

            if (v < 3000 || v > 5000) {
                // Will raise ConcurrentModificationException
//                employees.remove(k);

                // So add key to list, and remove later
                keysToRemove.add(k);
            }
        }

        for (String k : keysToRemove) {
            employees.remove(k);
        }

        System.out.println(employees);
    }
}