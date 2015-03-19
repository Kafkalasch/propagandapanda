/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package propagandapanda.backendprovider;

import propagandapanda.PasswordSecurer;
import propagandapanda.backendprovider.DefaultPanels.DefaultEditPanel;
import propagandapanda.backendprovider.DefaultPanels.MutableString;

/**
 *
 * @author Michi
 */
public class MailProviderEditPanel extends DefaultEditPanel{
    
     private String to;
    private String from;
    private String smtpServ;
    private String username;
    //inherits protected String encryptedPassword
    
    public MailProviderEditPanel(MutableString name,
            MutableString to, MutableString from, 
            MutableString smtpServer, MutableString username,
            MutableString encryptedPW, PasswordSecurer pws){
        super();
        addNameLine(name);
        addLabelAndFieldLine("To:", to);
        addLabelAndFieldLine("From:", from);
        addLabelAndFieldLine("Username:", username);
        addLabelAndSecureFieldLine("Password:", encryptedPW, pws);
        addLabelAndFieldLine("Smtp server:", smtpServer);
    }
}
