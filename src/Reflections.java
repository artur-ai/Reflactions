import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Reflections {
    public static Object createObject(Class<?> clazz) {
        try {
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            return constructor.newInstance();
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static void causeObjectNoParamets(Object object) {
        Class<?> clazz = object.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.getParameterCount() == 0) {
                try {
                    method.setAccessible(true);
                    method.invoke(object);
                } catch (Exception exception) {
                    System.out.println("Can not cause " + method.getName());
                }
            }
        }
    }
    public static void printFinalMethods(Object object){
        Class<?> clazz = object.getClass();
        for (Method method : clazz.getDeclaredMethods()){
            if (Modifier.isFinal(method.getModifiers())){
                System.out.println(method);
            }
        }
    }

    public void printNonPublicMethods(Class<?> clazz){
        for (Method method : clazz.getDeclaredMethods()){
            if (Modifier.isPublic(method.getModifiers())){
                System.out.println(method);
            }
        }
    }

    public static void printSuperClassAndInterface(Class<?> clazz){
        Class<?> current = clazz.getSuperclass();
        while (current != null){
            System.out.println(" - " + current.getName());
            current = current.getSuperclass();
        }

        for (Class<?> interfac : clazz.getInterfaces()){
            System.out.println(" - " + interfac.getName());
        }
    }

    public static void resetPrivateFieldsToDefault(Object object){
        Class<?> clazz = object.getClass();
        for (Field field : clazz.getDeclaredFields()){
            field.setAccessible(true);

            try {
                Class<?> type = field.getType();
                if (type.isPrimitive()){

                }
            } catch (){
            }

        }
    }


}

