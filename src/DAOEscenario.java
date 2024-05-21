import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAOEscenario {

	
	public static Connection _c;
	

	public DAOEscenario(String Modo) {
		DAOMySql dms = new DAOMySql(Modo);
		if (dms.c!=null) {
			_c = dms.c;
		}
		else _c= null;
	}
	
	/**
	 * Trae la lista de Escenarios registrados en la base de datos
	 * @return Colección de objetos Lander registrados
	 */
	public ArrayList<Escenario>getEscenarios() {
		
		ArrayList<Escenario> esc = new ArrayList<Escenario>();
		try {
			Statement stm = _c.createStatement();
			String ssql = "SELECT * FROM Escenario";
			ResultSet rs = stm.executeQuery(ssql);
			while (rs.next()) {
				Escenario nesc = new Escenario(rs.getString(1),rs.getDouble(2),rs.getDouble(3),rs.getDouble(4));
				esc.add(nesc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
}
