/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package propagandapanda.backendprovider;

import propagandapanda.PasswordSecurer;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import propagandapanda.backendprovider.DefaultPanels.DefaultDetailPanel;
import propagandapanda.backendprovider.DefaultPanels.DefaultEditPanel;
import propagandapanda.backendprovider.DefaultPanels.MutableString;

/**
 *
 * @author Michi
 */
public class MailProvider extends BackendProvider{
    
    // Einstellungen
    private MutableString name;
    private MutableString to;
    private MutableString from;
    private MutableString smtpServ;
    private MutableString username;
    private MutableString encryptedPassword;
    private MutableString praefix;
    private MutableString postfix;
    
    // Variabel
    private String message;
    private String subject;    
    public MailProvider(){
        name = new MutableString("E-Mail");
        to = new MutableString("to@someone.at");
        from = new MutableString("aglorious@person.at");
        smtpServ = new MutableString("smtp.mail.at");
        username = new MutableString("maxime mustermann");
        encryptedPassword = new MutableString("");
        praefix = new MutableString("");
        postfix = new MutableString("");
//        to = "michihoefler@gmx.at";
//        from = to;
//        smtpServ = "mail.gmx.at";
//        username = from;
    }
    
    @Override
    public void newPost(String text, String header, String masterPW){
        super.newPost(text, header, masterPW);
        this.subject = header;
        this.message = praefix + "\n" + text + "\n" + postfix;
        
    }

    @Override
    public boolean send() {
        
        sendMail();
        return true;
    }

    @Override
    public JPanel getDetailPanel() {
        return  new DefaultDetailPanel(subject, message);
    }

    @Override
    public JPanel getStatusPanel() {
        JPanel ret = new JPanel();
        ret.setLayout(new BoxLayout(ret, BoxLayout.Y_AXIS));
        ret.add(new JButton("MAIL Test. Siehe System.out.println."));
        ret.setBackground(Color.green);
        ret.setMaximumSize(new Dimension(Short.MAX_VALUE, ret.getPreferredSize().height));
        ret.setAlignmentX(Component.CENTER_ALIGNMENT);
        return ret;
    }

    @Override
    public JPanel getEditPanel() {
        return new MailProviderEditPanel(name, to, from, smtpServ, username, encryptedPassword, masterPW, praefix, postfix);
    }
    
    private int sendMail(){
        try
        {
            Properties props = System.getProperties();
              // -- Attaching to default Session, or we could start a new one --
              props.put("mail.transport.protocol", "smtp" );
              props.put("mail.smtp.starttls.enable","true" );
              props.put("mail.smtp.host", smtpServ.getString());
              props.put("mail.smtp.auth", "true" );
              Authenticator auth = new SMTPAuthenticator();
              Session session = Session.getInstance(props, auth);
              // -- Create a new message --
              Message msg = new MimeMessage(session);
              // -- Set the FROM and TO fields --
              msg.setFrom(new InternetAddress(from.getString()));
              msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to.getString(), false));
              msg.setSubject(subject);
              msg.setText(message);
              // -- Set some other header information --
              //msg.setHeader("MyMail", "Mr. XYZ" );
              msg.setSentDate(new Date());
              // -- Send the message --
              Transport.send(msg);
              System.out.println("Message sent to "+to.getString()+" OK." );
              return 0;
        }
        catch (Exception ex)
        {
          ex.printStackTrace();
          System.out.println("Exception "+ex);
          return -1;
        }
  }

    @Override
    public String getName(){
        if(name == null){
            return getClass().getSimpleName();
        }
        else return name.getString();
    };
    
// Also include an inner class that is used for authentication purposes

private class SMTPAuthenticator extends javax.mail.Authenticator {
        @Override
        public PasswordAuthentication getPasswordAuthentication() {
            String usr =  username.getString();           // specify your email id here (sender's email id)
            String password = PasswordSecurer.decryptPW(encryptedPassword.getString(), masterPW);  // specify your password here
            return new PasswordAuthentication(usr, password);
        }
  }
}
