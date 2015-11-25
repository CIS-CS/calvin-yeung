package page109_StringManipulation;
import original.IBIO;
/**
 *  Uses StringBuffers to do limited tokenization.
 *  A string is stored in a StringBuffer.  The string is tokenized.  Each token
 *  is placed in a StringBuffer, which are stored in an array.
 *  
 *  Prompts the user for a String. Tokenizes the string. Stores the tokens in a
 *  StringBuffer.
 *
 *  Not a substitute for Java's  StringTokenizer Class!
 *
 *  @author Richard
 *  @version 061003
 */
public class Tokenizer2
{
    private static final int  MAX = 6;             // maximum tokens in a string
    private static final int  LONGEST_TOKEN = 20;  // length of longest single token
    private static final char SPACE = ' ';         // token separator

    // The original message
    private String message = "Henry the Human Fly";

    // An array of StringBuffers.  Each buffer will hold one token.
    private StringBuffer[] tokens = new StringBuffer[MAX];


    public static void main(String[] args)
    {
        new Tokenizer2();
    }

    /**
     * Constructor
     */
    public Tokenizer2()
    {
        while( !(message = IBIO.input("Enter a sentence: ")).equals("") )
        {
            tokenize(message);
            printWords();
            clearBuffers();
        }
    }

    private void tokenize(String message)
    {
        int pos = 0;                              // position in the String
        int count = 0;                            // element in data array
        int len = message.length();               // length of initial String

        // loop through message until end or no more space for tokens
        while ( (pos < len) && (count < MAX) )
        {
            // Original array just a set of empty object references, so construct new instance
            // for each array element
            tokens[count] = new StringBuffer(LONGEST_TOKEN);

            // find end of current token, marked by a space
            while ( (pos < len) && (message.charAt(pos)!=(SPACE)) )
            {
                tokens[count].append(message.charAt(pos));
                pos = pos + 1;
            }
            count = count + 1;
            pos = pos + 1;
        }
    }

    private void printWords()
    {
        for(int x = 0; x < MAX; x = x + 1)
        {
            IBIO.output(x + " - " + tokens[x]);
        }
    }

    private void clearBuffers()
    {
        // Erase each token
        for(int x = 0; x < MAX; x = x + 1)
        {
            //if (tokens[x] != null) tokens[x].setLength(0);
            if (tokens[x] != null) tokens[x] = null;
        }
    }

}
