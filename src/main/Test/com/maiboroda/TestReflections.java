package com.maiboroda;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestReflections {

    @Test
    public void creatObjectTest() throws ReflectiveOperationException {
        Object object = Reflections.createObject(TestClass.class);

        System.out.println("Created object: " + object);
        System.out.println("Class of object: " + object.getClass());
        assertNotNull(object);
        assertTrue(object instanceof TestClass);
    }

    @Test
    public void causeObjectNoParametsTest() throws ReflectiveOperationException {
        TestClass testObject = new TestClass();
        assertDoesNotThrow(() -> Reflections.causeObjectNoParamets(testObject));
    }

    @Test
    public void  printFinalMethodsTest(){
        TestClass testObj = new TestClass();
        Reflections.printFinalMethods(testObj);
    }

    @Test
    public void printNonPublicMethodsTest(){
        Reflections.printNonPublicMethods(TestClass.class);
    }

    @Test
    public void printSuperClassAndInterfaceTest(){
        Reflections.printSuperClassAndInterface(TestClass.ChildClass.class);
    }

    @Test
    public void resetPrivateFieldsToDefaultTest () throws IllegalAccessException, NoSuchFieldException{
        TestClass testObj = new TestClass();
        Field numberField = TestClass.class.getDeclaredField("number");
        numberField.setAccessible(true);
        assertEquals(5, numberField.getInt(testObj));

        Field stringField = TestClass.class.getDeclaredField("text");
        stringField.setAccessible(true);
        assertEquals("Hello", (String) stringField.get(testObj));

        Reflections.resetPrivateFieldsToDefault(testObj);
        assertEquals(0, numberField.getInt(testObj));
        assertNull((String) stringField.get(testObj));
    }

}
