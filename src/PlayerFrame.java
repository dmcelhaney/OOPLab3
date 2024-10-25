import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class PlayerFrame extends JFrame {
    ArrayList<WCPlayer> players;
    ArrayList<WCPlayer> filteredPlayers;
    StatsPanel statsPanel;
    ChartPanel chartPanel;

    public void setFilteredPlayers(ArrayList<WCPlayer> players) {
        filteredPlayers = players;
    }

    PlayerFrame(ArrayList<WCPlayer> players) {
        this.players = players;
        this.filteredPlayers = players;

        setPreferredSize(new Dimension(1000, 700));
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("World Cup Players");

        TablePanel tablePanel = new TablePanel(players, this);
        tablePanel.setPreferredSize(new Dimension(900, 400));
        add(tablePanel);

        statsPanel = new StatsPanel(filteredPlayers);
        statsPanel.setPreferredSize(new Dimension(900, 200));
        add(statsPanel);

        chartPanel = new ChartPanel(filteredPlayers);
        chartPanel.setPreferredSize(new Dimension(900, 200));
        add(chartPanel);

        pack();
        setVisible(true);
    }

    public void updateDisplay() {
        remove(statsPanel);
        statsPanel = new StatsPanel(filteredPlayers);
        statsPanel.setPreferredSize(new Dimension(900, 200));
        add(statsPanel);


        remove(chartPanel);
        chartPanel = new ChartPanel(filteredPlayers);
        chartPanel.setPreferredSize(new Dimension(900, 200));
        add(chartPanel);

        revalidate();
        repaint();
    }
}