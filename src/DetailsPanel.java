import javax.swing.*;
import java.awt.*;

public class DetailsPanel extends JPanel {
    static final Font labelFont = new Font("Arial", Font.BOLD, 14);
    static final Font valueFont = new Font("Arial", Font.PLAIN, 14);

    public DetailsPanel(WCPlayer player) {
        JLabel playerNameLabel = new JLabel("Player Name");
        playerNameLabel.setFont(valueFont);
        playerNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        playerNameLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        playerNameLabel.setVerticalAlignment(SwingConstants.CENTER);
        playerNameLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        add(playerNameLabel);

        JLabel playerName = new JLabel(player.playerName());
        playerNameLabel.setFont(labelFont);
        playerName.setHorizontalAlignment(SwingConstants.CENTER);
        playerName.setHorizontalTextPosition(SwingConstants.CENTER);
        playerName.setVerticalAlignment(SwingConstants.CENTER);
        playerName.setVerticalTextPosition(SwingConstants.BOTTOM);
        add(playerName);
    }
}
