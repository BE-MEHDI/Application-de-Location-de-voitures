package sample.modele;



import java.sql.*;
import java.util.Date;

public class Vehicule {
    int tarif;
    public String marque;
    public String matricule;
    String modele;
    int disponibilite;
    public Vehicule() {

    }

    public Vehicule(String marque ,String matricule , String modele , int disponibilite , int tarif) {
        this.tarif = tarif;
        this.marque = marque;
        this.matricule = matricule;
        this.modele = modele;
        this.disponibilite = disponibilite;
    }

    public void addCar(Connection conn){
        try
        {
            Statement statement = conn.createStatement();
            String sql = "Insert into `Vehicule` (`marque`,`matricule`,`modele`,`disponibilite`, `tarif`) values ('" + marque + "','" + matricule+ "','" +modele+ "','" + disponibilite + "','"+tarif+"')";
            statement.executeUpdate(sql);
        }
        catch(SQLException e)
        {
           e.printStackTrace();
        }
    }


    void DetailsVehiculs(Connection conn) {
        try {
            Statement statment = conn.createStatement();
            ResultSet resultat = statment.executeQuery("SELECT * FROM Vehicule");
            while(resultat.next()){
                System.out.println("Marque:" +resultat.getString("marque")+ "Matricule:"  +resultat.getString("matricule")+ "modele:" +resultat.getString("modele")+ "disponibilite:" +resultat.getInt("disponibilite")+ "tarif:" +resultat.getInt("tarif"));
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        } }


    public void DeleteVehicule(String id_vehicule ,Connection conn)
    {
        String sql = "DELETE from Vehicule Where ID_vehicule='"+id_vehicule+"';" ;

        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    public void ChangeDisponibilite0(String matricule ,Connection myconn)
    {
    	String sql = "UPDATE `rent_carcar`.`vehicule` SET `disponibilite` = '0'  Where matricule='"+matricule+"';" ;
    	
    	try {
    	Statement mystmt = myconn.createStatement();
    	mystmt.executeUpdate(sql);
    	}
    	catch(SQLException exc)
    	{
    		exc.printStackTrace();
    	}
    } 
    //sa marche pas bien .
    public void ChangeDisponibilite1(ResultSet resultat ,Connection myconn)
    {
    	String sql = "UPDATE `rent_carcar`.`vehicule` SET `disponibilite` = '1'  Where matricule='"+resultat+"';" ;
    	
    	try {
    	Statement mystmt = myconn.createStatement();
    	mystmt.executeUpdate(sql);
    	}
    	catch(SQLException exc)
    	{
    		exc.printStackTrace();
    	}
    } 

    void DetailsVehicul(String matricule,Connection conn){

        try
        {
            String sql="SELECT * from Vehicule  where matricule = '"+matricule+"' ; ";
            Statement statement = conn.createStatement();
            ResultSet resultat = statement.executeQuery(sql);
            resultat.next();
            System.out.println("Marque:" +resultat.getString("marque")+ "Matricule:"  +resultat.getString("matricule")+ "modele:" +resultat.getString("modele")+ "disponibilite:" +resultat.getInt("disponibilite")+ "tarif:" +resultat.getInt("tarif"));
        }
        catch(SQLException e)
        {
           e.printStackTrace();
        }


    }





}
