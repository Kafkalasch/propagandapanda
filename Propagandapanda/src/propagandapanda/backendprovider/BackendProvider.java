/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package propagandapanda.backendprovider;

import propagandapanda.PasswordSecurer;
import java.io.File;
import java.io.Serializable;
import java.net.URI;
import javax.swing.JPanel;
import propagandapanda.backendprovider.DefaultPanels.MutableString;
/**
 * Oberklasse aller Schnittstellen.
 * 
 * Alle Schnittstellen müssen von dieser Klasse erben.
 * Es müssen auch alle Verbindungsinfos gespeichert werden, da die einzelnen
 * Instanzen gespeichert und zukünftig wieder geladen werden. Somit soll
 * eine Verbindung zu dem Medium ohne Output von außen wieder möglich sein.
 * 
 * Die Passwörter hierfür sollen mit dem übergebenen PasswordSecurer entschlüsselt und wieder 
 * verschlüsselt werden, damit sie nicht im plain Text gespeichert werden.
 * 
 * Folgende Funktionsweise ist vorgesehen:
 * Mit newPost(...) werden Texte und PasswordSecurer usw übergeben.
 * Optional können mit addVideo(...) oder addPhoto(...) weitere Infos übergeben werden.
 * mit getDetailPanel() soll ein Panel zur Verfügung gestellt werden, mit dem Nachkorrekturen möglich sind.
 * mit send() wird versendet. Die Korrekturen sind selbstständig aus dem DetailPanel bzw. Statuspanel zu holen.
 * danach wird mit getStatusPanel() der Status abgefragt. Siehe auch Kommentare bei den einzelnen Methoden.
 * 
 * In propagandapanda.backendprovider.defaultPanels gibts DefaultPanels die optional verwendet, bzw. von denen abgeleitet werden kann.
 * 
 * @author Michi
 */
public abstract class BackendProvider implements Serializable{
    
    
    protected transient String masterPW;
    
    public BackendProvider(){}
    
    /**
     * 
     * @param text can be an empty String
     * @param header can be an empty String
     * @param passwordSecurer damit können gespeicherte Passwörter entschlüsselt werden
     */
    public void newPost(String text, String header, String pw){
        this.masterPW = pw;
    }
    
    /**
     * Hier wird ein Foto übergeben. Kann, muss aber nicht funktionierend implementiert werden.
     * @param photo
     * @return true if file is suitable
     */
    public boolean addPhoto(File photo){
        return false;
    }
    
    /**
     * Hier wird ein Foto übergeben. Kann, muss aber nicht funktionierend implementiert werden.
     * @param photo
     * @return true if uri could be read and file is suitable
     */
    public boolean addPhoto(URI photo){
        File file = null;
        
        // TODO: download Photo here
        
        return addPhoto(file);
    }
    
    /**
     * Hier wird ein Video übergeben. Kann, muss aber nicht funktionierend implementiert werden.
     * @param photo
     * @return true if file is suitable
     */
    public boolean addVideo(File photo){
        return false;
    }
    
    /**
     * Hier wird ein Video übergeben. Kann, muss aber nicht funktionierend implementiert werden.
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
     * @return true falls senden erfolgreich war. 
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
