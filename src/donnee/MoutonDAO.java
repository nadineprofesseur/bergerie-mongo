package donnee;

import java.util.Map;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
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
	
	public Mouton trouverMoutonSelonNom(String nom)
	{
		MongoClient mongo = new MongoClient();
		DB bergerie = mongo.getDB("bergerie");
		DBCollection listeMoutons = bergerie.getCollection("mouton");		
		
		DBObject critereMouton = new BasicDBObject("nom",nom);
		DBCursor pointeurMouton = listeMoutons.find(critereMouton);
		Map champsMoutonTrouve = pointeurMouton.one().toMap();
		Mouton moutonTrouve = new Mouton(champsMoutonTrouve);
		
		mongo.close();	
		
		return moutonTrouve;
	}
	
}
