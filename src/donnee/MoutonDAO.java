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

	protected DBCollection listeMoutons = null;
	
	public MoutonDAO()
	{
		MongoClient mongo = new MongoClient();
		DB bergerie = mongo.getDB("bergerie");
		listeMoutons = bergerie.getCollection("mouton");		

		//		mongo.close();
	}
	
	public void ajouterMouton(Mouton mouton)
	{
		DBObject moutonMongo = new BasicDBObject();
		moutonMongo.putAll(mouton.exporterHash());
		listeMoutons.insert(moutonMongo);		
	}
	
	public Mouton trouverMoutonSelonNom(String nom)
	{
		DBObject critereMouton = new BasicDBObject("nom",nom);
		DBCursor pointeurMouton = listeMoutons.find(critereMouton);
		Map champsMoutonTrouve = pointeurMouton.one().toMap();
		Mouton moutonTrouve = new Mouton(champsMoutonTrouve);
		
		return moutonTrouve;
	}
	
	public void effacerMoutonSelonNom(String nom)
	{
		DBObject critereMouton = new BasicDBObject("nom",nom);
		this.listeMoutons.remove(critereMouton);		
	}
}
