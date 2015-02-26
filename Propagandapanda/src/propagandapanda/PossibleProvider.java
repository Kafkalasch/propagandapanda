/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package propagandapanda;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import propagandapanda.backendprovider.BackendProvider;
import propagandapanda.gui.FatalErrorWindow;

/**
 *
 * @author Michi
 */
public class PossibleProvider {
    private HashMap<String, Constructor<? extends BackendProvider>> map;
    
    public PossibleProvider(Collection<Class<? extends BackendProvider>> providerClasses){
        map = new HashMap<>((int) (1+ providerClasses.size()/0.75));
        Constructor<? extends BackendProvider> constr = null;
        String name;
        for(Class c : providerClasses){
            try {
                constr = c.getConstructor();
                name = constr.newInstance().getName();
                map.put(name, constr);
            } catch (NoSuchMethodException | SecurityException | 
                    InstantiationException | IllegalAccessException |
                    IllegalArgumentException| InvocationTargetException ex) {
                new FatalErrorWindow(ex);
            }
        }
        
    }
    
    public HashMap<String, Constructor<? extends BackendProvider>> getConstructors(){
        return map;
    }
    
    public Set<String> getNames(){
        return map.keySet();
    }
    
    public Constructor<? extends BackendProvider> getConstructor(String name){
        return map.get(name);
    }
}
