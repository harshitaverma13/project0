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

import in.co.rays.project0.DTO.CollegeDTO;
import in.co.rays.project0.Exception.DuplicateRecordException;
import in.co.rays.project0.Service.CollegeServiceInt;


@RunWith(SpringJUnit4ClassRunner.class)

@WebAppConfiguration

//@ContextConfiguration({ "file:src/main/webapp/WEB-INF/dispatcher-servlet.xml" })

@ContextConfiguration({ "file:D:/Pro_0/ORS_Proj_0/src/main/webapp/WEB-INF/dispacher-servlet.xml" })


public class CollegeServiceTest {

	
	@Autowired
	CollegeServiceInt model;
	
	@Ignore
	//@Test
	public void search(){
		CollegeDTO dto=new CollegeDTO();
    	//dto.setId(7);
		dto.setName("orintal");
		int pageNo=1;
		int pageSize=10;
		List lits=model.search(dto, pageNo, pageSize);
		Iterator it=lits.iterator();
		while (it.hasNext()) {
			CollegeDTO object = (CollegeDTO) it.next();
			System.out.println(object.getCity());
		}
	}
	
	
	
	@Ignore
	//@Test
	public void update(){
		CollegeDTO dto=new CollegeDTO();
    	dto.setId(2);
		dto.setName("orintal");
    	dto.setPhoneNo("123456789");
    	dto.setAddress("indore");
    	dto.setCity("indore");
    	dto.setState("mp");
    	dto.setCreatedBy("root");
    //	dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
    	dto.setModifiedBy("root");
    	//dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
		try {
			model.update(dto);
		} catch (DuplicateRecordException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		System.out.println(""+e.getMessage());
		}
	}
	
	@Ignore
	//@Test
	public void Delete(){
		long id=2;
		model.delete(id);
		System.out.println("Deleted");
	}
	
//    @Ignore
    @Test
    public void add(){
    	CollegeDTO dto=new CollegeDTO();
    	dto.setName("Lnct");
    	dto.setPhoneNo("955822789");
    	dto.setAddress("indore");
    	dto.setCity("indore");
    	dto.setState("mp");
    	dto.setCreatedBy("root");
    	dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
    	dto.setModifiedBy("root");
    	dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
        try {
			model.add(dto);
			System.out.println("Add Successs");
		} catch (DuplicateRecordException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
    
    }

	
}
