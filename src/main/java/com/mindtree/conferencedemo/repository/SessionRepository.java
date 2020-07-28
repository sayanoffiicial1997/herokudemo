package com.mindtree.conferencedemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.conferencedemo.models.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {

}
