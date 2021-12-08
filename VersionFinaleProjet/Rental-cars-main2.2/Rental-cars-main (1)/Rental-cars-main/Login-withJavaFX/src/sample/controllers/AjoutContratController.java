package sample.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.modele.Client;

public class AjoutContratController {
	String Nom;
	String Prenom;
	String Cin,DateFin,Datedebut,Montant;
    @FXML
    private TextField AJNom;

    @FXML
    private TextField AJPrenom;

    @FXML
    private TextField AJCin;

    @FXML
    private TextField AJDateFin;

    @FXML
    private TextField AJDatedebut;

    @FXML
    private TextField AJMontant;

    @FXML
    private Button btn_Enregistrer_Contrat;

    @FXML
    void Handle_Enregistrer_Contrat(ActionEvent event) throws IOException {
    	Nom = AJNom.getText();
    	Prenom = AJPrenom.getText();
    	Cin = AJCin.getText();
    	Client A = new Client(Nom,Prenom,Cin,0);
    	DateFin = AJDateFin.getText();
    	Datedebut = AJDatedebut.getText();
    	Montant = AJMontant.getText();
        Connection cn=null ;
        PreparedStatement st = null ;
        ResultSet res =null ;
        String query=" INSERT into contrat VALUES(DEFAULT,?,?,?,?,?,?) ";
        
        try {
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/rent_carcar","root","root");
            st=cn.prepareStatement(query);
            //st.setInt(1,5);
            A.AddClient(cn);
            st.setString(1,Nom);
            st.setString(2, Prenom);
            st.setString(3,Cin);
            st.setString(4,Datedebut);
            st.setString(5,DateFin);
            st.setString(6,Montant);
          int count=st.executeUpdate();
          System.out.println(count);
          AJNom.setText("");
          AJPrenom.setText("");
          AJCin.setText("");
          AJDateFin.setText("");
          AJDatedebut.setText("");
          AJMontant.setText("");
          cn.close();
        }

        catch(SQLException e) {
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


