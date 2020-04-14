package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.VendedorDao;
import model.entities.Departamento;
import model.entities.Vendedor;

public class VendedorDaoJDBC implements VendedorDao {

	private Connection conn;
	
	public VendedorDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insere(Vendedor obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualiza(Vendedor obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluirPorId(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vendedor buscaPorId(Integer id) {

		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"SELECT v.*, d.nome DepNome "
					+ "FROM departamento d, "
					+ "vendedor v "
					+ "WHERE v.id = ? "
					+ "AND d.id = v.departamentoId");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			
			// se rs.next() retorna false significa que o executeQuery não gerou resultado
			if(rs.next()) {
				Departamento dep = instanciaDepartamento(rs);
				Vendedor vend = instanciaVendedor(rs, dep);
				return vend;
			}
			return null;	
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

	}

	private Vendedor instanciaVendedor(ResultSet rs, Departamento dep) throws SQLException {
		Vendedor vend = new Vendedor();
		vend.setId(rs.getInt("Id"));
		vend.setNome(rs.getString("Nome"));
		vend.setEmail(rs.getString("Email"));
		vend.setDataNascimento(rs.getDate("DataNascimento"));
		vend.setSalarioBase(rs.getDouble("SalarioBase"));
		vend.setDepartamento(dep);
		return vend;
	}

	private Departamento instanciaDepartamento(ResultSet rs) throws SQLException {
		Departamento dep = new Departamento();
		dep.setId(rs.getInt("DepartamentoId"));
		dep.setNome(rs.getString("DepNome"));
		return dep;
	}

	@Override
	public List<Vendedor> retornaTudo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vendedor> retornaPorDepartamento(Departamento departamento) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"SELECT v.*, d.Nome DepNome\r\n" + 
					"  FROM departamento d,\r\n" + 
					"       vendedor v\r\n" + 
					" WHERE DepartamentoId = ?\r\n" + 
					"   AND d.Id = v.DepartamentoId\r\n" + 
					" ORDER BY v.Nome;");
			
			st.setInt(1, departamento.getId());
			rs = st.executeQuery();
			
			// cria uma lista para guardar os vendedores retornados pelo resultset
			List<Vendedor> lista = new ArrayList<Vendedor>();
			
			// cria um objeto Map composto por um valor inteiro, que vai ser o id do departamento, e pelo próprio objeto Departamento
			Map<Integer, Departamento> map = new HashMap<Integer, Departamento>();
			
			// quando rs.next() retornar false significa que o executeQuery não encontrou mais registro
			while(rs.next()) {
				
				// dep recebe o departamento que está no map, retornado a partir do id do departamento
				Departamento dep = map.get(rs.getInt("DepartamentoId"));
				
				// verifica se o departamento já existe no map
				if(dep == null) {
					// se não existir, instancia o departamento e joga dentro do map
					dep = instanciaDepartamento(rs);
					map.put(rs.getInt("DepartamentoId"), dep);
				}
				Vendedor vend = instanciaVendedor(rs, dep);
				lista.add(vend);
			}
			return lista;	
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
	}

}
