import java.util.ArrayList;

public class MusicOrganizer {
    private ArrayList<String> files;
    private MusicPlayer player;
    
    public MusicOrganizer() {
        files = new ArrayList<String>();
        player = new MusicPlayer();
    }
    
    public void addFile(String filename) {
        files.add(filename);
    }
    
    public int getNumberOfFiles() {
        return files.size();
    }
    
    public boolean validIndex(int i) {
        return i >= 0 && i < getNumberOfFiles();
    }
    
    public boolean checkIndex(int i) {
        if(!validIndex(i))
            return false;
        return true;
    }
    
    public String listMatching(String search) {
        String str = "";
        
        for(String name : files)
            if(name.contains(search))
                str = str + " " + name;
        
       return str.equals("") ? null : str.substring(1);
    }
    
    public String listAllFiles() {
        String str = "";
        
        int index = 0;
        for(String name : files)
            str = str + String.format("\n%d: %s", index++, name);
            
        return str.equals("") ? null : str;
    }
    
    public void listFile(int index) {
        if(validIndex(index))
            System.out.println(files.get(index));
    }
    
    public void removeFile(int index) {
        if(validIndex(index))
            files.remove(index);
    }
    
    public void startPlaying(int index) {
        String filename = files.get(index);
        player.startPlaying(filename);
    }
    
    public void stopPlaying() {
        player.stop();
    }
}
