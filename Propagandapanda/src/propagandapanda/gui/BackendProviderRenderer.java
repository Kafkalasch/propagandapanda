/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package propagandapanda.gui;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import propagandapanda.backendprovider.BackendProvider;

/**
 *
 * @author Michi
 */
public class BackendProviderRenderer extends JLabel implements ListCellRenderer{
    
    public BackendProviderRenderer(){
        setOpaque(true);
        //        setHorizontalAlignment(CENTER);
//        setVerticalAlignment(CENTER);
    }
    

//    public Component getListCellRendererComponent(
//                                       JList list,
//                                       Object value,
//                                       int index,
//                                       boolean isSelected,
//                                       boolean cellHasFocus) {
//        //Get the selected index. (The index param isn't
//        //always valid, so just use the value.)
//        int selectedIndex = ((Integer)value).intValue();
//
//        if (isSelected) {
//            setBackground(list.getSelectionBackground());
//            setForeground(list.getSelectionForeground());
//        } else {
//            setBackground(list.getBackground());
//            setForeground(list.getForeground());
//        }
//
//        //Set the icon and text.  If icon was null, say so.
//        ImageIcon icon = images[selectedIndex];
//        String pet = petStrings[selectedIndex];
//        setIcon(icon);
//        if (icon != null) {
//            setText(pet);
//            setFont(list.getFont());
//        } else {
//            setUhOhText(pet + " (no image available)",
//                        list.getFont());
//        }
//
//        return this;
//    }
//    . . .


    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        //Get the selected index. (The index param isn't
        //always valid, so just use the value.)
        
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        //Set the icon and text.  If icon was null, say so.
        setFont(list.getFont());
        setText(((BackendProvider)value).getName());
        return this;
    }


}
