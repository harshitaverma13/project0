package in.co.rays.project0.Test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import in.co.rays.project0.DTO.FacultyDTO;
import in.co.rays.project0.DTO.UserDTO;
import in.co.rays.project0.Exception.DuplicateRecordException;
import in.co.rays.project0.Service.FacultyServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)

@WebAppConfiguration

//@ContextConfiguration({ "file:src/main/webapp/WEB-INF/dispatcher-servlet.xml" })

@ContextConfiguration({ "file:D:/Pro_0/ORS_Proj_0/src/main/webapp/WEB-INF/dispacher-servlet.xml" })

public class FacultyServiceTest {

	@Autowired
	FacultyServiceInt model;
	
	@Ignore
//	@Test
	public void update(){
		FacultyDTO dto=new FacultyDTO();
		try {
			dto.setId(1);
//			dto.setCollegeId(1);
	//		dto.setCourseId(2);
			dto.setCollegeName("SVCE");
		//	dto.setSubjectId(3);
			//dto.setSubjectName("Power system");
			dto.setEmailId("afrojkhan121@.com");
			dto.setFirstName("Afroj");
			dto.setLastName("khan");
			//dto.setPassword("123456");
			dto.setGender("Male");
			dto.setDob(new Timestamp(new Date().getTime()));
			dto.setQualification("ME");
			dto.setMobileNo("1234567891");
			dto.setCreatedBy("root");
		    dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
		    dto.setModifiedBy("root");
		    dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
			model.update(dto);
			System.out.println("Updated");
		
		} catch (DuplicateRecordException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		System.out.println(e.getMessage());
		
		}
	}
	
	
	
	//@Ignore
	/*@Test
	public void add(){
		FacultyDTO dto=new FacultyDTO();
		try {
			dto.setCollegeId(1);
			dto.setCourseId(2);
			dto.setSubjectId(5);
			dto.setCollegeName("MCA");
			dto.setSubjectName("Computer");
			dto.setEmailId("afrojkhan121@gmail.com");
			dto.setFirstName("Afroj");
			dto.setLastName("khan");
			dto.setPassword("2658");
			dto.setGender("Female");
			dto.setDob(new Timestamp(new Date().getTime()));
			dto.setQualification("BCOM");
			dto.setMobileNo("9896565891");			
			dto.setCreatedBy("root");
		    dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
		    dto.setModifiedBy("root");
		    dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
			model.add(dto);
			System.out.println("Success Add");
		} catch (DuplicateRecordException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		System.out.println(e.getMessage());
		
		}
	}
	*/
	
	@Ignore
	//@Test
	public void Search(){
		FacultyDTO dto=new FacultyDTO();	
		//dto.setId(4);
		//dto.setCollegeId(2);
		dto.setEmailId("julie@gmail.com");
		int pageNo=1;
		int pageSize=10;
		
		List list=model.search(dto, pageNo, pageSize);
		Iterator<FacultyDTO> it=list.iterator();
		while(it.hasNext()){
			FacultyDTO  dto1=it.next();
			
		System.out.println(dto1.getCollegeName());
		System.out.println(dto1.getFirstName());
		System.out.println(dto1.getLastName());
		}
	}
	@Ignore
	//@Test
	public void delete(){

		UserDTO dto = new UserDTO();		
	//	model.delete(2L);
		System.out.println("******Deleted successfully****");
	}
	

}


