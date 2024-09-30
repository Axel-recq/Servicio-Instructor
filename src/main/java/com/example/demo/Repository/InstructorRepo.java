package com.example.demo.Repository;

import com.example.demo.Modelo.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepo extends JpaRepository <Instructor , Integer>{
}
