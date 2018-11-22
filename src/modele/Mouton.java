package modele;

import java.util.HashMap;
import java.util.Map;

public class Mouton {

	protected String nom;
	protected String description;
	protected float poids;
	
	public Mouton(Map<String, String> champs)
	{
		this.nom = champs.get("nom");
		this.description = champs.get("description");
		//this.poids = champs.get("poids");
	}
	
	public Mouton(String nom) {
		super();
		this.nom = nom;
	}
	public Mouton(String nom, String description) {
		super();
		this.nom = nom;
		this.description = description;
		this.poids = 0;
	}
	public Mouton(String nom, String description, float poids) {
		super();
		this.nom = nom;
		this.description = description;
		this.poids = poids;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public float getPoids() {
		return poids;
	}
	public void setPoids(float poids) {
		this.poids = poids;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Map<String, String> exporterHash()
	{
		Map<String, String> hash = new HashMap<String, String>();
		hash.put("nom", this.nom);
		hash.put("description", this.description);
		hash.put("poids", this.poids + "");
		return hash;
	}
}
