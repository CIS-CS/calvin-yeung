public class Test {
    public void test() {
        MusicOrganizer m = new MusicOrganizer();
        
        System.out.println("Adding 20 tracks...");
        for(int i = 0; i < 20; i++)
            m.addTrack(new Track("bob", "asdf", "" + i));
            
        System.out.println("Added 20 tracks.");
        System.out.println("\nPrinting 5 random tracks...");
        m.playRandom(5);
        System.out.println("\nPrinting 7 random tracks...");
        m.playRandom(7);
        System.out.println("\nPrinting all random tracks...");
        m.playAllRandom();
    }
}