
// Driver https://mvnrepository.com/artifact/org.mongodb/mongo-java-driver/3.0.0
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import donnee.MoutonDAO;
import modele.Mouton;

import java.util.HashMap;
import java.util.Map;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class App {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		System.out.println("Allo Mongo");
		MoutonDAO accesseurMouton = new MoutonDAO();
		
		Mouton mouton = new Mouton("Dodo", "calme", 10);
		accesseurMouton.ajouterMouton(mouton);
		
		Mouton moutonTrouve = accesseurMouton.trouverMoutonSelonNom("Dodo");
		System.out.println("Le mouton Dodo est " + moutonTrouve.getDescription());
		

	}

}
