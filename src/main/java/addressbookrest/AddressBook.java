package addressbookrest;

import javax.persistence.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<BuddyInfo> buddies;

    private String name;

    public AddressBook() {
        buddies = new ArrayList<>();
//        this.id = 1234L;
    }
    public AddressBook(String name) {
        buddies = new ArrayList<>();
        this.name = name;
    }
//    public AddressBook(String id) {
//        buddies = new ArrayList<>();
//        this.id = id;
//    }

    public void setBuddy(BuddyInfo buddy) {
        buddies.add(buddy);
    }

    public void removeBuddy(BuddyInfo buddy) {
        buddies.remove(buddy);
    }

    public boolean contains(BuddyInfo buddy){
        return buddies.contains(buddy);
    }

    public Long getId(){return id;}

    public void setId(Long id){this.id = id;}


    public List<addressbookrest.BuddyInfo> getBuddies(){
        return buddies;
    }
//
//    public void setBuddies(List<addressbookrest.BuddyInfo> buddies){
//        this.buddies = buddies;
//    }

    public void print(){
        String addressBookString = "<addressBook>";
        for (BuddyInfo buddyInfo : buddies){
            addressBookString = addressBookString.concat("\n" + buddyInfo.toString());
        }
        addressBookString = addressBookString.concat("\n" + "</addressBook>");
        System.out.println(addressBookString);
    }

    public static void main(String[] args){
        AddressBook addressBook = new AddressBook();
        BuddyInfo buddy1 = new BuddyInfo("Alice", "Carleton", "123");
        BuddyInfo buddy2 = new BuddyInfo("Brandon", "Carleton", "567");
        BuddyInfo buddy3 = new BuddyInfo("Christine", "Carleton", "456");
        addressBook.setBuddy(buddy1);
        addressBook.setBuddy(buddy2);
        addressBook.setBuddy(buddy3);
        addressBook.print();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
