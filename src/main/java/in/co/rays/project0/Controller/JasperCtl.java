package in.co.rays.project0.Controller;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 * Jasper functionality Controller .Performs operation for Jasper Report
 * 
 * @author FrontController
 * @version 1.0
 * @Copyrigh (c) SunilOS
 */
@Controller
@RequestMapping("/ctl/JasperCtl")
public class JasperCtl {
	
	
	 @Autowired
	    private SessionFactory sessionFactory = null;

	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
	
	
	/**
	 * Jasper functionality Controller display contant
	 */

	    @RequestMapping(method = RequestMethod.GET)
		@Transactional(readOnly = true)
	    public void display(ModelMap map, HttpServletRequest request, HttpServletResponse response) {
			
		try {
				Connection con = null;
				/*JasperReport jasperReport = JasperCompileManager.compileReport("C:/Users/HP/JaspersoftWorkspace/MyReports/dinu.jrxml");*/
			JasperReport jasperReport = JasperCompileManager.compileReport("C:/Users/BosS/Downloads/Cherry12.jrxml");
				
				
				Map<String, Object> map2 = new HashMap<String, Object>();
				con = ((SessionImpl) sessionFactory.getCurrentSession()).connection();
				
				JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map2, con);
				byte[] pdf = JasperExportManager.exportReportToPdf(jasperPrint);

				response.setContentType("application/pdf");
				response.getOutputStream().write(pdf);
				response.getOutputStream().flush();

			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
}
