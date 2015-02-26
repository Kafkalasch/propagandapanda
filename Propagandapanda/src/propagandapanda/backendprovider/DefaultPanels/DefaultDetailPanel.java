/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package propagandapanda.backendprovider.DefaultPanels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Michi
 */
public class DefaultDetailPanel extends JPanel{
    
    private JTextField headerField = null;
    private JTextArea textArea = null;
    private JLabel charCount = null;
    
    /**
     * Ein Standard-DeatailPanel das verwendet werden kann.
     * Es kann auch erweitert bzw. davon abgeleitet werden. 
     * Durch die Übergabe von MutableStrings werden diese aktuell gehalten werden,
     * falls diese in den zugehörigen Feldern verändert werden.
     * @param header wird aktuell gehalten, falls verändert
     * @param text wird aktuell gehalten, falls verändert
     */
    public DefaultDetailPanel(MutableString header, MutableString text){
        super();
        setLayout(new GridBagLayout());
        addHeaderLine(header);
        addTextArea(text);
    }
    
    /**
     * Ein Standard-DeatailPanel das verwendet werden kann.
     * Es kann auch erweitert bzw. davon abgeleitet werden. 
     * Durch die Übergabe von MutableStrings werden diese aktuell gehalten werden,
     * falls diese in den zugehörigen Feldern verändert werden.
     * @param text wird aktuell gehalten, falls verändert
     */
    public DefaultDetailPanel(MutableString text){
        super();
        setLayout(new GridBagLayout());
        addTextArea(text);
    }
    
    private void addHeaderLine(MutableString header){
        JLabel lab = new JLabel("Header:");
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.ipadx = 2;
        c.anchor = GridBagConstraints.LINE_START;
        this.add(lab, c);
        
        headerField = new JTextField(header.getString());
        headerField.getDocument().addDocumentListener(new KeepValueUpToDate(header));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1;
        this.add(headerField, c);
    }
    
    private void addTextArea(MutableString text){
        JLabel lab = new JLabel("Text:");
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.ipadx = 2;
        c.anchor = GridBagConstraints.LINE_START;
        this.add(lab, c);
        
        charCount = new JLabel("(" + text.getString().length()+")");
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;
        c.ipadx = 2;
        c.anchor = GridBagConstraints.LINE_START;
        this.add(charCount, c);
        
        textArea = new JTextArea(text.getString());
        textArea.setRows(10);
        textArea.getDocument().addDocumentListener(new TextAreaListener());
        textArea.getDocument().addDocumentListener(new KeepValueUpToDate(text));
        JScrollPane cp = new JScrollPane(textArea);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        c.weightx = 1;
        this.add(cp, c);
    }
    
    
    private class TextAreaListener implements DocumentListener{

        @Override
        public void insertUpdate(DocumentEvent e) {
            charCount.setText("("+textArea.getText().length()+")");
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            charCount.setText("("+textArea.getText().length()+")");
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            charCount.setText("("+textArea.getText().length()+")");
        }
        
        
    }
}
