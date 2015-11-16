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
    
    public boolean printAuthor() {
        System.out.printf("Author: %s\n", author);
        return true;
    }
    
    public boolean printTitle() {
        System.out.printf("Title: %s\n", title);
        return true;
    }
    
    public boolean printDetails() {
        printAuthor();
        printTitle();
        System.out.printf("Pages: %d\n", pages);
        if(refNumber.length() > 0)
            System.out.printf("#: %s\n", refNumber);
        System.out.printf("Borrowed: %d\n", borrowed);
        
        return true;
    }
    
    public boolean setRefNumber(String ref) {
        if(ref.length() >= 3) {
            refNumber = ref;
            return true;
        }
        
        else return false;
    }
    
    public boolean borrow() {
        borrowed++;
        return true;
    }
}
