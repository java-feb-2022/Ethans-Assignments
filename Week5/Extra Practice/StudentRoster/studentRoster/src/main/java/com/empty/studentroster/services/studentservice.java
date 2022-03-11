package com.empty.studentroster.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.empty.studentroster.models.student;
import com.empty.studentroster.repo.studentsrepo;
@Service
public class studentservice {
	@Autowired
	private studentsrepo studentsrepo;
	public List<student> allDorms(){
		return studentsrepo.findAll();
	}
	public student save(student e) {
		return studentsrepo.save(e);
	}
	public student findStudent(Long id) {
		return studentsrepo.findById(id).orElse(null);
	}
}
