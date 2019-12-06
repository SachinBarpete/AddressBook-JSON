package com.bridgelabz.addressbook.repository;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.bridgelabz.addressbook.model.Person;

/**
 * @author Sachin Barpete
 * @purpose connection class to json file for read and write
 *
 */
public class Connection {
	static ObjectMapper mapper = new ObjectMapper();

	/**
	 * @param list
	 * @purpose read the data from json file
	 * @return list of person
	 */
	@SuppressWarnings("rawtypes")
	public static List readFile(List<Person> list) {

		try {
			list = mapper.readValue(new File("addressBook.json"), new TypeReference<List<Person>>() {
			});

		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;

	}

	/**
	 * @param list
	 * @purpose write the data into json file
	 */
	@SuppressWarnings("deprecation")
	public static void writeFile(List<Person> list) {

		try {
			mapper.defaultPrettyPrintingWriter().writeValue(new File("addressBook.json"), list);
			String jsonString = mapper.writeValueAsString(list);
			System.out.println(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
