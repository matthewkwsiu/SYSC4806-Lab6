package Swing;
import addressbookrest.AddressBook;
import addressbookrest.BuddyInfo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveBuddyListener implements ActionListener {

    AddressBook ab;



    public void actionPerformed(ActionEvent e) {
        removeBuddyInfo();
    }

    public void removeBuddyInfo() {
        JFrame f = new JFrame();
        String name = JOptionPane.showInputDialog(f, "Enter Name of Buddy");
        String address = JOptionPane.showInputDialog(f, "Enter address of Buddy");
        String phone = JOptionPane.showInputDialog(f, "Enter phone of Buddy");
        if (ab.contains(new BuddyInfo(name, address, phone))) {
            ab.removeBuddy(new BuddyInfo(name, address, phone));
        }
    }

    public void setAddressBook(AddressBook ab){
        this.ab = ab;
    }
}
