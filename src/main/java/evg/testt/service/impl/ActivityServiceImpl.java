package evg.testt.service.impl;

import evg.testt.dao.ActivityDao;
import evg.testt.model.Activity;
import evg.testt.model.Contact;
import evg.testt.service.ActivityService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ActivityServiceImpl extends BaseService<Activity, ActivityDao> implements ActivityService {

    @Override
    public List<Activity> getByContact(Contact contact) {
        return contact.getId() == null ? Collections.emptyList() : dao.findByContact(contact);
    }

}
