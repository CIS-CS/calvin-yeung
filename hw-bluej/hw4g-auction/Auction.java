import java.util.ArrayList;
import java.util.Iterator;

public class Auction {
    private ArrayList<Lot> lots;
    private int nextLotNumber;

    public Auction() {
        lots = new ArrayList<Lot>();
        nextLotNumber = 1;
    }
    
    public void enterLot(String description) {
        lots.add(new Lot(nextLotNumber, description));
        nextLotNumber++;
    }
    
    public void showLots() {
        for(Lot lot : lots) {
            System.out.println(lot.toString());
        }
    }
    
    public boolean makeABid(int lotNumber, Person bidder, long value) {
        Lot selectedLot = getLot(lotNumber);
        if(selectedLot != null) {
            Bid bid = new Bid(bidder, value);
            boolean successful = selectedLot.bidFor(bid);
            if(successful) {
                System.out.println("The bid for lot number " + lotNumber + " was successful.");
                
            }
            else {
                Bid highestBid = selectedLot.getHighestBid();
                System.out.println("Lot number: " + lotNumber + " already has a bid of: " +
                                   highestBid.getValue());
            }
            
            return successful;
        }
        
        return false;
    }
    
    public Lot getLot(int lotNumber) {
        if((lotNumber >= 1) && (lotNumber < nextLotNumber)) {
            Lot selectedLot = null;
            
            for(Lot l : lots) {
                if(l.getNumber() == lotNumber) {
                    selectedLot = l;
                    break;
                }
            }
            
            return selectedLot;
        }
        
        else {
            System.out.println("Lot number: " + lotNumber +
                               " does not exist.");
            return null;
        }
    }
    
    public boolean removeLot(int num) {
        Iterator<Lot> iter = lots.iterator();
        
        while(iter.hasNext()) {
            Lot lot = iter.next();
            if(lot.getNumber() == num) {
                iter.remove();
                return true;
            }
        }
        
        return false;
    }
    
    public ArrayList<Lot> getUnsold() {
        ArrayList<Lot> unsold = new ArrayList<Lot>();
        
        for(Lot l : lots)
            if(l.getHighestBid() == null) unsold.add(l);
            
        return unsold;
    }
    
    public int close() {
        int count = 0;
        
        for(Lot l : lots) {
            Bid highest = l.getHighestBid();
            
            if(highest != null) {
                Person bidder = highest.getBidder();
                
                if(bidder == null) System.out.println("No Bidder");
                else System.out.println("Highest bidder: " + bidder);
                System.out.println("Winning bid: " + highest.getValue() + "\n");
                
                count++;
            }
        }
        
        return count;
    }
}
