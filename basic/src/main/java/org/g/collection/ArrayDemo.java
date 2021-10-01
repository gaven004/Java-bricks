package org.g.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

public class ArrayDemo {
    public void createInline() {
        String[] a = new String[]{"hello", "goodbye"};
    }

    public void sortAndSearch() {
        String[] a = new String[]{"hello", "goodbye"};

        Arrays.sort(a);

        int i = Arrays.binarySearch(a, "key");
    }

    public void join() {
        String[] a = new String[]{"hello", "goodbye"};

        // Method 1
        // Return: [hello, goodbye]
        Arrays.toString(a);

        // Method 2
        // Return: hello, goodbye
        String.join(", ", a);

        // Method 3
        // Return: [hello, goodbye]
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (CharSequence cs : a) {
            joiner.add(cs);
        }
        joiner.toString();
    }

    public static String join1(String[] a) {
        return Arrays.toString(a);
    }

    public static String join2(String[] a,
                               CharSequence delimiter) {
        return String.join(delimiter, a);
    }

    public static String join3(String[] a,
                               CharSequence delimiter,
                               CharSequence prefix,
                               CharSequence suffix) {
        StringJoiner joiner = new StringJoiner(delimiter, prefix, suffix);
        for (CharSequence cs : a) {
            joiner.add(cs);
        }
        return joiner.toString();
    }

    // Can not keep the original order
    public static String[] distinct1(String[] a) {
        if (a == null)
            return null;

        int l = a.length;
        Set<String> set = new HashSet<>(l);
        for (int i = 0; i < l; i++) {
            set.add(a[i]);
        }

        String[] d = new String[set.size()];

        return set.toArray(d);
    }

    // Keep the original order
    public static String[] distinct2(String[] a) {
        if (a == null)
            return null;

        return Arrays.stream(a).distinct().toArray(String[]::new);
    }
}
