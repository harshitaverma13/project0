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

import in.co.rays.project0.DTO.MarksheetDTO;
import in.co.rays.project0.DTO.StudentDTO;
import in.co.rays.project0.Exception.DuplicateRecordException;
import in.co.rays.project0.Form.MarksheetForm;
import in.co.rays.project0.Form.MarksheetValidator;
import in.co.rays.project0.Service.MarksheetServiceInt;
import in.co.rays.project0.Service.StudentServiceInt;


/**
 * Contains navigation logics for Marksheet, Marksheet List, Merit List, and
 * GetMarksheet Usecases.
 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SunilOS
 */
@Controller
@RequestMapping(value = "/ctl/Marksheet")

public class MarksheetCtl extends BaseCtl{
	/**
     * Logger object
     */
    private static Logger log = Logger.getLogger(MarksheetCtl.class);

    @Autowired
    MarksheetServiceInt service;

    @Autowired
    StudentServiceInt studentService;

    /**
     * i18n Message source
     */
    @Autowired
    private MessageSource messageSource;

    @Autowired
    private MarksheetValidator marksheetValidator;

    /**
     * Preload Student List
     */
    @Override
    public void preload(Model model) {
        model.addAttribute("studentList", studentService.search(null));
        model.addAttribute("marksheetList", service.search(null));
      
    }

    /**
     * Displays Marksheet view.
     * 
     * @param id
     * @param form
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String display(@RequestParam(required = false) Long id,
            @ModelAttribute("form") MarksheetForm form, Model model) {
        if (id != null && id > 0) {
            form.populate(service.findByPK(id));
        }
        return "Marksheet";
    }

    /**
     * Submits Marksheet data.
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
            @ModelAttribute("form") @Valid MarksheetForm form,
            BindingResult bindingResult, Model model) {
    	 if(OP_RESET.equalsIgnoreCase(operation)){
        	 return "redirect:Marksheet";
         }
    	 if(OP_CANCEL.equalsIgnoreCase(operation)){
        	 return "redirect:Marksheet/search";
         }
    	 marksheetValidator.validate(form, bindingResult);
           
        if (bindingResult.hasErrors()) {
            return "Marksheet";
        }

        try {
            if (OP_SAVE.equalsIgnoreCase(operation)||OP_UPDATE.equalsIgnoreCase(operation)) {

                MarksheetDTO dto = (MarksheetDTO) form.getDto();
                StudentDTO sdto = studentService.findByPK(form.getStudentId());
                dto.setName(sdto.getValue());

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

                service.delete(form.getId());

                String msg = messageSource.getMessage("message.success", null,
                        locale);
                model.addAttribute("success", msg);

                return "redirect:Marksheet/search";

            }

        } catch (DuplicateRecordException e) {
        	log.error(e);
			String msg = messageSource.getMessage("duplicate.message.marksheet", null, locale);
			model.addAttribute("error", msg);
		}catch (Exception e) {
			log.error(e);
			
		}
        return "Marksheet";
    }

    /**
     * Displays Marksheet List View.
     * 
     * @param form
     * @param model
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchList(Locale locale,@ModelAttribute("form") MarksheetForm form,
            Model model) {
    	List list=service.search(null, form.getPageNo(), form.getPageSize());
        if(list==null||list.size()==0){
        	String msg = messageSource.getMessage("message.listNull", null, locale);
        	model.addAttribute("error", msg);
        }	
        		model.addAttribute("list",list );
        return "MarksheetList";
    }

    /**
     * Submits Marskheet List data.
     * 
     * @param locale
     * @param form
     * @param operation
     * @param model
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchList(Locale locale,
            @ModelAttribute("form") MarksheetForm form,
            @RequestParam(required = false) String operation, Model model) {

        log.debug("in searchList method");

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
            	
				service.delete(id);
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
        MarksheetDTO dto = (MarksheetDTO) form.getDto();
        List list=service.search(dto, pageNo, form.getPageSize());
        if(!OP_DELETE.equalsIgnoreCase(operation)){
        if(list==null||list.size()==0){
        	String msg = messageSource.getMessage("message.listNull", null, locale);
        	model.addAttribute("error", msg);
        }}
        		
        		model.addAttribute("list",list );
        return "MarksheetList";
    }

    /**
     * Displays Meritlist view.
     * 
     * @param form
     * @param model
     * @return
     */
    @RequestMapping(value = "/meritlist", method = RequestMethod.GET)
    public String getMeritList(@ModelAttribute("form") MarksheetForm form,
            Model model) {
        List meritList = service.getMeritList(0, 10);
        model.addAttribute("list", meritList);
        return "GetMeritList";
    }

    /**
     * Gets Marksheet.
     * 
     * @param form
     * @param model
     * @return
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getMarksheet(@ModelAttribute("form") MarksheetForm form,
            Model model) {
        MarksheetDTO dto = service.findByRollNo(form.getRollNo());
        if (dto != null) {
            form.populate(dto);
        } else {
            
        }
        return "GetMarksheet";
    }
    /**
     * Gets Marksheet.
     * 
     * @param form
     * @param model
     * @return
     */
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public String getSubmitMarksheet(Locale locale, @ModelAttribute("form") @Valid MarksheetForm form,BindingResult bindingResult,
            Model model) {
    	if(!(form.getRollNo().isEmpty())){
    		MarksheetDTO dto = service.findByRollNo(form.getRollNo());
    		if (dto != null) {
                form.populate(dto);
                
                
            } else {
            	String msg = messageSource.getMessage("recordNotfound.message.marksheet", null, locale);
    			model.addAttribute("error", msg);
    		}
        }
        return "GetMarksheet";
    }

}
