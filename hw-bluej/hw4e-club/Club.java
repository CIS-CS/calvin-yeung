import java.util.ArrayList;
import java.util.Iterator;

public class Club {
    private ArrayList<Membership> members;
    
    public Club() {
        members = new ArrayList<Membership>();
    }

    public boolean join(Membership member) {
        boolean contains = false;
        for(Membership m : members) {
            if(member == m) {
                contains = true;
                break;
            }
        }
        
        if(!contains) members.add(member);
        return !contains;
    }
    
    public int numberOfMembers() {
        return members.size();
    }
    
    public ArrayList<Membership> purge(int month, int year) {
       ArrayList<Membership> p = new ArrayList<Membership>();
        
       if(month < 1 || month > 12) {
           System.err.printf("Error: month must be in range 1-12!\n");
           return null;
       }
       
       Iterator<Membership> iter = members.iterator();
       while(iter.hasNext()) {
           Membership m = iter.next();
           
           if(m.getMonth() == month && m.getYear() == year) {
               p.add(m);
               iter.remove();
           }
       }
               
       return p;
    }
}
