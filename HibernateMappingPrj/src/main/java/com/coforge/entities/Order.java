package com.coforge.entities;
 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@AllArgsConstructor
@Data
@Entity
@Table(name="order_table")
public class Order {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ordId;
 
    private String proname;
    private double amount;
 
    public Order() {}
 
    public Order(String proname, double amount) {
        this.proname = proname;
        this.amount = amount;
    }
}
 
 