/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package propagandapanda.backendprovider.DefaultPanels;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.HashSet;
import javax.swing.JPasswordField;
import javax.swing.event.DocumentEvent;
import javax.swing.text.BadLocationException;
import propagandapanda.PasswordSecurer;
import propagandapanda.gui.FatalErrorWindow;

/**
 *
 * @author Michi
 */
public class KeepSecureValueUpToDate extends KeepValueUpToDate{

    private final String masterPW;
    public KeepSecureValueUpToDate(MutableString value, String pw) {
        super(value);
        this.masterPW = pw;
    }

    @Override
    public void focusLost(FocusEvent e) {
        if(e.getComponent() instanceof JPasswordField){
            JPasswordField pf = (JPasswordField) e.getComponent();
                char[] input = pf.getPassword();
                if(input.length == 0)
                    return;
                else 
                    value.setString(PasswordSecurer.encryptPW(String.valueOf(input), masterPW));
                
                String test = value.getString();
                int i = 0;
            
            
        }
    }
    
    
}
