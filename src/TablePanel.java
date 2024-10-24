import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TablePanel extends JPanel {
    //JTable table;
    JScrollPane scrollPane;
    JComboBox<String> filterYearDropdown;
    ArrayList<WCPlayer> players;

    TablePanel(ArrayList<WCPlayer> players) {
        this.players = players;
        List<String> distinctYears = players.stream().collect(Collectors.groupingBy(WCPlayer::yearPlayed)).keySet().stream().sorted().map(Object::toString).toList();
        String[] distinctYearsArray = distinctYears.toArray(new String[distinctYears.size()]);
        filterYearDropdown = new JComboBox<>(distinctYearsArray);
        filterYearDropdown.setFont(new Font("Arial", Font.BOLD, 12));
        add(filterYearDropdown);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Player Name");
        model.addColumn("Team");
        model.addColumn("Birth Country");
        model.addColumn("Year Played");

        ArrayList<Object[]> data = new ArrayList<>();
        for (WCPlayer player : players) {
            data.add(new Object[] {player.playerName(), player.team(), player.birthCountry(), player.yearPlayed()});
        }

        for (Object[] row : data) {
            model.addRow(row);
        }

        JTable table = new JTable(model);
        table.setAutoCreateRowSorter(true);
        //table.setPreferredScrollableViewportSize(new Dimension(1200, 1000));
        JScrollPane scrollPane = new JScrollPane(table);

        scrollPane.setPreferredSize(new Dimension(900, 500));
        add(scrollPane);
    }
}
