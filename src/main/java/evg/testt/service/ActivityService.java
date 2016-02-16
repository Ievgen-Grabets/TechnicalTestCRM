package evg.testt.service;

import evg.testt.model.Activity;
import evg.testt.model.Contact;

import java.util.List;

public interface ActivityService extends Service<Activity> {

    List<Activity> getByContact(Contact contact);

}
