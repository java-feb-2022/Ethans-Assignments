package com.empty.studentroster.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empty.studentroster.models.dorm;
import com.empty.studentroster.repo.dormsrepo;
@Service
public class dormservice {
	@Autowired
	private dormsrepo dormsrepo;
	public List<dorm> allDorms(){
		return dormsrepo.findAll();
	}
	public dorm save(dorm e) {
		return dormsrepo.save(e);
	}
	public dorm findDorm(Long id) {
		return dormsrepo.findById(id).orElse(null);
	}
}
