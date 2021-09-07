package com.Examples.Java8.Streams;


public class Student implements Cloneable
{
	
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", city=" + city + ", country=" + country + ", state=" + state
				+ ", standard=" + standard + "]";
	}
	protected Object clone() throws CloneNotSupportedException {
		
		return super.clone();
	}
	private int id;
	private String name;
	private String city;
	private String country;
	private String state;
	private int standard;
	public Student(int id, String name, String city, String country, String state,int standard) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.country = country;
		this.state = state;
		this.standard=standard;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getStandard() {
		return standard;
	}
	public void setStandard(int standard) {
		this.standard = standard;
	}
	
	
	
	
	

}
