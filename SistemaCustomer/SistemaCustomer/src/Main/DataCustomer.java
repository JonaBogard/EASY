package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataCustomer {
	
	Connection cx;

	public Connection conectar() {
		try {
			cx = DriverManager.getConnection("jdbc:mysql://localhost:3306/simulacion", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return cx;
	}

	public boolean insertarCustomer(NeocioCustomer nc) {
		PreparedStatement ps = null;
		try {
			ps = conectar().prepareStatement("INSERT INTO orders VALUES(?,?)");
			ps.setString(1, nc.getId());
			ps.setString(2, nc.getDato());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean consultarCustomer(NeocioCustomer nc) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conectar().prepareStatement("SELECT * FROM databade WHERE id=?");
			ps.setString(1, nc.getId());
			rs = ps.executeQuery();
			if (rs.next()) {
				nc.setId(rs.getString(1));
				nc.setDato(rs.getString(2));
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	

	public boolean actualizarCustomer(NeocioCustomer nc) {
		PreparedStatement ps = null;
		try {
			NeocioCustomer nc2 = new NeocioCustomer();
			nc2.setId(nc.getId());
			if (nc2.consultarCustomer()){
				ps = conectar().prepareStatement("UPDATE database SET Date=? WHERE id=?");
				ps.setString(1, nc.getDato());
				ps.setString(2, nc.getId());
				ps.executeUpdate();
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
