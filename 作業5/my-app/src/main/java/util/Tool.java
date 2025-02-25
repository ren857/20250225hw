package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import model.Consmer;
import model.Employee;

public class Tool {

	public static void main(String[] args) {
		
		// 讀取並檢查
		Employee readEmployee = (Employee) Tool.read("employee.txt");
		if (readEmployee != null && readEmployee.getEmployeeID() != null) {
		    System.out.println("Employee ID: " + readEmployee.getEmployeeID());
		} else {
		    System.out.println("Employee ID is null or consmer is not found.");
		}
		Consmer readConsmer = (Consmer) Tool.read("consmer.txt");
		if (readConsmer != null && readConsmer.getConsmerID() != null) {
		    System.out.println("Consmer ID: " + readConsmer.getConsmerID());
		} else {
		    System.out.println("Consmer ID is null or consmer is not found.");
		}

	}

	public static void save(Object s, String filename) {

		try {
			FileOutputStream fos = new FileOutputStream(filename);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(s);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Object read(String filename) {
		Object o = null;
		try {
			FileInputStream fis = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fis);
			o = ois.readObject();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;

	}
	
	public static List<String> readName(String filename){
		List<String> names = new ArrayList<>();
		Consmer consmer = (Consmer) read(filename);
		if(consmer != null) {
			names.add(consmer.getName());
		}
		return names;
		
	}
}
