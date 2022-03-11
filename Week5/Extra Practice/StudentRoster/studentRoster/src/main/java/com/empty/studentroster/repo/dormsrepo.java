package com.empty.studentroster.repo;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.empty.studentroster.models.dorm;

@Repository
public interface dormsrepo extends CrudRepository<dorm, Long> {
	List<dorm> findAll();
}
