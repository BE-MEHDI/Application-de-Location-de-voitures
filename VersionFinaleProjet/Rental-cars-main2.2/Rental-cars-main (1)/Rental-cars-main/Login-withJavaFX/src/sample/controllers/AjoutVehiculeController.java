package sample.controllers;

import java.io.IOException;
import java.sql.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.modele.Vehicule;

public class AjoutVehiculeController {
	String Marque ;
	String Matricule;
	String Modele;
	int Disponibilite;
	int Tarif;
    @FXML
    private TextField AJMarque;

    @FXML
    private TextField AJMatricule;

    @FXML
    private TextField AJModèle;

    @FXML
    private TextField AJTarif;

    @FXML
    private TextField AJDisponibilité;

    @FXML
    private Button btn_Enregistrer_Vehicule;

    @FXML
    void Handle_Enregistrer_Vehicule(ActionEvent event) throws IOException {
    	Marque = AJMarque.getText();
    	Matricule = AJMatricule.getText();
    	Modele = AJModèle.getText();
    	Tarif = Integer.parseInt(AJTarif.getText());
    	Disponibilite = Integer.parseInt(AJDisponibilité.getText());
    	Vehicule V =new Vehicule(Marque,Matricule,Modele,Disponibilite,Tarif);
        Connection conn=null ;
        PreparedStatement st = null ;
        ResultSet res =null ;
        
        try {
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/rent_carcar","root","root");
            V.addCar(conn);
          AJMarque.setText("");
          AJMatricule.setText("");
          AJModèle.setText("");
          AJDisponibilité.setText("");
          AJTarif.setText("");
          conn.close();
        }

        catch(SQLException e) {
           
            
	        e.printStackTrace(); 
        }
    }
}
