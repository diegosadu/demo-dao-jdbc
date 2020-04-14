package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.VendedorDao;
import model.entities.Departamento;
import model.entities.Vendedor;

public class Programa {

	public static void main(String[] args) {
		
		/*Departamento obj = new Departamento(1, "Livros");
		System.out.println(obj);
		
		Vendedor vend = new Vendedor(21, "Bob", "bob@gmail.com", new Date(), 3000.0, obj);
		
		VendedorDao vendededorDao = DaoFactory.criaVendedorDao();
		System.out.println(vend);*/
		
		VendedorDao vendedorDao = DaoFactory.criaVendedorDao();
		
		System.out.println("===== TESTE 1: vendedor buscaPorId =====");
		Vendedor vend = vendedorDao.buscaPorId(3);
		System.out.println(vend);
		
		System.out.println("\n===== TESTE 2: vendedor buscaPorDepartamento =====");
		Departamento dep = new Departamento(2, null);
		List<Vendedor> lista = vendedorDao.buscaPorDepartamento(dep);
		for (Vendedor vendedor : lista) {
			System.out.println(vendedor);
		}
		
		System.out.println("\n===== TESTE 3: vendedor buscaTudo =====");
		lista = vendedorDao.buscaTudo();
		for (Vendedor vendedor : lista) {
			System.out.println(vendedor);
		}
		
		System.out.println("\n===== TESTE 4: vendedor insere =====");
		Vendedor novoVend = new Vendedor(null, "Greg", "greg@gmail.com", new Date(), 4000.0, dep);
		vendedorDao.insere(novoVend);
		System.out.println("Inserido! Novo ID = " + novoVend.getId());

	}

}
