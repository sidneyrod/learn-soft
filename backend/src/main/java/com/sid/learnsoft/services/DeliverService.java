package com.sid.learnsoft.services;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sid.learnsoft.dto.DeliverRevisionDTO;
import com.sid.learnsoft.entities.Deliver;
import com.sid.learnsoft.observers.DeliverRevisionObserver;
import com.sid.learnsoft.repositories.DeliverRepository;

@Service
public class DeliverService {

	@Autowired
	private DeliverRepository repository;
	
	@Autowired
	private Set<DeliverRevisionObserver> deliverRevisionObservers = new LinkedHashSet<>();
	
	@PreAuthorize("hasAnyRole('ADMIN', 'INSTRUCTOR')")
	@Transactional
	public void saveRevision(Long id, DeliverRevisionDTO dto) {
		Deliver deliver = repository.getOne(id);
		deliver.setStatus(dto.getStatus());
		deliver.setFeedback(dto.getFeedback());
		deliver.setCorrectCount(dto.getCorrectCount());
		repository.save(deliver);
		for (DeliverRevisionObserver observer : deliverRevisionObservers) {
			observer.onSaveRevivion(deliver);
		}
	}
	
	public void subscribeDeliverRevisionObserver(DeliverRevisionObserver observer) {
		deliverRevisionObservers.add(observer);
	}
}