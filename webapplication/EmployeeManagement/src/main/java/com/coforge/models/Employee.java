package com.coforge.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor

@NoArgsConstructor
@Data           //// one for all setter gether one time 

public class Employee {

	private long eid;
	private String ename;
	private double salary;
	private String email;
	private String mobile;
	private LocalDate doj;
	private LocalDate dob;
	
}
