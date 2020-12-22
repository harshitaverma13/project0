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

import in.co.rays.project0.DTO.TimeTableDTO;
import in.co.rays.project0.Exception.ApplicationException;
import in.co.rays.project0.Exception.DuplicateRecordException;
import in.co.rays.project0.Service.TimeTableServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)

@WebAppConfiguration

//@ContextConfiguration({ "file:src/main/webapp/WEB-INF/dispatcher-servlet.xml" })

@ContextConfiguration({"file:D:/Pro_0/ORS_Proj_0/src/main/webapp/WEB-INF/dispacher-servlet.xml" })


public class TimeTableServiceTest {

	@Autowired
	TimeTableServiceInt model;
	
	
@Ignore
	public void add() throws ApplicationException{
	TimeTableDTO dto=new TimeTableDTO();	
	//dto.setCourseId(2);
	//dto.setSubjectId(2);
	Date d=new Date();
	d.getDate();
	dto.setSemester("1st");
	dto.setExamDate(d);
	dto.setExamTime("7am to 9am");
	dto.setCreatedBy("root");
	dto.setModifiedBy("root");
	dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
	dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
	
	try {
		model.add(dto);
	} catch (DuplicateRecordException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
	System.out.println(e.getMessage());
	}	
		
	}
@Ignore
public void update() throws ApplicationException{
	TimeTableDTO dto=new TimeTableDTO();
	dto.setId(2L);
	//dto.setCourseId(2);
	//dto.setSubjectId(2);
	Date d=new Date();
	d.getDate();
	dto.setSemester("5st");
	dto.setExamDate(d);
	dto.setExamTime("8am to 9am");
	dto.setCreatedBy("root");
	dto.setModifiedBy("root");
	dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
	dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
	
	try {
		model.update(dto);
	} catch (DuplicateRecordException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
	System.out.println(e.getMessage());
	}	
		
	}
@Ignore
public void delete()
{ 
	//model.delete(4L);
	}
@Test
public void Search(){
 TimeTableDTO dto= new 	TimeTableDTO();
	
	dto.setId(2L);
	int pageNo=1;
	int pageSize=10;
	List list=model.search(dto, pageNo, pageSize);
	Iterator< TimeTableDTO> it=list.iterator();
	while(it.hasNext()){
		TimeTableDTO dto1=it.next();
	System.out.println(dto1.getCourseId());
	}
}


}

