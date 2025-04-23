import java.lang.reflect.Constructor;

public class Reflactions {
    public static Object createObject(Class<?> clazz) {
        try {
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            return constructor.newInstance();
        } catch (Exception E) {
            E.printStackTrace();
            return null;
        }
    }

    public static void ObjectNoParamets() {
        Class<?>
    }
}
