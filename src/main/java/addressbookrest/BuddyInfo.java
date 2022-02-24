package addressbookrest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class BuddyInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;
    private static final String DELIMITER = "#";

    public BuddyInfo(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public BuddyInfo(){
        this("", "", "");
    }

    public static void main(String[] args) {
        BuddyInfo buddy = new BuddyInfo("Count Alexander Ilyich Rostov", "Teatral'nyy Proyezd, 2, Moscow, Russia, 109012" , "7 499 501-78-00");
        System.out.println("Hello " + buddy.getName() + "!");
    }


    public Long getId(){return id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String name) {
        this.address = name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String name) {
        this.phoneNumber = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuddyInfo buddyInfo = (BuddyInfo) o;
        return Objects.equals(name, buddyInfo.name) && Objects.equals(address, buddyInfo.address) && Objects.equals(phoneNumber, buddyInfo.phoneNumber);
    }

    @Override
    public String toString() {
        return name + DELIMITER + address + DELIMITER + phoneNumber;
    }

}
