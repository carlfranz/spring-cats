package org.carlof.owner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.websocket.server.PathParam;

import org.carlof.cat.Cat;
import org.carlof.cat.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OwnerController {

	@Autowired
	OwnerRepository ownerRepository;
	
	@Autowired
	CatRepository catRepository;
	
	@GetMapping(path="/owners",produces="application/json")
	public ResponseEntity<List<Owner>>  getOwners() {
		List<Owner> allOwners = (List<Owner>) ownerRepository.findAll(); 
		return ResponseEntity.ok(allOwners); 
	}
	
	@PostMapping(path="/owners",produces="application/json")
	public ResponseEntity<Owner> saveOwner(@RequestBody Owner owner) {
		ownerRepository.save(owner);
		return ResponseEntity.ok(owner); 
	}
	
	@PutMapping(path="/owners/{id}",produces="application/json")
	public ResponseEntity<Owner> saveOwner(@PathVariable(value = "id") Integer id, @RequestBody Owner pOwner) {
		Owner catOwner = (Owner)ownerRepository.findOne(id);
		
		Set<Cat> newCatList = new HashSet<Cat>();
		for (Cat pCat : pOwner.getCats()) {
			newCatList.add(catRepository.findOne(pCat.getId()));
		}
		catOwner.setCats(newCatList);
		
		Owner newCatOwner = ownerRepository.save(catOwner);
		return ResponseEntity.ok(newCatOwner); 
	}
}
