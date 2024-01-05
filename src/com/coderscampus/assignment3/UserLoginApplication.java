package com.coderscampus.assignment3;

import java.util.Scanner;

public class UserLoginApplication {

	public static void main(String[] args) {

		UserService userService = new UserService(); // Instantiates UserService

		// Takes in user input
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter Username: ");
		String loginInput = scanner.next();

		System.out.println("Enter Password: ");
		String passwordInput = scanner.next();

		int unsuccessfulLoginAttempts = 4;

		while (unsuccessfulLoginAttempts != 0) {
			for (POJO user1 : userService.users) {

				if (user1.getUsername().equalsIgnoreCase(loginInput) && user1.getPassword().equals(passwordInput)) {
					System.out.println("Welcome " + user1.getName());
					return;
				}
			}
			System.out.println("Invalid login, please try again.");
			unsuccessfulLoginAttempts--;

			System.out.println("Enter Username: ");
			loginInput = scanner.next();

			System.out.println("Enter Password: ");
			passwordInput = scanner.next();

			if (unsuccessfulLoginAttempts == 0) {
				System.out.println("Too many failed attempts, you are now locked out.");
			}

		}
		// Closes scanner method
		scanner.close();
	}

}
