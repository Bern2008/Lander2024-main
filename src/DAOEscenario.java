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
			
			else {_c= null;}
		}
	
	/**
	 * Trae la lista de Escenarios registrados en la base de datos
	 * @return Colección de objetos Escenario registrados
	 */
	
	public ArrayList<Escenario> getEscenarios() {
		
		ArrayList<Escenario> esc = new ArrayList<Escenario>();
		
		try {
			Statement stm = _c.createStatement();
			String ssql = "SELECT * FROM escenario";
			ResultSet rs = stm.executeQuery(ssql);
			while (rs.next()) {
				Escenario nesc = new Escenario(rs.getString(2),rs.getDouble(3),rs.getDouble(4),rs.getDouble(5));
				esc.add(nesc); // Se produce conversión automática de INTEGER a DOUBLE
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return esc;
	}
	
	
}
