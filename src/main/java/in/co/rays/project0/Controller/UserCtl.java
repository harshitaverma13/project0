package in.co.rays.project0.Controller;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.co.rays.project0.DTO.RoleDTO;
import in.co.rays.project0.DTO.UserDTO;
import in.co.rays.project0.Exception.DuplicateRecordException;
import in.co.rays.project0.Form.ChangePasswordForm;
import in.co.rays.project0.Form.ChangePasswordValidator;
import in.co.rays.project0.Form.MyProfileForm;
import in.co.rays.project0.Form.MyProfileValidator;
import in.co.rays.project0.Form.UserForm;
import in.co.rays.project0.Form.UserValidator;
import in.co.rays.project0.Service.RoleServiceInt;
import in.co.rays.project0.Service.UserServiceInt;
import in.co.rays.project0.Util.Util;

/**
 * Contains navigation logics for User, UserList, MyProfile, ChangePassword,
 * usecases.
 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SunilOS
 */
@Controller
@RequestMapping(value = "/ctl/User")
public class UserCtl extends BaseCtl {
	private static Logger log = Logger.getLogger(UserCtl.class);

	@Autowired
	private UserServiceInt service;

	@Autowired
	private RoleServiceInt roleService;

	@Autowired
	UserValidator uservalidator;

	@Autowired
	private MyProfileValidator profileValidator;

	@Autowired
	private ChangePasswordValidator passwordValidator;

	/**
	 * i18n Message source
	 */
	@Autowired
	private MessageSource messageSource;

	/**
	 * Preload Rols List
	 */
	@Override
	public void preload(Model model) {
		// Preload Role List
		List rolelist = roleService.search(null);
		model.addAttribute("roleList", rolelist);
		System.out.println("USERCTL LIST**********"+rolelist);
		
		/*Iterator it = rolelist.iterator();
		RoleDTO dt= new RoleDTO();
		dt=(RoleDTO) it.next();
		System.out.println(dt.getRoleName()+"rolnAME");*/

		List userList = service.search(null);
		model.addAttribute("userList", userList);

	}

	/**
	 * Displayes User view.
	 * 
	 * @param id
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String display(@RequestParam(required = false) Long id, @ModelAttribute("form")
	UserForm form, Model model) {

		log.debug("UserCtl doDisplay Start " + id);

		if (id != null && id > 0) {
			UserDTO dto = service.findByPK(id);
			form.populate(dto);
		}

		return "User";

	}

	/**
	 * Submits User data.
	 * 
	 * @param locale
	 * @param operation
	 * @param form
	 * @param bindingResult
	 * @param session
	 * @param model
	 * @return
	 */

	@RequestMapping(method = RequestMethod.POST)
	public String submit(Locale locale, @RequestParam String operation, @ModelAttribute("form") 
	@Valid UserForm form, BindingResult bindingResult, HttpSession session, Model model) {

		log.debug("UserCtl doSubmit Start ");

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:User";
		}
		if (OP_CANCEL.equalsIgnoreCase(operation)) {
			return "redirect:User/search";
		}

		uservalidator.validate(form, bindingResult);

		if (bindingResult.hasErrors()) {
			return "User";
		}

