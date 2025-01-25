package com.stdproject.api.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stdproject.api.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

	

}
