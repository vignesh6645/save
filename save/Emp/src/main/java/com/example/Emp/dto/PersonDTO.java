
package com.example.Emp.dto;

        import lombok.Data;
        import lombok.Getter;
        import lombok.Setter;

        import javax.persistence.Column;
        import java.util.List;

@Data
@Getter
@Setter
public class PersonDTO {


    private long id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String address;
    private String bloodGroup;
    private String emailId;
    private String mobile_number;
    private String fathersName;
    private String mothersName;

    private int rollNo;
    private String department;
    private String college;
    private String personId;

    private String studentId;

    private List <persondeatilDto>persondeatilDtos;
}




