package movietime.core.tabledatabase;

public interface TableInterface {

	public void createTable(String[] nomicolonne) throws ClassNotFoundException;

	public void addRow(Object[] data);

	public void removeRow(int id);

	public void updateRow(Object[] data);

}
