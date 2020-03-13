package com.hibernate.rrelationshipinhibernate;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Market")
public class Market {
	@Id
	@GeneratedValue
	@Column(name="market_id")
	private int id;
	@Column(name="market_name")
	private String name;
	@OneToMany(cascade={CascadeType.PERSIST,CascadeType.REMOVE}, 
			fetch=FetchType.EAGER, mappedBy = "market")
	private List<Stock> stockList;
	public Market() {
		
	}
	public Market(String name, List<Stock> stockList) {
		super();
		this.name = name;
		this.stockList = stockList;
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
	public List<Stock> getStockList() {
		return stockList;
	}
	public void setStockList(List<Stock> stockList) {
		this.stockList = stockList;
	}
	@Override
	public String toString() {
		return "Market [id=" + id + ", name=" + name +  "]";
	}
	
}
