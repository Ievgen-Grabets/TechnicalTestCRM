package evg.testt.controller;

import evg.testt.model.Contact;
import evg.testt.service.ContactService;
import evg.testt.service.ActivityService;
import evg.testt.util.JspPath;
import evg.testt.validation.ContactValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private ContactValidator contactValidator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(contactValidator);
    }

    /**
     * Show all contacts
     * @return - models of contacts and view
     * @throws SQLException
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showAll() throws SQLException {
        return new ModelAndView(JspPath.CONTACT_ALL, "contacts", contactService.getAll());
    }

    /**
     * Save or update contact form
     * @param id - contact id ( if null it is mean new entity)
     * @return model and view of web contact form
     * @throws SQLException
     */
    @RequestMapping(value = "/contactEdit", method = RequestMethod.GET)
    public ModelAndView showAdd(@RequestParam(required = false) Integer id) throws SQLException {
        // prepare contact data
        ModelAndView modelAndView = new ModelAndView(JspPath.CONTACT_EDIT, "contacts", contactService.getAll());
        Contact contact = (id!=null ) ? contactService.getById(id) : Contact.newBuilder().build();
        modelAndView.addObject("currentContact", contact);
        // prepare activity data
        modelAndView.addObject("currentActivities", activityService.getByContact(contact));
        return modelAndView;
    }

    /**
     * Save or update contact action
     * @param currentContact - contact
     * @param result - validation result
     * @return redirect link
     */
    @RequestMapping(value = "/contactSaveOrUpdate", method = RequestMethod.POST)
    public String addNewOne(@ModelAttribute("currentContact") @Validated Contact currentContact, BindingResult result) throws SQLException {
        if(!result.hasErrors()){
            contactService.insert(currentContact);
            return "redirect:/contactEdit?id="+currentContact.getId();
        }else{
            return JspPath.CONTACT_EDIT;
        }
    }

    /**
     * Delete contact
     * @param currentContact
     * @return link to redirect
     * @throws SQLException
     */
    @RequestMapping(value = "/deleteContact", method = RequestMethod.POST)
    public String deleteContact(@ModelAttribute("currentContact") Contact currentContact) throws SQLException {
        contactService.delete(currentContact);
        return "redirect:/";
    }

}
