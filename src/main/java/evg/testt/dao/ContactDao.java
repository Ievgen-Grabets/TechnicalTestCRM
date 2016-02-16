package evg.testt.dao;

import evg.testt.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactDao extends JpaRepository<Contact, Integer> {

    /**
     * Get contact by email
     * @param email
     * @return
     */
    Contact findByEmail(String email);

}
