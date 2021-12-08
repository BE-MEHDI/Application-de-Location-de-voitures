package sample.modele;

public class tabClient {
	String id_client;
	String telephone;
	String Nom , Prenom , CIN ;
	public tabClient(String id,String Nom, String Prenom, String CIN, String Telephone) {
		super();
		this.telephone = Telephone;
		this.Nom = Nom;
		this.Prenom = Prenom;
		this.CIN = CIN;
		this.id_client = id;
	}
	public String getId_client() {
		return id_client;
	}
	public void setId_client(String id_client) {
		this.id_client = id_client;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public String getCIN() {
		return CIN;
	}
	public void setCIN(String cIN) {
		CIN = cIN;
	} 
	
	
}
