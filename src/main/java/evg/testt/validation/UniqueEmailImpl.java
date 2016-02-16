package evg.testt.validation;

import evg.testt.model.Contact;
import evg.testt.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Method;


public class UniqueEmailImpl implements ConstraintValidator<UniqueEmail, Object>{

    @Autowired
    ContactService contactService;

    @Override
    public void initialize(UniqueEmail UniqueEmail) {

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value != null) {
            Contact currentContact = (Contact) value;
            Contact foundContact;
            if (currentContact.getEmail().isEmpty()) {
                return true;
            }
            try {
                foundContact = contactService.getByEmail(currentContact.getEmail());
            } catch (Exception ignored) {
                return true;
            }
            if (!currentContact.equals(foundContact)) {
                return false;
            }
        }
        return true;
    }

}
