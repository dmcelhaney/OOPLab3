import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerFrame extends JFrame {
    ArrayList<WCPlayer> players;
    TablePanel tablePanel;
    StatsPanel statsPanel;
    PlayerChartPanel chartPanel;
    int yearFilter = 0;
    String teamFilter = "";
    String birthCountryFilter = "";

    public void setYearFilter(int yearFilter) {
        this.yearFilter = yearFilter;
    }

    public void setTeamFilter(String teamFilter) {
        this.teamFilter = teamFilter;
    }

    public void setBirthCountryFilter(String birthCountryFilter) {
        this.birthCountryFilter = birthCountryFilter;
    }

    PlayerFrame(ArrayList<WCPlayer> players) {
        this.players = players;
        //this.filteredPlayers = players;

        setPreferredSize(new Dimension(1000, 1200));
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("World Cup Players");

        updateDisplay();

        pack();
        setVisible(true);
    }

    public void updateDisplay() {
        ArrayList<WCPlayer> filteredList =  players;
        if (yearFilter > 0) {
            filteredList = players.stream().filter(player -> player.yearPlayed() == yearFilter).collect(Collectors.toCollection(ArrayList::new));
        }

        if (!teamFilter.isEmpty()) {
            filteredList = filteredList.stream().filter(player -> player.team().equals(teamFilter)).collect(Collectors.toCollection(ArrayList::new));
        }

        if (!birthCountryFilter.isEmpty()) {
            filteredList = filteredList.stream().filter(player -> player.birthCountry().equals(birthCountryFilter)).collect(Collectors.toCollection(ArrayList::new));
        }

        if (tablePanel != null) {
            remove(tablePanel);
        }
        tablePanel = new TablePanel(filteredList, this);
        tablePanel.setPreferredSize(new Dimension(900, 300));
        add(tablePanel);

        if (statsPanel != null) {
            remove(statsPanel);
        }
        statsPanel = new StatsPanel(filteredList);
        statsPanel.setPreferredSize(new Dimension(900, 200));
        statsPanel.setLayout(new BoxLayout(statsPanel, BoxLayout.Y_AXIS));
        add(statsPanel);

        if (chartPanel != null) {
            remove(chartPanel);
        }
        chartPanel = new PlayerChartPanel(filteredList);
        chartPanel.setPreferredSize(new Dimension(900, 600));
        add(chartPanel);

        revalidate();
        repaint();
    }
}