package model.dao;

import java.util.List;

import model.entities.Departamento;

public interface DepartamentoDAO {

	void insere(Departamento obj);
	void atualiza(Departamento obj);
	void excluirPorId(Integer id);
	Departamento buscaPorId(Integer id);
	List<Departamento> retornaTudo();
}