		try {
			if (OP_SAVE.equals(operation) || OP_UPDATE.equals(operation)) {

				UserDTO dto = (UserDTO) form.getDto();

				if (dto.getId() > 0) {
					service.update(dto);
					String msg = messageSource.getMessage("message.success.update", null, locale);
					model.addAttribute("success", msg);

				} else {
					Long id = service.add(dto);
					
					String msg = messageSource.getMessage("message.success.add", null, locale);
					model.addAttribute("success", msg);
				}

				return "User";

			} else if (OP_DELETE.equals(operation)) {

				service.delete(form.getId());
				return "redirect:Student/search";
			}
		} catch (DuplicateRecordException e) {
			log.error(e);
			String msg = messageSource.getMessage("duplicate.message.user", null, locale);
			model.addAttribute("error", msg);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);

		}

		return "User";
	}

	/**
	 * Displays User List
	 * 
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchList(Locale locale, @ModelAttribute("form") UserForm form, Model model) {

		List list = service.search(null, form.getPageNo(), form.getPageSize());

		if (list == null || list.size() == 0) {
			String msg = messageSource.getMessage("message.listNull", null, locale);
			model.addAttribute("error", msg);
		}
		model.addAttribute("list", list);

		return "UserList";
	}

	/**
	 * Submits User List data.
	 * 
	 * @param locale
	 * @param form
	 * @param operation
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchList(Locale locale, @ModelAttribute("form") UserForm form,
			@RequestParam(required = false) String operation, Model model) {

		log.debug("in searchList method");

		// Calculate next page number
		int pageNo = form.getPageNo();

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:search";
		}
		if (OP_NEW.equalsIgnoreCase(operation)) {
			return "User";
		}

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;

		form.setPageNo(pageNo);

		if (OP_DELETE.equals(operation)) {

			pageNo = 1;

			if (form.getIds() != null) {

				for (long id : form.getIds()) {
					service.delete(id);
				}

				String msg = messageSource.getMessage("message.success.delete", null, locale);
				model.addAttribute("success", msg);

			} else {
				String msg = messageSource.getMessage("message.list.delete", null, locale);
				model.addAttribute("error", msg);
			}

		}

		// Get search attributes
		UserDTO dto = (UserDTO) form.getDto();
		List list = service.search(dto, pageNo, form.getPageSize());
		if (!OP_DELETE.equalsIgnoreCase(operation)) {
			if (list == null || list.size() == 0) {
				String msg = messageSource.getMessage("message.listNull", null, locale);
				model.addAttribute("error", msg);
			}
		}

		model.addAttribute("list", list);

		return "UserList";

	}

	/**
	 * Displays MyProfile View
	 * 
	 * @param session
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String displayProfile(HttpSession session, @ModelAttribute("form") MyProfileForm form, Model model) {
		log.debug("MyProfileCtl start");
		UserDTO dto = (UserDTO) session.getAttribute("user");
		form.populate(dto);
		return "MyProfile";
	}

	/**
	 * Submits MyProfile
	 * 
	 * @param session
	 * @param form
	 * @param model
	 * @return
	 * @throws DuplicateRecordException
	 */
	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public String submitProfile(Locale locale, @RequestParam String operation,
			@ModelAttribute("form") @Valid MyProfileForm form, BindingResult bindingResult, Model model)
			throws DuplicateRecordException {
		
		if (OP_CHANGE_MY_PASSWORD.equalsIgnoreCase(operation)) {
			return "redirect:changepassword";
		}

		if (OP_UPDATE.equalsIgnoreCase(operation)) {
			profileValidator.validate(form, bindingResult);
		
			if (bindingResult.hasErrors()) {
				return "MyProfile";
			}

			UserDTO dto = service.findByPK(form.getId());
			dto.setFirstName(form.getFirstName());
			dto.setLastName(form.getLastName());
			dto.setDob(Util.getDate(form.getDob()));
			dto.setMobileNo(form.getMobileNo());
			dto.setGender(form.getGender());

			
			
			service.update(dto);
			String msg = messageSource.getMessage("message.success", null, locale);
			model.addAttribute("success", msg);
		}
		return "MyProfile";
	}

	/**
	 * Displays Change Password view.
	 * 
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/changepassword", method = RequestMethod.GET)
	public String displayChangePassword(@ModelAttribute("form") ChangePasswordForm form, Model model) {
		log.debug("displayChangePassword start");
		return "ChangePassword";
	}

	/**
	 * Submits Change Password data.
	 * 
	 * @param session
	 * @param form
	 * @param model
	 * @return
	 * @throws DuplicateRecordException
	 */
	@RequestMapping(value = "/changepassword", method = RequestMethod.POST)
	public String submitChangePassword(Locale locale, @RequestParam String operation, HttpSession session,
			@ModelAttribute("form") @Valid ChangePasswordForm form, BindingResult bindingResult, Model model)
			throws DuplicateRecordException {
		if (OP_CHANGE_MY_PROFILE.equalsIgnoreCase(operation)) {
			return "redirect:profile";
		}
		passwordValidator.validate(form, bindingResult);
		if (bindingResult.hasErrors()) {
			return "ChangePassword";
		}
		if (OP_SAVE.equalsIgnoreCase(operation)) {
			// New password and confirm password must be same
			if (form.getNewPassword().equals(form.getConfirmPassword())) {

				UserDTO dto = (UserDTO) session.getAttribute("user");
				dto = service.findByPK(dto.getId());

				// Old password must be valid
				if (dto.getPassword().equals(form.getOldPassword())) {
					// Change Password
					dto.setPassword(form.getNewPassword());
					service.update(dto);
					String msg = messageSource.getMessage("message.success", null, locale);
					model.addAttribute("success", msg);
				} else {
					String msg = messageSource.getMessage("error.changepassword.message", null, locale);
					model.addAttribute("error", msg);
				}
			} else {
				String msg = messageSource.getMessage("notmatch.changepassword.message", null, locale);
				model.addAttribute("error", msg);
			}
		}
		return "ChangePassword";
	}

}
