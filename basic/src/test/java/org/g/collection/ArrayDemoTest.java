package org.g.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArrayDemoTest {
    ArrayDemo instance = new ArrayDemo();

    @Test
    void createInline() {
    }

    @Test
    void sortAndSearch() {
    }

    @Test
    void join() {
        instance.join();
    }

    @Test
    void distinct1() {
        String[] a = new String[]{"c", "d", "b", "a", "b", "a", "b", "a", "b", "c"};

        String[] expected = new String[]{"a", "b", "c", "d"};
        String[] actual = instance.distinct1(a);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void distinct2() {
        String[] a = new String[]{"c", "d", "b", "a", "b", "a", "b", "a", "b", "c"};

        String[] expected = new String[]{"c", "d", "b", "a"};
        String[] actual = instance.distinct2(a);

        Assertions.assertArrayEquals(expected, actual);
    }
}