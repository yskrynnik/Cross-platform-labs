package helloworldapp;

import Library.LibClass;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        String result = LibClass.acrostic(args);
        System.out.println("Result = " + result);
    }
}
