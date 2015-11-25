User-defined classes
--------------------
This section talks about user-defined classes (the ones you write) as opposed
to the built-in classes (in the Java library).

String and Math are two classes from the Java library.
The classes in the library are meant to be used by other classes, namely,
the classes that you write.  
The classes in the library will not have a main() method.

Note also that you can define classes in different packages.
The Time class below is defined in this package but used in the page077 package.

Time.java
---------
    This is an improved version of the code from the red book.
    Stores the time of day as: HH AM, or HH PM.
    This class is used by TimeApp in package page077_Exceptions.
    Throws an exception if the time is invalid.

    Note, this class also illustrates the use of the throw and throws key
    words.  See the package on Exceptions, page077_Exceptions.

    Any method can throw an exception if something goes wrong in the method.
    If a method can throw an exception, then the signature should include
    the throws key word, along with the exception(s) that can be thrown.


