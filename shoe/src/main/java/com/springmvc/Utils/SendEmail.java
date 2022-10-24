package com.springmvc.Utils;

import java.io.File;
import java.util.Properties;

import org.apache.log4j.Logger;

import jakarta.mail.Authenticator;
import jakarta.mail.BodyPart;
import jakarta.mail.Message;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
public class SendEmail {
	final static Logger logger = Logger.getLogger(SendEmail.class);
	public static void Send(String emailTo, String subject, String content, String fileHoaDon) throws Exception {
		final String username = "tranthien4649@gmail.com";
		final String password = "ixjylfcxekuvykua";
		
		try {
			Properties prop = new Properties();
			prop.put("mail.smtp.host", "smtp.gmail.com");
			prop.put("mail.smtp.port", "587");
			prop.put("mail.smtp.auth", "true");
			prop.put("mail.smtp.starttls.enable", "true");
			
			Session session = Session.getInstance(prop, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("tranthien4649@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));
			message.setSubject(subject);
			
			BodyPart messageBodyPart = new MimeBodyPart(); 
			messageBodyPart.setText(content);
			
			MimeBodyPart attachmentPart = new MimeBodyPart();
			if(fileHoaDon!=null){
			attachmentPart.attachFile(new File(fileHoaDon));
			}
			
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			
			if(fileHoaDon!=null){
			multipart.addBodyPart(attachmentPart);
			}
			
			message.setContent(multipart);
			Transport.send(message);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
	}
}
