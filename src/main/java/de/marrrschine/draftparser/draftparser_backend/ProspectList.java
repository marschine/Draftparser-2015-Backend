package de.marrrschine.draftparser.draftparser_backend;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProspectList {
	private List<Prospect> prospectList;

	public ProspectList() {
		super();
		this.prospectList = new ArrayList<Prospect>();
	}

	public ProspectList(List<Prospect> prospectList) {
		super();
		this.prospectList = prospectList;
	}

	public List<Prospect> getProspectList() {
		return prospectList;
	}

	public void setProspectList(List<Prospect> prospectList) {
		this.prospectList = prospectList;
	}
	
	public void addProspect(Prospect prospect){
		this.prospectList.add(prospect);
	}

	public List<Prospect> getFirstN(int n){
		return this.prospectList.subList(0, n);
	}

	@Override
	public String toString() {
		return "[prospectList=" + prospectList + "]";
	}
}
