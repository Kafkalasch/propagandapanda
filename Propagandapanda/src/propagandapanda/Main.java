/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package propagandapanda;

import propagandapanda.gui.FatalErrorWindow;

/**
 *
 * @author Michi
 */
public class Main {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
     try{
    // TODO code application logic here
      }catch(Throwable e){
          FatalErrorWindow few = new FatalErrorWindow(e);
      }
  }
  
}
