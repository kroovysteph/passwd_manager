import java.util.Set;
import java.util.HashSet;
import java.io.*;
import java.awt.datatransfer.*;
import java.awt.Toolkit;

public class Manager {

	private static Set<Account> accounts = new HashSet<Account>();

	public static void main(String[] args) throws IOException {

		load();
		if (args != null && args.length > 0 && !args[0].equals("listall")) {
			Account account = getByName(args[0]);
			String s = "test";
			System.out.println(account);


			//pw to clipboard (does not work yet)
			/**
			*  Toolkit toolkit = Toolkit.getDefaultToolkit();
			*  Clipboard clipboard = toolkit.getSystemClipboard();
			*  s = account.getPhrase();
			*  StringSelection strSel = new StringSelection(s);
			*  clipboard.setContents(strSel, null);
			*/

		} else if (args != null && args.length > 0 && args[0].equals("listall")) {
			//assert commandline-argument was "listall"
			int c = 1;
			for (Account acc : accounts) {
				//System.out.println(c++ + ". " + acc.getService());
				System.out.printf("%3d.\t%s\n", c++, acc.getService());
			}

		} else {
			System.out.println("\n====================================");
			System.out.println("Which service do you want to access?");
			System.out.println("====================================\n");
		}
	}

	public static Account getByName(String s) {
		for (Account a : accounts) {
			if (s.equals(a.getService())) {
				return a;
			}
		}
		return new Account("leider", "nicht", "hinterlegt");
	}

	/**
	*  reads out of list.txt and
	*  initializes accounts-Set.
	*/
	public static void load() throws IOException {
		String service = "";
		String login = "";
		String phrase = "";
		BufferedReader reader = new BufferedReader(new FileReader("list.txt"));
		while (reader.readLine() != null) {
			service = reader.readLine();
			login = reader.readLine();
			phrase = reader.readLine();
			accounts.add(new Account(service, login, phrase));
		}
	}
}
