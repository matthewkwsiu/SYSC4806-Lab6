package addressbookrest;

import addressbookrest.AddressBook;
import addressbookrest.BuddyInfo;



import static org.junit.Assert.*;


import org.junit.jupiter.api.Test;


public class AddressBookTest {


    private AddressBook addressBook;
    private BuddyInfo buddy1;




    @Test
    public void addBuddy() {
        addressBook = new AddressBook();
        buddy1 = new BuddyInfo("Alice", "Carleton", "123");
        addressBook.setBuddy(buddy1);
        assertTrue(addressBook.contains(buddy1));
    }
}