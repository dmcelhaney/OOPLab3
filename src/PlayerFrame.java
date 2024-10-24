import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PlayerFrame extends JFrame {
    ArrayList<WCPlayer> players;


    PlayerFrame(ArrayList<WCPlayer> players) {
        this.players = players;

        setPreferredSize(new Dimension(1000, 700));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("World Cup Players");

        TablePanel tablePanel = new TablePanel(players);
        tablePanel.setPreferredSize(new Dimension(900, 600));
        add(tablePanel);

        pack();
        setVisible(true);
    }
}