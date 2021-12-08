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
import sample.modele.Contrat;
import sample.modele.tabContrat;
import sample.modele.tabVehicule;

public class ContratController implements Initializable {

    @FXML
    private Button btn_Ajout_Contrat;

    @FXML
    private Button btn_Actualiser_Contrat;

    @FXML
    private Button btn_Supprimer_Contrat;

    @FXML
    private TextField id_Supprimer_Contrat;

    @FXML
    private TableView<tabContrat> Table_Contrat;

    @FXML
    private TableColumn<tabContrat, String> col_id_Contrat;

    @FXML
    private TableColumn<tabContrat, String> col_CIN;

    @FXML
    private TableColumn<tabContrat, String> col_Nom;

    @FXML
    private TableColumn<tabContrat, String> col_Prenom;

    @FXML
    private TableColumn<tabContrat, String> col_DateDebut;

    @FXML
    private TableColumn<tabContrat, String> col_DateFin;

    @FXML
    private TableColumn<tabContrat, String> col_Montant;
  //Btn Pour Ajouter Contrat
    @FXML
    void Handle_Ajout_Contrat(ActionEvent event) throws IOException {
    	Stage formeajout = new Stage();
        Parent root2 = FXMLLoader.load(getClass().getResource("../xmlFile/AjoutContratForm.fxml"));
        Scene scene2 = new Scene(root2,800,600);
        formeajout.setScene(scene2);
        formeajout.setTitle(" Nouveau Contrat ");
        formeajout.show();
    }
    void Actualiser() {
    	for ( int i = 0; i<Table_Contrat.getItems().size(); i++) {
    		Table_Contrat.getItems().clear();
        }
    	charger();
    }
    

    @FXML
    void Handle_Actualiser_Contrat(ActionEvent event) {
    	Actualiser();
    }

    @FXML
    void Handle_Supprimer_Contrat(ActionEvent event) {
    	try {
			int id = Integer.parseInt(id_Supprimer_Contrat.getText());
			Connection	Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rent_carcar", "root" , "root");
			Contrat C = new Contrat();
			C.deleteContrat(id,Conn);
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
	public void charger()
	{
		try 
	    { 
		 Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rent_carcar","root","root");
		 
	Statement mystmt = myconn.createStatement(); 
		String sql ="SELECT * From Contrat";
	    ResultSet rs=mystmt.executeQuery(sql);		 
	    while(rs.next()) {
	    	oblist.add(new tabContrat((rs.getString(1)),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6), rs.getString(7)));
	    
	    }myconn.close(); }
	    
	    catch(SQLException exc)
	    {
	    	exc.printStackTrace();
	    	
	    }

		col_id_Contrat.setCellValueFactory(new PropertyValueFactory("numContrat"));
		col_Nom.setCellValueFactory(new PropertyValueFactory("nomClient"));
		col_Prenom.setCellValueFactory(new PropertyValueFactory("prenomClient"));
		col_CIN.setCellValueFactory(new PropertyValueFactory("cinClient"));
		col_DateDebut.setCellValueFactory(new PropertyValueFactory("dateDebut"));
		col_DateFin.setCellValueFactory(new PropertyValueFactory("dateFin"));
		col_Montant.setCellValueFactory(new PropertyValueFactory("montant"));
		Table_Contrat.setItems(null);
		Table_Contrat.setItems(oblist);
	}
	 ObservableList<tabContrat> oblist=  FXCollections.observableArrayList();

}
