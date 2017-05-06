package org.carlof.cat;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CatsController {
	
	@Autowired
	CatRepository catRepository;

	@GetMapping(path="/cats",produces="application/json")
	public ResponseEntity<List<Cat>>  getCats() {
		List<Cat> allCats = (List<Cat>) catRepository.findAll(); 
		return ResponseEntity.ok(allCats); 
	}
	
	@PostMapping(path="/cats",produces="application/json")
	public ResponseEntity<Cat> saveCat(@RequestBody Cat cat) throws URISyntaxException {
		Cat savedCat = catRepository.save(cat);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedCat);
	}
	
	@DeleteMapping(path="/cats/{id}")
	public ResponseEntity deleteCat(@PathVariable(value = "id") Integer id) {
		try {
			
			catRepository.delete(id);
			
		} catch(IllegalArgumentException e) {
			return ResponseEntity.badRequest().build();
		} catch(EmptyResultDataAccessException e) {
			return ResponseEntity.noContent().build(); //delete
		}
		return ResponseEntity.accepted().build();
	}
}
