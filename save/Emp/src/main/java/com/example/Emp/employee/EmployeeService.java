package com.example.Emp.employee;
import com.example.Emp.dto.*;
import com.example.Emp.model.*;
import com.example.Emp.repo.*;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CityRpository cityRpository;

    @Autowired
    private StateRepo stateRepo;

    @Autowired
    private CountryRepo countryRepo;

    @Autowired
    private  PersonRepo personRepo;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private ParentsDetailsRepo parentsDetailsRepo;

    public BaseResponse show(EmployeeDTO employeeDTO)
    {
        Employee dto=new Employee();
        BaseResponse baseResponse=new BaseResponse();
        dto.setName(employeeDTO.getName());
        dto.setEmail(employeeDTO.getEmail());
        Optional<City> city = cityRpository.findById(employeeDTO.getCityid());
        dto.setCityid(city.get());
        employeeRepository.save(dto);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("sucess");
        baseResponse.setData(dto);
        return  baseResponse;
    }


    public BaseResponse show1(CityDTO cityDTO) {
        City dto1=new City();
        BaseResponse baseResponse=new BaseResponse();
        dto1.setCityName(cityDTO.getCityName());
        Optional<State> state = stateRepo.findById(cityDTO.getStateid());
        dto1.setStateid(state.get());
         cityRpository.save(dto1);
         baseResponse.setStatusCode("201");
        baseResponse.setStatusMsg("sucess");
        baseResponse.setData(dto1);
        return  baseResponse;
    }


    public BaseResponse show2(StateDTO stateDTO) {
        State dto2=new State();
        BaseResponse baseResponse=new BaseResponse();
        dto2.setStateName(stateDTO.getStateName());
        Optional<Country> country =countryRepo.findById(stateDTO.getCountryid());
        dto2.setCountryid(country.get());
        stateRepo.save(dto2);
        baseResponse.setStatusCode("201");
        baseResponse.setStatusMsg("sucess");
        baseResponse.setData(dto2);
        return  baseResponse;
    }

    public BaseResponse show3(CountryDTO countryDTO) {
        Country dto3=new Country();
        BaseResponse baseResponse=new BaseResponse();
        dto3.setCountryName(countryDTO.getCountryName());
        countryRepo.save(dto3);
        baseResponse.setStatusCode("203");
       baseResponse.setStatusMsg("sucess");
        baseResponse.setData(dto3);
        return  baseResponse;
    }
    @Autowired
    private PersonRepo productRepository;

    public Iterable<Person> findAll() {
        return productRepository.findAll();
    }
    public BaseResponse show4(PersonDTO personDTO) {
        Person person=new Person();
        BaseResponse baseResponse=new BaseResponse();
        person.setFirstName(personDTO.getFirstName());
        person.setLastName(personDTO.getLastName());
        person.setDateOfBirth(personDTO.getDateOfBirth());
        person.setBloodGroup(personDTO.getBloodGroup());
        person.setEmailId(personDTO.getEmailId());
        person.setMobile_number(personDTO.getMobile_number());
        person.setAddress(personDTO.getAddress());
        person.setFathersName(personDTO.getFathersName());
        person.setMothersName(personDTO.getMothersName());
        person=personRepo.save(person);

        Student student=new Student();
        student.setRollNo(personDTO.getRollNo());
        student.setDepartment(personDTO.getDepartment());
        student.setCollege(personDTO.getCollege());
        student.setPersonId(person);
        student=studentRepo.save(student);

        Person person1=person;
        Student student1=student;
        Person finalPerson = person;
        Student finalStudent = student;
        personDTO.getPersondeatilDtos().stream().forEachOrdered(persondeatilDto -> {
                             ParentsDetails parentsDetails = new ParentsDetails();
        parentsDetails.setRelationship(persondeatilDto.getRelationship());
        parentsDetails.setParentOccupation(persondeatilDto.getParentOccupation());
        parentsDetails.setStudentId(student1);
        parentsDetails.setPerson(person1);
        parentsDetailsRepo.save(parentsDetails);
        });
        baseResponse.setStatusCode("101");
        baseResponse.setStatusMsg("sucess");
        baseResponse.setData(finalPerson);
        baseResponse.setData(finalStudent);
        baseResponse.setData(personDTO);
        return baseResponse;
    };

    public static String generateToken(long userId, String subject, String userName) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        JwtBuilder builder = Jwts.builder().setSubject(subject).claim("userId", userId)
                .claim("userName", userName).setIssuedAt(now);
        return builder.compact();
    }

    public BaseResponse jwt(TokenDto tokenDto) {
        Optional<Employee> empl = employeeRepository.findByEmail(tokenDto.getEmail());
        try {
            if (empl.isPresent()) {
                String jwtt = generateToken(empl.get().getId(),"üser",empl.get().getEmail());
                tokenDto.setToken(jwtt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        BaseResponse baseResponse=new BaseResponse();
        baseResponse.setStatusCode("2000");
        baseResponse.setStatusMsg("sucess-jwt");
        baseResponse.setData(tokenDto);
        return  baseResponse;
    }

    public BaseResponse personn() {
        try {
            List<String> EmptyList = Collections.<String>emptyList();
            List<Person> person = personRepo.findAll();
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setStatusCode("100");
            baseResponse.setStatusMsg("program run successfully");
            baseResponse.setData(EmptyList);
            return baseResponse;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    }



