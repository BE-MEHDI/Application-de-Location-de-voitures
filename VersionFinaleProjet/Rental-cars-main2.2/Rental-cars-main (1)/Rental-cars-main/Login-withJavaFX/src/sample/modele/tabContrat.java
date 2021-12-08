package sample.modele;

public class tabContrat {
	
	
	String numContrat ; 
	String nomClient , prenomClient , cinClient  ;
	String dateDebut , dateFin ;
	
	String montant;
	public tabContrat(String numContrat, String nomClient, String prenomClient, String cinClient, String dateDebut,
			String dateFin,String montant) {
		super();
		this.numContrat = numContrat;
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.cinClient = cinClient;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.montant=montant;
	}
	public String getMontant() {
		return montant;
	}
	public void setMontant(String montant) {
		this.montant = montant;
	}
	public String getNumContrat() {
		return numContrat;
	}
	public void setNumContrat(String numContrat) {
		this.numContrat = numContrat;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getPrenomClient() {
		return prenomClient;
	}
	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}
	public String getCinClient() {
		return cinClient;
	}
	public void setCinClient(String cinClient) {
		this.cinClient = cinClient;
	}
	public String getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}
	public String getDateFin() {
		return dateFin;
	}
	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}
	

}
