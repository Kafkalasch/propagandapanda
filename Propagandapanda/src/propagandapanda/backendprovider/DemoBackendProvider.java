/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package propagandapanda.backendprovider;

import propagandapanda.backendprovider.DefaultPanels.DefaultDetailPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.io.File;
import java.net.URI;
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
public class DemoBackendProvider implements BackendProvider{

    private MutableString name = new MutableString("DemoBackendProvider");
    private MutableString header = null;
    private MutableString text = null;
    
    
    
    @Override
    public void newPost(String text, String header) {
        this.text = new MutableString(text);
        this.header = new MutableString(header);
    }

    @Override
    public boolean addPhoto(File photo) { return false; }

    @Override
    public boolean addPhoto(URI photo) { return false; }

    @Override
    public boolean addVideo(File photo) { return false; }

    @Override
    public boolean addVideo(URI photo) { return false; }

    @Override
    public boolean send() {
        System.out.println(header+"\n"+text);
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
        return new DefaultDetailPanel(header, text);
    }

    @Override
    public JPanel getEditPanel() {
        return new DefaultEditPanel(name);
    }

    @Override
    public JPanel getAddPanel() {
        JPanel ret = new JPanel();
        ret.add(new JButton("This ist nur eine Demodarstellung - Add"));
        return ret;}

    @Override
    public String getName() {
        return name.getString();
    }
    
   
    
}
