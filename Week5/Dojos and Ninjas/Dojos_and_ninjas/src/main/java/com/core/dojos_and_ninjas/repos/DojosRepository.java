package com.core.dojos_and_ninjas.repos;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.core.dojos_and_ninjas.models.Dojo;
@Repository
public interface DojosRepository extends CrudRepository<Dojo, Long> {
	List<Dojo> findAll();
}
