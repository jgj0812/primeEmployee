package primeemployee.infra;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import primeemployee.domain.*;

@RepositoryRestResource(collectionResourceRel = "rankViews", path = "rankViews")
public interface RankViewRepository
    extends PagingAndSortingRepository<RankView, Long> {}
