package com.springmvc.Utils;

import java.io.File;
import java.util.Properties;

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
/**
 * @author PhamMinhThien
 * @since 2022
 **/
public class SendEmail {
	/**
	 * Send
	 * @param String emailTo
	 * @param String subject
	 * @param String content
	 * @param String fileHoaDon
	 * @return message
	 * @throws Exception
	 **/
	public static void Send(String emailTo, String subject, String content, String fileHoaDon) throws Exception {
		final String username = "phmth1999@gmail.com";
		final String password = "bosdgbarojbcjyuk";
		
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
			message.setFrom(new InternetAddress("phmth1999@gmail.com"));
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
		}
	}
}
