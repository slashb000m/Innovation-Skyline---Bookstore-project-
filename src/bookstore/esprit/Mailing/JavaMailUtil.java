/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.Mailing;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Legion
 */
public class JavaMailUtil {
    public static void sendMail(String recepient,String objet, String texte){
        try {
            System.out.println("Preparing message sending");
            Properties properties = new Properties();
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");
          
            String myAccountEmail = "inovationskyline99@gmail.com";
            String myAccountPwd =  "123456789.aaa";
            Session session = Session.getInstance(properties, new Authenticator(){
                @Override
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(myAccountEmail, myAccountPwd);
                }
                
                
            });
            Message message = prepareMessage(session,myAccountEmail,recepient,objet, texte);
            
            Transport.send(message);
            System.out.println("Message sent ! ");
        } catch (MessagingException ex) {
            Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static Message prepareMessage(Session session, String myAccountEmail,String recepient,String objet, String texte) {
        
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(recepient));
            message.setSubject(objet);
            message.setText(texte);
            return message;
            
           
        } catch (AddressException ex) {
            Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
 return null;
    }
    
}
