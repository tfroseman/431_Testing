import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Lab8.PACKAGE_NAME
 * thomasroseman on 3/21/16
 */
public class Parser {

    public static void main(String[] args) {
        Class classObject;
        Field fields[];
        Constructor constructor[];
        Method methods[];
        try {
            classObject = Class.forName("NewClass");
            fields = classObject.getDeclaredFields();
            constructor = classObject.getDeclaredConstructors();
            methods = classObject.getDeclaredMethods();


            System.out.println("Compiled from " + classObject + ".java");

            for (int i = 0; i < constructor.length; i++) {
                System.out.println(constructor[i]);
                System.out.print("{\n");

                for (Field field : fields) System.out.println("\t" + field + ";");

                System.out.println("\t" + constructor[i] + ";");

                for (Method method : methods){
                    //System.out.print("\n"+method.toString() +" \n");


                    System.out.print("\t" + Modifier.toString(method.getModifiers()) + " ");
                    System.out.print(method.getReturnType() + " ");
                    System.out.print(method.getName() + " (");

                    for (int j = 0; j < method.getParameterCount(); j++) {
                        if(j == method.getParameterCount()-1){
                            System.out.print(method.getParameterTypes()[j].toString()+ " " +(j+1));
                        }else{
                            System.out.print(method.getParameterTypes()[j].toString()+ " " +(j+1)+", ");
                        }

                    }
                    System.out.print(")\n");
                }
                System.out.println("}");

            }
        } catch (ClassNotFoundException | SecurityException e) {
            //System.out.println(e.getMessage());
        }
    }

}
