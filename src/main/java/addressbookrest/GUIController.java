package addressbookrest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GUIController {

    @Autowired
    private AddressBookRepository abr;

    @GetMapping("/viewgui")
    public String greetingSubmit2(Model model, @ModelAttribute AddressBook addressBook2) {
        model.addAttribute("buddies", abr.findById(addressBook2.getId()).get().getBuddies());
        model.addAttribute("buddyinfo", new BuddyInfo());
        model.addAttribute("id", addressBook2.getId());
        return "addressbook";
    }

    @PostMapping("/viewgui")
    public String greetingSubmit3(Model model, @RequestParam Long i, @ModelAttribute BuddyInfo buddyInfo) {
        AddressBook a = abr.findById(i).get();
        a.setBuddy(buddyInfo);
        abr.save(a);
        model.addAttribute("buddies", a.getBuddies());
        model.addAttribute("buddyinfo", new BuddyInfo());
        model.addAttribute("id", i);
        return "addressbook";
    }

    @GetMapping("/viewaddressbooks")
    public String viewAddressBooks(Model model) {
        model.addAttribute("addressbooks", abr.findAll());
        model.addAttribute("addressbook", new AddressBook());
        model.addAttribute("addressbook2", new AddressBook());
        model.addAttribute("numbers", 100);
        return "addressbooks";
    }

    @PostMapping("/viewaddressbooks")
    public String addAddressBook(Model model, @ModelAttribute AddressBook addressBook) {
        abr.save(addressBook);
        model.addAttribute("addressbooks", abr.findAll());
        model.addAttribute("addressbook", new AddressBook());
        model.addAttribute("addressbook2", new AddressBook());
        return "addressbooks";
    }


}
