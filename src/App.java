
// Driver https://mvnrepository.com/artifact/org.mongodb/mongo-java-driver/3.0.0

import donnee.MoutonDAO;
import modele.Mouton;

public class App {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		System.out.println("Allo Mongo");
		MoutonDAO accesseurMouton = new MoutonDAO();
		
		Mouton mouton = new Mouton("Foufou", "fou", 10);
		accesseurMouton.ajouterMouton(mouton);
				
		Mouton moutonTrouve = accesseurMouton.trouverMoutonSelonNom("Foufou");
		System.out.println("Le mouton Foufou est " + moutonTrouve.getDescription());
		
		accesseurMouton.effacerMoutonSelonNom("Foufou");

	}

}
