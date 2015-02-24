/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package propagandapanda;

import java.io.File;
import java.io.Serializable;
import java.net.URI;
import javax.swing.JPanel;

/**
 *
 * @author Michi
 */
public interface BackendProvider {
    /**
     * 
     * @param text can be an empty String
     * @param header can be an empty String
     */
    public void newPost(String text, String header);
    
    /**
     * 
     * @param photo
     * @return true if file is suitable
     */
    public boolean addPhoto(File photo);
    
    /**
     * 
     * @param photo
     * @return true if uri could be read and file is suitable
     */
    public boolean addPhoto(URI photo);
    
    /**
     * 
     * @param photo
     * @return true if file is suitable
     */
    public boolean addVideo(File photo);
    
    /**
     * 
     * @param photo
     * @return true if uri could be read and file is suitable
     */
    public boolean addVideo(URI photo);
    
    /**
     * 
     * @return
     * @throws SendException 
     */
    public void send() throws SendException;
    
    public Serializable saveData();
    
    public void loadData(Serializable accountInfo) throws LoadException;
    
    public JPanel getDetailPanel();
    
    public JPanel getEditPanel();
    
    public JPanel getAddPanel();
    
    public String getDescription();
}
