package postgreSQL;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import models.*;
public class QueryTool {
	
	private static final String insert = "INSERT INTO %s(%s) VALUES(%s);"; 	//C
	private static final String select = "SELECT * FROM %s;";				//R
	private static final String update = "UPDATE %s %s WHERE id = %d";		//U						
	private static final String delete = "DELETE FROM %s;";					//D

	private static final String by_Id = "%s WHERE id = %d";
	private static final String alter_sequence = "ALTER SEQUENCE %s_id_seq RESTART;";
	
	private static final String animal = "animal";
	private static final String cat = "cat";
	private static final String tiger = "tiger";
	
	private static final String animal_attribute = "name, age, weight"; 
	private static final String cat_attribute = animal_attribute + ", color, category";
	private static final String tiger_attribute =  cat_attribute + ", numOfEmployee";
	
	private static final String animal_values = "\'%s\', %d, %f"; 
	private static final String cat_values = animal_values + ", \'%s\', \'%s\'";
	private static final String tiger_values = cat_values + ", %d";
	
	private static final String animal_update = "SET name = \'%s\', age = %d, weight = %f"; 
	private static final String cat_update = animal_update + ", color = \'%s\', category =  \'%s\'";
	private static final String tiger_update = cat_update + ", numOfEmployee = %d";
	
	
	private static void executeUpdate(String query) throws SQLException {
		Connection connection = Connector.Connect();
		if (connection != null) {
		Statement statement = connection.createStatement();
		statement.executeUpdate(query);
		Connector.Disconnect(connection);
		}
	}
	private static ResultSet executeQuery(String query) throws SQLException {
		Connection connection = Connector.Connect();
		ResultSet result = null;
		if (connection != null) {
		Statement statement = connection.createStatement();
		result = statement.executeQuery(query);
		statement.close();
		Connector.Disconnect(connection);
		}
		return result;
	}
	
	public static void insertAnimal(Animal a) throws SQLException {	
		executeUpdate(String.format(String.format(insert, animal, animal_attribute, animal_values),
				a.getName(), a.getAge(), a.getWeight()));
	}
	public static void insertCat(Cat c) throws SQLException {	
		executeUpdate(String.format(String.format(insert, cat, cat_attribute, cat_values),
				c.getName(), c.getAge(), c.getWeight(), c.getColor(), c.getCategory()));
	}
	public static void insertTiger(Tiger t) throws SQLException {	
		executeUpdate(String.format(String.format(insert, tiger, tiger_attribute, tiger_values),
				t.getName(), t.getAge(), t.getWeight(), t.getColor(), t.getCategory(), t.getNumOfEatenEmployee()));
	}
	
	public static ResultSet selectAnimal() throws SQLException {
		return executeQuery(String.format(select, animal));
	}
	public static ResultSet selectCat() throws SQLException {
		return executeQuery(String.format(select, cat));
	}
	public static ResultSet selectTiger() throws SQLException {
		return executeQuery(String.format(select, tiger));
	}
	
	public static ResultSet selectAnimalById(int id) throws SQLException {
		return executeQuery(String.format(String.format(select, by_Id), 
				animal, id));
	}
	public static ResultSet selectCatById(int id) throws SQLException {
		return executeQuery(String.format(String.format(select, by_Id), 
				cat, id));
	}
	public static ResultSet selectTigerById(int id) throws SQLException {
		return executeQuery(String.format(String.format(select, by_Id),
				tiger, id));
	}
	
	public static void updateAnimal(Animal a, int id) throws SQLException {
		executeUpdate(String.format(String.format(update, animal, animal_update, id),
				a.getName(), a.getAge(), a.getWeight()));
	}
	public static void updateCat(Cat c, int id) throws SQLException {
		executeUpdate(String.format(String.format(update, cat, cat_update, id),
				c.getName(), c.getAge(), c.getWeight(), c.getColor(), c.getCategory()));
	}
	public static void updateTiger(Tiger t, int id) throws SQLException {
		executeUpdate(String.format(String.format(update, tiger, tiger_update, id),
				t.getName(), t.getAge(), t.getWeight(), t.getColor(), t.getCategory(), t.getNumOfEatenEmployee()));
	}
	
	public static void deleteAnimal() throws SQLException {
		executeUpdate(String.format(delete, animal));
	}
	public static void deleteCat() throws SQLException {
		executeUpdate(String.format(delete, cat));
	}
	public static void deleteTiger() throws SQLException {
		executeUpdate(String.format(delete, tiger));
	}
	
	public static void deleteAnimalById(int id) throws SQLException {
		executeUpdate(String.format(String.format(delete, by_Id),
				animal, id));
	}
	public static void deleteCatById(int id) throws SQLException {
		executeUpdate(String.format(String.format(delete, by_Id),
				cat, id));
	}
	public static void deleteTigerById(int id) throws SQLException {
		executeUpdate(String.format(String.format(delete, by_Id),
				tiger, id));
	}
	
	public static void alterAnimal() throws SQLException {
		executeUpdate(String.format(alter_sequence, animal));
	}
	public static void alterCat() throws SQLException {
		executeUpdate(String.format(alter_sequence, cat));
	}
	public static void alterTiger() throws SQLException {
		executeUpdate(String.format(alter_sequence, tiger));
	}
	
	private static final String animal_orderBy = "select * from animal order by(name);";
	private static final String animal_startWithB = "select * from animal where name like 'B%';";
	private static final String animal_ageMoreAvg = "select * from animal where age > (select avg(age) from animal);";
	
	public static ResultSet sortAnimal() throws SQLException {
		return executeQuery(animal_orderBy);
	}
	public static ResultSet startWithB() throws SQLException {
		return executeQuery(animal_startWithB);
	}
	public static ResultSet ageMoreThanAvg() throws SQLException {
		return executeQuery(animal_ageMoreAvg);
	}
}
