package ua.lviv.lgs;

public class Main {
    public static void main(String[] args) {
        MyClass myObject = new MyClass("Value 1", "Value 2", 42);
        myObject.writeToAnnotationMarkedFieldsToFile("output.txt");
    }
}