package main;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.sql.ResultSet;
import postgreSQL.*;
import models.*;

public class Program {
	
	public static String pause() {
		System.out.println("Press Any Key To Continue...");
		return new java.util.Scanner(System.in).nextLine();
	}
	
	public static void main(String[] argv) {
		List<Animal> animals = Arrays.asList(
				new Animal("Bonny", 5, 11.2),
				new Animal("Fluffy", 3, 9.8),
				new Animal("Endy", 11, 45.5),
				new Animal("Luna", 5, 11.2),
				new Animal("Jasper", 3, 5.6)
			);
		try {
			for (Animal a : animals)
				QueryTool.insertAnimal(a);														//C
			pause();
			
			QueryTool.updateAnimal(new Animal("Shadow",  4, 13.3), 2);							//U
			pause();
			
			QueryTool.deleteAnimalById(2);														//D
			pause();
			
			ResultSet rs = QueryTool.selectAnimalById(1);										//R
			while (rs.next())
				System.out.println(new Animal(rs.getString(2), rs.getInt(3), rs.getFloat(4)));
			pause();
				
			rs = QueryTool.sortAnimal();
			while (rs.next())
				System.out.println(new Animal(rs.getString(2), rs.getInt(3), rs.getFloat(4)));
			pause();
			
			rs= QueryTool.startWithB();
			while (rs.next())
				System.out.println(new Animal(rs.getString(2), rs.getInt(3), rs.getFloat(4)));
			pause();
			
			rs= QueryTool.ageMoreThanAvg();
			while (rs.next())
				System.out.println(new Animal(rs.getString(2), rs.getInt(3), rs.getFloat(4)));
			pause();
			
			rs = QueryTool.selectAnimal();														//R
			while (rs.next())
				System.out.println(new Animal(rs.getString(2), rs.getInt(3), rs.getFloat(4)));
			pause();
			
			QueryTool.deleteAnimal();															//D
			QueryTool.alterAnimal();
		}	
		catch(SQLException e) {
			System.out.println("Error: " + e.getMessage());
			return;
		}

	}
}