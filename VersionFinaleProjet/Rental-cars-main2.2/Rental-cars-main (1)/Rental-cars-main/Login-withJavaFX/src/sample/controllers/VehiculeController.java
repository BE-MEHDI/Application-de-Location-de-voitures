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
import sample.modele.Vehicule;
import sample.modele.tabVehicule;

public class VehiculeController implements Initializable {

    @FXML
    private Button btn_Refresh_Vehicule;

    @FXML
    private Button btn_Ajout_Vehicule;

    @FXML
    private Button btn_Supprimer_Vehicule;

    @FXML
    private TextField id_Supp_Vehicule;

    @FXML
    private TableView<tabVehicule> Table_Vehicule;

    @FXML
    private TableColumn<tabVehicule, String> id_Vehicule;

    @FXML
    private TableColumn<tabVehicule, String> Marque_Vehicule;

    @FXML
    private TableColumn<tabVehicule, String> Tarif_Vehicule;

    @FXML
    private TableColumn<tabVehicule,String> Matricule_Vehicule;

    @FXML
    private TableColumn<tabVehicule, String> Model_Vehicule;

    @FXML
    private TableColumn<tabVehicule, String> Dispo_Vehicule;

    @FXML
    void Handle_Ajout_Vehicule(ActionEvent event) throws IOException {
    	Stage formeajout = new Stage();
        Parent root2 = FXMLLoader.load(getClass().getResource("../xmlFile/AjoutVehiculeForm.fxml"));
        Scene scene2 = new Scene(root2,800,600);
        formeajout.setScene(scene2);
        formeajout.setTitle(" Nouveau Vehicule ");
        formeajout.show();
    }
    void Actualiser() {
    	for ( int i = 0; i<Table_Vehicule.getItems().size(); i++) {
    		Table_Vehicule.getItems().clear();
        }
    	charger();
    }

    @FXML
    void Handle_Refresh_Vehicule(ActionEvent event) {
    	Actualiser();
    }

    @FXML
    void Handle_Supprimer_Vehicule(ActionEvent event) {
    	try {
			String id = id_Supp_Vehicule.getText();
			Connection	Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rent_carcar", "root" , "root");
			Vehicule V=new Vehicule();
			V.DeleteVehicule(id ,Conn);
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
		String sql ="SELECT * From Vehicule";
	    ResultSet rs=mystmt.executeQuery(sql);		 
	    while(rs.next()) {
	    	oblist.add(new tabVehicule(String.valueOf(rs.getString(1)),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6)));
	    
	    }myconn.close(); }
	    
	    catch(SQLException exc)
	    {
	    	exc.printStackTrace();
	    }


		id_Vehicule.setCellValueFactory(new PropertyValueFactory("id"));
		Matricule_Vehicule.setCellValueFactory(new PropertyValueFactory("matricule"));
	Marque_Vehicule.setCellValueFactory(new PropertyValueFactory("marque"));
	Model_Vehicule.setCellValueFactory(new PropertyValueFactory("Modele"));
	Dispo_Vehicule.setCellValueFactory(new PropertyValueFactory("Disponibilite"));
	Tarif_Vehicule.setCellValueFactory(new PropertyValueFactory("Tarif"));
	Table_Vehicule.setItems(null);
	Table_Vehicule.setItems(oblist);
	}
	 ObservableList<tabVehicule> oblist=  FXCollections.observableArrayList();

}
