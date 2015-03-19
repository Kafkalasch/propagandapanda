/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package propagandapanda;

/**
 *
 * @author Michi
 */
public class PasswordSecurer {
    
    private String masterPassword;
    
    
    /**
     * Entschlüsselt und Verschlüsselt mithilfe des übergebenen Master Passwortes
     * die übergebenen ver- und entschlüsselten Passwörter.
     * @param masterPassword 
     */
    public PasswordSecurer(String masterPassword){
        this.masterPassword = masterPassword;
    }
    
    /**
     * Das übergebene Password wird mit Hilfe des Masterpasswortes verschlüsselt.
     * (noch nicht implementiert)
     * @param plainPassword ein zu verschlüsselndes Passwort
     * @return gibt das verschlüsselte Password zurück.
     */
    public String encryptPW(String plainPassword){
        // TODO Security einbauen.
        return plainPassword;
    }
    
    /**
     * Das übergebene Password wird mit Hilfe des Masterpasswortes entschlüsselt.
     * (noch nicht implementiert)
     * @param encryptedPW ein verschlüsseltes Passwort
     * @return gibt das entschlüsselte Passwort zurück
     */
    public String decryptPW(String encryptedPW){
        // TODO Security einbauen.
        return encryptedPW;
    }
    
    /**
     * siehe nicht statisches Äquivalent.
     * @param encryptedPW
     * @param masterPW
     * @return 
     */
    public static String decryptPW(String encryptedPW, String masterPW){
        // TODO Security einbauen.
        return encryptedPW;
    }
    
    /**
     * siehe nicht statische Äquivalent.
     * @param decryptedPW
     * @param masterPW
     * @return 
     */
    public static String encryptPW(String decryptedPW, String masterPW){
        // TODO Security einbauen.
        return decryptedPW;
    }
}
