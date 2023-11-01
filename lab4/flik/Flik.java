package flik;

/** An Integer tester created by Flik Enterprises.
 * @author Josh Hug
 * */
public class Flik {
    /** @param a Value 1
     *  @param b Value 2
     *  @return Whether a and b are the same */
    public static boolean isSameNumber(Integer a, Integer b) {
        return a.equals(b);
        // In the context of objects, == checks to see if the variables refer to the same object reference.
        //
        //To compare the value of the objects you should use the equals() method.
    }
}
