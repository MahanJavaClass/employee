package ir.mahan.train.view;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class PersonTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private List<FormEvent> db;

	String[] columnNames = { "ID", "First Name", "Last Name", "Role", "Age",
			"Gender", "City", "Favorite Sports", "Salary" };

	public void setData(List<FormEvent> db) {
		this.db = db;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return db.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		FormEvent person = db.get(row);
		switch (col) {
		case 0:
			return person.ID;
		case 1:
			return person.getName();
		case 2:
			return person.getFamily();
		case 3:
			return person.getRole();
		case 4:
			return person.getAge();
		case 5:
			return person.getGender();
		case 6:
			return person.getCity();
		case 7:
			return person.getFavoriteSport();
		case 8:
			return person.getSalary();
		}
		return null;
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public boolean isCellEditable(int row, int col) {
		switch (col) {
		case 1:
			return true;
		case 2:
			return true;
		case 8:
			return true;
		default:
			return false;
		}
	}

	@Override
	public void setValueAt(Object value, int row, int col) {
		if (db == null) {
			return;
		}
		FormEvent p = (FormEvent) db.get(row);
		switch (col) {
		case 1:
			p.setName((String) value);
			break;
		case 2:
			p.setFamily((String) value);
			break;
		case 8:
			p.setSalary((String) value);
			break;
		default:
			return;

		}
	}
}
