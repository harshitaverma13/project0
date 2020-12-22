
package in.co.rays.project0.Controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.co.rays.project0.DTO.RoleDTO;
import in.co.rays.project0.DTO.UserDTO;
import in.co.rays.project0.Exception.ApplicationException;
import in.co.rays.project0.Exception.DuplicateRecordException;
import in.co.rays.project0.Exception.RecordNotFoundException;
import in.co.rays.project0.Form.ForgetPasswordForm;
import in.co.rays.project0.Form.LoginForm;
import in.co.rays.project0.Form.LoginValidator;
import in.co.rays.project0.Form.UserRegistrationForm;
import in.co.rays.project0.Form.UserRegistrationValidator;
import in.co.rays.project0.Service.RoleServiceInt;
import in.co.rays.project0.Service.UserServiceInt;

/**
 * Contains navigation logics for Login, Forgot Password and SignUp Usecases.
 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SunilOS
 */
@Controller
public class LoginCtl extends BaseCtl {
	private static Logger log = Logger.getLogger(LoginCtl.class);

	/**
	 * Operations
	 */
	protected static final String OP_SIGNIN = "SignIn";
	protected static final String OP_SIGNUP = "SignUp";

	@Autowired
	private UserServiceInt service;

	@Autowired
	private RoleServiceInt roleService;
	@Autowired
	LoginValidator loginValidator;

	@Autowired
	private UserRegistrationValidator validator;

	/**
	 * i18n Message source
	 */
	@Autowired
	private MessageSource messageSource;

	/**
	 * Displays Login View.
	 * 
	 * @param form
	 * @param session
	 * @param model
	 * @return
	 */
	
	/*@GetMapping
	@PostMapping*/
	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public String display(@ModelAttribute("form") LoginForm form, HttpSession session, Model model, Locale locale) {
		log.debug("Login Submit Started");
		UserDTO dto = (UserDTO) session.getAttribute("user");

		if (dto != null) {
			session.invalidate();
			String msg = messageSource.getMessage("message.logout", null, locale);
			model.addAttribute("success", msg);

		}
		return "Login";
	}

	/**
	 * Submits Login data.
	 * 
	 * @param form
	 * @param bindingResult
	 * @param session
	 * @return
	 * @throws RecordNotFoundException
	 */
	@RequestMapping(value = "/Login", method = { RequestMethod.POST })
	public String submit(Locale locale, @ModelAttribute("form") @Valid LoginForm form, 
			BindingResult bindingResult, HttpSession session, Model model) {

		log.debug("Login Submit Started");

		System.out.println("result Fail :" + bindingResult.hasErrors());

		loginValidator.validate(form, bindingResult);

		if (bindingResult.hasErrors()) {

			return "Login";
		}

		if (OP_SIGNIN.equalsIgnoreCase(form.getOperation())) {

			UserDTO dto = new UserDTO();
			dto.setLogin(form.getEmailId());
			dto.setPassword(form.getPassword());

			try {
				dto = service.authenticate(dto.getLogin(), dto.getPassword());
				if (dto != null) 
				{
					session.setAttribute("user", dto);

					RoleDTO roleDto = roleService.findById(dto.getRoleId());
					session.setAttribute("role", roleDto);

					String str = (String) session.getAttribute("URI");

					if (str == null || "null".equalsIgnoreCase(str)) 
					{
						/*
						 * model.addAttribute("message", "Welcome :" +
						 * form.getEmailId());
						 */
						return "redirect:/Welcome";
					} else {
						str = str.replace("/ORS_Proj_0", "");

						return "redirect:" + str;
					}

				}
			} catch (RecordNotFoundException e) {
				String msg = messageSource.getMessage("login.error", null, locale);
				model.addAttribute("error", msg);
				e.printStackTrace();
			}

		}

		log.debug("Login Submit End");
		return "Login";

	}

	/**
	 * Displays ForgetPAssword View
	 * 
	 * @param form
	 * @param model
	 * @return
	 */

	@RequestMapping(value = "/ForgetPassword", method = RequestMethod.GET)
	public String display(@ModelAttribute("form") ForgetPasswordForm form, Model model) {
		return "ForgetPassword";
	}

	/**
	 * Submits ForgetPassword data.
	 * 
	 * @param locale
	 * @param form
	 * @param bindingResult
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/ForgetPassword", method = RequestMethod.POST)
	public String submit(Locale locale, @RequestParam String operation,
			@ModelAttribute("form") @Valid ForgetPasswordForm form, BindingResult bindingResult, Model model) {
		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:ForgetPassword";
		}

		if (bindingResult.hasErrors()) {
			return "ForgetPassword";
		}

		UserDTO dto = service.findByLogin(form.getLogin());

		if (dto == null) {
			String msg = messageSource.getMessage("forgetpass.error", null, locale);
			model.addAttribute("error", msg);
		} else {
			try {
				service.forgetPassword(form.getLogin());
				String msg = messageSource.getMessage("sendPassword.message", null, locale);
				model.addAttribute("success", msg);

			} catch (ApplicationException e) {
				log.error("Critical Issue ", e);
			}
		}
		return "ForgetPassword";
	}

	/**
	 * Displays SignUp view
	 * 
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/SignUp", method = RequestMethod.GET)
	public String display(@ModelAttribute("form") UserRegistrationForm form, Model model) {
		return "UserRegistration";
	}

	/**
	 * Submits SignUp data
	 * 
	 * @param locale
	 * @param form
	 * @param bindingResult
	 * @param model
	 * @return
	 * @throws DuplicateRecordException
	 */
	@RequestMapping(value = "/SignUp", method = RequestMethod.POST)
	public String submit(Locale locale, @RequestParam String operation,
			@ModelAttribute("form") @Valid UserRegistrationForm form, BindingResult bindingResult, Model model) 
	{
		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:SignUp";
		}

		validator.validate(form, bindingResult);
		if (bindingResult.hasErrors()) {
			return "UserRegistration";
		}

		UserDTO dto = (UserDTO) form.getDto();

		// Default Role is Student
		dto.setRoleId((long) RoleDTO.STUDENT);
		/*dto.setRoleId((long) RoleDTO.ADMIN);*/
		try {
			long pk = service.registerUser(dto);
			form.setId(pk);
			String msg = messageSource.getMessage("registration.sucess.message", null, locale);
			model.addAttribute("success", msg);

		} catch (DuplicateRecordException e) {
			log.error(e);
			String msg = messageSource.getMessage("duplicate.message.user", null, locale);
			model.addAttribute("error", msg);
			return "UserRegistration";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "UserRegistration";	

	}
}