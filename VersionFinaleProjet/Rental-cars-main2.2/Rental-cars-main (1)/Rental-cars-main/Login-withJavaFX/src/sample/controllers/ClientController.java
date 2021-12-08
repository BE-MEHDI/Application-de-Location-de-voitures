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
import sample.modele.Client;
import sample.modele.tabClient;


public class ClientController  implements Initializable {

    @FXML
    private Button btn_Ajout_Client;

    @FXML
    private Button btn_Refresh_Client;

    @FXML
    private Button btn_Supprimer_Client;

    @FXML
    private TextField Num_Supp_Client;

    @FXML
    private TableView<tabClient> Table_Client;

    @FXML
    private TableColumn<tabClient, String> col_Num;

    @FXML
    private TableColumn<tabClient,String> col_Nom;

    @FXML
    private TableColumn<tabClient, String> col_Prenom;

    @FXML
    private TableColumn<tabClient, String> col_CIN;

    @FXML
    private TableColumn<tabClient,String> col_Telephone;
    //Btn Pour Ajouter Client
    @FXML
    void Handle_Ajout_Client(ActionEvent event) throws IOException {
    	Stage formeajout = new Stage();
        Parent root2 = FXMLLoader.load(getClass().getResource("../xmlFile/AjoutClientForm.fxml"));
        Scene scene2 = new Scene(root2,800,600);
        formeajout.setScene(scene2);
        formeajout.setTitle(" Nouveau Client ");
        formeajout.show();
    }
    //Fonction Actualiser Pour Vider la Table Client et Charger la nouvelle Table de DB 
    void Actualiser() throws IOException {
    	for ( int i = 0; i<Table_Client.getItems().size(); i++) {
    		Table_Client.getItems().clear();
        }
    	charger();
    }
    // Btn Refresh Appel la fonction Actualiser.
    @FXML
    void Handle_Refresh_Client(ActionEvent event) throws IOException {
    	Actualiser();
    }
    //Pour appeler la fonction Charger quand l'interface  est appelé
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			charger();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    //la fonction charger() sert à se connecter à database et extraire les information de client.
    public void charger() throws IOException
	{
		try 
	    { 
		 Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rent_carcar","root","root");
		 
	Statement mystmt = myconn.createStatement(); 
		String sql =" SELECT * From clients ";
	    ResultSet rs=mystmt.executeQuery(sql);		 
	    while(rs.next()) {
	    	oblist.add(new tabClient(String.valueOf(rs.getString(1)),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
	    
	    }myconn.close(); }
	    
	    catch(SQLException exc)
	    {
	    	exc.printStackTrace();
	    	 
	    }

//à linterieur de PropertyValueFactory (les attributs de tabClient)
		col_Num.setCellValueFactory(new PropertyValueFactory("id_client"));
		col_Nom.setCellValueFactory(new PropertyValueFactory("Nom"));
		col_Prenom.setCellValueFactory(new PropertyValueFactory("Prenom"));
		col_CIN.setCellValueFactory(new PropertyValueFactory("CIN"));
		col_Telephone.setCellValueFactory(new PropertyValueFactory("telephone"));
		Table_Client.setItems(null);
		Table_Client.setItems(oblist);
	}
	 ObservableList<tabClient> oblist=  FXCollections.observableArrayList();


    @FXML
    void Handle_Supprimer_Client(ActionEvent event) throws IOException {
    	try {
			int id = Integer.parseInt(Num_Supp_Client.getText());
			Connection	Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rent_carcar", "root" , "root");
			Client c=new Client();
			c.DeleteClient(id,Conn);
			Actualiser();
			Conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
    }
    }

