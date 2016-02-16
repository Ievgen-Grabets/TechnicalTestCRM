package evg.testt.controller;

import evg.testt.model.Activity;
import evg.testt.model.Contact;

import evg.testt.service.ActivityTypeService;
import evg.testt.service.ContactService;
import evg.testt.service.ActivityService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @Autowired
    private ActivityTypeService activityTypeService;

    @Autowired
    private ContactService contactService;

    /**
     * Show add new activity form
     * @param currentContact
     * @return model and view, Activity and contact list
     * @throws SQLException
     */
    @RequestMapping(value = "/addActivity", method = RequestMethod.GET)
    public ModelAndView addActivity(@ModelAttribute("currentContact") Contact currentContact) throws SQLException {
        ModelAndView modelAndView = new ModelAndView(JspPath.ACTIVITY_EDIT);
        // prepare activity data
        Contact contact = contactService.getById(currentContact.getId());
        Activity activity = Activity.newBuilder().setContact(contact).build();
        modelAndView.addObject("currentActivity", activity);
        // prepare contact data
        modelAndView.addObject("types", activityTypeService.getAll());
        modelAndView.addObject("contacts", contactService.getAll());
        return modelAndView;
    }

    /**
     * Show edit new activity form
     * @param id
     * @return
     * @throws SQLException
     */
    @RequestMapping(value = "/editActivity", method = RequestMethod.GET)
    public ModelAndView activityEditById(@RequestParam Integer id) throws SQLException {
        ModelAndView modelAndView = new ModelAndView(JspPath.ACTIVITY_EDIT);
        modelAndView.addObject("currentActivity", activityService.getById(id));
        modelAndView.addObject("types", activityTypeService.getAll());
        modelAndView.addObject("contacts", contactService.getAll());
        return modelAndView;
    }

    /**
     * Add or update activity
     * @param currentActivity
     * @return redirect
     * @throws SQLException
     */
    @RequestMapping(value = "/activitySaveOrUpdate", method = RequestMethod.POST)
    public String saveActivity(@ModelAttribute("currentActivity") Activity currentActivity, @RequestParam(required = true) Integer typeId) throws SQLException {
        Contact contact = contactService.getById(currentActivity.getContact().getId());
        currentActivity.setContact(contact);
        currentActivity.setType(activityTypeService.getById(typeId));
        activityService.insert(currentActivity);
        return "redirect:/contactEdit?id="+contact.getId();
    }

    /**
     * Delete activity
     * @param currentActivity
     * @return link to redirect
     * @throws SQLException
     */
    @RequestMapping(value = "/deleteActivity", method = RequestMethod.POST)
    public String deleteActivity(@ModelAttribute("currentActivity") Activity currentActivity) throws SQLException {
        Integer contactId = currentActivity.getContact().getId();
        activityService.delete(currentActivity);
        return "redirect:/contactEdit?id="+contactId;
    }

}
