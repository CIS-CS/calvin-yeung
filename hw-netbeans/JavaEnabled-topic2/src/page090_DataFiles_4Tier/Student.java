package page090_DataFiles_4Tier;

/**
 *  This class defines a Student object.
 * @author CIS
 */
public class Student {
    
    private String name;
    private int    age;
    
    //--------------------------------------- Constructors
    public Student(String name, int age)
    {
        this.name = name;
        this.age = age;
    }    
    
    //--------------------------------------- Set methods
    public void setName(String name)
    {
        this.name = name;
    }
    public void setAge(int age)
    {
       this.age = age; 
    }
     
    //--------------------------------------- Get methods
    public String getName()
    {
        return name;
    }
    public int getAge()
    {
        return age;
    } 
    
    //--------------------------------------- toString
    public String toString()
    {
        return name + " + " + age;
    }    
}
