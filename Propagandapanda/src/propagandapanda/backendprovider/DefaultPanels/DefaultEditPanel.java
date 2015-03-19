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
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Ein Standard-DeatailPanel das verwendet werden kann.
 * Es kann auch erweitert bzw. davon abgeleitet werden. 
 * Durch die Übergabe von MutableStrings werden diese aktuell gehalten werden,
 * falls diese in den zugehörigen Feldern verändert werden.
 * @author Michi
 */
public class DefaultEditPanel extends JPanel{
    
    private JTextField nameField = null;
    
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
    private void addNameLine(MutableString name){
        JLabel lab = new JLabel("Name of the channel:");
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.ipadx = 2;
        c.anchor = GridBagConstraints.LINE_START;
        this.add(lab, c);
        
        nameField = new JTextField(name.getString());
        nameField.getDocument().addDocumentListener(new KeepValueUpToDate(name));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1;
        this.add(nameField, c);
    }
    
    
    
}
