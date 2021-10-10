import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args)
    {
        List<Track> listHors = new ArrayList<>();
        int distant = 1000000000;
        for (int i = 0; i < 20; i++){
            listHors.add(new Track(String.valueOf(i), String.valueOf(i), i, distant));
        }
        for (Track hors : listHors){
            hors.start();
        }
    }

}
