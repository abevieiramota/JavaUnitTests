package abevieiramota.learning.junit.passo2assertions.parameterized;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCUtil {
	
	private static final String DEFAULT_DRIVER_NAME = null;
	
	public static List<String[]> linhas(String query, String connectionURL, String driverName) throws ClassNotFoundException, SQLException {
		Class.forName(driverName);
		
		Connection conn = DriverManager.getConnection(connectionURL, "teste", "teste");
		
		return linhas(query, conn);
	}
	
	public static List<String[]> linhas(String query, String connectionURL) throws ClassNotFoundException, SQLException {
		return linhas(query, connectionURL, DEFAULT_DRIVER_NAME);
	}
	
	public static List<String[]> linhas(String query, Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery(query);
		
		int numColumns = rs.getMetaData().getColumnCount();
		
		List<String[]> dados = new ArrayList<String[]>();
		
		while(rs.next()) {
			String[] row = new String[numColumns];
			for(int i = 0; i < numColumns; i++) {
				row[i] = rs.getString(i + 1);
			}
			dados.add(row);
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
		return dados;
	}

}
