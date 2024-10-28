import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class TablePanel extends JPanel {
    JTable playerTable;
    PlayerTableModel playerTableModel;
    JScrollPane playerTableScrollPane;
    //ArrayList<WCPlayer> players;
    PlayerFrame parentFrame;

    TablePanel(ArrayList<WCPlayer> players, PlayerFrame frame) {
        this.parentFrame = frame;

        add(new JLabel("Team"));
        add(createTeamComboBox());

        add(new JLabel("Birth Country"));
        add(createBCComboBox());

        add(new JLabel("Year Played"));
        add(createYearComboBox());

        playerTableModel = new PlayerTableModel();

        Object[][] playerData = new Object[players.size()][];
        for (int i = 0; i < players.size(); i++) {
            playerData[i] = new Object[] {players.get(i).playerName(), players.get(i).team(), players.get(i).birthCountry(), players.get(i).yearPlayed()};
        }
        playerTableModel.setData(playerData);

        playerTable = new JTable(playerTableModel);
        playerTable.setRowSelectionAllowed(true);
        playerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        playerTable.setAutoCreateRowSorter(true);

        ListSelectionModel selectionModel = playerTable.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!selectionModel.isSelectionEmpty()) {
                    int selectedRow = selectionModel.getMinSelectionIndex();
                    DetailsPanel detailsPanel = new DetailsPanel(players.get(selectedRow));
                    JDialog dialog = new JDialog(parentFrame, "Player Details", true);
                    dialog.setSize(400, 300);
                    dialog.getContentPane().add(detailsPanel);
                    dialog.setLocationRelativeTo(parentFrame);
                    dialog.setVisible(true);
                    dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    dialog.pack();
                }
            }
        });

        playerTableScrollPane = new JScrollPane(playerTable);

        playerTableScrollPane.setPreferredSize(new Dimension(900, 225));
        add(playerTableScrollPane);
    }

    //-------------------------------Year Filter

    private JComboBox createYearComboBox() {
        List<String> distinctYears = parentFrame.players.stream().collect(Collectors.groupingBy(WCPlayer::yearPlayed)).keySet().stream().sorted().map(Object::toString).toList();
        String[] distinctYearsArray = distinctYears.toArray(new String[distinctYears.size()]);

        JComboBox<String> filterYearComboBox = new JComboBox<>(distinctYearsArray);
        filterYearComboBox.insertItemAt("", 0);
        filterYearComboBox.setFont(new Font("Arial", Font.BOLD, 12));

        filterYearComboBox.setSelectedIndex(0);
        if (parentFrame.yearFilter > 0) {
            int yo = distinctYears.indexOf(String.valueOf(parentFrame.yearFilter));
            filterYearComboBox.setSelectedIndex(distinctYears.indexOf(String.valueOf(parentFrame.yearFilter)) + 1);  //add 1 here due to added blank entry
            int yoyo = filterYearComboBox.getSelectedIndex();;
        }

        filterYearComboBox.addActionListener(e -> {
            int year = 0;
            if (filterYearComboBox.getSelectedIndex() > 0) {
                year = Integer.parseInt(filterYearComboBox.getSelectedItem().toString());
            }

            parentFrame.setYearFilter(year);
            parentFrame.updateDisplay();
        });

        return filterYearComboBox;
    }

    //-------------------------------Team Filter

    private JComboBox createTeamComboBox(){
        List<String> teams = parentFrame.players.stream().collect(Collectors.groupingBy(WCPlayer::team)).keySet().stream().sorted().map(Object::toString).toList();
        String[] teamsArray = teams.toArray(new String[teams.size()]);

        JComboBox<String> filterTeamComboBox = new JComboBox<>(teamsArray);
        filterTeamComboBox.insertItemAt("", 0);
        filterTeamComboBox.setFont(new Font("Arial", Font.BOLD, 12));
        filterTeamComboBox.setSelectedIndex(0);
        if (!parentFrame.teamFilter.isEmpty()) {
            filterTeamComboBox.setSelectedIndex(teams.indexOf(parentFrame.teamFilter) + 1);  //add 1 here due to added blank entry
        }

        filterTeamComboBox.addActionListener(e -> {
            parentFrame.setTeamFilter(filterTeamComboBox.getSelectedItem().toString());
            parentFrame.updateDisplay();
        });

        return filterTeamComboBox;
    }

    //-------------------------------bc: Birth Country

    private JComboBox createBCComboBox(){
        List<String> bc = parentFrame.players.stream().collect(Collectors.groupingBy(WCPlayer::birthCountry)).keySet().stream().sorted().map(Object::toString).toList();
        String[] birthCountriesArray = bc.toArray(new String[bc.size()]);

        JComboBox<String> filterbcComboBox = new JComboBox<>(birthCountriesArray);
        filterbcComboBox.insertItemAt("", 0);
        filterbcComboBox.setFont(new Font("Arial", Font.BOLD, 12));
        filterbcComboBox.setSelectedIndex(0);
        if (!parentFrame.birthCountryFilter.isEmpty()) {
            filterbcComboBox.setSelectedIndex(bc.indexOf(parentFrame.birthCountryFilter) + 1);  //add 2 here due to added blank entry
        }

        filterbcComboBox.addActionListener(e -> {
            parentFrame.setBirthCountryFilter(filterbcComboBox.getSelectedItem().toString());
            parentFrame.updateDisplay();
        });

        return filterbcComboBox;
    }
}
