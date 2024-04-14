package class_and_object.OOP.encapsulation;

public class CarCar {
	private String name ;
	private int year ;
	
	protected CarCar(String name, int year){
		this.setName(name);
		this.setYear(year);
	}
	protected CarCar(CarCar x){
		this.copy(x);
	}
	
	public String pubName() {
		return name;
	}
	public int pubYear() {
		return year;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public void copy(CarCar x) {
		this.setName(x.pubName());
		this.setYear(x.pubYear());
		
	}
}
