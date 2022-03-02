package addressbookrest;

import addressbookrest.BuddyInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@RepositoryRestResource(collectionResourceRel = "addressbook", path = "addressbook")
public interface AddressBookRepository extends CrudRepository<AddressBook, Long> {

    List<AddressBook> findAll();

}
