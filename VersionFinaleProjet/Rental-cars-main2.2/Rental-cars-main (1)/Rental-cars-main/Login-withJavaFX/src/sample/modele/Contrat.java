
package sample.modele;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Contrat{
    Client client;
    int numContrat ;
    Date dateDebut ;
    Date dateFin;
    int duree;
    //Constructeur par défaut de Contrat
    public Contrat() {}

    //Constructeur d'un Contrat
	public Contrat(int num , String firstName , String lastName ,String cin ,String DB , String DF , int d ) throws Exception {
		numContrat = num ;
		client.Nom = firstName ; 
		client.Prenom = lastName ;
		client.CIN = cin ;
		duree = d ;
		
		
		dateDebut =new  SimpleDateFormat("yyyy-MM-dd").parse(DB);
		dateFin = new SimpleDateFormat("yyyy-MM-dd").parse(DF);
		
		
		
	
	}
	// Add Contrat
	
			public void AddContrat(Connection conn) {
				
				java.sql.Date sqlDateDebut = new java.sql.Date(dateDebut.getTime()); 
				java.sql.Date sqlDateFin = new java.sql.Date(dateFin.getTime());
				
				
				
				Connection cx = null ;
				PreparedStatement st = null ;
				
				String query = "insert into Contrat values(?,?,?,?,?,?,?)";
				
				
				try {
					st=cx.prepareStatement(query);
					st.setInt(1,numContrat);
					st.setString(2,client.Nom);
					st.setString(3, client.Prenom);
					st.setString(4,client.CIN);
					st.setDate(5,sqlDateDebut);
					st.setDate(6,sqlDateFin);
			        st.setInt(7,duree);
			        int count=st.executeUpdate();
			        System.out.println(count);	
						
					
				}
				
				catch(SQLException e) {
					e.printStackTrace();
				}
				
				
}
			
			public  void deleteContrat(int numContrat,Connection myconn) {	 
				 String query = "delete from Contrat where ID_contrat ="+numContrat ;
				 try {
			            Statement statement = myconn.createStatement();
			            statement.executeUpdate(query);
			        }
			        catch(SQLException e)
			        {
			            e.printStackTrace();
			        }
				 
			}
	
    
    
    
    
}