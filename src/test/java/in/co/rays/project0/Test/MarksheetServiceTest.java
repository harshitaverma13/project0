package in.co.rays.project0.Test;

import java.sql.Timestamp
;
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

import in.co.rays.project0.DTO.MarksheetDTO;
import in.co.rays.project0.Exception.DuplicateRecordException;
import in.co.rays.project0.Service.MarksheetServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)

@WebAppConfiguration

//@ContextConfiguration({ "file:src/main/webapp/WEB-INF/dispatcher-servlet.xml" })

@ContextConfiguration({ "file:D:/Pro_0/ORS_Proj_0/src/main/webapp/WEB-INF/dispacher-servlet.xml" })


public class MarksheetServiceTest {

	@Autowired
	MarksheetServiceInt model;

//    @Test
	@Ignore
	public void getMeritsearch(){
		MarksheetDTO dto=new MarksheetDTO();
		//dto.setId(1);
		//dto.setRollNo("1");
		//dto.setStudentName("manish bundela");
		//dto.setStudentId(1);
		
		int pageNo=1;
		int pageSize=10;
		
		List list=model.getMeritList(pageNo, pageSize);
        //System.out.println(list.size());
	 Iterator<MarksheetDTO> it=list.iterator();
	 while (it.hasNext()) {
		       dto=it.next();
		System.out.println(dto.getId());       
		System.out.println(dto.getRollNo());
	}
	}
	
    
   @Ignore
	//@Test
	public void search(){
		MarksheetDTO dto=new MarksheetDTO();
		//dto.setId(1);
		//dto.setRollNo("1");
		//dto.setStudentName("manish bundela");
		dto.setStudentId(1L);
		
		int pageNo=1;
		int pageSize=10;
		
		List list=model.search(dto, pageNo, pageSize);
        //System.out.println(list.size());
	 Iterator<MarksheetDTO> it=list.iterator();
	 while (it.hasNext()) {
		       dto=it.next();
		System.out.println(dto.getId());       
		//System.out.println(dto.getRollNo());
	}
	}
	
	@Ignore
	public void delete(){
		long id=4;
		model.delete(id);
	}
	
	
	@Ignore
	//@Test
	public void update(){
	MarksheetDTO dto=new MarksheetDTO();
	dto.setId(1);
	dto.setStudentId(2L);
	dto.setName("Rahul");
	dto.setRollNo("0857Ex113D05");
	dto.setChemistry(25);
	dto.setPhysics(96);
	dto.setMaths(12);
    dto.setCreatedBy("root");
    dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
    dto.setModifiedBy("root");
    dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
	
	try {
		model.update(dto);
	} catch (DuplicateRecordException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println(e.getMessage());
	}
	}
	
	//@Ignore
	@Test
	public void add(){
	MarksheetDTO dto=new MarksheetDTO();
	
	dto.setStudentId(2L);
	dto.setRollNo("0857Ex113D03");
	dto.setName("Afroj");
	dto.setChemistry(95);
	dto.setPhysics(96);
	dto.setMaths(96);
    dto.setCreatedBy("root");
    dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
    dto.setModifiedBy("root");
    dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
	
	try {
		model.add(dto);
		System.out.println("Add Success");
	} catch (DuplicateRecordException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println(e.getMessage());
	}
	}
}

