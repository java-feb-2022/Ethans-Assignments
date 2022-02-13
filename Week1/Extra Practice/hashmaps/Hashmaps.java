import java.util.HashMap;
import java.util.HashMap;
import java.util.Set;
public class Hashmaps {
    public static void main(String[] args) {
        HashMap<String, String> tracklist = new HashMap<String, String>();
        tracklist.put("Greedy" , "Thats what you get for being Greedehhhh"); 
        tracklist.put("Gangsters paradise", "been spendin most our lives livin in a gangster's paradise");
        tracklist.put("handclap","I can make your hands clap");
        tracklist.put("Can't hold us", "Put your hands up like the ceiling can't hold us.");
        tracklist.get("Greedy");
        Set<String> Lyrics = tracklist.keySet();
        for (String key : Lyrics){
            System.out.println(key);
            System.out.println(tracklist.get(key));
        }
    }
    
}
