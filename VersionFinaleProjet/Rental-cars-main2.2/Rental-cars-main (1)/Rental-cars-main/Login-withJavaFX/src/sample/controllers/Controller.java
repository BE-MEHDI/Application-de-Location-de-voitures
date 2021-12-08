package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
	
	
	
	//String user="" ;
	//String pass = "" ;
	
	@FXML
    private TextField username;

    @FXML
    private PasswordField password;
    
    
   // @FXML
  //  private Label labelMessage;
    
    
    
    
    

    @FXML  
    private Button button;



    @FXML
  public  void login(ActionEvent event) throws Exception {

    		String user = username.getText();
    		String passw = password.getText();
 
	  if("admin".equals(user) && "admin".equals(passw)) { 
		  
		  
		  
	  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../xmlFile/window2.fxml"));
            Parent root2 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            //stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("Acceuil");
            stage.setScene(new Scene(root2));
            stage.show();
            //hide this current window 
          ((Node) event.getSource()).getScene().getWindow().hide(); 
          
           
	  }
	  else {
		 System.out.println("erreur");
		 Stage formeajout = new Stage();
	        Parent root2 = FXMLLoader.load(getClass().getResource("../xmlFile/Error.fxml"));
	        Scene scene2 = new Scene(root2,350,100);
	        formeajout.setScene(scene2);
	        formeajout.setTitle(" Erreur ");
	        formeajout.show();  
	  }
    
    }
	
           
     
    





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    	

    }
}
