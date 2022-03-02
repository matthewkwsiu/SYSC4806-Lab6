package addressbookrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class AddressBookController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private AddressBookRepository abr;
    private static List<AddressBook> addressBooks = new ArrayList<>();
//    private ConcurrentHashMap<Long, AddressBook> addressBooks = new ConcurrentHashMap<Long, AddressBook>();

    private final AtomicLong defaultNumber = new AtomicLong();


//    @GetMapping("/greeting")
//    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
//        return new Greeting(counter.incrementAndGet(), String.format(template, name));
//    }

    @GetMapping("/createaddressbook")
    public List<AddressBook>createAddressBook(@RequestParam(value = "name", defaultValue = "") String name) {
        System.out.println("creating address book");
//        addressBooks.put(counter.incrementAndGet(), new AddressBook(name));
//        addressBooks.add( new AddressBook(name));
        abr.save(new AddressBook(name));
//        return addressBooks;
        return abr.findAll();
    }

    @GetMapping("/viewaddressbook")
    public List<AddressBook>viewAddressBooks() {
        return abr.findAll();
//        return addressBooks;
    }

    @GetMapping("/getaddressbook")
    public Optional<AddressBook> getAddressBook(@RequestParam(value = "id", defaultValue = "1") Long id) {
        return abr.findById(id);
//        return addressBooks;
    }

    public static List<AddressBook> getAddressBooks() {
        return addressBooks;
    }

    //    @PostMapping("/buddyinfo")
//    public void addBuddyInfo(@RequestParam(value = "addressBookIndex", defaultValue = "0") int i,
//                                    @RequestParam(value = "name", defaultValue = "Alex") String name,
//                                    @RequestParam(value = "address", defaultValue = "123 Street") String address,
//                                    @RequestParam(value = "phoneNumber", defaultValue = "123-456-7890") String phoneNumber) {
//        System.out.println("adding buddy info");
////        addressBooks.getOrDefault(addressBookIndex, addressBooks).setBuddy(new BuddyInfo(name, address, phoneNumber));
//
//        addressBooks.get(i).setBuddy(new BuddyInfo(name, address, phoneNumber));
//
//    }
//
//    @PostMapping("/removebuddyinfo")
//    public String removeBuddyInfo(@RequestParam(value = "addressBookIndex", defaultValue = "0") int i,
//                                    @RequestParam(value = "name", defaultValue = "Alex") String name,
//                                    @RequestParam(value = "address", defaultValue = "123 Street") String address,
//                                    @RequestParam(value = "phoneNumber", defaultValue = "123-456-7890") String phoneNumber) {
//        System.out.println("adding buddy info");
////        addressBooks.getOrDefault(addressBookIndex, addressBooks).setBuddy(new BuddyInfo(name, address, phoneNumber));
//
//
//        addressBooks.get(i).removeBuddy(new BuddyInfo(name, address, phoneNumber));
//
//        return "removed" + new BuddyInfo(name, address, phoneNumber);
//    }

//    @GetMapping("/testing123")
//    public String greetingForm2(Model model) {
//        model.addAttribute("greeting", new AddressBook());
//        return "addressbook";
//    }

}