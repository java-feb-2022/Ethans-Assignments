package com.core.dojos_and_ninjas.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.core.dojos_and_ninjas.models.Dojo;
import com.core.dojos_and_ninjas.repos.DojosRepository;
@Service
public class DojoService {
	@Autowired
	private DojosRepository dojoRepo;
	
	public List<Dojo> allDojos() {
		return dojoRepo.findAll();
	}
	
	public Dojo create(Dojo e) {
		return dojoRepo.save(e);
	}
	
	public Dojo findDojo(Long id) {
		return dojoRepo.findById(id).orElse(null);
	}
	public void delete(Long id) {
		dojoRepo.deleteById(id);
	}
}
