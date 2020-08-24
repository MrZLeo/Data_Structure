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
            String s1 = "ac"+ "def";
            String s2 = new String("acdef");
            if(s1.equals(s2)) {
                System.out.println("==succeeded");
            }
            if(s1==s2) {
                System.out.println(".equals() succeeded");
            }
    }
}
