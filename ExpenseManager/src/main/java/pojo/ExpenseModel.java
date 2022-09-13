package pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ExpenseModel implements Serializable {

	@Id @GeneratedValue
	int id;
	
	String name;
	int cost;
	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	String descp;
	@Temporal(value=TemporalType.TIMESTAMP)
	Date date;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getdescp() {
		return descp;
	}
	public void setdescp(String descp) {
		this.descp = descp;
	}
	
}

