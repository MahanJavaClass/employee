package ir.mahan.train.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataBase {
	private List<Person> people;

	public DataBase() {
		people = new ArrayList<>();
	}

	public void addPerson(Person p) {
		people.add(p);
	}

	@SuppressWarnings("unused")
	private void deletePerson(int index) {
		people.remove(index);
	}

	public void saveToFile(File file) throws IOException {

		FileOutputStream fileStream = new FileOutputStream(file);
		ObjectOutputStream os = new ObjectOutputStream(fileStream);
		Person[] persons = people.toArray(new Person[people.size()]);
		os.writeObject(persons);
		os.close();

	}

	public List<Person> loadFromFile(File file) throws IOException {
		// TODO Auto-generated method stub

		FileInputStream fileStream = new FileInputStream(file);
		ObjectInputStream os = new ObjectInputStream(fileStream);
		try {
			Person[] persons = (Person[]) os.readObject();
			people.clear();
			people.addAll(Arrays.asList(persons));

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		people.toArray(new Person[people.size()]);
		os.close();
		return people;

	}

	public List<Person> getPeopleList() {
		return people;
	}
}
