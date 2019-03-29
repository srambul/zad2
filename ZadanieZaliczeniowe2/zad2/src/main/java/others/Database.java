package others;

import java.util.ArrayList;

public class Database {

	private static ArrayList<User> users = new ArrayList<>();
	private static ArrayList<String> usernames = new ArrayList<>();
	private static ArrayList<String> emails = new ArrayList<>();

	public static boolean addUser(User user) {
		boolean contains = false;

		contains = emails.contains(user.getEmail());
		if (contains)
			return false;
		contains = usernames.contains(user.getUserName());
		if (contains)
			return false;
		emails.add(user.getEmail());
		usernames.add(user.getUserName());
		users.add(user);

		return true;
	}

	public static User getUser(String username, String password) {

		for (User u : users) {
			if (u.getUserName().equals(username)) {
				if (u.getPassword().equals(password))
					return u;
			}
		}
		return null;
	}

	public static ArrayList<User> getUsers() {
		return users;
	}

	public static void changePremium(String username, boolean changePremium) {
		for (User user : users) {
			if (user.getUserName().equals(username)) {
				user.setPremium(changePremium);
				break;
			}
		}
	}
}
