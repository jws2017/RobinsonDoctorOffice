package data_structures;

import java.sql.SQLException;

public interface Table {

	void createTable() throws SQLException;
	void populateTable() throws SQLException;
	void dropTable() throws SQLException;
}
