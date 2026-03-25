package com.coforge.entities;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="customerTable")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="custid")
	private long custId;
	@Column(name="custname")
	private String custName;
	@Column(name="city")
	private String city;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="custId" ,referencedColumnName = "custId")
	private List<Order>orders;
	public Customer(String custName, String city, List<Order> orders) {
		super();
		this.custName = custName;
		this.city = city;
		this.orders = orders;
	}
	
	
	

}
