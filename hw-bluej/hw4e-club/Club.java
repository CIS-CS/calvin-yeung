import java.util.ArrayList;

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
}
