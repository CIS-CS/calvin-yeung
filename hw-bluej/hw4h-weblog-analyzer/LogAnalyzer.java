public class LogAnalyzer {
    private int[] hourCounts;
    private LogfileReader reader;

    public LogAnalyzer(String filename) { 
        hourCounts = new int[24];
        reader = new LogfileReader(filename);
    }
    
    public void analyzeHourlyData() {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    public void printHourlyCounts() {
        System.out.println("Hr: Count");
        for(int hour = 0; hour < hourCounts.length; hour++)
            System.out.println(hour + ": " + hourCounts[hour]);
    }
    
    public void printData() {
        reader.printData();
    }
    
    public int numberOfAccesses() {
        int total = 0;
        for(int h : hourCounts)
            total += h;
        return total;
    }
    
    public int busiestHour() {
        int h = -1, hits = Integer.MIN_VALUE;
        
        for(int i = 0; i < hourCounts.length; i++) {
            if(hourCounts[i] > hits) {
                hits = hourCounts[i];
                h = i;
            }
        }
        
        return h;
    }
    
    public int quietestHour() {
        int h = -1, hits = Integer.MAX_VALUE;
        
        for(int i = 0; i < hourCounts.length; i++) {
            if(hourCounts[i] > hits) {
                hits = hourCounts[i];
                h = i;
            }
        }
        
        return h;
    }
    
    public String busiestTwoHourPeriod() {
        int h = -1, hits = Integer.MIN_VALUE;
        
        for(int i = 0; i < hourCounts.length - 1; i++) {
            int sum = hourCounts[i] + hourCounts[i + 1];
            
            if(sum > hits) {
                h = i;
                hits = sum;
            }
        }
        
        return String.format("%d-%d", h, h + 1);
    }
}
