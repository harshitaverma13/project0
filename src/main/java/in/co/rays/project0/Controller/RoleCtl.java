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

import in.co.rays.project0.DTO.RoleDTO;
import in.co.rays.project0.Exception.DuplicateRecordException;
import in.co.rays.project0.Form.RoleForm;
import in.co.rays.project0.Form.RoleValidator;
import in.co.rays.project0.Service.RoleServiceInt;


/**
 * Contains navigation logics for Role and Role List Usecases.
 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SunilOS
 */
@Controller
@RequestMapping(value = "/ctl/Role")
public class RoleCtl extends BaseCtl {
	 private static Logger log = Logger.getLogger(RoleCtl.class);

	    @Autowired
	    private RoleServiceInt service;

	    /**
	     * i18n Message source
	     */
	    @Autowired
	    private MessageSource messageSource;

	    @Autowired
	    private RoleValidator roleValidator;

	    /**
	     * Preload Role List
	     */
	    @Override
	    public void preload(Model model) {
	     
	       
	        model.addAttribute("roleList", service.search(null));
	        
	    }
	    
	    /**
	     * Displays Role view.
	     * 
	     * @param id
	     * @param form
	     * @param model
	     * @return
	     */
	    @RequestMapping(method = RequestMethod.GET)
	    public String display(@RequestParam(required = false) Long id,
	            @ModelAttribute("form") RoleForm form, Model model) {

	        log.debug("RoleCtl doDisplay() Start");

	        if (id != null && id > 0) {
	            form.populate(service.findById(id));
	        }
	        return "Role";
	    }

	    /**
	     * Submits Role data.
	     * 
	     * @param locale
	     * @param operation
	     * @param form
	     * @param bindingResult
	     * @param model
	     * @return
	     */
	    @RequestMapping(method = RequestMethod.POST)
	    public String submit(Locale locale,
	            @RequestParam(required = false) String operation,
	            @ModelAttribute("form") @Valid RoleForm form,
	            BindingResult bindingResult, Model model) {

	        log.debug("RoleCtl doSubmit() Start");
	        if(OP_RESET.equalsIgnoreCase(operation)){
	       	 return "redirect:Role";
	        }
	        if(OP_CANCEL.equalsIgnoreCase(operation)){
	       	 return "redirect:Role/search";
	        }
	        roleValidator.validate(form, bindingResult);
	        if (bindingResult.hasErrors()) {
	            return "Role";
	        }

	        try {
	            if (OP_SAVE.equalsIgnoreCase(operation)||OP_UPDATE.equalsIgnoreCase(operation)) {

	                RoleDTO dto = (RoleDTO) form.getDto();

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
	                return "redirect:Role/search";
	            }

	        } catch (DuplicateRecordException e) {
	        	log.error(e);
				String msg = messageSource.getMessage("duplicate.message.role", null, locale);
				model.addAttribute("error", msg);
			}catch (Exception e) {
				log.error(e);
				
			}

	        return "Role";
	    }

	    /**
	     * Displays Role List view.
	     * 
	     * @param form
	     * @param model
	     * @return
	     */
	    @RequestMapping(value = "/search", method = RequestMethod.GET)
	    public String searchList(Locale locale,@ModelAttribute("form") RoleForm form, Model model) {
	    	List list=service.search(null, form.getPageNo(), form.getPageSize());
	         if(list==null||list.size()==0){
	         	String msg = messageSource.getMessage("message.listNull", null, locale);
	         	model.addAttribute("error", msg);
	         }	
	         		model.addAttribute("list",list );
	        return "RoleList";
	    }

	    /**
	     * Submits Role List data.
	     * 
	     * @param locale
	     * @param form
	     * @param operation
	     * @param model
	     * @return
	     */
	    @RequestMapping(value = "/search", method = { RequestMethod.POST })
	    public String searchList(Locale locale,
	            @ModelAttribute("form") RoleForm form,
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
	        RoleDTO dto = (RoleDTO) form.getDto();

	        List list=service.search(dto, pageNo, form.getPageSize());
	        if(!OP_DELETE.equalsIgnoreCase(operation)){
	        if(list==null||list.size()==0){
	        	String msg = messageSource.getMessage("message.listNull", null, locale);
	        	model.addAttribute("error", msg);
	        }}
	        		
	        		model.addAttribute("list",list );
	        return "RoleList";
	    }
}
