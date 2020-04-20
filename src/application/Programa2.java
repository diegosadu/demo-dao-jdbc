package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartamentoDao;
import model.entities.Departamento;

public class Programa2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DepartamentoDao departamentoDao = null;
		
		System.out.println("===== TESTE 1: departamento buscaPorId =====");
		departamentoDao = DaoFactory.criaDepartamentoDao();
		Departamento dep = departamentoDao.buscaPorId(1);
		System.out.println(dep);
		
		System.out.println("/n===== TESTE 2: departamento buscaTudo =====");
		//List<Departamento> listaDep = departamentoDao.buscaTudo();
		for (Departamento departamento : departamentoDao.buscaTudo()) {
			System.out.println(departamento);
		}
		
		System.out.println("/n===== TESTE 3: departamento insere =====");
		dep = new Departamento(null, "Movies");
		departamentoDao.insere(dep);
		if (dep.getId() != null) {
			System.out.println("Registro inserido! Id = " + dep.getId());
		}
		
		System.out.println("/n===== TESTE 4: departamento atualiza =====");
		int id = 6;
		dep = departamentoDao.buscaPorId(id);
		String nomeAntigo = dep.getNome();
		dep.setNome("News");
		departamentoDao.atualiza(dep);
		String nomeNovo = dep.getNome();
		System.out.println("Nome do registro " + id + " alterado de " + nomeAntigo + " para " + nomeNovo + ".");
		
		System.out.println("/n===== TESTE 5: departamento excluirPorId =====");
		System.out.print("Informe o Id do departamento a ser excluído:");
		departamentoDao.excluirPorId(sc.nextInt());
		System.out.println("Registro excluído!");
		
	}

}
