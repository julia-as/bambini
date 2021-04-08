package de.julia.kitabase.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.julia.kitabase.exceptions.ChildNotFoundException;
import de.julia.kitabase.model.Child;
import de.julia.kitabase.repository.ChildRepository;


@RestController
public class ChildController {
	
	@Autowired
	private final ChildRepository repository;
	
	@Autowired
	EntityManager entityManager;
	
	ChildController(ChildRepository repository) {
		this.repository = repository;
	}

	 // Aggregate root
	 // tag::get-aggregate-root[]
	@GetMapping("/children")
	public List<Child> allChildren() {
		return repository.findAll();
	}
	// end::get-aggregate-root[]
	
	
	// Get all children of one group
	@GetMapping("/children/{groupName}")
	public List<Child> allChildrenPerGroup(@PathVariable String groupName) {
		System.out.println("groupName: " + groupName);
		return repository.findByGroupNameIgnoreCase(groupName);
	}
	
	
	// Get child by ID
	@GetMapping("/child/{id}") 
	public Child getChildById(@PathVariable(value="id", required=true) Long id) {
		return  repository.findById(id)
				.orElseThrow(() -> new ChildNotFoundException(id));
	}


	// Get child by name, send last name as request parameter "lastName={lastName}"
	@GetMapping("/child/lastName") 
	public Child getChildByLastName(@RequestParam(value="lastName") String lastName) {
		return  repository.findByLastNameIgnoreCase(lastName)
				.orElseThrow(() -> new ChildNotFoundException(lastName));
	}
	
	
	// Get child by first name, send first name as request parameter "firstName={firstName}"
	@GetMapping("/child/firstName") 
	public Child getChildByFirstName(@RequestParam(value="firstName") String firstName) {
		return  repository.findByFirstNameIgnoreCase(firstName)
				.orElseThrow(() -> new ChildNotFoundException(firstName));
		}
		
	
	@PostMapping("/children")
	public Child newChild(@RequestBody Child newChild) {
		System.out.println("new child: " + newChild.toString());
		return repository.save(newChild);
	}
	
	
	// Replace child
	@PutMapping("/child/{id}")
	public Child replaceChild(@RequestBody Child newChild, @PathVariable Long id) {
		 return repository.findById(id)
				 .map(child -> {
					 child.setFirstName(newChild.getFirstName());
					 child.setLastName(newChild.getLastName());
					 child.setGroupName(newChild.getGroupName());
					 return repository.save(child);
				 })
				 .orElseGet(() -> {
					 newChild.setId(id);
					 return repository.save(newChild);
				 });
	}
	
	
	// Delete child
	@DeleteMapping("/child/{id}")
	public void deleteChild(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
}
