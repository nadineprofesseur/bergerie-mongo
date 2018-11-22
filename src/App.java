
// Driver https://mvnrepository.com/artifact/org.mongodb/mongo-java-driver/3.0.0

import donnee.MoutonDAO;
import modele.Mouton;

public class App {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		System.out.println("Allo Mongo");
		MoutonDAO accesseurMouton = new MoutonDAO();
		
		Mouton mouton = new Mouton("Coucou", "joyeux", 10);
		accesseurMouton.ajouterMouton(mouton);
		
		Mouton moutonTrouve = accesseurMouton.trouverMoutonSelonNom("Coucou");
		System.out.println("Le mouton Coucou est " + moutonTrouve.getDescription());
		

	}

}
