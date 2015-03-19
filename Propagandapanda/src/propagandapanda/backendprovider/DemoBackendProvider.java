/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package propagandapanda.backendprovider;

import propagandapanda.PasswordSecurer;
import propagandapanda.backendprovider.DefaultPanels.DefaultDetailPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.io.File;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import propagandapanda.backendprovider.DefaultPanels.DefaultEditPanel;
import propagandapanda.backendprovider.DefaultPanels.MutableString;

/**
 *
 * @author Michi
 */
@SuppressWarnings("serial")
public class DemoBackendProvider extends BackendProvider{

    MutableString name;
    private String header = null;
    private String text = null;
    private DefaultDetailPanel detailPanel = null;
    
    public DemoBackendProvider(){
        name = new MutableString("Demo");
    }
    
    @Override
    public void newPost(String text, String header, PasswordSecurer pws) 
    {
        super.newPost(text, header, pws);
        this.text = text;
        this.header = header;
    }


    @Override
    public boolean send() {
        System.out.println(detailPanel.getHeader()+":\n"+detailPanel.getText());
        return true;
    }

    @Override
    public JPanel getStatusPanel() {
        JPanel ret = new JPanel();
        ret.setLayout(new BoxLayout(ret, BoxLayout.Y_AXIS));
        ret.add(new JButton("Alles gut verlaufen."));
        ret.setBackground(Color.green);
        ret.setMaximumSize(new Dimension(Short.MAX_VALUE, ret.getPreferredSize().height));
        ret.setAlignmentX(Component.CENTER_ALIGNMENT);
        return ret;
    }
    
    @Override
    public JPanel getDetailPanel() {
        detailPanel = new DefaultDetailPanel(header, text);
        return detailPanel;
    }

    @Override
    public JPanel getEditPanel() {
        return new DefaultEditPanel(name);
    }

    @Override
    public String getName(){
        if(name == null){
            return getClass().getSimpleName();
        }
        else return name.getString();
    };
   
    
}
