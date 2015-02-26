/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package propagandapanda;

import propagandapanda.backendprovider.BackendProvider;
import java.util.ArrayList;

/**
 *
 * @author Michi
 */
public class MainViewModel {
    public ArrayList<BackendProvider> providerList;
    
    private PossibleProvider possProvs;
    
    public MainViewModel(PossibleProvider possibleProvider){
        this.possProvs = possibleProvider;
    }
    
    
    
    
}
