package evg.testt.service;

import evg.testt.model.Contact;

public interface ContactService extends Service<Contact> {

    Contact getByEmail(String email);

}
