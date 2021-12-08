package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.modele.Reservation;
import sample.modele.Vehicule;
import sample.modele.tabReservation;
import sample.modele.tabVehicule;

public class ReservationController implements Initializable{

    @FXML
    private Button btn_Ajout_Reservation;

    @FXML
    private Button btn_Actualiser_Reservation;

    @FXML
    private Button btn_Supprimer_Reservation;

    @FXML
    private TextField num_Supprimer_Reservation;

    @FXML
    private TableView<tabReservation> Tableau_Reservation;

    @FXML
    private TableColumn<tabReservation, String> col_Num_Reservation;

    @FXML
    private TableColumn<tabReservation, String> col_Nom_Reservation;

    @FXML
    private TableColumn<tabReservation, String> col_Prenom_Reservation;

    @FXML
    private TableColumn<tabReservation, String> col_Marque_Reservation;

    @FXML
    private TableColumn<tabReservation, String> col_Matricule_Reservation;

    @FXML
    private TableColumn<tabReservation, String> col_Duree_Reservation;

    @FXML
    private TableColumn<tabReservation, String> col_Prix_Reservation;

    @FXML
    private TableColumn<tabReservation, String> col_Date_Reservation;

    @FXML
    void Handle_Actualiser_Reservation(ActionEvent event) {
    	Actualiser();
    }

    @FXML
    void Handle_Ajout_Reservation(ActionEvent event) throws IOException {
    	Stage formeajout = new Stage();
        Parent root2 = FXMLLoader.load(getClass().getResource("../xmlFile/AjoutReservationForm.fxml"));
        Scene scene2 = new Scene(root2,800,600);
        formeajout.setScene(scene2);
        formeajout.setTitle(" Nouvelle Reservation ");
        formeajout.show();
    }
    void Actualiser() {
    	for ( int i = 0; i<Tableau_Reservation.getItems().size(); i++) {
    		Tableau_Reservation.getItems().clear();
        }
    	charger();
    }
    public void charger()
	{
		try 
	    { 
		 Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rent_carcar","root","root");
		 
	Statement mystmt = myconn.createStatement(); 
		String sql ="SELECT * From Reservation";
	    ResultSet rs=mystmt.executeQuery(sql);		 
	    while(rs.next()) {
	    	oblist.add(new tabReservation(String.valueOf(rs.getString(1)),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
	    
	    } }
	    
	    catch(SQLException exc)
	    {
	    	exc.printStackTrace();
	    }


		col_Num_Reservation.setCellValueFactory(new PropertyValueFactory("num_Res"));
		col_Nom_Reservation.setCellValueFactory(new PropertyValueFactory("nom_Client"));
		col_Prenom_Reservation.setCellValueFactory(new PropertyValueFactory("prenom_Client"));
		col_Marque_Reservation.setCellValueFactory(new PropertyValueFactory("marque_Voiture"));
		col_Matricule_Reservation.setCellValueFactory(new PropertyValueFactory("matricule_Voiture"));
		col_Duree_Reservation.setCellValueFactory(new PropertyValueFactory("prix"));
		col_Prix_Reservation.setCellValueFactory(new PropertyValueFactory("duree"));
		col_Date_Reservation.setCellValueFactory(new PropertyValueFactory("date_reservation"));
		Tableau_Reservation.setItems(null);
		Tableau_Reservation.setItems(oblist);
	}
	 ObservableList<tabReservation> oblist=  FXCollections.observableArrayList();
    
    @FXML
    void Handle_Supprimer_Reservation(ActionEvent event) {
    	try {
			int id = Integer.parseInt(num_Supprimer_Reservation.getText());
			Reservation R = new Reservation();
			Connection	Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rent_carcar", "root" , "root");
			R.deleteReservation(id , Conn);
			/*String sql="SELECT matricule from Reservation  where ID_reservation = '"+id+"' ; ";
            Statement statement = Conn.createStatement();
            ResultSet resultat = statement.executeQuery(sql);
            Vehicule V = new Vehicule();
            V.ChangeDisponibilite1(resultat ,Conn);*/
			Actualiser();
			Conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		charger();
		
	}

}
