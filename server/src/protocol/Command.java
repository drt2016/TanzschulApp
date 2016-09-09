package protocol;

public enum Command {
	getall("getall"), register("register"), login("login"), updatechart("updatechart"), updateprofile("updateprofile"),getprofile("getprofile"), foreignprofile("foreignprofile"),getkurs("getkurs"),updatelink("updatelink"), alogin("alogin"),agetkurs("agetkurs"),addkurs("addKurs"),adeletekurs("adeletekurs");

	private String text;

	private Command(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}

	public static Command fromString(String text) {

		if (text == null) {
			return null;
		}

		for (Command c : Command.values()) {
			if (c.text.equals(text)) {
				return c;
			}
		}

		return null;

	}

}


