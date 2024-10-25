import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "Dataset Diversification Migration Corridors 1930-2018 HARVARD.csv";
        ArrayList<WCPlayer> players = FileReader.readPlayerData(fileName);

        PlayerFrame frame = new PlayerFrame(players);

    }
}