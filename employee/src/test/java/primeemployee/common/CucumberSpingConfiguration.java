package primeemployee.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import primeemployee.EmployeeApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { EmployeeApplication.class })
public class CucumberSpingConfiguration {}
