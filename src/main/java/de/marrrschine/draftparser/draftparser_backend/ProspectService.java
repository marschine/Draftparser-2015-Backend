package de.marrrschine.draftparser.draftparser_backend;

import java.util.ArrayList;

public interface ProspectService {

	public boolean reset() throws Exception;
	
	public ArrayList<Prospect> getLiveProspects() throws Exception;

}
