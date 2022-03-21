package com.exam.practice.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exam.practice.models.Project;
import com.exam.practice.repos.ProjectRepo;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepo repo;
	public Project findById(Long id) {
		Optional<Project> result = repo.findById(id);
		if(result.isPresent()) {
			return result.get();
		}
		return null;
	}
	public List<Project> all() {
		return repo.findAll();
	}
	public Project update(Project proj) {
		return repo.save(proj);
	}
	public Project create(Project proj) {
		return repo.save(proj);
	}
	public void delete(Project proj) {
		repo.delete(proj);
	}
}