import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class DBUtils {

	public static TableModel resultSetToTableModel(ResultSet rs) {
		try {
			ResultSetMetaData metaData = (ResultSetMetaData) rs.getMetaData();
			int numberOfColumns = metaData.getColumnCount();
			Vector columnNames = new Vector();

			// Get the column names
			for (int column = 0; column < numberOfColumns; column++) {
				columnNames.addElement(metaData.getColumnLabel(column + 1));
			}

			// Get all rows.
			Vector rows = new Vector();

			while (rs.next()) {
				Vector newRow = new Vector();

				for (int i = 1; i <= numberOfColumns; i++) {
					newRow.addElement(rs.getObject(i));
				}

				rows.addElement(newRow);
			}

			return new DefaultTableModel(rows, columnNames);
		}
		catch (Exception e) {
			e.printStackTrace();

			return null;
		}

	}
	
	public static Klasse resultSetToKlasse(ResultSet rs) {
		try {
			
			ResultSetMetaData metaData = (ResultSetMetaData) rs.getMetaData();
			int numberOfColumns = metaData.getColumnCount();
			Vector columnNames = new Vector();

			// Get all rows.
			Klasse klasse = new Klasse();

			while (rs.next()) {
				Schueler neuerSchueler = new Schueler((String)rs.getObject(1),(String)rs.getObject(2),(String)rs.getObject(3),(Double)rs.getObject(4));
				
				klasse.addSchueler(neuerSchueler);
			}

			return klasse;
		}
		catch (Exception e) {
			e.printStackTrace();

			return null;
		}

	}
}
