package com.example.Emp.repo;

import com.example.Emp.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRpository extends JpaRepository  <City,Integer>{
}
