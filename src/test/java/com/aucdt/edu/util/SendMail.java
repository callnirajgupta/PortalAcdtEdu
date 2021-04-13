package com.aucdt.edu.util;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// Properties props = new Properties();
		/*
		 * props.put("mail.smtp.host", "smtp.gmail.com");
		 * props.put("mail.smtp.socketFactory.port", "465");
		 * 
		 * props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		 * props.put("mail.smtp.auth", "true"); props.put("mail.smtp.port", "465");
		 */

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.aucdt.edu.gh");
		props.put("mail.smtp.port", 587);
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.trust", "smtp.aucdt.edu.gh");
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.debug", "false");

		// get Session
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("admin_dev@aucdt.edu.gh", "N5ik*n38");
			}
		});
		// compose message
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {

			MimeMessage msg = new MimeMessage(session);
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");

			msg.setFrom(new InternetAddress("admin_dev@aucdt.edu.gh", "admin_dev@aucdt.edu.gh"));

			msg.setReplyTo(InternetAddress.parse("admin_dev@aucdt.edu.gh", false));

			msg.setSubject("Test Report by Automation", "UTF-8");

			msg.setSentDate(new Date());

			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("admin_dev@aucdt.edu.gh"));

			// Create the message body part
			BodyPart messageBodyPart = new MimeBodyPart();

			messageBodyPart.setText("Find mail as report");

			// Create a multipart message for attachment
			Multipart multipart = new MimeMultipart();

			// Set text message part
			multipart.addBodyPart(messageBodyPart);

			// Second part is image attachment
			messageBodyPart = new MimeBodyPart();
			String filename = System.getProperty("user.dir")
					+ "/target/cucumber-JVM-reports/cucumber-html-reports/overview-features.html";

			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			// Trick is to add the content-id header here
			messageBodyPart.setHeader("Content-ID", "image_id");
			
			// zip the cucumber html report--
			
			File f = new File(System.getProperty("user.dir")+"/target/cucumber-html-report");

	        // Populates the array with names of files and directories
	    	String[] myFiles = f.list();
	    	String path=System.getProperty("user.dir")+"/target/cucumber-html-report/";
	    	for(int i=0;i<myFiles.length;i++) {
	    		myFiles[i]=path+myFiles[i];
	    	}
	    	
	    	
	    	
	    	String zipFile = System.getProperty("user.dir")+"/target/CucumberReport.zip";
	    	ZipTheFolder zipfolder= new ZipTheFolder();
try {
	zipfolder.zip(myFiles, zipFile);
} catch (Exception ex) {
    // some errors occurred
    ex.printStackTrace();
  }
			// Second Attachement
			

			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
			String filename2 = System.getProperty("user.dir") + "\\target\\CucumberReport.zip";

			try {
				messageBodyPart2.attachFile(filename2, "application/zip", "base64");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			multipart.addBodyPart(messageBodyPart);
			multipart.addBodyPart(messageBodyPart2);

			// third part for displaying image in the email body
			messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent("<h1>Attached is the zip</h1>" + "<img src= filename>", "text/html");
			multipart.addBodyPart(messageBodyPart);

			// Set the multipart message to the email message
			msg.setContent(multipart);

			// Send message
			Transport.send(msg);
			System.out.println("EMail Sent Successfully with image!!");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

}
