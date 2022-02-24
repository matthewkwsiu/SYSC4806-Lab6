package Swing;
import addressbookrest.AddressBook;

import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame {


//    private JList<addressbookrest.BuddyInfo> buddyInfoJList;
//    private JMenu AddressBookMenu, BuddyInfoMenu;
//    private JMenuBar menuBar;
//
//    private addressbookrest.AddressBook addressBook;


    public void init() {
//        super();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(new Dimension(600, 400));

        setState(Frame.NORMAL);

//        buddyInfoJList = new JList<>();
//
//        menuBar = new JMenuBar();
//
//        AddressBookMenu = new JMenu("addressbookrest.AddressBook");
//        menuBar.add(AddressBookMenu);

//        CreateAddressBook = new JMenuItem(new AbstractAction("CreateAddressBook") {
//            public void actionPerformed(ActionEvent e) {
//                addressBook = new addressbookrest.AddressBook();
//                buddyInfoJList = new JList<>(addressBook);
//                add(buddyInfoJList);
//            }
//        });
//        AddressBookMenu.add(CreateAddressBook);


//        setJMenuBar(menuBar);
        setVisible(true);
    }

//    public void addAddressBook(addressbookrest.AddressBook addressBook) {
//        this.addressBook = addressBook;
//        buddyInfoJList = new JList<>(addressBook);
//        add(buddyInfoJList);
//    }
//
//    public void addJMenuItem(JMenuItem jmi){
//        AddressBookMenu.add(jmi);
//        setVisible(true);
//    }


    public static void main(String[] args) {
        JMenuItem CreateAddressBook, AddBuddyInfo, RemoveBuddyInfo;


        MainFrame mf = new MainFrame();
        AddressBook ab = new AddressBook();
//        mf.addAddressBook(ab);

        AddBuddyInfo = new JMenuItem("Add addressbookrest.BuddyInfo");
        AddBuddyInfo.addActionListener(new AddBuddyListener());
        //add a setter for addressBook
//        mf.addJMenuItem(AddBuddyInfo);

        RemoveBuddyInfo = new JMenuItem("Remove addressbookrest.BuddyInfo");
        RemoveBuddyInfo.addActionListener(new RemoveBuddyListener());
//        mf.addJMenuItem(RemoveBuddyInfo);



    }

}
