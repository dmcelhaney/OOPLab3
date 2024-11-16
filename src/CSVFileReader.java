import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVFileReader extends FileReader {

    @Override
    ArrayList<WCPlayer> readPlayerData() throws IOException {
        ArrayList<WCPlayer> players = new ArrayList<>();
        String contents = Files.readString(Path.of(getFilename()), StandardCharsets.UTF_8);
        Scanner scanner = new Scanner(contents);
        scanner.nextLine();
        scanner.useDelimiter(",");

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] data = line.split(",");
            WCPlayer player = new WCPlayer(data[0], data[1], Parser.parseDate(data[2]), data[3], data[4], data[5], data[6], data[7], data[8], data[9],Integer.parseInt(data[10]), Integer.parseInt(data[11]));
            players.add(player);
        }

        return players;
    }
}
