package primeemployee.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import primeemployee.EmployeeApplication;
import primeemployee.domain.EmployeeAdd;

@Entity
@Table(name = "Employee_table")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;

    private String userId;

    private String phoneNo;

    private Date enterDate;

    private Boolean masterYn;

    @Embedded
    private RankId rankId;

    @Embedded
    private DepartmentId departmentId;

    @PostPersist
    public void onPostPersist() {
        EmployeeAdd employeeAdd = new EmployeeAdd(this);
        employeeAdd.publishAfterCommit();
    }

    public static EmployeeRepository repository() {
        EmployeeRepository employeeRepository = EmployeeApplication.applicationContext.getBean(
            EmployeeRepository.class
        );
        return employeeRepository;
    }
}
