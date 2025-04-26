package com.maiboroda;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class Reflections {
    public static Object createObject(Class<?> clazz) throws ReflectiveOperationException {
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        return constructor.newInstance();
    }

    public static void causeObjectNoParamets(Object object) throws ReflectiveOperationException {
        Class<?> clazz = object.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.getParameterCount() == 0) {
                method.setAccessible(true);
                method.invoke(object);
            }
        }
    }

    public static void printFinalMethods(Object object) {
        Class<?> clazz = object.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (Modifier.isFinal(method.getModifiers())) {
                System.out.println(method);
            }
        }
    }

    public static void printNonPublicMethods(Class<?> clazz) {
        for (Method method : clazz.getDeclaredMethods()) {
            if (!Modifier.isPublic(method.getModifiers())) {
                System.out.println(method);
            }
        }
    }

    public static void printSuperClassAndInterface(Class<?> clazz) {
        Class<?> current = clazz.getSuperclass();
        while (current != null) {
            System.out.println(" - " + current.getName());
            current = current.getSuperclass();
        }

        for (Class<?> interfac : clazz.getInterfaces()) {
            System.out.println(" - " + interfac.getName());
        }
    }

    public static void resetPrivateFieldsToDefault(Object object) throws IllegalAccessException {
        Class<?> clazz = object.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);

            Class<?> type = field.getType();
            if (type.isPrimitive()) {
                if (type == boolean.class) field.setBoolean(object, false);
                else if (type == int.class) field.setInt(object, 0);
                else if (type == byte.class) field.setByte(object, (byte) 0);
                else if (type == short.class) field.setShort(object, (short) 0);
                else if (type == long.class) field.setLong(object, 0L);
                else if (type == float.class) field.setFloat(object, 0.0f);
                else if (type == double.class) field.setDouble(object, 0.0d);
                else if (type == char.class) field.setChar(object, '\u0000');
            } else {
                field.set(object, null);
            }
        }
    }

}


