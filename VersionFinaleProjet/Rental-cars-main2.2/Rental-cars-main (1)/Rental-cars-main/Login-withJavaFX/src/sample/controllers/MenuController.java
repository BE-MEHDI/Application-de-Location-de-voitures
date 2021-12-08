package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class MenuController {
	
	@FXML
    private Button btn_Acceuil;

    @FXML
    private Button btn_Vehicule;

    @FXML
    private Button btn_Client;

    @FXML
    private Button btn_Reservation;

    @FXML
    private Button btn_Contrat;

    @FXML
    private AnchorPane mainInterface;

    @FXML
    void handleAcceuilAction(ActionEvent event)throws Exception {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../xmlFile/Acceuil.fxml"));
    	Node tp = fxmlLoader.load();
    	mainInterface.getChildren().setAll(tp);
    }

    @FXML
    void handleClientAction(ActionEvent event) throws Exception{
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../xmlFile/Client.fxml"));
    	Node tp = fxmlLoader.load();
    	mainInterface.getChildren().setAll(tp);
    	
    	

    }

    @FXML
    void handleContratAction(ActionEvent event) throws Exception {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../xmlFile/Contrat.fxml"));
    	Node tp = fxmlLoader.load();
    	mainInterface.getChildren().setAll(tp);
    }

    @FXML
    void handleReservationAction(ActionEvent event) throws Exception{
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../xmlFile/Reservation.fxml"));
    	Node tp = fxmlLoader.load();
    	mainInterface.getChildren().setAll(tp);
    }

    @FXML
    void handleVehiculeAction(ActionEvent event) throws Exception{
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../xmlFile/Vehicule.fxml"));
    	Node tp = fxmlLoader.load();
    	mainInterface.getChildren().setAll(tp);
    }
	
 

   
    
    

}
