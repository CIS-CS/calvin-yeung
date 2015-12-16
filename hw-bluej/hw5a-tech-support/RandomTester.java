import java.util.Random;
import java.util.ArrayList;

public class RandomTester {
    private Random random;
    
    public RandomTester() {
        random = new Random();
    }
    
    public void printOneRandom() {
        printMultiRandom(1);
    }
    
    public void printMultiRandom(int n) {
        for(int i = 0; i < n; i++)
            System.out.println(random.nextInt());
    }
    
    public int throwDice() {
        return random.nextInt(6) + 1;
    }
    
    public String getResponse() {
        int value = random.nextInt(3);
        String response = "";
        
        switch(value) {
            case 0: response = "yes";
                    break;
            case 1: response = "no";
                    break;
            case 2: response = "maybe";
                    break;
        }
        
        return response;
    }
    
    public ArrayList<String> getResponses(int n) {
        ArrayList<String> responses = new ArrayList<String>();
        
        for(int i = 0; i < n; i++)
            responses.add(getResponse());
            
        return responses;
    }
    
    public int randomInclusive(int min, int max) {
        return random.nextInt(max - min) + 1;
    }
}
