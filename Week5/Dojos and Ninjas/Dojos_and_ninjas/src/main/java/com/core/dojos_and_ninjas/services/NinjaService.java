package com.core.dojos_and_ninjas.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.core.dojos_and_ninjas.models.Ninja;
import com.core.dojos_and_ninjas.repos.NinjasRepository;
@Service
public class NinjaService {
	@Autowired
	private NinjasRepository ninjaRepo;
	
	public List<Ninja> allNinjas() {
		return ninjaRepo.findAll();
	}
	
	public Ninja save(Ninja E) {
		return ninjaRepo.save(E);
	}
	
	public Ninja findNinja(Long id) {
		return ninjaRepo.findById(id).orElse(null);
	}
	public void delete(Long id) {
		ninjaRepo.deleteById(id);
	}
}