package evg.testt.service.impl;

import evg.testt.dao.ContactDao;
import evg.testt.model.Contact;
import evg.testt.service.ContactService;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl extends BaseService<Contact, ContactDao> implements ContactService {

    @Override
    public Contact getByEmail(String email) {
        return dao.findByEmail(email);
    }

}
