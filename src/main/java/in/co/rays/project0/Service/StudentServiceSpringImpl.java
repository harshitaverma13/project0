package in.co.rays.project0.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.rays.project0.DAO.StudentDAOInt;
import in.co.rays.project0.DTO.CollegeDTO;
import in.co.rays.project0.DTO.StudentDTO;
import in.co.rays.project0.Exception.DuplicateRecordException;

/**
 * Session facade of Student Service. It is transactional, apply delcarative
 * transactions with help of Spring AOP.
 * 
 * If unchecked exception is propagated from a method then transaction will be
 * rolled back.
 * 
 * Default propogation value is Propagation.REQUIRED and readOnly = false
 * 
 * @author FrontController
 * @version 1.0
 * @Copyright (c) SunilOS
 */

@Service("studentService")
public class StudentServiceSpringImpl implements StudentServiceInt {
	@Autowired
	private StudentDAOInt dao = null;
	@Autowired
	CollegeServiceInt model;

	public void setDao(StudentDAOInt dao) {
		this.dao = dao;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(StudentDTO dto) throws DuplicateRecordException {
		StudentDTO dtoExist = findByEmail(dto.getEmail());
		if (dtoExist != null) {
			throw new DuplicateRecordException("Login Id Is Alredy Exist");
		}
		
		CollegeDTO collegeDto=new CollegeDTO();
		 collegeDto = model.findByPK(dto.getCollegeId());
		dto.setCollegeName(collegeDto.getName());
		return dao.add(dto);

	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long update(StudentDTO dto) throws DuplicateRecordException {
		StudentDTO dtoExist = findByEmail(dto.getEmail());
		if (dtoExist != null && dtoExist.getId() != dto.getId()) {
			throw new DuplicateRecordException("Login Id Is Alredy Exist");
		}
		CollegeDTO collegeDto=new CollegeDTO();
		 collegeDto = model.findByPK(dto.getCollegeId());
		dto.setCollegeName(collegeDto.getName());
		return dao.update(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(long id) {
		dao.delete(id);
	}

	@Transactional(readOnly = true)
	public StudentDTO findByEmail(String email) {
		return dao.findByEmail(email);
	}

	@Transactional(readOnly = true)
	public StudentDTO findByPK(long pk) {
		return dao.findByPK(pk);
	}

	@Transactional(readOnly = true)
	public List<StudentDTO> search(StudentDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}

	@Transactional(readOnly = true)
	public List<StudentDTO> search(StudentDTO dto) {
		return dao.search(dto, 0, 0);
	}

}
