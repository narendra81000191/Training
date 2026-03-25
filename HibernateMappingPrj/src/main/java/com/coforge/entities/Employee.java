package com.coforge.entities;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long  eid;
	@Size(min = 3,message = "Ename should have atleast 3 charcter.")
	@NotBlank(message = "It cannot be null.")
	private String ename;
	@NotBlank(message = "Not to be empty")
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
	private String email;
	@NotBlank
	@Pattern(regexp = "[6789][0-9]{9}",message = "Invalid mobile number, mobile number must start with exact length of 10 digits")
	private String mobile;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "aid",referencedColumnName = "aid")
	private Address address;
	public Employee(String ename, String email, String mobile, Address address) {
		super();
		this.ename = ename;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
	}
	
	
	

}
