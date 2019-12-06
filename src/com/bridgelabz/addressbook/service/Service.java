package com.bridgelabz.addressbook.service;

import java.util.List;
import java.util.Scanner;

import com.bridgelabz.addressbook.model.Person;

/**
 * @author Sachin Barpete
 * @purpose providing service to the controller
 *
 */
public class Service {
	static Scanner sc = new Scanner(System.in);

	/**
	 * @param list
	 * @purpose add the person details
	 */
	public static void add(List<Person> list) {
		Person p = new Person();
		System.out.println("Enter first name");
		p.setFirstName(sc.next());
		System.out.println("Enter last name");
		p.setLastName(sc.next());
		System.out.println("Enter Address");
		p.setAddress(sc.next());
		System.out.println("Enter city");
		p.setCity(sc.next());
		System.out.println("Enter state");
		p.setState(sc.next());
		System.out.println("Enter zipcode");
		p.setZipcode(sc.nextInt());
		System.out.println("Enter phone number");
		p.setPhoneNumber(sc.nextLong());
		list.add(p);
	}

	/**
	 * @param list
	 * @purpose edit person details
	 */
	public static void edit(List<Person> list) {
		System.out.println("Enter first name");
		String firstName = sc.next();
		System.out.println("Enter last name");
		String lastName = sc.next();

		for (int i = 0; i < list.size(); i++) {
			if (firstName.equals(list.get(i).getFirstName()) && lastName.equals(list.get(i).getLastName())) {
				Person p = new Person();
				p.setFirstName(firstName);
				p.setLastName(lastName);
				System.out.println("Enter Address");
				p.setAddress(sc.next());
				System.out.println("Enter city");
				p.setCity(sc.next());
				System.out.println("Enter state");
				p.setState(sc.next());
				System.out.println("Enter zipcode");
				p.setZipcode(sc.nextInt());
				System.out.println("Enter phone number");
				p.setPhoneNumber(sc.nextLong());
				list.remove(i);
				list.add(i, p);
				return;
			}
		}
		System.out.println("Enter valid name");
	}

	/**
	 * @param list
	 * @purpose delete person record from address book
	 */
	public static void delete(List<Person> list) {

		System.out.println("Enter first name");
		String firstName = sc.next();
		System.out.println("Enter last name");
		String lastName = sc.next();
		for (int i = 0; i < list.size(); i++) {
			if (firstName.equals(list.get(i).getFirstName()) && lastName.equals(list.get(i).getLastName())) {
				list.remove(i);
				return;
			}
		}
		System.out.println("Enter valid name");
	}

	/**
	 * @param list
	 * @purpose sort address book by first name
	 */
	public static void sortByFirstName(List<Person> list) {

		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i).getFirstName().compareToIgnoreCase(list.get(j).getFirstName()) > 0) {
					Person temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
		}
	}

	/**
	 * @param list
	 * @purpose sort address book by zip code
	 */
	public static void sortByZipcode(List<Person> list) {

		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {

				if (list.get(i).getZipcode() > list.get(j).getZipcode()) {
					Person temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
		}
	}

}
