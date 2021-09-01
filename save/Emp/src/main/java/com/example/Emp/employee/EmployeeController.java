package com.example.Emp.employee;

import antlr.Token;
import com.example.Emp.dto.*;
import com.example.Emp.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService obj;


    @PostMapping(value = "/employee_details")
    public BaseResponse display(@RequestBody EmployeeDTO employeeDTO) {
        return obj.show(employeeDTO);
    }

    @PostMapping(value = "/city")
    public BaseResponse display1(@RequestBody CityDTO cityDTO) {
        return obj.show1(cityDTO);
    }


    @PostMapping(value = "/state")
    public BaseResponse display2(@RequestBody StateDTO stateDTO) {
        return obj.show2(stateDTO);
    }

    @PostMapping(value = "/country")
    public BaseResponse display3(@RequestBody CountryDTO countryDTO) {
        return obj.show3(countryDTO);
    }


    @PostMapping(value = "/person")
    public BaseResponse display4(@RequestBody PersonDTO personDTO) {
        return obj.show4(personDTO);
    }

    @GetMapping(value = "/person1")
    public BaseResponse getAllPerson(){
        return obj.personn();
    }

    @GetMapping(value = "/jwt")
    public BaseResponse display(@RequestBody TokenDto tokenDto) {
        return obj.jwt(tokenDto);
    }
}
