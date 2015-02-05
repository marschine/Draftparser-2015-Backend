package de.marrrschine.draftparser.draftparser_backend;

public class Util {
	public static String prepareThreadElements(String currentElement) {
		String[] newString = currentElement.split("-", 1);
		if (newString[0].equals(currentElement)) {
			newString = currentElement.split("–", 1);
		}
		String name = newString[0].split(",")[0].trim();
		return name;
	}

	public static String[] prepareSelection(String currentElement)
			throws Exception {
		String[] selection = currentElement.split("-", 2);
		String[] returnSelection = new String[3];
		if (selection[0].contains("#")) {
			System.out.println(selection[0]);
			String[] teamelement = selection[0].split(" ", 2);
			String[] teamRaw = teamelement[1].trim().split("\\s");
			returnSelection[0] = teamRaw[0];
			String playerNameRaw = selection[1].split(">", 2)[1];
			String playerName = playerNameRaw.split(",", 2)[0].trim();
			String firstNameRaw = playerName.split(" ", 2)[0];
			String lastname = playerName.split(" ", 2)[1];
			if (firstNameRaw.contains("*")) {
				firstNameRaw = firstNameRaw.substring(1);
			}
			returnSelection[1] = firstNameRaw;
			returnSelection[2] = lastname;
			return returnSelection;
		} else {
			throw new Exception("Team or Player not parsable");
		}
	}

	public static Prospect createProspect(String[] el) throws Exception {
		int rank = Integer.parseInt(el[0]);
		String name;
		if (el[1].contains("*")) {
			name = el[1].substring(1);
		} else {
			name = el[1];
		}
		String firstname = name.split(" ", 2)[0];
		String lastname = name.split(" ", 2)[1];
		String pos = el[2];
		int posRank = Integer.parseInt(el[3]);
		String school = el[4];
		String year = el[5];
		String height = el[6];
		String weight = el[7];
		Prospect currentProspect = new Prospect(rank, firstname, lastname, pos,
				posRank, school, year, height, weight);
		return currentProspect;
	}

	public static String prepareThreadProspect(String currentLine) {
		String[] newString = currentLine.split("-");
		if (newString[0].equals(currentLine)) {
			newString = currentLine.split("–");
		}
		String name = newString[1].split(",")[0].trim();
		return name;
	}
}