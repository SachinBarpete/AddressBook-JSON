package com.bridgelabz.addressbook.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.bridgelabz.addressbook.model.Person;
import com.bridgelabz.addressbook.repository.Connection;
import com.bridgelabz.addressbook.service.Service;

/**
 * @author Sachin Barpete
 * @purpose controller class for run address book application
 *
 */
public class AddressBook {
	static Scanner sc = new Scanner(System.in);

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		List<Person> list = new LinkedList<>();

		System.out.println(" Enter : \n 1 for add person" + "\n 2 for edit details" + "\n 3 for delete person record"
				+ "\n 4 for sort by firstName" + "\n 5 for sort by zipcode");
		System.out.println(" ------------- ");
		int ch = sc.nextInt();
		switch (ch) {
		case 1:
			list = Connection.readFile(list);
			Service.add(list);
			Connection.writeFile(list);
			System.out.println("data added successfully");
			break;
		case 2:
			list = Connection.readFile(list);
			Service.edit(list);
			Connection.writeFile(list);
			break;
		case 3:
			list = Connection.readFile(list);
			Service.delete(list);
			Connection.writeFile(list);
			break;
		case 4:
			list = Connection.readFile(list);
			Service.sortByFirstName(list);
			Connection.writeFile(list);
			break;
		case 5:
			list = Connection.readFile(list);
			Service.sortByZipcode(list);
			Connection.writeFile(list);
			break;
		default:
			System.out.println("Enter valid number");
		}

	}

}
