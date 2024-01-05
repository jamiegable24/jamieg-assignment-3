package com.coderscampus.assignment3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserService {

	BufferedReader fileReader = null; // Instantiates fileReader with a null value
	POJO user = new POJO(); // Instantiates user from POJO
	POJO[] users = new POJO[4]; // Instantiates users array containing 4 objects
	{
		// Reads data.text file and assigns to a variable "line"
		try {
			fileReader = new BufferedReader(new FileReader("dataAssignment3.txt"));
			String line;

			// Splits dataAssignment3.text by comma into separate lines
			int i = 0;
			while ((line = fileReader.readLine()) != null) {
				String[] loginArray = line.split(",");

				// Assigns each entry into array
				String username = loginArray[0];
				String password = loginArray[1];
				String name = loginArray[2];

				// Creates new user for every iteration through the loops
				user = new POJO();

				user.setUsername(username);
				user.setPassword(password);
				user.setName(name);

				// Iterates through each user in the array
				users[i] = user;
				i++;
			}

			// Returns error if file not found or there is an I/O exception
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("I/O exception");
			e.printStackTrace();
		} finally {
			try {
				// Closes file reader
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}