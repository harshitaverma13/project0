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

import in.co.rays.project0.DTO.SubjectDTO;
import in.co.rays.project0.Exception.ApplicationException;
import in.co.rays.project0.Exception.DuplicateRecordException;
import in.co.rays.project0.Service.SubjectServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)

@WebAppConfiguration

//@ContextConfiguration({ "file:src/main/webapp/WEB-INF/dispatcher-servlet.xml" })

@ContextConfiguration({ "file:D:/Pro_0/ORS_Proj_0/src/main/webapp/WEB-INF/dispacher-servlet.xml" })


public class SubjectServiceTest {

	@Autowired
	SubjectServiceInt model;
	
	
	//@Ignore
	@Test
	public void search(){
		SubjectDTO dto=new SubjectDTO();
		//dto.setId(1);
		//dto.setSubjectName("DBMS");
		//dto.setCourseName("BCA");
		dto.setCourseId(3L);
		int pageNo=1;
		int pageSize=10;

		List list=model.search(dto, pageNo, pageSize);
         

        Iterator<SubjectDTO> it=list.iterator();
	    while (it.hasNext()) {
		       dto=it.next();
		System.out.println(dto.getId());       
		System.out.println(dto.getCourseName());
		System.out.println(dto.getDescription());
		//System.out.println(dto.getSubjectName());
	}
	
	}
	
	
	@Ignore
	//@Test
	public void delete(){
		long id=1;
	//	model.delete(id);
		System.out.println("Success Deleted");
		
	}
	
	@Ignore
   //@Test
	public void update() throws ApplicationException{
		SubjectDTO dto=new SubjectDTO();
		dto.setId(1);
		//dto.setSubjectName("Science");
		dto.setCourseId(3L);
		dto.setCourseName("MCOM");
		dto.setDescription("it's computer");
		dto.setCreatedBy("root");
		dto.setModifiedBy("root");
		dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
		dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
		
		
		try {
			model.update(dto);
			System.out.println("Update Success");
		} catch (DuplicateRecordException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		System.out.println(e.getMessage());
		
		}
	}
//	@Ignore
//	@Test
	public void add() throws ApplicationException{
		SubjectDTO dto=new SubjectDTO();
		//dto.setSubjectName("Maths");
		dto.setCourseId(6L);
		dto.setCourseName("BSC");
		dto.setDescription("this is a BSC subject");
		dto.setCreatedBy("root");
		dto.setModifiedBy("root");
		dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
		dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
		
		
		try {
			model.add(dto);
			System.out.println("Success Add");
		} catch (DuplicateRecordException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		System.out.println(e.getMessage());
		
		}
	}
	
}

