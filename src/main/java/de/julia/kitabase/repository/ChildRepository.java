package de.julia.kitabase.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import de.julia.kitabase.model.Child;;

public interface ChildRepository extends JpaRepository<Child, Long> {
	
	Optional<Child> findById(@Param(value = "id") Long id);

	Optional<Child> findByLastNameIgnoreCase(@Param(value = "lastName") String lastName);
	
	Optional<Child> findByFirstNameIgnoreCase(@Param(value = "firstName") String firstName);
	
	
//	Iterable<Child> findAll(@Param(value = "groupName") String groupName);
	
	List<Child> findByGroupNameIgnoreCase(@Param(value = "groupName") String groupName);
	
}
