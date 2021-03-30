package de.julia.kitabase.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import de.julia.kitabase.model.Child;;

public interface ChildRepository extends JpaRepository<Child, Long> {
	
	@GetMapping
	Optional<Child> findById(@RequestParam(value="id") Long id);

//	@Query("SELECT * FROM children WHERE lastName = :lastName")
	@GetMapping
	List<Child> findByLastName(@RequestParam(value="lastName") String lastName);
	
//	@Query("SELECT * FROM children WHERE groupName = :groupName")
	@GetMapping
	List<Child> findByGroupName(@RequestParam(value="groupName") String groupName);
	
}
