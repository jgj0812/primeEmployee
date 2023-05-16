package primeemployee.domain;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import primeemployee.domain.*;

@RepositoryRestResource(collectionResourceRel = "ranks", path = "ranks")
public interface RankRepository extends PagingAndSortingRepository<Rank, Long> {
    List<Rank> findByName(String name);
}
