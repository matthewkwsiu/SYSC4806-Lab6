import addressbookrest.AddressBook;
import addressbookrest.BuddyInfo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressBookTest {


    private AddressBook addressBook;
    private BuddyInfo buddy1;
    private BuddyInfo buddy2;
    private BuddyInfo buddy3;


    @Before
    public void setup(){
        addressBook = new AddressBook();
        buddy1 = new BuddyInfo("Alice", "Carleton", "123");
        buddy2 = new BuddyInfo("Brandon", "Carleton", "567");
        buddy3 = new BuddyInfo("Christine", "Carleton", "456");
    }

    @Test
    public void addBuddy() {
        addressBook.setBuddy(buddy1);
        assertTrue(addressBook.contains(buddy1));
    }
}