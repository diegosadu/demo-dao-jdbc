package model.dao;

import java.util.List;

import model.entities.Vendedor;

public interface VendedorDAO {

	void insere(Vendedor obj);
	void atualiza(Vendedor obj);
	void excluirPorId(Integer id);
	Vendedor buscaPorId(Integer id);
	List<Vendedor> retornaTudo();
}