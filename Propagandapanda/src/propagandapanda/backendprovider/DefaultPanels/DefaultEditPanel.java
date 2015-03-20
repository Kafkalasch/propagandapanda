/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package propagandapanda.backendprovider.DefaultPanels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import propagandapanda.PasswordSecurer;

/**
 * Ein Standard-DeatailPanel das verwendet werden kann.
 * Es kann auch erweitert bzw. davon abgeleitet werden. 
 * Durch die Übergabe von MutableStrings werden diese aktuell gehalten werden,
 * falls diese in den zugehörigen Feldern verändert werden.
 * @author Michi
 */
public class DefaultEditPanel extends JPanel{
    
   protected int linecount;
   
   
   
   public DefaultEditPanel(){
       super();
        setLayout(new GridBagLayout());
        linecount = 0;
   }
    
   /**
     * 
     * @param name will keep name up to date if it will be edited in the corresponding textfield.
     */
    public DefaultEditPanel(MutableString name){
        this();
        addNameLine(name);
    }
    
     /**
     * 
     * @param name will keep name up to date if it will be edited in the corresponding textfield.
     */
    public final JTextField addNameLine(MutableString name){
        return addLabelAndFieldLine("Name of the channel:", name);
    }
    
    public void addLabelAndTextArea(String label, MutableString text){
        JLabel lab = new JLabel(label);
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = linecount;
        c.ipadx = 2;
        c.anchor = GridBagConstraints.LINE_START;
        this.add(lab, c);
        
        
        JTextArea textArea = new JTextArea(text.getString());
        textArea.setRows(3);
        textArea.addFocusListener(new KeepValueUpToDate(text));
        JScrollPane cp = new JScrollPane(textArea);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = ++linecount;
        c.gridwidth = 2;
        c.weightx = 1;
        c.weighty = 1;
        this.add(cp, c);
        
        linecount++;
    }
    
    public final JTextField addLabelAndFieldLine(String labelText, MutableString field){
        JLabel lab = new JLabel(labelText);
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = linecount;
        c.ipadx = 2;
        c.anchor = GridBagConstraints.LINE_START;
        add(lab, c);
        
        JTextField textField = new JTextField(field.getString());
        textField.addFocusListener(new KeepValueUpToDate(field));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = linecount;
        c.weightx = 1;
        add(textField, c);
        
        linecount++;
        return textField;
    }
    
    public final JPasswordField addLabelAndSecureFieldLine(String labelText, MutableString field, String pws){
        JLabel lab = new JLabel(labelText);
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = linecount;
        c.ipadx = 2;
        c.anchor = GridBagConstraints.LINE_START;
        add(lab, c);
        
        JPasswordField textField = new JPasswordField();
        textField.addFocusListener(new KeepSecureValueUpToDate(field, pws));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = linecount;
        c.weightx = 1;
        add(textField, c);
        
        linecount++;
        return textField;
    }
    
    
    
}
