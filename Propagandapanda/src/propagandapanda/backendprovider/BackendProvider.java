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
public abstract class BackendProvider implements Serializable{
    
    protected transient String masterPassword;
    
    public BackendProvider(){}
    
    /**
     * 
     * @param text can be an empty String
     * @param header can be an empty String
     * @param masterPassword could be null or an empty String. Haven't decided yet.
     */
    public abstract void newPost(String text, String header, String masterPassword);
    
    /**
     * 
     * @param photo
     * @return true if file is suitable
     */
    public abstract boolean addPhoto(File photo);
    
    /**
     * 
     * @param photo
     * @return true if uri could be read and file is suitable
     */
    public boolean addPhoto(URI photo){
        File file = null;
        
        // TODO: download Photo here
        
        return addPhoto(file);
    }
    
    /**
     * 
     * @param photo
     * @return true if file is suitable
     */
    public abstract boolean addVideo(File photo);
    
    /**
     * 
     * @param photo
     * @return true if uri could be read and file is suitable
     */
    public boolean addVideo(URI photo){
        File file = null;
        
        // TODO: download Video here
        
        return addVideo(file);
    }
    
    /**
     * Die neuen Infos sind Selbstständig aus den hergebebenen DetailPanel, bzw Statuspanel zu holen.
     * @return
     * @throws SendException 
     */
    public abstract boolean send();
    
    /**
     * Panel mit TextInfos. Wird nach newPost(text, header) aufgerufen
     * hier wird nochmal feinschliff am text begangen. auch sollen constraints wie zeichenlimitierungen angezeigt werden etc.
     * @return 
     */
    public abstract JPanel getDetailPanel();
    
    /**
     * Panel mit SendeInfos. Wird nach send() aufgerufen.
     * Hier soll bei nicht möglichem Versand die Möglichkeit zu Korrekturen geboten werden, bzw. Fehler angezeigt werden.
     * Bei positivem Versand soll hier der Link zu dem Post oder ähnliches stehen.
     * @return 
     */
    public abstract JPanel getStatusPanel();
    
    /**
     * Panel zum Editieren von Verbindungsinfos.
     * 
     * Zumindest der Name sollte editierbar sein.
     */
    public abstract JPanel getEditPanel();
    
    /**
     * Panel mit Verbindungsinfos usw zum Erstellen einer neuen Instanz
     * @return 
     */
    public JPanel getAddPanel(){
        return getEditPanel();
    }
    
    /**
     * Gibt den Namen dieser einen Instanz zurück.
     * Muss von Anfang an funktionieren (also nicht null zurückgeben), auch wenn diese Instanz
     * nur mit einem argumentlosen Konstruktor aufgerufen wurde.
     * 
     * @return 
     */
    public abstract String getName();
    
    @Override
    public String toString(){
        return getName();
    }
    
}
