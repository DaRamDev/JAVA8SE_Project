package chapter5.oop.good.copy;

public abstract class Employee {

	private String name;
	protected double salary;

	public Employee() {
		super();
	}
	

	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}


	public String getName() {
	    return this.name;
	}

	public double getSalary() {
	    return this.salary;
	}
	
    public abstract void manageSalary(double rate);


}