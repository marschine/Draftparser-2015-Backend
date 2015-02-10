package de.marrrschine.draftparser.draftparser_backend;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/players")
public class Players {

	@Autowired
	ProspectService prospectService;
	
	@GET
	@Path("/reset")
	public void resetDB() throws Exception {
		prospectService.reset();
	}

	@GET
	@Path("/live")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Prospect> getLive() throws Exception {
		return prospectService.getLiveProspects();
	}
}
