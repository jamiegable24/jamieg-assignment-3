package com.coderscampus.assignment3;

import java.util.Scanner;

public class UserLoginApplication {

	public static void main(String[] args) {

		UserService userService = new UserService(); // Instantiates UserService

		// Takes in user input
		Scanner scanner = new Scanner(System.in);


		int unsuccessfulLoginAttempts = 5; // sets the maximum # of attempts

		while (unsuccessfulLoginAttempts > 0) {

			System.out.println("Enter Username: ");
			String loginInput = scanner.next();

			System.out.println("Enter Password: ");
			String passwordInput = scanner.next();

			// Check if the login is valid
			 boolean loginSuccessful = false;
			for (POJO user1 : userService.users) {

				if (user1.getUsername().equalsIgnoreCase(loginInput) && user1.getPassword().equals(passwordInput)) {
					System.out.println("Welcome " + user1.getName());
					loginSuccessful = true;
					return;// Exits the program after successful login
				}
			}

			unsuccessfulLoginAttempts--;
			if (loginSuccessful = false) {
				System.out.println("Invalid login, please try again.");
			
			
			}
			if (unsuccessfulLoginAttempts == 0) {
				System.out.println("Too many failed attempts, you are now locked out.");
				
			}

		}
		// Closes scanner method
		scanner.close();
	}

}