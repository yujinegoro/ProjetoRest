package br.com.project.rest.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class SendEmail {

	Logger logger = LoggerFactory.getLogger(SendEmail.class);

	@Autowired
	public JavaMailSender emailSender;

	/**
	 * 
	 * Metodo responsavel por enviar email, se os dados de autenticação estiverem corretos.
	 * 
	 * @param mensagem
	 * @return
	 */
	public boolean send(String mensagem) {
		try {

			SimpleMailMessage emailBody = new SimpleMailMessage();

			emailBody.setSubject("Aviso mala direta - Nota menor que 7");
			emailBody.setText(mensagem);
			emailBody.setTo("teste@gmail.com");
			emailBody.setFrom("teste@gmail.com");

			emailSender.send(emailBody);
			return true;

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		// return true //para testes
		return false;

	}

}
