import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StatsPanel extends JPanel {
    static final Font labelFont = new Font("Arial", Font.BOLD, 14);
    static final Font valueFont = new Font("Arial", Font.PLAIN, 14);

    public StatsPanel(ArrayList<WCPlayer> players) {
        JLabel numberOfCountriesLabel = new JLabel("# of countries: ");
        numberOfCountriesLabel.setFont(labelFont);
//        numberOfCountriesLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        numberOfCountriesLabel.setHorizontalTextPosition(SwingConstants.CENTER);
//        numberOfCountriesLabel.setVerticalAlignment(SwingConstants.CENTER);
//        numberOfCountriesLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        add(numberOfCountriesLabel);

        JLabel numberOfCountries = new JLabel("23");
        numberOfCountries.setFont(valueFont);
//        numberOfCountries.setHorizontalAlignment(SwingConstants.CENTER);
//        numberOfCountries.setHorizontalTextPosition(SwingConstants.CENTER);
//        numberOfCountries.setVerticalAlignment(SwingConstants.CENTER);
//        numberOfCountries.setVerticalTextPosition(SwingConstants.BOTTOM);
        add(numberOfCountries);
    }
}
