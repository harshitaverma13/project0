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
import in.co.rays.project0.DTO.SubjectDTO;
import in.co.rays.project0.Exception.DuplicateRecordException;
import in.co.rays.project0.Form.SubjectForm;
import in.co.rays.project0.Form.SubjectValidator;
import in.co.rays.project0.Service.CourseServiceInt;
import in.co.rays.project0.Service.SubjectServiceInt;

/**
 * Contains navigation logics for Subject, Subject List Usecases.
 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SunilOS
 */
@Controller
@RequestMapping(value = "/ctl/Subject")
public class SubjectCtl extends BaseCtl {
	/**
	 * Logger object
	 */
	private static Logger log = Logger.getLogger(CollegeCtl.class);

	@Autowired
	SubjectServiceInt service;

	@Autowired
	CourseServiceInt courseService;

	/**
	 * i18n Message source
	 */
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private SubjectValidator subjectValidator;

	/**
	 * Preload course List
	 */

	@Override
	public void preload(Model model) {
		model.addAttribute("courseList", courseService.search(null));
		model.addAttribute("subjectList", service.search(null));
	}

	/**
	 * Displays Subject view.
	 * 
	 * @param id
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String display(@RequestParam(required = false) Long id, @ModelAttribute("form") SubjectForm form,
			Model model) {
		if (id != null && id > 0) {
			form.populate(service.findByPK(id));
		}
		return "Subject";
	}

	/**
	 * Submits Subject data.
	 * 
	 * @param locale
	 * @param operation
	 * @param form
	 * @param bindingResult
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String submit(Locale locale, @RequestParam String operation,
			@ModelAttribute("form") @Valid SubjectForm form, BindingResult bindingResult, Model model) {
		 if(OP_RESET.equalsIgnoreCase(operation)){
	    	 return "redirect:Subject";
	     }
		 if(OP_CANCEL.equalsIgnoreCase(operation)){
	    	 return "redirect:Subject/search";
	     }
	      subjectValidator.validate(form, bindingResult); 
		if (bindingResult.hasErrors()) {
			return "Subject";
		}

		try {
			if (OP_SAVE.equalsIgnoreCase(operation)||OP_UPDATE.equalsIgnoreCase(operation)) {

				SubjectDTO dto = (SubjectDTO) form.getDto();
				
				CourseDTO cdto = courseService.findByPK(form.getCourseId());
				dto.setCourseName(cdto.getValue());

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
				SubjectDTO dto = new SubjectDTO();
				dto.setId(form.getId());
				service.delete(dto);

				String msg = messageSource.getMessage("message.success", null, locale);
				model.addAttribute("success", msg);

				return "redirect:Subject/search";

			}

		} catch (DuplicateRecordException e) {
			log.error(e);
			String msg = messageSource.getMessage("duplicate.message.subject", null, locale);
			model.addAttribute("error", msg);
		}catch (Exception e) {
			log.error(e);
			
		}

		return "Subject";
	}
	 /**
     * Displays Subject List View.
     * 
     * @param form
     * @param model
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchList(Locale locale,@ModelAttribute("form") SubjectForm form,
            Model model) {
    	List list=service.search(null, form.getPageNo(), form.getPageSize());
        if(list==null||list.size()==0){
        	String msg = messageSource.getMessage("message.listNull", null, locale);
        	model.addAttribute("error", msg);
        }	
        		model.addAttribute("list",list );
        return "SubjectList";
    }
    /**
     * Submits Subject List data.
     * 
     * @param locale
     * @param form
     * @param operation
     * @param model
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchList(Locale locale,
            @ModelAttribute("form") SubjectForm form,
            @RequestParam(required = false) String operation, Model model) {

        log.debug("in searchList method");
        SubjectDTO dto=null;
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
        	if(form.getIds() != null){
        	
            for (long id : form.getIds()) {
            	SubjectDTO deleteDto=new SubjectDTO();
            	deleteDto.setId(id);
				service.delete(deleteDto);
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
         dto = (SubjectDTO) form.getDto();
         List list=service.search(dto, pageNo, form.getPageSize());
         if(!OP_DELETE.equalsIgnoreCase(operation)){
         if(list==null||list.size()==0){
         	String msg = messageSource.getMessage("message.listNull", null, locale);
         	model.addAttribute("error", msg);
         }}
         		
         		model.addAttribute("list",list );
         		return "SubjectList";
    }
}
