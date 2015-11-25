package page109_StringManipulation;

import original.IBIO;
    
/**
 *  Uses StringBuffers to do limited tokenization.
 *  A string is stored in a StringBuffer.  The string is tokenized.  Each token
 *  is placed in a StringBuffer, which are stored in an array.
 *
 *  This Class should be adapted to tokenise a String entered by the user.
 *  This would illustrate the limitations of this example.
 *
 *  Not a substitute for Java's  StringTokenizer Class.
 * 
 *  @author Richard 
 *  @version 061003
 */
public class Tokenizer
{
    private static final int MAX = 6;             // maximum tokens in a string
    private static final int LONGEST_TOKEN = 20;  // length of longest single token
    private static final char SPACE = ' ';        // token separator (delimiter)
        
    // Original string
    private StringBuffer message = new StringBuffer("Henry the Human Fly");    
    // Store the tokens here
    private StringBuffer[] data = new StringBuffer[MAX];  
    
    public static void main(String[] args)
    {
        Tokenizer t = new Tokenizer();
        t.tokenize(t.message);
        t.displayWords();        
    }
    
    private void tokenize(StringBuffer message)
    {
        int pos = 0;                              // position in the String
        int count = 0;                            // element in data array
        int len = message.length();               // length of initial String
        
        // loop through message until end or no more space for tokens
        while ( (pos < len) && (count < MAX) )
        {
            // Original array just a set of empty object references, so construct new instance
            // for each array element
            data[count] = new StringBuffer(LONGEST_TOKEN);
            
            // find end of current token, marked by a space
            while ( (pos < len) && (message.charAt(pos)!=(SPACE)) )
            {
                data[count].append(message.charAt(pos));
                pos = pos + 1;
            }
            count = count + 1;
            pos = pos + 1;
        }
    }
    
    private void displayWords()
    {
        for(int i = 0; i < MAX; i++)
        {
            IBIO.output(i + " - " + data[i]);
        }
    }
}
