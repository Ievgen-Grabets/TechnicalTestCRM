package evg.testt.dao;

import evg.testt.model.Activity;
import evg.testt.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityDao extends JpaRepository<Activity, Integer> {

    /**
     * Get all activities by specified contact
     * @param contact
     * @return list activities
     */
    List<Activity> findByContact(Contact contact);

}
