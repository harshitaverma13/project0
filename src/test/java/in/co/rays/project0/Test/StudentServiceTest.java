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

import in.co.rays.project0.DTO.StudentDTO;
import in.co.rays.project0.Exception.DuplicateRecordException;
import in.co.rays.project0.Service.StudentServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)

@WebAppConfiguration

//@ContextConfiguration({ "file:src/main/webapp/WEB-INF/dispatcher-servlet.xml" })

@ContextConfiguration({ "file:D:/Pro_0/ORS_Proj_0/src/main/webapp/WEB-INF/dispacher-servlet.xml" })



public class StudentServiceTest {
	

	@Autowired
	StudentServiceInt model;
	
	
	@Ignore
//	@Test
	public void Search(){
		StudentDTO dto=new StudentDTO();	
		//dto.setId(4);
		//dto.setCollegeId(2);
		dto.setEmail("afroj@gmail.com");
		int pageNo=1;
		int pageSize=10;
		List list=model.search(dto, pageNo, pageSize);
		Iterator< StudentDTO > it=list.iterator();
		while(it.hasNext()){
			StudentDTO dto1=it.next();
		System.out.println(dto1.getCollegeName());
		}
	}
	
//	@Ignore
	@Test
	public void delete(){
	long id=3;
		model.delete(id);
		System.out.println("Deleted");
	}
	
	@Ignore
	//@Test
	public void update() throws DuplicateRecordException{
		StudentDTO dto=new StudentDTO();	
		dto.setId(3);
		dto.setCollegeId(2L);
		dto.setEmail("chinu12@gmail.com");
		dto.setDob(new Timestamp(new Date().getTime()));
		dto.setMobileNo("1234567891");
		dto.setFirstName("Dinesh");
		dto.setLastName("batham");
		dto.setCreatedBy("root");
		dto.setModifiedBy("root");
		dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
		dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
		model.update(dto);
		System.out.println("Update Success");
			
	}
	
	@Ignore
	//@Test
	public void add() throws DuplicateRecordException{
	StudentDTO dto=new StudentDTO();	
	dto.setCollegeId(1L);
	dto.setCollegeName("LNCT");
	dto.setEmail("lnct@gmail.com");
	dto.setDob(new Timestamp(new Date().getTime()));
	dto.setMobileNo("1234567891");
	dto.setFirstName("Sonali");
	dto.setLastName("patidar");
	dto.setCreatedBy("root");
	dto.setModifiedBy("root");
	dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
	dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
	model.add(dto);
	System.out.println("Success Add");
	
	
	}
	

}
