package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.VendedorDao;
import model.entities.Departamento;
import model.entities.Vendedor;

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
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
		
		System.out.println("\n===== TESTE 5: vendedor atualiza =====");
		vend = vendedorDao.buscaPorId(1);
		vend.setNome("Martha Waine");
		vendedorDao.atualiza(vend);
		System.out.println("Vendedor atualizado!");
		
		System.out.println("\n===== TESTE 6: vendedor excluirPorId =====");
		System.out.print("Entre com um Id de vendedor para a exclusão:");
		int id = sc.nextInt();
		vendedorDao.excluirPorId(id);
		System.out.println("Vendedor excluído!");
		
		sc.close();

	}

}
