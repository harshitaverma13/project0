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

import in.co.rays.project0.DTO.TimeTableDTO;
import in.co.rays.project0.Exception.DuplicateRecordException;
import in.co.rays.project0.Form.TimeTableForm;
import in.co.rays.project0.Service.CourseServiceInt;
import in.co.rays.project0.Service.SubjectServiceInt;
import in.co.rays.project0.Service.TimeTableServiceInt;


/**
 * Contains navigation logics for TimeTable and TimeTable List usecases.

 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SunilOS
 */
@Controller
@RequestMapping(value = "/ctl/TimeTable")
public class TimeTableCtl extends BaseCtl{
	/**
	 * Logger object
	 */
	private static Logger log = Logger.getLogger(TimeTableCtl.class);
	@Autowired
	TimeTableServiceInt service;
	@Autowired
	CourseServiceInt courseservice;
	@Autowired
	SubjectServiceInt subjectService;

	

	/**
	 * i18n Message source
	 */
	@Autowired
	private MessageSource messageSource;

	
	/**
     * Preload College,Student,Course List
     */
    @Override
    public void preload(Model model) {
     
        model.addAttribute("courseList",courseservice.search(null));
        model.addAttribute("subjectList",subjectService.search(null));
        model.addAttribute("timetableList", service.search(null));
        
    }
    /**
     * Displays TimeTable View.
     * 
     * @param id
     * @param form
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String display(@RequestParam(required = false) Long id,
            @ModelAttribute("form") TimeTableForm form, Model model) {
        if (id != null && id > 0) {
            form.populate(service.findByPK(id));
        }
        return "TimeTable";
    }
    /**
     * Submits TimeTable data.
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
    public String submit(Locale locale, @RequestParam String operation,
            @ModelAttribute("form") @Valid TimeTableForm form,
            BindingResult bindingResult, Model model, HttpSession session) {

        log.debug("operation " + form.getOperation());
        if(OP_RESET.equalsIgnoreCase(operation)){
       	 return "redirect:TimeTable";
        }
        if(OP_CANCEL.equalsIgnoreCase(operation)){
       	 return "redirect:TimeTable/search";
        }
          
        if (bindingResult.hasErrors()) {
            return "TimeTable";
        }

        try {
            if (OP_SAVE.equalsIgnoreCase(operation)||OP_UPDATE.equalsIgnoreCase(operation)) {

                TimeTableDTO dto = (TimeTableDTO) form.getDto();
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
            	TimeTableDTO dto=new TimeTableDTO();
            	dto.setId(form.getId());
                service.delete(dto);

                String msg = messageSource.getMessage("message.success", null,
                        locale);
                model.addAttribute("success", msg);

                return "redirect:TimeTable/search";
            }

        }catch (DuplicateRecordException e) {
        	log.error(e);
			String msg = messageSource.getMessage("duplicate.message.timetable", null, locale);
			model.addAttribute("error", msg);
		}catch (Exception e) {
			log.error(e);
			
		}

        return "TimeTable";
    }

    /**
     * Displays TimeTable List view.
     * 
     * @param form
     * @param model
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchList(Locale locale,@ModelAttribute("form") TimeTableForm form,
            Model model) {
    	List list=service.search(null, form.getPageNo(), form.getPageSize());
        if(list==null||list.size()==0){
        	String msg = messageSource.getMessage("message.listNull", null, locale);
        	model.addAttribute("error", msg);
        }	
        		model.addAttribute("list",list );
        return "TimeTableList";
    }

    /**
     * Submits TimeTable List data.
     * 
     * @param locale
     * @param form
     * @param operation
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchList(Locale locale,
            @ModelAttribute("form") TimeTableForm form,
            @RequestParam(required = false) String operation, Model model)
            throws Exception {

        log.debug("in searchList method");
TimeTableDTO dto=new TimeTableDTO();
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
        dto = (TimeTableDTO) form.getDto();
        

        List list=service.search(dto, pageNo, form.getPageSize());
        if(!OP_DELETE.equalsIgnoreCase(operation)){
        if(list==null||list.size()==0){
        	String msg = messageSource.getMessage("message.listNull", null, locale);
        	model.addAttribute("error", msg);
        }}
        		
        model.addAttribute("list",list );
        return "TimeTableList";
    }


}
