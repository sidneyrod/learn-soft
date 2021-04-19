package com.sid.learnsoft.services;

import java.time.Instant;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sid.learnsoft.dto.NotificationDTO;
import com.sid.learnsoft.entities.Deliver;
import com.sid.learnsoft.entities.Notification;
import com.sid.learnsoft.entities.User;
import com.sid.learnsoft.observers.DeliverRevisionObserver;
import com.sid.learnsoft.repositories.NotificationRepository;

@Service
public class NotificationService implements DeliverRevisionObserver {

	@Autowired
	private NotificationRepository repository;
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private DeliverService deliverService;
	
	@PostConstruct
	private void initialize() {
		deliverService.subscribeDeliverRevisionObserver(this);
	}
	
	@Transactional(readOnly = true)
	public Page<NotificationDTO> notificationsForCurrentUser(boolean unreadOnly, Pageable pegeable) {
		User user = authService.authenticated();
		Page<Notification> page = repository.find(user, unreadOnly, pegeable);
		return page.map(x -> new NotificationDTO(x));
	}
	
	@Transactional
	public void saveDeliverNotification(Deliver deliver) {
		
		Long sectionId = deliver.getLesson().getSection().getId();
		Long resourceId = deliver.getLesson().getSection().getResource().getId();
		Long offerId = deliver.getLesson().getSection().getResource().getOffer().getId();
		
		String route = "/offers/" + offerId + "/resources/" + resourceId + "/sections/" + sectionId;
		String text = deliver.getFeedback();
		Instant moment = Instant.now();
		User user = deliver.getEnrollment().getStudent();
		
		Notification notification = new Notification(null, text, moment, false, route, user);
		repository.save(notification);
	}

	@Override
	public void onSaveRevivion(Deliver deliver) {
		saveDeliverNotification(deliver);
	}
}