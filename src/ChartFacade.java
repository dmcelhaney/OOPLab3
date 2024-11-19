import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Implementation of Facade Pattern
public class ChartFacade {
    public JFreeChart createBarChart(ArrayList<WCPlayer> players){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        List<String> distinctYears = players.stream().collect(Collectors.groupingBy(WCPlayer::yearPlayed)).keySet().stream().sorted().map(Object::toString).toList();
        for(String year : distinctYears) {
            int numberOfPlayersForYear = players.stream().filter(player -> player.yearPlayed() == Integer.parseInt(year)).collect(Collectors.toList()).size();
            dataset.addValue(numberOfPlayersForYear, "# of Players", year.substring(2));
        }

        //Create chart
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

        return chart;
    }
}
