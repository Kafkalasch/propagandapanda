package propagandapanda.backendprovider.DefaultPanels;


import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
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
public class KeepValueUpToDate implements DocumentListener{

    private MutableString value;
    
    KeepValueUpToDate(MutableString value){
        this.value = value;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        Update(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        Update(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        Update(e);
    }
    
    private void Update(DocumentEvent e){
        try {
            value.setString(e.getDocument().getText(0, e.getDocument().getLength()));
        } catch (BadLocationException ex) {
            new FatalErrorWindow(ex);
        }
    }
     
}
