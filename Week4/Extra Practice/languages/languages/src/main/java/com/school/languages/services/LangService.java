package com.school.languages.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.school.languages.models.Language;
import com.school.languages.repo.LangRepo;
@Service
public class LangService {
	private final LangRepo langRepo;
	public LangService(LangRepo repo) {
		this.langRepo = repo;
	}
	public List<Language> allLangs(){
		return langRepo.findAll();
	}
	public Language save(Language E) {
		return langRepo.save(E);
	}
	public Language findLanguage(Long id) {
		Optional<Language> OptE = langRepo.findById(id);
		if (OptE.isPresent()) {
			return OptE.get();
		}
		else {
			return null;
		}
	}
	public void delete(Long id) {
		langRepo.deleteById(id);
	}
}
