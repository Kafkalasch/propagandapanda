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
    public boolean send();
    
    /**
     * Panel mit TextInfos. Wird nach newPost(text, header) aufgerufen
     * @return 
     */
    public JPanel getDetailPanel();
    
    /**
     * Panel mit SendeInfos. Wird nach send() aufgerufen
     * @return 
     */
    public JPanel getStatusPanel();
    
    /**
     * Panel zum Editieren von Verbindungsinfos
     */
    public JPanel getEditPanel();
    
    /**
     * Panel mit Verbindungsinfos usw.
     * @return 
     */
    public JPanel getAddPanel();
    
    public String getName();
    
}
