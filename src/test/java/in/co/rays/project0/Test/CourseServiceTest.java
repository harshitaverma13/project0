package in.co.rays.project0.Test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import in.co.rays.project0.DTO.CourseDTO;
import in.co.rays.project0.Exception.DuplicateRecordException;
import in.co.rays.project0.Service.CourseServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)

@WebAppConfiguration

//@ContextConfiguration({ "file:src/main/webapp/WEB-INF/dispatcher-servlet.xml" })

@ContextConfiguration({ "file:D:/Pro_0/ORS_Proj_0/src/main/webapp/WEB-INF/dispacher-servlet.xml" })


public class CourseServiceTest {

	@Autowired
	CourseServiceInt model;
	
	@Ignore
   //@Test	
public void search(){
		CourseDTO dto=new CourseDTO();
		//dto.setId(1);
		//dto.setCourseName("BBA");
	    //dto.setCourseDuration("3 year");
	    dto.setDescription("eng");
		int pageNo=1;
		int pageSize=10;
		
		List list=model.search(dto, pageNo, pageSize);
       // System.out.println(list.size());
	 
        Iterator<CourseDTO> it=list.iterator();
	    while (it.hasNext()) {
		       dto=it.next();
		System.out.println(dto.getId());       
	//	System.out.println(dto.get);
	}
	}
	
	@Ignore
// @Test
	public void update(){
		CourseDTO dto=new CourseDTO();
		try {
			dto.setId(1);
			dto.setName("BBA");
		    dto.setDuration("3 year");
		    dto.setDescription("eng");
			dto.setCreatedBy("root");
			dto.setModifiedBy("root");
			dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
			dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
			model.update(dto);
		
		} catch (DuplicateRecordException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Ignore
	//@Test
	public void findByPk(){
		long id=1;
		CourseDTO dto=new CourseDTO();
		dto=model.findByPK(id);
		System.out.println(dto.getName());
	}
	@Ignore
	//@Test
	public void findByName(){
		String roleName="BBA";
		System.out.println("In Findbyname");
		CourseDTO dto=new CourseDTO();
		dto=model.findByName(roleName);
	System.out.println(dto.getId());
	System.out.println("Name = " +dto.getName());
	System.out.println("Successs");
	}
	
	//@Ignore
	@Test
	public void Delete(){
		long id=2;
		//model.delete(id);
		System.out.println("Deleted");
		
	}
	
	
	@Ignore
	//@Test
	public void add()
	{  
		CourseDTO dto=new CourseDTO();
	
	dto.setName("MA");
    dto.setDuration("2 year");
    dto.setDescription("History");
    dto.setCreatedBy("root");
    dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
    dto.setModifiedBy("root");
    dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
    
    long pk;
	try {
		pk = model.add(dto);
	    System.out.println(pk + "Successs addd");

	} catch (DuplicateRecordException e) {
		System.out.println(e.getMessage());
		//e.printStackTrace();
	}
}

}