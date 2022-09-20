package com.megagiganto.ypTrackerSpringBoot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.megagiganto.ypTrackerSpringBoot.app.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer>{

}
