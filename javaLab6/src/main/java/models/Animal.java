package models;

public class Animal {
	
	protected int id;
	protected String name;	
	protected double weight;
	protected int age;
	
	public Animal() {
	};
	public Animal(String name, int age, double weight) {
		if (age > 0)
			this.age = age;
		if (weight > 0)
			this.weight = weight;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public int getAge() {
		return age;
	}
	public double getWeight() {
		return weight;
	}
	public String getName() {
		return name;
	}
	
	public void setAge(int age) {
		if (age > 0)
			this.age = age;
	}
	public void setWeight(double weight) {
		if (weight > 0)
			this.weight = weight;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name + ", " + age + " years, " + weight + "kg, "; 
	}
	
}
