package com.sid.learnsoft.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sid.learnsoft.dto.NotificationDTO;
import com.sid.learnsoft.entities.Notification;
import com.sid.learnsoft.entities.User;
import com.sid.learnsoft.repositories.NotificationRepository;

@Service
public class NotificationService {

	@Autowired
	private NotificationRepository repository;
	
	@Autowired
	private AuthService authService;
	
	public Page<NotificationDTO> notificationsForCurrentUser(boolean unreadOnly, Pageable pegeable) {
		User user = authService.authenticated();
		Page<Notification> page = repository.find(user, unreadOnly, pegeable);
		return page.map(x -> new NotificationDTO(x));
	}
}