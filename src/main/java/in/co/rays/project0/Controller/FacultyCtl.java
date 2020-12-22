package in.co.rays.project0.Controller;

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

import in.co.rays.project0.DTO.FacultyDTO;
import in.co.rays.project0.Exception.DuplicateRecordException;
import in.co.rays.project0.Form.FacultyForm;
import in.co.rays.project0.Form.FacultyValidator;
import in.co.rays.project0.Service.CollegeServiceInt;
import in.co.rays.project0.Service.CourseServiceInt;
import in.co.rays.project0.Service.FacultyServiceInt;
import in.co.rays.project0.Service.SubjectServiceInt;

/**
 * Contains navigation logics for Course and Course List usecases.
 * 
 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SunilOS
 */
@Controller
@RequestMapping(value = "/ctl/Faculty")
public class FacultyCtl extends BaseCtl {
	/**
	 * Logger object
	 */
	private static Logger log = Logger.getLogger(FacultyCtl.class);
	@Autowired
	FacultyServiceInt service;
	@Autowired
	CourseServiceInt courseservice;
	@Autowired
	SubjectServiceInt subjecService;
	@Autowired
	CollegeServiceInt collegeService;

	/**
	 * i18n Message source
	 */
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private FacultyValidator validator;

	/**
	 * Preload College,Student,Course List
	 */
	@Override
	public void preload(Model model) {
		model.addAttribute("collegeList", collegeService.search(null));
		model.addAttribute("courseList", courseservice.search(null));
		model.addAttribute("subjectList", subjecService.search(null));

		model.addAttribute("facultyList", service.search(null));

	}

	/**
	 * Displays Faculty View.
	 * 
	 * @param id
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String display(@RequestParam(required = false) Long id, @ModelAttribute("form") FacultyForm form,
			Model model) {
		if (id != null && id > 0) {
			form.populate(service.findByPK(id));
		}
		return "Faculty";
	}

	/**
	 * Submits Faculty data.
	 * 
	 * @param locale
	 * @param operation
	 * @param form
	 * @param bindingResult
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String submit(Locale locale, @RequestParam String operation, @ModelAttribute("form") @Valid FacultyForm form,
			BindingResult bindingResult, Model model, HttpSession session) {

		log.debug("operation " + form.getOperation());
		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:Faculty";
		}
		if (OP_CANCEL.equalsIgnoreCase(operation)) {
			return "redirect:Faculty/search";
		}
		validator.validate(form, bindingResult);
		if (bindingResult.hasErrors()) {
			return "Faculty";
		}

		try {
			if (OP_SAVE.equalsIgnoreCase(operation) || OP_UPDATE.equalsIgnoreCase(operation)) {

				FacultyDTO dto = (FacultyDTO) form.getDto();

				if (dto.getId() > 0) {
					service.update(dto);
					String msg = messageSource.getMessage("message.success.update", null, locale);
					model.addAttribute("success", msg);
				} else {
					Long id = service.add(dto);

					String msg = messageSource.getMessage("message.success.add", null, locale);
					model.addAttribute("success", msg);
				}
			} else if (OP_DELETE.equalsIgnoreCase(operation)) {
				FacultyDTO dto = new FacultyDTO();
				dto.setId(form.getId());
				service.delete(dto);

				String msg = messageSource.getMessage("message.success", null, locale);
				model.addAttribute("success", msg);

				return "redirect:Faculty/search";
			}

		} catch (DuplicateRecordException e) {
			log.error(e);
			String msg = messageSource.getMessage("duplicate.message.faculty", null, locale);
			model.addAttribute("error", msg);
		} catch (Exception e) {
			log.error(e);

		}
		return "Faculty";
	}

	/**
	 * Displays Faculty List view.
	 * 
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchList(Locale locale, @ModelAttribute("form") FacultyForm form, Model model) {
		List list = service.search(null, form.getPageNo(), form.getPageSize());
		if (list == null || list.size() == 0) {
			String msg = messageSource.getMessage("message.listNull", null, locale);
			model.addAttribute("error", msg);
		}
		model.addAttribute("list", list);
		return "FacultyList";
	}

	/**
	 * Submits Faculty List data.
	 * 
	 * @param locale
	 * @param form
	 * @param operation
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchList(Locale locale, @ModelAttribute("form") FacultyForm form,
			@RequestParam(required = false) String operation, Model model) throws Exception {

		log.debug("in searchList method");
		FacultyDTO dto = new FacultyDTO();
		// Calculate next page number
		int pageNo = form.getPageNo();
		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:search";
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
					dto.setId(id);
					service.delete(dto);
				}

				String msg = messageSource.getMessage("message.success.delete", null, locale);
				model.addAttribute("success", msg);
			} else {
				String msg = messageSource.getMessage("message.list.delete", null, locale);
				model.addAttribute("error", msg);
			}
		}

		// Get search attributes
		dto = (FacultyDTO) form.getDto();

		List list = service.search(dto, pageNo, form.getPageSize());
		if (!OP_DELETE.equalsIgnoreCase(operation)) {
			if (list == null || list.size() == 0) {
				String msg = messageSource.getMessage("message.listNull", null, locale);
				model.addAttribute("error", msg);
			}
		}
		model.addAttribute("list", list);
		return "FacultyList";
	}

}
