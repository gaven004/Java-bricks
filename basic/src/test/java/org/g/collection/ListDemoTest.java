package org.g.collection;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class ListDemoTest {

    @Test
    void distinct1() {
        List<Integer> list = Arrays.asList(2, 3, 4, 6, 1, 2, 9, 1);
        System.out.println(list);

        list = ListDemo.distinct1(list);
        System.out.println(list);
    }

    @Test
    void distinct2() {
        List<Integer> list = Arrays.asList(2, 3, 4, 6, 1, 2, 9, 1);
        System.out.println(list);

        list = ListDemo.distinct2(list);
        System.out.println(list);
    }
}