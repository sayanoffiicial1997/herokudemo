package com.mindtree.conferencedemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.conferencedemo.models.Speaker;

public interface SpeakerRepository extends JpaRepository<Speaker, Long>{

}
