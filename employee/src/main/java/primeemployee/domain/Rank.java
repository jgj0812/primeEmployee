package primeemployee.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import primeemployee.EmployeeApplication;
import primeemployee.domain.RankAdd;

@Entity
@Table(name = "Rank_table")
@Data
public class Rank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @PostPersist
    public void onPostPersist() {
        RankAdd rankAdd = new RankAdd(this);
        rankAdd.publishAfterCommit();
    }

    public static RankRepository repository() {
        RankRepository rankRepository = EmployeeApplication.applicationContext.getBean(
            RankRepository.class
        );
        return rankRepository;
    }
}
