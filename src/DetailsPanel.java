import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

public class DetailsPanel extends JPanel {
    static final Font labelFont = new Font("Arial", Font.BOLD, 14);
    static final Font valueFont = new Font("Arial", Font.PLAIN, 14);

    public DetailsPanel(WCPlayer player) {

        //------------------------------Name

        JLabel playerNameLabel = new JLabel("Player Name");
        playerNameLabel.setFont(labelFont);
        playerNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        playerNameLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        playerNameLabel.setVerticalAlignment(SwingConstants.CENTER);
        playerNameLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        add(playerNameLabel);

        JLabel playerName = new JLabel(player.playerName());
        playerName.setFont(valueFont);
        playerName.setHorizontalAlignment(SwingConstants.CENTER);
        playerName.setHorizontalTextPosition(SwingConstants.CENTER);
        playerName.setVerticalAlignment(SwingConstants.CENTER);
        playerName.setVerticalTextPosition(SwingConstants.BOTTOM);
        add(playerName);

        //------------------------------Team

        JLabel playerTeamLabel = new JLabel("Team");
        playerTeamLabel.setFont(labelFont);
        playerTeamLabel.setHorizontalAlignment(SwingConstants.CENTER);
        playerTeamLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        playerTeamLabel.setVerticalAlignment(SwingConstants.CENTER);
        playerTeamLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        add(playerTeamLabel);

        JLabel playerTeam = new JLabel(player.team());
        playerTeam.setFont(valueFont);
        playerTeam.setHorizontalAlignment(SwingConstants.CENTER);
        playerTeam.setHorizontalTextPosition(SwingConstants.CENTER);
        playerTeam.setVerticalAlignment(SwingConstants.CENTER);
        playerTeam.setVerticalTextPosition(SwingConstants.BOTTOM);
        add(playerTeam);

        //------------------------------DOB

        JLabel playerDOBLabel = new JLabel("DOB");
        playerDOBLabel.setFont(labelFont);
        playerDOBLabel.setHorizontalAlignment(SwingConstants.CENTER);
        playerDOBLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        playerDOBLabel.setVerticalAlignment(SwingConstants.CENTER);
        playerDOBLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        add(playerDOBLabel);

        //Format the timestamp
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String formattedTimestamp = "";
        if (player.dob() != null) {
            formatter.format(player.dob());
        }

        JLabel playerDOB = new JLabel(formattedTimestamp);
        playerDOB.setFont(valueFont);
        playerDOB.setHorizontalAlignment(SwingConstants.CENTER);
        playerDOB.setHorizontalTextPosition(SwingConstants.CENTER);
        playerDOB.setVerticalAlignment(SwingConstants.CENTER);
        playerDOB.setVerticalTextPosition(SwingConstants.BOTTOM);
        add(playerDOB);

        //------------------------------Birth Country

        JLabel playerBirthCountryLabel = new JLabel("Birth Country");
        playerBirthCountryLabel.setFont(labelFont);
        playerBirthCountryLabel.setHorizontalAlignment(SwingConstants.CENTER);
        playerBirthCountryLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        playerBirthCountryLabel.setVerticalAlignment(SwingConstants.CENTER);
        playerBirthCountryLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        add(playerBirthCountryLabel);

        JLabel playerBirthCountry = new JLabel(player.birthCountry());
        playerBirthCountry.setFont(valueFont);
        playerBirthCountry.setHorizontalAlignment(SwingConstants.CENTER);
        playerBirthCountry.setHorizontalTextPosition(SwingConstants.CENTER);
        playerBirthCountry.setVerticalAlignment(SwingConstants.CENTER);
        playerBirthCountry.setVerticalTextPosition(SwingConstants.BOTTOM);
        add(playerBirthCountry);

        //------------------------------Year Played

        JLabel playerYearPlayedLabel = new JLabel("Year Played");
        playerYearPlayedLabel.setFont(labelFont);
        playerYearPlayedLabel.setHorizontalAlignment(SwingConstants.CENTER);
        playerYearPlayedLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        playerYearPlayedLabel.setVerticalAlignment(SwingConstants.CENTER);
        playerYearPlayedLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        add(playerYearPlayedLabel);

        JLabel playerYearPlayed = new JLabel(String.valueOf(player.yearPlayed()));
        playerYearPlayed.setFont(valueFont);
        playerYearPlayed.setHorizontalAlignment(SwingConstants.CENTER);
        playerYearPlayed.setHorizontalTextPosition(SwingConstants.CENTER);
        playerYearPlayed.setVerticalAlignment(SwingConstants.CENTER);
        playerYearPlayed.setVerticalTextPosition(SwingConstants.BOTTOM);
        add(playerYearPlayed);
    }
}
