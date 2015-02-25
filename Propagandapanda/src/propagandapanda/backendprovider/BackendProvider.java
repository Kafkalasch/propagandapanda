/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package propagandapanda.backendprovider;

import java.io.File;
import java.io.Serializable;
import java.net.URI;
import javax.swing.JPanel;
import propagandapanda.LoadException;
import propagandapanda.SendException;

/**
 *
 * @author Michi
 */
public interface BackendProvider extends Serializable{
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
    public boolean send() throws SendException;
    
    public JPanel getDetailPanel();
    
    public JPanel getEditPanel();
    
    public JPanel getAddPanel();
    
    public String getName();
}
