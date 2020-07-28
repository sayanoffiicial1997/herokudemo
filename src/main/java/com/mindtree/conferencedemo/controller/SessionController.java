package com.mindtree.conferencedemo.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.conferencedemo.models.Session;
import com.mindtree.conferencedemo.repository.SessionRepository;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionController {
	@Autowired
	private SessionRepository sessionRepository;

	@GetMapping
	public List<Session> list() {
		// TODO Auto-generated method stub
		return sessionRepository.findAll();
	}

	@GetMapping
	@RequestMapping("{id}")
	public Session get(@PathVariable Long id) {
		return sessionRepository.getOne(id);
	}

	@PostMapping
	public Session create(@RequestBody final Session session) {
		return sessionRepository.saveAndFlush(session);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		sessionRepository.deleteById(id);
	}
	
	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "{id}" , method = RequestMethod.PUT)
	public Session update(@PathVariable Long id , @RequestBody Session session) {
		Session existingSession= sessionRepository.getOne(id);
		BeanUtils.copyProperties(session, existingSession , "session_id");
		return sessionRepository.saveAndFlush(existingSession); 
	}
}
