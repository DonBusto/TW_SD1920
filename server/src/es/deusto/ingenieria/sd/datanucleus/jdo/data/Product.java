/**********************************************************************
Copyright (c) 2003 Andy Jefferson and others. 
 **********************************************************************/
package es.deusto.ingenieria.sd.datanucleus.jdo.data;


import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;




/*
 * Part 2 (RMI) Remember that in order to transfer objects they must have a special feature
 */

@PersistenceCapable(detachable="true")
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Product {

	protected String name;
	protected String description;
	protected double price;
	
	public Product(String name, String description, double price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String toString() {
		return "Product: " + name + " [" + description + "]";
	}
}