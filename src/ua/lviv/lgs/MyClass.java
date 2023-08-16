package ua.lviv.lgs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class MyClass {
    @CustomAnnotation("Field 1 annotation")
    private String field1;

    private String field2;

    @CustomAnnotation("Field 3 annotation")
    private int field3;

    public MyClass(String field1, String field2, int field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    public void writeToAnnotationMarkedFieldsToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            Class<?> clazz = this.getClass();
            for (java.lang.reflect.Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(CustomAnnotation.class)) {
                    CustomAnnotation annotation = field.getAnnotation(CustomAnnotation.class);
                    String fieldValue = field.get(this).toString();
                    String annotationValue = annotation.value();
                    writer.write("Field: " + field.getName() + "\n");
                    writer.write("Annotation: " + annotationValue + "\n");
                    writer.write("Value: " + fieldValue + "\n\n");
                }
            }
        } catch (IOException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}