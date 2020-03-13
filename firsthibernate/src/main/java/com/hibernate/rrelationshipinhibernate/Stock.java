package com.hibernate.rrelationshipinhibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Stock")
public class Stock {
	@Id
	@GeneratedValue
	@Column(name="stock_id")
	private int id;
	
	@Column(name="stock_name")
	private String name;
	@Column(name="stock_value")
	private double value;
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE}, 
			fetch=FetchType.EAGER)
	@JoinColumn(name="market_id")
	private Market market;
	public Stock() {
		
		// TODO Auto-generated constructor stub
	}
	public Stock( String name, double value,Market market) {
		super();
		
		this.name = name;
		this.value = value;
		this.market=market;
	}
	public Stock( String name, double value) {
		super();
		
		this.name = name;
		this.value = value;
		
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
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public Market getMarket() {
		return market;
	}
	public void setMarket(Market m) {
		this.market=m;
	}
	@Override
	public String toString() {
		return "Stock [id=" + id + ", name=" + name + ", value=" + value + ", market="+market+"]";
	}
	
}
