import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;
import entities.AccountOrder;
public class Test
{
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException
    {
        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            String className = scanner.next();
            Class adaptive = Class.forName(className);
            Constructor constructor = adaptive.getConstructor();
            Object o = constructor.newInstance();
            Method[] methods = adaptive.getDeclaredMethods();
            for(Method method : methods)
            {
                System.out.println(method.getName());
            }
        }

    }
}
