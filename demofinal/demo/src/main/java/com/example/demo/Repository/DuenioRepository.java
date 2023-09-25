package com.example.demo.Repository;

import com.example.demo.Model.Duenio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DuenioRepository extends JpaRepository<Duenio, Integer> {
}
