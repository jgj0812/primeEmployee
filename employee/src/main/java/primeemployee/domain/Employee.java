package primeemployee.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import primeemployee.EmployeeApplication;
import primeemployee.domain.EmployeeAdd;
import primeemployee.domain.EmployeeDelete;
import primeemployee.domain.EmployeeUpdate;

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

        EmployeeUpdate employeeUpdate = new EmployeeUpdate(this);
        employeeUpdate.publishAfterCommit();

        EmployeeDelete employeeDelete = new EmployeeDelete(this);
        employeeDelete.publishAfterCommit();
    }

    public static EmployeeRepository repository() {
        EmployeeRepository employeeRepository = EmployeeApplication.applicationContext.getBean(
            EmployeeRepository.class
        );
        return employeeRepository;
    }
}
