package com.example.Emp.repo;

import com.example.Emp.model.ParentsDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentsDetailsRepo extends JpaRepository<ParentsDetails,Integer> {
}
