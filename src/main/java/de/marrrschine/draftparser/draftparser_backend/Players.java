package de.marrrschine.draftparser.draftparser_backend;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/players")
public class Players {

	@GET
	@Path("/reset")
	public void resetDB() throws Exception {
		ProspectService prospectService = new ProspectService();
		prospectService.reset();
	}
}
