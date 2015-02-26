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
     * hier wird nochmal feinschliff am text begangen. auch sollen constraints wie zeichenlimitierungen angezeigt werden etc.
     * @return 
     */
    public JPanel getDetailPanel();
    
    /**
     * Panel mit SendeInfos. Wird nach send() aufgerufen.
     * Hier soll bei nicht möglichem Versand die Möglichkeit zu Korrekturen geboten werden, bzw. Fehler angezeigt werden.
     * Bei positivem Versand soll hier der Link zu dem Post oder ähnliches stehen.
     * @return 
     */
    public JPanel getStatusPanel();
    
    /**
     * Panel zum Editieren von Verbindungsinfos.
     * 
     * Zumindest der Name sollte editierbar sein.
     */
    public JPanel getEditPanel();
    
    /**
     * Panel mit Verbindungsinfos usw. zum Erstellen einer neuen Instanz
     * @return 
     */
    public JPanel getAddPanel();
    
    /**
     * Gibt den Namen dieser einen Instanz zurück.
     * @return 
     */
    public String getName();
    
}
