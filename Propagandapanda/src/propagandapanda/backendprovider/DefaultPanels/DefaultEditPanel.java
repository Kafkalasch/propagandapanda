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
    
   int linecount = 0;
   
   public DefaultEditPanel(){
       super();
        setLayout(new GridBagLayout());
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
    
    public final JTextField addLabelAndFieldLine(String labelText, MutableString field){
        JLabel lab = new JLabel(labelText);
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = linecount;
        c.ipadx = 2;
        c.anchor = GridBagConstraints.LINE_START;
        add(lab, c);
        
        JTextField textField = new JTextField(field.getString());
        textField.getDocument().addDocumentListener(new KeepValueUpToDate(field));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = linecount;
        c.weightx = 1;
        add(textField, c);
        
        linecount++;
        return textField;
    }
    
    public final JPasswordField addLabelAndSecureFieldLine(String labelText, MutableString field, PasswordSecurer pws){
        JLabel lab = new JLabel(labelText);
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = linecount;
        c.ipadx = 2;
        c.anchor = GridBagConstraints.LINE_START;
        add(lab, c);
        
        JPasswordField textField = new JPasswordField(field.getString());
        textField.getDocument().addDocumentListener(new KeepSecureValueUpToDate(field, pws));
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
