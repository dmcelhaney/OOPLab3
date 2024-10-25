import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TablePanel extends JPanel {
    //JTable table;
    //JComboBox<String> filterYearComboBox;
    JTable playerTable;
    PlayerTableModel playerTableModel;
    JScrollPane playerTableScrollPane;
    ArrayList<WCPlayer> players;
    PlayerFrame parentFrame;

    TablePanel(ArrayList<WCPlayer> players, PlayerFrame frame) {
        this.players = players;
        this.parentFrame = frame;

        add(new JLabel("World Cup Year"));
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
                    DetailsPanel detailsPanel = new DetailsPanel(parentFrame.filteredPlayers.get(selectedRow));
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

        playerTableScrollPane.setPreferredSize(new Dimension(900, 500));
        add(playerTableScrollPane);
    }

    private JComboBox createYearComboBox() {
        List<String> distinctYears = players.stream().collect(Collectors.groupingBy(WCPlayer::yearPlayed)).keySet().stream().sorted().map(Object::toString).toList();
        String[] distinctYearsArray = distinctYears.toArray(new String[distinctYears.size()]);

        JComboBox<String> filterYearComboBox = new JComboBox<>(distinctYearsArray);
        filterYearComboBox.insertItemAt("", 0);
        filterYearComboBox.setFont(new Font("Arial", Font.BOLD, 12));
        filterYearComboBox.setSelectedIndex(0);
        filterYearComboBox.addActionListener(e -> {
            List<WCPlayer> filteredPlayers =  players.stream().toList();
            if (filterYearComboBox.getSelectedIndex() > 0) {
                int selectedYear = Integer.parseInt(filterYearComboBox.getSelectedItem().toString());
                filteredPlayers = players.stream().filter(player -> player.yearPlayed() == selectedYear).toList();
            }

            Object[][] playerData = new Object[filteredPlayers.size()][];
            for (int i = 0; i < filteredPlayers.size(); i++) {
                playerData[i] = new Object[] {filteredPlayers.get(i).playerName(), filteredPlayers.get(i).team(), filteredPlayers.get(i).birthCountry(), filteredPlayers.get(i).yearPlayed()};
            }

            playerTableModel.setData(playerData);
            parentFrame.setFilteredPlayers(new ArrayList<>(filteredPlayers));
            parentFrame.updateDisplay();
        });

        return filterYearComboBox;
    }


    private void updatePlayerTableDisplay() {
    }
}
