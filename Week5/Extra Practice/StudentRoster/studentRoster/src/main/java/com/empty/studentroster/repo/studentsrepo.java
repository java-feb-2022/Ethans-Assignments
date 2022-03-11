package com.empty.studentroster.repo;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.empty.studentroster.models.student;
@Repository
public interface studentsrepo extends CrudRepository <student, Long> {
	List<student> findAll();
}
