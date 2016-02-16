package evg.testt.validation;

import evg.testt.model.Contact;
import evg.testt.service.ContactService;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ContactValidator implements Validator {

    @Autowired
    private ContactService contactService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Contact.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Contact contact = (Contact) target;
        //Contact userValid = contactService.getByEmail(contact.getEmail());

        if (!StringUtils.hasLength(contact.getFirstName())) {
            errors.rejectValue("firstName", "required", "required");
        }

        if (!StringUtils.hasLength(contact.getLastName())) {
            errors.rejectValue("lastName", "required", "required");
        }

        if(!EmailValidator.getInstance().isValid(contact.getEmail())){
            errors.rejectValue("email", "email.notValid", "Email address is not valid.");
        }

    }
}
