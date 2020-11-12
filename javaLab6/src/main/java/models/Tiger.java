package models;

public class Tiger extends Cat {
	
	private int numOfEatenEmployee;
	
	public Tiger() {
		super();
	};
	public Tiger(String name, int age, double weight, String color, Categories CATegory, int numOfEatenEmployee) {
		super(name, age, weight, color, CATegory);
		this.numOfEatenEmployee = numOfEatenEmployee;
	}
	
	public int getNumOfEatenEmployee() {
		return numOfEatenEmployee;
	}
	
	public void setNumOfEatenEmployee(int numOfEatenEmployee) {
		this.numOfEatenEmployee = numOfEatenEmployee;
	}
	
	@Override
	public String toString() {
		return super.toString() + " NumOfEatenEmployees: "+ numOfEatenEmployee; 
	}
}
