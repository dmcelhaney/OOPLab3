import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class PlayerChartPanel extends JPanel {
    static final Font labelFont = new Font("Arial", Font.BOLD, 14);
    static final Font valueFont = new Font("Arial", Font.PLAIN, 14);

    public PlayerChartPanel(ArrayList<WCPlayer> players) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        List<String> distinctYears = players.stream().collect(Collectors.groupingBy(WCPlayer::yearPlayed)).keySet().stream().sorted().map(Object::toString).toList();
        for(String year : distinctYears) {
            int numberOfPlayersForYear = players.stream().filter(player -> player.yearPlayed() == Integer.parseInt(year)).collect(Collectors.toList()).size();
            dataset.addValue(numberOfPlayersForYear, "# of Players", year.substring(2));
        }

        // Create chart
        JFreeChart chart = ChartFactory.createBarChart(
                "Players by Year", // Chart title
                "Year", // X-axis label
                "# of Players", // Y-axis label
                dataset, // Dataset
                PlotOrientation.VERTICAL, // Orientation
                true, // Include legend
                true, // Include tooltips
                false // Include URLs
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        add(chartPanel, BorderLayout.CENTER);
    }
}
