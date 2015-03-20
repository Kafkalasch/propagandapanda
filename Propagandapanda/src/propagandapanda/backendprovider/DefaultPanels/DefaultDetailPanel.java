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
 *Ein Standard-DeatailPanel das verwendet werden kann.
 * Es kann auch erweitert bzw. davon abgeleitet werden. .
 * @author Michi
 */
public class DefaultDetailPanel extends DefaultEditPanel{
    
    private JTextField headerField = null;
    private JTextArea textArea = null;
    private JLabel charCount = null;
    
    /**
     * 
     * @param header 
     * @param text 
     */
    public DefaultDetailPanel(String header, String text){
        super();
        addHeaderLine(header);
        addTextArea(text);
    }
    
    /**
     * @param text
     */
    public DefaultDetailPanel(String text){
        super();
        addTextArea(text);
    }
    
    public String getHeader(){
        return headerField.getText();
    }
    
    public String getText(){
        return textArea.getText();
    }
    
    private void addHeaderLine(String header){
        JLabel lab = new JLabel("Header:");
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = linecount;
        c.ipadx = 2;
        c.anchor = GridBagConstraints.LINE_START;
        this.add(lab, c);
        
        headerField = new JTextField(header);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = linecount;
        c.weightx = 1;
        this.add(headerField, c);
        
        linecount++;
    }
    
    private void addTextArea(String text){
        JLabel lab = new JLabel("Text:");
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = linecount;
        c.ipadx = 2;
        c.anchor = GridBagConstraints.LINE_START;
        this.add(lab, c);
        
        charCount = new JLabel("(" + text.length()+")");
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = linecount;
        c.ipadx = 2;
        c.anchor = GridBagConstraints.LINE_START;
        this.add(charCount, c);
        
        textArea = new JTextArea(text);
        textArea.setRows(10);
        textArea.getDocument().addDocumentListener(new TextAreaListener());
        JScrollPane cp = new JScrollPane(textArea);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = ++linecount;
        c.gridwidth = 2;
        c.weightx = 1;
        this.add(cp, c);
        
        linecount++;
    }
    
    /**
     * hält den Zähler aktuell
     */
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
