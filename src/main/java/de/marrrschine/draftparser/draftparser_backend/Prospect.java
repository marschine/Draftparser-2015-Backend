package de.marrrschine.draftparser.draftparser_backend;

import javax.xml.bind.annotation.XmlRootElement;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@XmlRootElement
@Entity
public class Prospect {

	@Id
	ObjectId id;

	private int rank;

	private String firstname;

	private String lastname;

	private String pos;

	private int posRank;

	private String school;

	private String classYear;

	private String height;

	private String weight;

	private String projRnd;

	private String team = "";

	private int overall = 999;

	private boolean taken = false;

	public Prospect() {
		super();
	}

	public Prospect(int rank, String firstname, String lastname, String pos, int posRank,
			String school, String classYear, String height, String weight) {
		super();
		this.rank = rank;
		this.firstname = firstname;
		this.lastname = lastname;
		this.pos = pos;
		this.posRank = posRank;
		this.school = school;
		this.classYear = classYear;
		this.height = height;
		this.weight = weight;
	}

	public Prospect(String firstname, String lastname, String team) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.team = team;
	}

	public int getOverall() {
		return overall;
	}

	public void setOverall(int overall) {
		this.overall = overall;
	}

	public boolean isTaken() {
		return taken;
	}

	public void setTaken(boolean taken) {
		this.taken = taken;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public int getPosRank() {
		return posRank;
	}

	public void setPosRank(int posRank) {
		this.posRank = posRank;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getClassYear() {
		return classYear;
	}

	public void setClassYear(String classYear) {
		this.classYear = classYear;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getProjRnd() {
		return projRnd;
	}

	public void setProjRnd(String projRnd) {
		this.projRnd = projRnd;
	}

	public boolean equals(Prospect other) {
		if ((this.lastname.equalsIgnoreCase(other.lastname))
				&& (this.firstname.equalsIgnoreCase(other.firstname))) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Prospect [rank=" + rank + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", taken= " + taken + ", pos="
				+ pos + ", posRank=" + posRank + ", school=" + school
				+ ", classYear=" + classYear + ", height=" + height
				+ ", weight=" + weight + ", projRnd=" + projRnd + "]";
	}

}
