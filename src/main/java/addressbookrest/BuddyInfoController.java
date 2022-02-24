package addressbookrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuddyInfoController {

    @Autowired
    private AddressBookRepository abr;

    @PostMapping("/buddyinfo")
    public String addBuddyInfo(@RequestParam(value = "addressBookIndex", defaultValue = "0") int i,
                             @RequestParam(value = "name", defaultValue = "Alex") String name,
                             @RequestParam(value = "address", defaultValue = "123 Street") String address,
                             @RequestParam(value = "phoneNumber", defaultValue = "123-456-7890") String phoneNumber) {
        System.out.println("adding buddy info");
//        addressBooks.getOrDefault(addressBookIndex, addressBooks).setBuddy(new BuddyInfo(name, address, phoneNumber));

        abr.findAll().get(i).setBuddy(new BuddyInfo(name, address, phoneNumber));
        abr.save(abr.findAll().get(i));
        return "viewgui?i=" + i;
    }

    @PostMapping("/removebuddyinfo")
    public String removeBuddyInfo(@RequestParam(value = "addressBookIndex", defaultValue = "0") int i,
                                  @RequestParam(value = "name", defaultValue = "Alex") String name,
                                  @RequestParam(value = "address", defaultValue = "123 Street") String address,
                                  @RequestParam(value = "phoneNumber", defaultValue = "123-456-7890") String phoneNumber) {
        System.out.println("adding buddy info");
//        addressBooks.getOrDefault(addressBookIndex, addressBooks).setBuddy(new BuddyInfo(name, address, phoneNumber));


        abr.findAll().get(i).removeBuddy(new BuddyInfo(name, address, phoneNumber));
        abr.save(abr.findAll().get(i));

        return "removed" + new BuddyInfo(name, address, phoneNumber);
    }
}
