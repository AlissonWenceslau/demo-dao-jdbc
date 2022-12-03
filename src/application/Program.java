package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		//Injeção de dependência
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("===TEST 1: Seller findById===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n===TEST 2: Seller findByDepartmentId===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller s : list) {
			System.out.println(s);
		}
		
		System.out.println("\n===TEST 3: Seller findAll===");
		list = sellerDao.findAll();
		for(Seller s : list) {
			System.out.println(s);
		}
		
		System.out.println("\n===TEST 4: Seller Insert===");
		Seller newSeller = new Seller(null, "Alisson", "alisson@gmail.com", new Date(), 3600.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("\n===TEST 5: Seller Update===");
		seller = sellerDao.findById(1);
		seller.setName("Marlene Wiene");
		sellerDao.update(seller);
		System.out.println("Update completed!");
		
		System.out.println("\n===TEST 6: Seller Delete===");
		sellerDao.deleteById(24);
		System.out.println("Delete completed!");
	}
}

