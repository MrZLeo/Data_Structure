package code.Java;

/**
 * @author MrZLeo
 */
public class Test {

    public static double test(){
        long startTime = System.nanoTime();

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

    }
}
