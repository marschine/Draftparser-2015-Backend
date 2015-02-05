package de.marrrschine.draftparser.draftparser_backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

public class ProspectService {

	Mongo mongo;
	Morphia morphia;
	Datastore ds;
    TalkCrawler talkCrawler;

	public ProspectService() throws UnknownHostException{
		super();
		this.mongo = new MongoClient();
		this.morphia = new Morphia();
		this.ds = morphia.createDatastore(mongo, "dbTest");
		talkCrawler = new TalkCrawler();
	}
//
//	public ProspectList getProspects() throws Exception {
//		this.setTaken();
//		// look for entries untaken
//		Query<Prospect> query = ds.createQuery(Prospect.class);
//		ArrayList<Prospect> prospectListRaw = (ArrayList<Prospect>) query
//				.asList();
//		ProspectList prospectList = new ProspectList(prospectListRaw);
//		return prospectList;
//	}
//
//	public String getOtc() throws IOException {
//		return crawler2.getOTC();
//	}

	public boolean setTaken() throws Exception {
		List<Prospect> draftedProspects = talkCrawler.getSelections();
		int i = 0;
		for (Prospect prospect : draftedProspects) {
			i++;
			String firstname = prospect.getFirstname();
			String lastname = prospect.getLastname();
			String team = prospect.getTeam();
			Query<Prospect> query = ds.createQuery(Prospect.class)
					.field("lastname").equal(lastname);
			query.field("firstname").equal(firstname);
			UpdateOperations<Prospect> ops = ds.createUpdateOperations(
					Prospect.class).set("taken", true);
			ds.update(query, ops);
			ops = ds.createUpdateOperations(Prospect.class).set("team", team);
			ds.update(query, ops);
			ops = ds.createUpdateOperations(Prospect.class).set("overall", i);
			ds.update(query, ops);
		}
		return true;
	}

	public boolean reset() throws Exception {
		URL url = new URL(
				"http://lvps87-230-26-65.dedicated.hosteurope.de/files/public-docs/prospects.txt");
		String currentLine;
		URLConnection conn = url.openConnection();
		BufferedReader readFile = new BufferedReader(new InputStreamReader(
				conn.getInputStream()));
		// ProspectList prospectList = new ProspectList();
		
		ds.getCollection(Prospect.class).remove(new BasicDBObject());
		while ((currentLine = readFile.readLine()) != null) {
			saveCurrentLineProspect(currentLine, ds);
		}
		this.setTaken();
		return true;
	}

	public Prospect saveCurrentLineProspect(String currentLine, Datastore ds)
			throws Exception {
		String changedLine = currentLine.replaceAll("\\t+", ";").trim();
		String[] el = changedLine.split(";");
		if (!el[0].equals("")){
			Prospect currentProspect = Util.createProspect(el);
			ds.save(currentProspect);
			return currentProspect;
		}
		throw new Exception("Fehler beim speichern der Prospects!");
	}
//
//	public ProspectList getNewLiveProspects() throws Exception {
//		this.setTaken();
//		// look for entries untaken
//		Query<Prospect> query = ds.createQuery(Prospect.class).field("taken")
//				.equal(false);
//		ArrayList<Prospect> prospectListRaw = (ArrayList<Prospect>) query
//				.asList();
//		ProspectList prospectList = new ProspectList(prospectListRaw.subList(0,
//				100));
//		return prospectList;
//	}
}
