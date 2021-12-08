 package sample.modele;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.*;

public class Client {

    
    public String  Nom ,Prenom ,CIN ;
    public int telephone ;
    
    public Client(String nom, String prenom, String CIN, int telephone) {
        Nom = nom;
        Prenom = prenom;
        this.CIN = CIN;
        this.telephone = telephone;
    }
    
    public Client() {
    	
    }
    public void AddClient(Connection conn){

        try{
            Statement statement =conn.createStatement();
            String sql = "Insert into `Clients` (`Nom_client`,`Prenom_client`,`CIN_client`, `telephone_client`) values ('" + Nom+ "','" +Prenom+ "','" + CIN + "','"+telephone+"');";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void DeleteClient(int idClient,Connection conn){

        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("DELETE from Clients Where ID_client="+idClient+";");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }


    }

//Creation de methode pour verifier si le client existe dans la table Client ou pas !





    }









