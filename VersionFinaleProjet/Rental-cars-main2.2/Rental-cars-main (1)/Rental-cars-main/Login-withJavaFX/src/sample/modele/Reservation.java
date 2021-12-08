package sample.modele;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;


public class Reservation {
	
	Client c ;
	Vehicule v ; 
	int Prix ;
	int Duree  ;
	Date date ; 
	public Reservation() {
		
	}
	
	public Reservation(Client C , Vehicule V , int Prix , int Duree  , String date  ) throws Exception{
		
		c=C;
		v=V ; 
		this.Prix=Prix;
		this.Duree=Duree;
		this.date = new SimpleDateFormat("yyyy-mm-dd").parse(date);
	}
	
	public void Add_res(Connection Conn) {
		
		
		try {
			
			java.sql.Date date = new java.sql.Date(this.date.getTime());
			Statement Stat = Conn.createStatement();
			String sql = "Insert into `Reservation` (`Nom_client`,`Prenom_client`,`marque`,`matricule`,`duree`,`Prix`,`datereservation`) values ('" + c.Nom+ "','"+c.Prenom+ "','"+ v.marque+ "','" +v.matricule+ "','" + Duree + "','"+Prix+"','"+date+"');";
			Stat.executeUpdate(sql);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}
		public void deleteReservation(int numReservation , Connection conn) {
			
			try {
			
				Statement st =conn.createStatement();
				String query = "delete from Reservation where ID_reservation="+numReservation+";";
				st.executeUpdate(query);
			
		}
			catch(SQLException e ) {
				e.printStackTrace();
			}
		
		
	}
		
}
	
	
	

