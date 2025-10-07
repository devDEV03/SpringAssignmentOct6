package com.service;

import java.nio.channels.IllegalSelectorException;
import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {
	
	public CompletableFuture<String> sendEmailAsync(String email){
		return CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(500);
				return "Email sent to " + email;
			}
			catch(InterruptedException e) {
				throw new IllegalStateException("Error sending email");
			}
		});
	}


}
