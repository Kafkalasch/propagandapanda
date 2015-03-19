/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package propagandapanda;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import propagandapanda.backendprovider.BackendProvider;
import java.util.ArrayList;
import javax.swing.JFrame;
import propagandapanda.gui.ErrorWindow;

/**
 *
 * @author Michi
 */
public class MainViewModel {
    public ArrayList<BackendProvider> providerList = new ArrayList<>();
    
    public PossibleProvider possibleProvider;
    
    public PasswordSecurer passwordSecurer;
    
    public String masterPassword = null;
    
    private JFrame owner = null;
    
    public MainViewModel(PossibleProvider possibleProvider)
    {
        this.possibleProvider = possibleProvider;
        this.passwordSecurer = new PasswordSecurer(null);
    }
    
    public void setOwner(JFrame owner){
        this.owner = owner;
    }
    
    public void save(){
        try{
            Path path = Paths.get("bin");
            Files.createDirectories(path);

            File f = new File(path.toString() + File.separator + "savedata");
//            if(f.exists())
//                f.delete();

            f.createNewFile();

            ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f, false)));
            
            oos.writeObject(providerList);
            oos.close();
        }catch(IOException ex){
            ErrorWindow err = new ErrorWindow(owner, "Speichern war nicht möglich!");
            err.addErrorMessage(ex);
            err.setExitOnOk();
            err.setVisible(true);
        }
    }
    
    public boolean load(){
        Path path = Paths.get("bin");
        File f = new File(path.toString() + File.separator + "savedata");
        if(!f.exists()){
            return false;
        }
        
        try{
            ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
            providerList = (ArrayList<BackendProvider>) ois.readObject();
            ois.close();
        }catch(Exception ex){
            ErrorWindow err = new ErrorWindow(owner, "Laden war nicht möglich!");
            err.addErrorMessage(ex);
            err.setVisible(true);
            return false;
        }
                
        return true;
        
    }
    
    
    
    
}
