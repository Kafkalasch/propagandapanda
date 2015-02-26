/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package propagandapanda;

import java.util.ArrayList;
import propagandapanda.backendprovider.DemoBackendProvider;
import propagandapanda.gui.FatalErrorWindow;
import propagandapanda.gui.MainView;

/**
 *
 * @author Michi
 */
public class Main {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
//     try{
         MainViewModel mvm = new MainViewModel();
         mvm.providerList = new ArrayList<>();
         mvm.providerList.add(new DemoBackendProvider());
         mvm.providerList.add(new DemoBackendProvider());
         mvm.providerList.add(new DemoBackendProvider());
         mvm.providerList.add(new DemoBackendProvider());
         mvm.providerList.add(new DemoBackendProvider());
         mvm.providerList.add(new DemoBackendProvider());
         mvm.providerList.add(new DemoBackendProvider());
         
         MainView mv = new MainView(mvm);
//      }catch(Throwable e){
//          FatalErrorWindow few = new FatalErrorWindow(e);
//      }
  }
  
}
