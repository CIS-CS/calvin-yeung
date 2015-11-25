Page 68 talks about tracing an algorithm using a trace table.
The trace is recorded in a trace table.
The column headings are the variables used in the algorithm.
Each row in the table shows the values of the variables for each iteration through
the algorithm.

Mystery.java

    This is the original code from the book.
    The application prompts the user for a string, and then reports how many times the
    letter 'a' appears in the string.
    The program works but does not use good programming style, namely,
    the application runs from within the constructor.  The constructor is meant to be
    used to initialize new objects.

Mystery2.java

    Same as the original version except it checks for occurances of 'abc' in the string.

Mystery3.java

    This version is improved because the application does not run from the constructor.
    Instead it runs from the main method.
    But there is a bug in the program.  What happens when you enter the string "abcabc"?
    Edit the code to fix the bug.


