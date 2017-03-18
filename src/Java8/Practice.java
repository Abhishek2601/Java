package Java8;

/**
 * Created by abhishekshukla on 3/18/17.
 */
interface java8{
    static String getName(){
        return "Hello";
    }
}
public class Practice {
    public static void main(String [] args){
        String name = java8.getName();
        System.out.print(name);
    }
}
