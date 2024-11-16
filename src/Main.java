import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "Dataset Diversification Migration Corridors 1930-2018 HARVARD.csv";
        FileReader reader = new CSVFileReader();
        reader.setFilename(fileName);
        ArrayList<WCPlayer> players = reader.readPlayerData();

        PlayerFrame frame = new PlayerFrame(players);
    }
}