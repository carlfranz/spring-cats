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
	
	@GetMapping(path="/owners/{id}",produces="application/json")
	public ResponseEntity<Owner>  getOwner(@PathVariable(value = "id") Integer id) {
		Owner owner = (Owner) ownerRepository.findOne(id); 
		return ResponseEntity.ok(owner); 
	}
	
	@PostMapping(path="/owners",produces="application/json")
	public ResponseEntity<Owner> saveOwner(@RequestBody Owner owner) {
		ownerRepository.save(owner);
		return ResponseEntity.ok(owner); 
	}
	
	@PutMapping(path="/owners/{id}",produces="application/json")
	public ResponseEntity<Owner> saveOwner(@PathVariable(value = "id") Integer id, @RequestBody Owner pOwner) {
		Owner catOwner = (Owner)ownerRepository.findOne(id);
		
		catOwner.setName(pOwner.getName());

		saveOwnerCats(id,pOwner.getCats());
		
		Owner newCatOwner = ownerRepository.save(catOwner);
		return ResponseEntity.ok(newCatOwner); 
	}
	
	//// cats array
	
	@GetMapping(path="/owners/{id}/cats",produces="application/json")
	public ResponseEntity<Set<Cat>> getOwnerCats(@PathVariable(value = "id") Integer id) {
		Owner owner = (Owner) ownerRepository.findOne(id);
		
		return ResponseEntity.ok(owner.getCats());
	}
	
	@PutMapping(path="/owners/{id}/cats",produces="application/json")
	public ResponseEntity<Set<Cat>> saveOwnerCats(@PathVariable(value = "id") Integer id, @RequestBody Set<Cat> cats){
		Owner owner = (Owner)ownerRepository.findOne(id);
		
		Set<Cat> newCatList = new HashSet<Cat>();
		for (Cat pCat : cats) {
			newCatList.add(catRepository.findOne(pCat.getId()));
		}
		owner.setCats(newCatList);
		Owner catOwner = ownerRepository.save(owner);
		return ResponseEntity.ok(newCatList);
	}
}
