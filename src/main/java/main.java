import java.util.ArrayList;
import java.util.List;

public class main {

    private static volatile List<String> testName = new ArrayList<>();

    public static void setTestName(String name) {
        testName.add(name);
    }

    public static void main(String[] args) throws InterruptedException {
        List<Track> listHors = new ArrayList<>();
        int distant = 1000;
        for (int i = 0; i < 20; i++){
            listHors.add(new Track(String.valueOf(i), String.valueOf(i), i, distant));
        }
        //listHors.stream().forEach(x -> x.run());
        for (Track hors : listHors){
            hors.start();
        }

        for (Track hors : listHors){
            hors.join();
        }
        testName.stream().map(x-> "Hors name " + x).forEach(System.out::println);
    }
}
