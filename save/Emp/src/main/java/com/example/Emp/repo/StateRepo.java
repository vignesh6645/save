package com.example.Emp.repo;

import com.example.Emp.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepo extends JpaRepository <State,Integer>{
}
