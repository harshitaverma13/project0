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

import in.co.rays.project0.DTO.RoleDTO;
import in.co.rays.project0.Exception.DuplicateRecordException;
import in.co.rays.project0.Service.RoleServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)

@WebAppConfiguration

//@ContextConfiguration({ "file:src/main/webapp/WEB-INF/dispatcher-servlet.xml" })

@ContextConfiguration({ "file:D:/Pro_0/ORS_Proj_0/src/main/webapp/WEB-INF/dispacher-servlet.xml" })


public class RoleServiceTest {
	
	@Autowired
	RoleServiceInt model;

	@Ignore
	//@Test
	public void search(){
		RoleDTO dto=new RoleDTO();
		//dto.setId(1);
		//dto.setRoleName("admin");
		dto.setRoleDescription("Student");
		int pageNo=1;
		int pageSize=10;
		
		List list=model.search(dto, pageNo, pageSize);
        System.out.println(list.size());
	 Iterator<RoleDTO> it=list.iterator();
	 while (it.hasNext()) {
		       dto=it.next();
		System.out.println(dto.getId());       
		System.out.println(dto.getRoleName());
	}
	}
	
	@Ignore
//	@Test
	public void update(){
		RoleDTO dto=new RoleDTO();
		try {
			dto.setId(2);
			dto.setRoleName("Student");
			dto.setRoleDescription("College student ");
			dto.setCreatedBy("root");
			dto.setModifiedBy("root");
			dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
			dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
			model.update(dto);
			System.out.println("Success update");
		
		} catch (DuplicateRecordException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Ignore
//	@Test
	public void findByPk(){
		long id=1;
		RoleDTO dto=new RoleDTO();
		dto=model.findById(id);
		System.out.println(dto.getRoleName());
	}
	@Ignore
	//@Test
	public void findByName(){
		String roleName="student";
		RoleDTO dto=new RoleDTO();
		dto=model.findByName(roleName);
	System.out.println("Success"+dto.getId());
	}
	
	@Ignore
//	@Test
	public void Delete(){
		long id=2;
		model.delete(id);
		
	}
	
	
	//@Ignore
	@Test
	public void add()
	{  
		RoleDTO dto=new RoleDTO();
	
	dto.setRoleName("Online");
    dto.setRoleDescription("access all student");
    dto.setCreatedBy("root");
    dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
    dto.setModifiedBy("root");
    dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
    
    long pk;
	try {
		pk = model.add(dto);
	    System.out.println("SuccessFully add");

	} catch (DuplicateRecordException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

	

}