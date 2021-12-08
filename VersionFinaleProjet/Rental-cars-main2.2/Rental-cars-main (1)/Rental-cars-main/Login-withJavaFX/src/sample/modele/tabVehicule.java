package sample.modele;

public class tabVehicule {
	
	String id ; 
	String tarif , marque , matricule , disponibilite,modele ;
	public tabVehicule(String id, String marque, String matricule, String modele, String disponibilite , String tarif) {
		super();
		this.id = id;
		this.tarif = tarif;
		this.marque = marque;
		this.matricule = matricule;
		this.disponibilite = disponibilite;
		this.modele = modele;
	}
	public String getModele() {
		return modele;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTarif() {
		return tarif;
	}
	public void setTarif(String tarif) {
		this.tarif = tarif;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getDisponibilite() {
		return disponibilite;
	}
	public void setDisponibilite(String disponibilite) {
		this.disponibilite = disponibilite;
	}
	
	
	
	
	

}
