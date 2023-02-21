package com.example.demoRESTWithJPA.repository;

import com.example.demoRESTWithJPA.domain.Spice;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SpiceRepository extends CrudRepository<Spice, Integer> {

    List<Spice> findByName(String name);

    Spice findById(int id);
}
