package com.stiverson.projeto.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.stiverson.projeto.cursomc.domain.Pedido;

public interface EmailService {
	
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);

}
