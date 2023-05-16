package primeemployee.domain;

import java.util.*;
import lombok.*;
import primeemployee.domain.*;
import primeemployee.infra.AbstractEvent;

@Data
@ToString
public class EmployeeAdd extends AbstractEvent {

    private Long id;
    private String userName;
    private String userId;
    private String phoneNo;
    private Date enterDate;
    private Boolean masterYn;
    private RankId rankId;
    private DepartmentId departmentId;

    public EmployeeAdd(Employee aggregate) {
        super(aggregate);
    }

    public EmployeeAdd() {
        super();
    }
}
