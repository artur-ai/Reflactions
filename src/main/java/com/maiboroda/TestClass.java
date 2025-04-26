package com.maiboroda;

public class TestClass {
    private int number = 5;
    private String text = "Hello";
    protected byte a = 1;
    short b = 2;

    public TestClass() {
    }

    public void publicMethods() {
        System.out.println("This method is public");
    }

    private void privateMethods() {
        System.out.println("This method is private");
    }

    final void finalMethods() {
        System.out.println("This method is final");
    }

    protected void protectedMethod(){
        System.out.println("This method is protected");
    }

    void DefaultMethod(){
        System.out.println("This method is default");
    }

    public class SuperClass{
    }

    public interface TestInterface{

    }

    public class ChildClass extends SuperClass implements TestInterface {

    }
}

