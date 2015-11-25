This section of Ch2 shows an example of a complete Java application.
The application prompts the user for two numbers, adds the numbers, and displays
the total to the user.

Avoid coding your programs like the author does in Add.java:  he executes the program
from within the constructor.  This is not good programming practice.

Add.java

    Prompts the user for two numbers, adds the numbers, and displays the total to the user.

Add2.java

    Same as Add.java except that the code is moved from the constructor to the main() method.

Add3.java

    Similar to Add2.java except that main() calls another method to do the addition.

AddModular.java

    The application is now more modular.  All the code has been moved to methods which are
    called from the main() method.

AddModular2.java

    In this version, the application is implemented in a single Java statement.