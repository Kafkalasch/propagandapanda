/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package propagandapanda.backendprovider.DefaultPanels;

/**
 *
 * @author Michi
 */
public class MutableString {
    
    private String str;
    
    public MutableString(String str){
        this.str = str;
    }
    
    public String getString(){
        return str;
    }
    
    public void setString(String str){
        this.str = str;
    }
    
    @Override
    public String toString(){
        return getString();
    }
}
