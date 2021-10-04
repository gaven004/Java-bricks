package org.g.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class ListDemo {
    public void create() {
        List<Integer> list = Arrays.asList(1, 2, 3);
    }

    public static <T> List<T> distinct1(List<T> src) {
        return src.stream().distinct().collect(Collectors.toList());
    }

    public static <T> List<T> distinct2(List<T> src) {
        LinkedHashSet<T> set = new LinkedHashSet<>(src);
        return new ArrayList<>(set);
    }
}
