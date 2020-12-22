package in.co.rays.project0.Controller;

import java.util.List;
import java.util.Locale;

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

import in.co.rays.project0.DTO.CourseDTO;
import in.co.rays.project0.Exception.DuplicateRecordException;
import in.co.rays.project0.Form.CourseForm;
import in.co.rays.project0.Form.CourseValidator;
import in.co.rays.project0.Service.CourseServiceInt;


/**
 * Contains navigation logics for Course and Course List usecases.

 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SunilOS
 */
@Controller
@RequestMapping(value = "/ctl/Course")
public class CourseCtl extends BaseCtl {
	/**
	 * Logger object
	 */
	private static Logger log = Logger.getLogger(CollegeCtl.class);

	/**
	 * College Service
	 */
	@Autowired
	private CourseServiceInt service;

	/**
	 * i18n Message source
	 */
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private CourseValidator courseValidator;
	/**
     * Preload ,Course List
     */
    @Override
    public void preload(Model model) {
      model.addAttribute("courseList", service.search(null));
        
    }
	/**
	 * Display Add/Edit Course View
	 * 
	 * @param id
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String display(Locale locale, @RequestParam(required = false) Long id,
			@ModelAttribute("form") CourseForm form, Model model) {
		log.debug("In CollegeCtl display start " + id);

		if (id != null && id > 0) {
			CourseDTO dto = service.findByPK(id);
			form.populate(dto);
		}
		return "Course";

	}

	/**
	 * Contains submit logic of Add/Edit College View
	 * 
	 * @param operation
	 * @param form
	 * @param bindingResult
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String submit(Locale locale, @RequestParam String operation, @ModelAttribute("form") @Valid CourseForm form,
			BindingResult bindingResult, Model model) {
		log.debug("operation " + form.getOperation());
		 if(OP_RESET.equalsIgnoreCase(operation)){
	    	 return "redirect:Course";
	     }
		 if(OP_CANCEL.equalsIgnoreCase(operation)){
	    	 return "redirect:Course/search";
	     }
		 courseValidator.validate(form, bindingResult);
	       
		if (bindingResult.hasErrors()) {
			return "Course";
		}
		CourseDTO dto = (CourseDTO) form.getDto();
		try {
			if (OP_SAVE.equalsIgnoreCase(operation) || OP_UPDATE.equalsIgnoreCase(operation)) {
				
				if (dto.getId() > 0) {
					service.update(dto);
					String msg = messageSource.getMessage("message.success.update", null, locale);
					model.addAttribute("success", msg);
				} else {
				Long id=service.add(dto);
				
					String msg = messageSource.getMessage("message.success.add", null, locale);
					model.addAttribute("success", msg);
				}
			} else if (OP_DELETE.equalsIgnoreCase(operation)) {
				dto.setId(form.getId());
				service.delete(dto);

				String msg = messageSource.getMessage("message.success", null, locale);
				model.addAttribute("success", msg);

				return "redirect:College/search";
			}
		} catch (DuplicateRecordException e) {
			log.error(e);
			String msg = messageSource.getMessage("duplicate.message.course", null, locale);
			model.addAttribute("error", msg);
		}catch (Exception e) {
			log.error(e);
			
		}
		return "Course";

	}

	/**
	 * Displays College List View
	 * 
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/search", method = { RequestMethod.GET })
	public String searchList(Locale locale,@ModelAttribute("form") CourseForm form, Model model) {
		List list=service.search(null, form.getPageNo(), form.getPageSize());
        if(list==null||list.size()==0){
        	String msg = messageSource.getMessage("message.listNull", null, locale);
        	model.addAttribute("error", msg);
        }	
        		model.addAttribute("list",list );
		return "CourseList";
	}

	/**
	 * Contains submit logics of College List View
	 * 
	 * @param form
	 * @param operationa
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/search", method = { RequestMethod.POST })
	public String searchList(Locale locale, @ModelAttribute("form") CourseForm form,
			@RequestParam(required = false) String operation, Model model) {
		log.debug("in collegectl searchList method");

		// Calculate next page number
		int pageNo = form.getPageNo();
		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:search";
		}
		CourseDTO dto =new CourseDTO();
		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;

		form.setPageNo(pageNo);
		 if (OP_DELETE.equals(operation)) {
			 pageNo = 1;
	        	if(form.getIds() != null){
	        	
	            for (long id : form.getIds()) {
	            	dto.setId(id);
					service.delete(dto);
	            }

	            String msg = messageSource.getMessage("message.success.delete", null,
	                   locale);
	            model.addAttribute("success", msg);
	        	}else{
	            	String msg = messageSource.getMessage("message.list.delete", null,
	                        locale);
	            	model.addAttribute("error",msg);
	            }
	        }

		// Get search attributes
		dto = (CourseDTO) form.getDto();

		List list=service.search(dto, pageNo, form.getPageSize());
		if(!OP_DELETE.equalsIgnoreCase(operation)){
		if(list==null||list.size()==0){
			String msg = messageSource.getMessage("message.listNull", null, locale);
			model.addAttribute("error", msg);
		}}
				
				model.addAttribute("list",list );
		return "CourseList";
	}

}
