package com.megagiganto.ypTrackerSpringBoot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.megagiganto.ypTrackerSpringBoot.app.model.Yarn;

@Repository
public interface YarnRepository extends JpaRepository<Yarn, Integer>{

}
