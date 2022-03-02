package addressbookrest;

import addressbookrest.AddressBook;
import addressbookrest.BuddyInfo;
import org.junit.Before;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.*;

import java.util.List;

import static org.junit.Assert.*;

public class BuddyInfoTest {

    private BuddyInfo buddy1;
    private BuddyInfo buddy2;
    private AddressBook addressBook1;

    @BeforeEach
    public void setup(){
        buddy1 = new BuddyInfo("Alice", "Carleton", "123");
        buddy2 = new BuddyInfo("Brandon", "Carleton", "567");
        addressBook1 = new AddressBook();
    }

    @Test
    public void getName() {
        assertEquals(buddy1.getName(), "Alice");
    }

    @Test
    public void testEquals() {
        assertTrue(buddy1.equals(buddy1));
    }

    @Test
    public void testNotEquals() {
        assertFalse(buddy1.equals(buddy2));
    }
//
//    @Test
//    public void testPersist(){
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BuddyInfoUnit");
//
//        EntityManager em = emf.createEntityManager();
//
//        EntityTransaction tx = em.getTransaction();
//
//        tx.begin();
//
//        em.persist(buddy1);
//        em.persist(buddy2);
//
//        tx.commit();
//
//        Query q = em.createQuery("SELECT p FROM BuddyInfo p");
//
//        List<BuddyInfo> results = q.getResultList();
//
//        System.out.println("List of products\n----------------");
//
//        for (BuddyInfo p : results) {
//
//            System.out.println(p.getName() + " (id=" + p.getId() + ")");
//        }
//
//        em.close();
//
//        emf.close();
//    }
//
//    @Test
//    public void testPersistAddressBook(){
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BuddyInfoUnit");
//
//        EntityManager em = emf.createEntityManager();
//
//        EntityTransaction tx = em.getTransaction();
//
//
//
//        addressBook1.setBuddy(buddy1);
//        addressBook1.setBuddy(buddy2);
//        tx.begin();
//        em.persist(addressBook1);
//        tx.commit();
//
//        Query q = em.createQuery("SELECT a FROM AddressBook a");
//
//        List<AddressBook> results = q.getResultList();
//
//        results.get(0).print();
//
//
//
//        Query q2 = em.createQuery("SELECT p FROM BuddyInfo p");
//
//        List<BuddyInfo> results2 = q2.getResultList();
//
//        System.out.println("List of products\n----------------");
//
//        for (BuddyInfo p : results2) {
//
//            System.out.println(p.getName() + " (id=" + p.getId() + ")");
//        }
//
//
//        em.close();
//
//        emf.close();
//    }
}