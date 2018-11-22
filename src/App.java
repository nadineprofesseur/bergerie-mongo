// Driver https://mvnrepository.com/artifact/org.mongodb/mongo-java-driver/3.0.0
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

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
		
		MongoClient mongo = new MongoClient();
		DB bergerie = mongo.getDB("bergerie");
		DBCollection listeMoutons = bergerie.getCollection("mouton");
		//MongoDatabase bergerie = mongo.getDatabase("bergerie");
		//MongoCollection listeMoutons = bergerie.getCollection("mouton");
		
		/*Map moutonDonnees = new HashMap();
		moutonDonnees.put("nom", "Toto");
		moutonDonnees.put("poids", 10);
		moutonDonnees.put("description", "fatigue");
		DBObject mouton = new BasicDBObject();
		mouton.putAll(moutonDonnees);
		listeMoutons.insert(mouton);
		//listeMoutons.insertOne(mouton);
		*/
		
		DBObject critereMouton = new BasicDBObject("nom","Yoyo");
		DBCursor pointeurMouton = listeMoutons.find(critereMouton);
		Map champsMoutonTrouve = pointeurMouton.one().toMap();
		System.out.println("Le mouton Yoyo est " + champsMoutonTrouve.get("description"));
		
		mongo.close();
		

	}

}