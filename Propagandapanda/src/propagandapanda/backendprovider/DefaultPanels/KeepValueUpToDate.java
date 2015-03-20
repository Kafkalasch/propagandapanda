package propagandapanda.backendprovider.DefaultPanels;


import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import propagandapanda.gui.FatalErrorWindow;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Hält den MutableString aktuell.
 * @author Michi
 */
public class KeepValueUpToDate implements FocusListener{

    protected MutableString value;
    
    KeepValueUpToDate(MutableString value){
        this.value = value;
    }

    @Override
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {
        if(e.getComponent() instanceof JTextComponent){
            value.setString( ((JTextComponent) e.getComponent()).getText());
        }
    }
}
