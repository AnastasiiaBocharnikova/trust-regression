package com.trust.cucumber.support;

import java.io.IOException;
import java.util.Properties;

import javax.mail.*;

import com.trust.cucumber.util.Log;

public class TechcheckMail {
		
	public String getChangePasswordLinkFromLastEmail () throws MessagingException, IOException {
	    
		String userEmail = "tcautotest777@gmail.com";
		String password = "Autorole7";
		String host = "imap.gmail.com";
				
		Properties props = new Properties();
		props.put("mail.store.protocol", "imaps");
    
		Session session = Session.getInstance(props);
		Store store = session.getStore();

		//connect to mail server
		store.connect(host, userEmail, password);

		//get INBOX folder
		Folder inbox = store.getFolder("INBOX");
		inbox.open(Folder.READ_ONLY);

		// the oldest email will have 1 number
		Message m = inbox.getMessage(inbox.getMessageCount());
		Multipart mp = (Multipart) m.getContent();
		BodyPart bp = mp.getBodyPart(0);
		String textEmail = bp.getContent().toString();
		Log.info(getLinkFromEmail(textEmail));
		store.close();
			return  getLinkFromEmail(textEmail);
    
	}
	
	private String getLinkFromEmail (String textEmail) {
		int startIndex = textEmail.indexOf("<");
		int endIndex = textEmail.indexOf(">");
		return textEmail.substring(startIndex+1, endIndex);
	}		
}	

