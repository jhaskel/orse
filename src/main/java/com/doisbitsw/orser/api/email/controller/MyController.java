package com.doisbitsw.orser.api.email.controller;


import com.doisbitsw.orser.api.email.domain.User;
import com.doisbitsw.orser.api.email.service.EmailService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
class EmailController {


	private final EmailService emailService;

	public EmailController(EmailService emailService) {
		this.emailService = emailService;
	}

	@RequestMapping(value = "/email", method = RequestMethod.POST)
	@ResponseBody
	public String sendMail(@RequestBody User user) throws MessagingException {
		emailService.sendMail(user);
		return "Email enviado com Sucesso.!";
	}

}