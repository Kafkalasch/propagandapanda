/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package propagandapanda.backendprovider.DefaultPanels;

import javax.swing.event.DocumentEvent;
import javax.swing.text.BadLocationException;
import propagandapanda.PasswordSecurer;
import propagandapanda.gui.FatalErrorWindow;

/**
 *
 * @author Michi
 */
public class KeepSecureValueUpToDate extends KeepValueUpToDate{

    PasswordSecurer pwSec;
    
    public KeepSecureValueUpToDate(MutableString value, PasswordSecurer pwSec) {
        super(value);
        this.pwSec = pwSec;
    }
    
    @Override
    protected void Update(DocumentEvent e){
        try {
            super.value.setString(pwSec.encryptPW(e.getDocument().getText(0, e.getDocument().getLength())));
        } catch (BadLocationException ex) {
            new FatalErrorWindow(ex);
        }
    }
    
}
