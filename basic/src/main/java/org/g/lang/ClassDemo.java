package org.g.lang;

public class ClassDemo {
    public void loadResource() {
        /**
         * it will attempt to load foo.txt from the same package as the "this" class
         * and with the class loader of the "this" class.
         */
        this.getClass().getResource("foo.txt");

        /**
         * it will load the resource from the class loader of "this" and from the x.y.z package
         * it will need to be in the same directory as classes in that package
         */
        this.getClass().getResource("/x/y/z/foo.txt");

        /**
         * A ClassLoader can be passed (shared) when creating a new thread using Thread.setContextClassLoader,
         * so that different thread contexts can load each other classes/resources.
         * If not set, the default is the ClassLoader context of the parent Thread.
         *
         * It will load with the context class loader but will not resolve the name according to any package
         * (it must be absolutely referenced)
         */
        Thread.currentThread().getContextClassLoader().getResource("/x/y/z/foo.txt");

        /**
         * ClassLoader.getSystemClassLoader() gives the class loader used to start the application.
         *
         * It will load the resource with the system class loader
         * (it would have to be absolutely referenced as well)
         */
        System.class.getResource("/x/y/z/foo.txt");

        /**
         * Also indicates that getResourceAsStream just calls "openStream" on the URL
         * returned from getResource and returns that.
         */
    }
}
