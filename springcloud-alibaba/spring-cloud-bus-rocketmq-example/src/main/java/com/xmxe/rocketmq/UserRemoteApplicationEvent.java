package com.xmxe.rocketmq;

import org.springframework.cloud.bus.event.RemoteApplicationEvent;

public class UserRemoteApplicationEvent extends RemoteApplicationEvent {

	private User user;

	public UserRemoteApplicationEvent() {
	}

	public UserRemoteApplicationEvent(Object source, User user, String originService,
			String destinationService) {
		super(source, originService, DEFAULT_DESTINATION_FACTORY.getDestination(originService));
		this.user = user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

}