/**********************************************************************
Copyright (c) 2003 Andy Jefferson and others. 
 **********************************************************************/
package es.deusto.ingenieria.sd.datanucleus.jdo.data;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.Join;

/*
 * Part 2 (RMI) Remember that in order to transfer objects they must have a special feature
 */

@PersistenceCapable(detachable = "true")
public class Shelf {

	private String identifier;
	@Persistent(defaultFetchGroup="true")
	@Join
	private List<Copy> copies;

	public Shelf(String identifier) {
			this.copies = new ArrayList<Copy>();
			this.identifier = identifier;
	}
	
	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
	public List<Copy> getCopies() {
		return copies;
	}
	
	public void addCopy(Copy c) {
		copies.add(c);
	}
	public void removeCopy(Copy c){
		copies.remove(c);
	}
	
	public String toString() {
		return "Shelf: " + identifier; 
	}


}