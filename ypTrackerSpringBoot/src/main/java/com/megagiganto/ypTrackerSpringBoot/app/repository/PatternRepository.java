package com.megagiganto.ypTrackerSpringBoot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.megagiganto.ypTrackerSpringBoot.app.model.Pattern;

@Repository
public interface PatternRepository extends JpaRepository<Pattern, Integer> {

}
