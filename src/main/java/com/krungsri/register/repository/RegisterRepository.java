package com.krungsri.register.repository;

import com.krungsri.register.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegisterRepository extends JpaRepository<Register, String> {
    List<Register> findAllById(int i);
}
