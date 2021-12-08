package sample.modele;

public class tabReservation {
	
	String Num_Res ,Nom_Client , Prenom_Client , Matricule_Voiture , Marque_Voiture  ; 
	String prix,duree, date_reservation ;
	public tabReservation(String num_Res, String nom_Client, String prenom_Client, String matricule_Voiture,
			String marque_Voiture, String prix, String duree, String date_reservation) {
		super();
		Num_Res = num_Res;
		Nom_Client = nom_Client;
		Prenom_Client = prenom_Client;
		Matricule_Voiture = matricule_Voiture;
		Marque_Voiture = marque_Voiture;
		this.prix = prix;
		this.duree = duree;
		this.date_reservation = date_reservation;
		
	}
	public String getNum_Res() {
		return Num_Res;
	}
	public void setNum_Res(String num_Res) {
		Num_Res = num_Res;
	}
	public String getNom_Client() {
		return Nom_Client;
	}
	public void setNom_Client(String nom_Client) {
		Nom_Client = nom_Client;
	}
	public String getPrenom_Client() {
		return Prenom_Client;
	}
	public void setPrenom_Client(String prenom_Client) {
		Prenom_Client = prenom_Client;
	}
	public String getMatricule_Voiture() {
		return Matricule_Voiture;
	}
	public void setMatricule_Voiture(String matricule_Voiture) {
		Matricule_Voiture = matricule_Voiture;
	}
	public String getMarque_Voiture() {
		return Marque_Voiture;
	}
	public void setMarque_Voiture(String marque_Voiture) {
		Marque_Voiture = marque_Voiture;
	}
	public String getPrix() {
		return prix;
	}
	public void setPrix(String prix) {
		this.prix = prix;
	}
	public String getDuree() {
		return duree;
	}
	public void setDuree(String duree) {
		this.duree = duree;
	}
	public String getDate_reservation() {
		return date_reservation;
	}
	public void setDate_reservation(String date_reservation) {
		this.date_reservation = date_reservation;
	}
}
