package page110_StringMethods;

/**
 * A simple program that uses more methods from the String class.
 * Uses: equals, substring, length, compareTo
 */
public class StringDemo {
    
    public static void main(String[] args) {
        
        String s1 = "abc";
        String s2 = "def";
        boolean isEqual;
        
        // Equality
        isEqual = s1.equals(s2);    // false
        s2 = s1;
        isEqual = s1.equals(s2);    // true

        // sub strings
        String s3 = s1.substring(0);    // s3 = "abc"
        s3 = s1.substring(0,1);         // s3 = "a"
        s3 = s1.substring(2);           // s3 = "c"
        s3 = s1.substring(0,3);         // s3 = "abc"
        //s3 = s1.substring(0,4);         // StringIndexOutOfBoundsException
        
        //if (s1.contains(s2)) {
                            
        // string length
        int length = s1.length();       // length = 3
        
        // lexical comparison
        s1 = "abc";
        s2 = "abc ";
        int compare = s1.compareTo(s2);       // compare = -3
        //compare = s2.compareTo(s1);         // compare = 3
        //compare = s1.compareTo(s1);         // compare = 0
        
        char c = ' ';
        int i = (int)c;
        
        System.out.println(i);
    }    
}
