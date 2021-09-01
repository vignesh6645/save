package com.example.Emp.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Data
@Getter
@Setter
public class CountryDTO {

    private int id;
    private String countryName;

}




