package donnee;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import modele.Mouton;

public class MoutonDAO {

	public void ajouterMouton(Mouton mouton)
	{
		MongoClient mongo = new MongoClient();
		DB bergerie = mongo.getDB("bergerie");
		DBCollection listeMoutons = bergerie.getCollection("mouton");		
		DBObject moutonMongo = new BasicDBObject();
		moutonMongo.putAll(mouton.exporterHash());
		listeMoutons.insert(moutonMongo);
		mongo.close();
	}
	
	
}
