package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Tourist;

public interface ITouristRepo extends JpaRepository<Tourist, Integer> {

}
