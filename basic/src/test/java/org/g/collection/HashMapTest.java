package org.g.collection;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class HashMapTest {
    HashMapDemo instance = new HashMapDemo();

    @Test
    void create() {
        Map<Integer, Integer> map = new HashMap(10, 0.75f);

         for (int i = 0; i < 20; i++) {
            map.put(i, i);
        }
    }

    @Test
    void filter() {
        instance.filter();
    }

    @Test
    void remove() {
        instance.remove();
    }
}