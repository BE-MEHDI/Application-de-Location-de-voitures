package sample.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.modele.Client;
import sample.modele.Reservation;
import sample.modele.Vehicule;

public class AjoutReservationController {
	String NomClient,PrenomClient,MarqueReservation;
	String MatriculeReservation;
	Date Date_Res;
	int DureeReservation,MarquePrix;
    @FXML
    private TextField AJNomClient;

    @FXML
    private TextField AJPrenomClient;

    @FXML
    private TextField AJMarqueReservation;

    @FXML
    private TextField AJDureeReservation;

    @FXML
    private TextField AJMatriculeReservation;

    @FXML
    private Button btn_Enregistrer_Reservation;

    @FXML
    private TextField AJMarquePrix;

    @FXML
    private TextField AJDate;

    @FXML
    void Handle_Enregistrer_Reservation(ActionEvent event) throws IOException {
    	 try
         {
             Connection    Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rent_carcar", "root" , "root");
             String nomclient = AJNomClient.getText();
             String prenomclient = AJPrenomClient.getText();
             String marque = AJMarqueReservation.getText();
             String matricule = AJMatriculeReservation.getText();
             String duree = AJDureeReservation.getText();
             String prix = AJMarquePrix.getText();
             String date = AJDate.getText();
             Client A = new Client();
             A.Nom = nomclient;
             A.Prenom = prenomclient;
             //A.AddClient(Conn);
             //il faut une methode dans addClient pour verifier si le client exite deja ou pas à faire !! 
             Vehicule V = new Vehicule();
             V.matricule = matricule;
             V.marque = marque;
             //ChangeDisponibilite methode pas optimale il faut qu'on ajoute la condition si la disponibilité = 0 .
             V.ChangeDisponibilite0(matricule ,Conn);
             int Duree, Prix;
             Duree = Integer.parseInt(duree);
             Prix = Integer.parseInt(prix);
             Reservation R = new Reservation(A, V, Prix, Duree, date);
             System.out.println("done");
             R.Add_res(Conn);
             Conn.close();
             
         }
         catch(Exception e)
         {
             e.printStackTrace();
             Stage formeajout = new Stage();
 	        Parent root2 = FXMLLoader.load(getClass().getResource("../xmlFile/Error.fxml"));
 	        Scene scene2 = new Scene(root2,350,100);
 	        formeajout.setScene(scene2);
 	        formeajout.setTitle(" erreur ");
 	        formeajout.show();  
         }

}
}
