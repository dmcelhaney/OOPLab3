import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StatsPanel extends JPanel {
    static final Font labelFont = new Font("Arial", Font.BOLD, 14);
    static final Font valueFont = new Font("Arial", Font.PLAIN, 14);

    public StatsPanel(ArrayList<WCPlayer> players) {
        JLabel numberOfCountriesLabel = new JLabel("# of teams: ");
        numberOfCountriesLabel.setFont(labelFont);
        add(numberOfCountriesLabel);

        long numTeams = players.stream().collect(Collectors.groupingBy(WCPlayer::team)).keySet().size();
        JLabel numberOfCountries = new JLabel(String.valueOf(numTeams));
        numberOfCountries.setFont(valueFont);
        add(numberOfCountries);

        Map<String, List<WCPlayer>> map = players.stream().collect(Collectors.groupingBy(WCPlayer::team));

        StringBuilder teamsWithTheLeastMigrantPlayers = new StringBuilder();
        try {
            int leastNumberOfMigrantPlayersCount = map.entrySet().stream().min((entry1, entry2) -> entry1.getValue().size() - entry2.getValue().size()).get().getValue().size();
            for(Map.Entry<String, List<WCPlayer>> entry : map.entrySet()) {
                if (entry.getValue().size() == leastNumberOfMigrantPlayersCount) {
                    if (!teamsWithTheLeastMigrantPlayers.isEmpty()) {
                        teamsWithTheLeastMigrantPlayers.append(", ");
                    }
                    teamsWithTheLeastMigrantPlayers.append(entry.getKey());
                }
            }
        } catch (NoSuchElementException ignored) {}

        JLabel teamWithLeastMigrantPlayersLabel = new JLabel("Team with least migrant players: ");
        teamWithLeastMigrantPlayersLabel.setFont(labelFont);
        add(teamWithLeastMigrantPlayersLabel);

        JLabel teamWithLeastMigrantPlayers = new JLabel(teamsWithTheLeastMigrantPlayers.toString());
        teamWithLeastMigrantPlayers.setFont(valueFont);
        add(teamWithLeastMigrantPlayers);

        StringBuilder teamsWithTheMostMigrantPlayers = new StringBuilder();
        try {
            int mostNumberOfMigrantPlayersCount = map.entrySet().stream().min((entry1, entry2) -> entry2.getValue().size() - entry1.getValue().size()).get().getValue().size();
            for(Map.Entry<String, List<WCPlayer>> entry : map.entrySet()) {
                if (entry.getValue().size() == mostNumberOfMigrantPlayersCount) {
                    if (!teamsWithTheMostMigrantPlayers.isEmpty()) {
                        teamsWithTheMostMigrantPlayers.append(", ");
                    }
                    teamsWithTheMostMigrantPlayers.append(entry.getKey());
                }
            }
        } catch (NoSuchElementException ignored) {}

        JLabel teamWithMostMigrantPlayersLabel = new JLabel("Team with most migrant players: ");
        teamWithMostMigrantPlayersLabel.setFont(labelFont);
        add(teamWithMostMigrantPlayersLabel);

        JLabel teamWithMostMigrantPlayers = new JLabel(teamsWithTheMostMigrantPlayers.toString());
        teamWithMostMigrantPlayers.setFont(valueFont);
        add(teamWithMostMigrantPlayers);
    }
}
