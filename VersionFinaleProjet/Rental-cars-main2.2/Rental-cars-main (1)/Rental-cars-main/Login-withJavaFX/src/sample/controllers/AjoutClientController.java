package sample.controllers;

import java.io.IOException;
import java.sql.Connection;
import sample.modele.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AjoutClientController {
	String Nom,Prenom,CIN;
	int Telephone;
    @FXML
    private TextField AJNom;

    @FXML
    private TextField AJPrenom;

    @FXML
    private TextField AJCIN;

    @FXML
    private TextField AJTelephone;

    @FXML
    private Button btn_Enregistrer_Client;

    @FXML
    void Handle_Enregistrer_Client(ActionEvent event) throws IOException {
    	Nom = AJNom.getText();
    	Prenom = AJPrenom.getText();
    	CIN = AJCIN.getText();
    	Telephone = Integer.parseInt(AJTelephone.getText());
    	Client c = new Client(Nom,Prenom,CIN,Telephone);
        Connection conn=null ;
        PreparedStatement st = null ;
        ResultSet res =null ;
        
        
        try {
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/rent_carcar","root","root");
            c.AddClient(conn);
          //int count=st.executeUpdate();
          //System.out.println(count);
          AJNom.setText("");
          AJPrenom.setText("");
          AJCIN.setText("");
          AJTelephone.setText("");
          conn.close();
        }

        catch(SQLException e) {
            e.printStackTrace();
              
        }
    }

    }


