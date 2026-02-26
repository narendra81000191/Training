package com.company;

public class Person {
  public String Name;
  public int age;
  public Person(){
	  System.out.println("it is the default constructor");
	  }
  public Person(String Name,int age) {
	  this();
	  this.Name=Name.toUpperCase();
	  this.age=age;
  }
  public Person(String Name) {
	  this(Name,20);
	  this.Name=Name;
  }
  public String getName() {
	  return Name;
	  
  }
  public void setName(String Name) {
	  this.Name=Name;
  }
  public int getAge() {
	  return age;
  }
  public void setAge(int age) {
	  this.age=age;
  }
  @Override
  public String  toString()
  {
	  return "Person[name "+Name+",age "+age+"]";
  }
  }
  
  

