import javax.swing.table.AbstractTableModel;

public class PlayerTableModel extends AbstractTableModel {
    private final String[] columnNames = {"Player Name", "Team", "Birth Country", "Year Played"};
    private Object[][] data;

    public void setData(Object[][] data) {
        this.data = data;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        data[rowIndex][columnIndex] = value;
        fireTableCellUpdated(rowIndex, columnIndex);
   }

   @Override
    public String getColumnName(int column) {
        return columnNames[column];
   }
}
