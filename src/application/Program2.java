package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("===TEST 1: Department Insert===");
		Department department = new Department(null, "Music");
		departmentDao.insert(department);
		System.out.println("Insert completed! ID = " + department.getId() );
		
		System.out.println("===TEST 2: Department FindAll===");
		List<Department> list = departmentDao.findAll();
		for(Department d : list) {
			System.out.println(d);
		}

	}

}
