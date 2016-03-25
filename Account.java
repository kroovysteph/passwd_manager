public class Account {

	private String service = "";
	private String login = "";
	private String phrase = "";

	public void setService(String service) {
		this.service = service;
	}

	public void setPhrase(String phrase) {
		this.phrase = phrase;
	}

	public String getService() {
		return this.service;
	}

	public String getPhrase() {
		return this.phrase;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getLogin() {
		return this.login;
	}


	//constructor
	public Account(String service, String login, String phrase) {
		this.service = service;
		this.login = login;
		this.phrase = phrase;
	}

	public String toString() {
		String s = "\n============================================";
		s += ("\n service: \t" + "< " + this.service + " >");
		s += ("\n login: \t" + this.login);
		s += ("\n phrase: \t" + this.phrase);
		s += ("\n============================================\n");
		return s;
	}
}
