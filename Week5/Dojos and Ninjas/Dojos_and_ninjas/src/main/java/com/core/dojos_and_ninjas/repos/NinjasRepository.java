package com.core.dojos_and_ninjas.repos;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.core.dojos_and_ninjas.models.Ninja;
@Repository
public interface NinjasRepository extends CrudRepository<Ninja, Long> {
	List<Ninja> findAll();
}

