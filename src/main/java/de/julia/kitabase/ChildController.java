package de.julia.kitabase;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ChildController {
	
	private final ChildRepository repository;
	
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
	
//	@GetMapping("/children/{groupName}")
//	public List<Child> allChildrenPerGroup() {
//		return repository.findAll();
//	}
	
	
	// Get single child
	@GetMapping("/children/{groupName}/{id}") 
	public Child getChild(@PathVariable String groupName, Long id) {
		return  repository.findById(id)
				.orElseThrow(() -> new ChildNotFoundException(id));
	}
	
	
	@PostMapping("/children/{groupName}")
	public Child newChild(@RequestBody Child newChild) {
		return repository.save(newChild);
	}
	
	
	// Replace child
	@PutMapping("/{groupName}/{id}")
	public Child replaceChild(@RequestBody Child newChild, @PathVariable Long id) {
		 return repository.findById(id)
				 .map(child -> {
					 child.setFirstName(newChild.getFirstName());
					 child.setLastName(newChild.getLastName());
					 return repository.save(child);
				 })
				 .orElseGet(() -> {
					 newChild.setId(id);
					 return repository.save(newChild);
				 });
	}
	
	
	// Delete child
	@DeleteMapping("/{groupName}/{id}")
	public void deleteChild(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
}
