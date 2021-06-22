package de.julia.kitabase.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Child {
	
	@Id @GeneratedValue 
	private Long id;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = true)
	private String groupName;
	

	public Child() {
		super();
	}

	public Child(String lastName, String firstName) {
		this.lastName = lastName;
		this.firstName = firstName;
	}
	
	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	  @Override
	  public boolean equals(Object o) {

	    if (this == o)
	      return true;
	    if (!(o instanceof Child))
	      return false;
	    Child child = (Child) o;
	    return Objects.equals(this.id, child.id) && Objects.equals(this.lastName, child.lastName)
	        && Objects.equals(this.firstName, child.firstName);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(this.id, this.lastName, this.firstName);
	  }

	  @Override
	  public String toString() {
	    return "Child{" + "id=" + this.id + ", "
	    		+ "first name ='" + this.firstName + '\'' + ", "
	    				+ "last name ='" + this.lastName + '\'' + ", "
	    						+ "group name ='" + this.groupName + '}';
	  }
	
}
