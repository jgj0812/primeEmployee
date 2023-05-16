package primeemployee.domain;

import java.util.*;
import lombok.*;
import primeemployee.domain.*;
import primeemployee.infra.AbstractEvent;

@Data
@ToString
public class EmployeeDelete extends AbstractEvent {

    private Long id;

    public EmployeeDelete(Employee aggregate) {
        super(aggregate);
    }

    public EmployeeDelete() {
        super();
    }
}
