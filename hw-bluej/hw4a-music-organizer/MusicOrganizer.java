import java.util.ArrayList;

public class MusicOrganizer {
    private ArrayList<String> files;
    
    public MusicOrganizer() {
        files = new ArrayList<String>();
    }
    
    public void addFile(String fileName) {
        files.add(fileName);
    }
    
    public int getNumberOfSongs() {
        return files.size();
    }
    
    public boolean validIndex(int i) {
        return i >= 0 && i < getNumberOfSongs();
    }
    
    public void checkIndex(int i) {
        if(!validIndex(i))
            System.out.printf("Not within range. Valid range: 0-%d\n", files.size());
    }
    
    public boolean listFile(int index) {
        if(validIndex(index)) {
            String fileName = files.get(index);
            System.out.println(fileName);
            return true;
        }
        
        return false;
    }
    
    public boolean removeFile(int index) {
        if(validIndex(index)) {
            files.remove(index);
            return true;
        }
        
        return false;
    }
}
