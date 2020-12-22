package in.co.rays.project0.Test;

import java.text.SimpleDateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import in.co.rays.project0.DTO.UserDTO;
import in.co.rays.project0.Exception.DuplicateRecordException;
import in.co.rays.project0.Service.UserServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)

@WebAppConfiguration  

//@ContextConfiguration({ "file:src/main/webapp/WEB-INF/dispatcher-servlet.xml" })

/*@ContextConfiguration({ "file:D:/Pro_New_00/ORS_Proj_0/src/main/webapp/WEB-INF/dispacher-servlet.xml" })*/
@ContextConfiguration({ "file:E:/Project 0/ORS_Proj_0/src/main/webapp/WEB-INF/dispacher-servlet.xml" })

public class UserServiceTest {
	
	@Autowired
	UserServiceInt model;
	
	@Test
	public void add() throws  DuplicateRecordException {

		//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		UserDTO dto = new UserDTO();
		// dto.setId(8L);
		dto.setFirstName("Sunill");
		dto.setLastName("Nagarr");
		dto.setLogin("sunilnagar9713@gmail.com");
		dto.setPassword("12345678");
		//dto.setDob("01/01/1992"));
		//dto.setDob("01/01/1993");
		dto.setRoleId(1L);
	//	dto.setUnSuccessfulLogin(2);
		dto.setGender("male");
		//dto.setLastLogin(new Timestamp(new Date().getTime()));
		//dto.setLastLoginIP();
		//dto.setLock("yes");
		dto.setMobileNo("8765432342");
		dto.setCreatedBy("Admin");
		dto.setModifiedBy("Admin");
		//dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
		//dto.setModifiedDatetime(new Timestamp(new Date().getTime()));

		long pk = model.add(dto);

		System.out.println("pk :---" + pk);
		System.out.println("****Add Successfully***");	
	}
	
	
}

