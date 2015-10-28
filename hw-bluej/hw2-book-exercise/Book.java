/**
 * A class that maintains information on a book.
 * This might form part of a larger application such
 * as a library system, for instance.
 *
 * @author (Insert your name here.)
 * @version (Insert today's date here.)
 */
class Book
{
    private String author;
    private String title;
    private String refNumber;
    private int pages;
    private int borrowed;
    private boolean courseText;

    /**
     * Set the author and title fields when this object
     * is constructed.
     */
    public Book(String bookAuthor, String bookTitle, int pages, boolean courseText)
    {
        author = bookAuthor;
        title = bookTitle;
        this.pages = pages;
        this.courseText = courseText;
        
        refNumber = "";
        borrowed = 0;
    }
    

    public String getAuthor() {
        return author;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getRefNumber() {
        return refNumber;
    }
    
    public int getPages() {
        return pages;
    }
    
    public int getBorrowed() {
        return borrowed;
    }
    
    public boolean isCourseText() {
        return courseText;
    }
    
    public void printAuthor() {
        System.out.printf("Author: %s\n", author);
    }
    
    public void printTitle() {
        System.out.printf("Title: %s\n", title);
    }
    
    public void printDetails() {
        printAuthor();
        printTitle();
        System.out.printf("Pages: %d\n", pages);
        if(refNumber.length() > 0)
            System.out.printf("#: %s\n", refNumber);
        System.out.printf("Borrowed: %d\n", borrowed);
    }
    
    public void setRefNumber(String ref) {
        if(ref.length() >= 3)
            refNumber = ref;
        else
            System.out.println("Ref Number must be at least 3 characters!");
    }
    
    public void borrow() {
        borrowed++;
    }
}
