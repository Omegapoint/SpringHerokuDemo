package demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AlternativeRepository extends CrudRepository<Alternative, Long>{

    Alternative findByAlternative(String alternative);

}
