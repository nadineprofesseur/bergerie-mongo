package donnee;

import java.util.Arrays;
import java.util.Map;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

import modele.Mouton;

public class MoutonDAO {

	protected DBCollection listeMoutons = null;
	
	public MoutonDAO()
	{
		// https://stackoverflow.com/questions/35597930/sockettimeout-with-opened-connection-in-mongodb/35777711
		// http://mongodb.github.io/mongo-java-driver/3.4/driver/tutorials/authentication/
		// http://mongodb.github.io/mongo-java-driver/3.6/javadoc/?com/mongodb/MongoCredential.html
		MongoCredential acces = MongoCredential.createCredential("Chloe", "Boutique", "admin".toCharArray());
		String uri = "mongodb://Chloe:admin@cluster0-shard-00-00-zoa4s.mongodb.net:27017";
		String serveur = "cluster0-shard-00-00-zoa4s.mongodb.net:27017";
		MongoClientOptions.Builder options = MongoClientOptions.builder();
		options.socketKeepAlive(true);		
		// http://mongodb.github.io/mongo-java-driver/3.6/javadoc/com/mongodb/MongoClient.html
		MongoClient mongo = new MongoClient(new ServerAddress(serveur), Arrays.asList(acces), options.build());
		DB bergerie = mongo.getDB("Boutique");
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
