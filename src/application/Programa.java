package application;

import model.dao.DaoFactory;
import model.dao.VendedorDao;
import model.entities.Vendedor;

public class Programa {

	public static void main(String[] args) {
		
		/*Departamento obj = new Departamento(1, "Livros");
		System.out.println(obj);
		
		Vendedor vend = new Vendedor(21, "Bob", "bob@gmail.com", new Date(), 3000.0, obj);
		
		VendedorDao vendededorDao = DaoFactory.criaVendedorDao();
		System.out.println(vend);*/
		
		VendedorDao vendedorDao = DaoFactory.criaVendedorDao();
		Vendedor vend = vendedorDao.buscaPorId(3);
		
		System.out.println(vend);

	}

}
