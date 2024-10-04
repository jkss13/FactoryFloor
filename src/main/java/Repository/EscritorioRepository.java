package Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entities.Escritorio;

public class EscritorioRepository implements RepositoryConnectionTemplate<Escritorio, Integer> {

	public static final EscritorioRepository current = new EscritorioRepository();
	
	private EscritorioRepository() {}
	
	@Override
	public void create(Escritorio e) throws SQLException {
		
		String sql = "INSERT INTO escritorios(nome) VALUES (?)";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setString(1, e.getNome());
		pstm.execute();
		
	}
	
	@Override
	public void update(Escritorio e) throws SQLException {
		
		String sql = "UPDATE escritorios SET nome=? WHERE id_escritorio=?";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setString(1, e.getNome());
		pstm.setInt(2, e.getCodigo());
		pstm.execute();
		
	}
	
	@Override
	public Escritorio read(Integer i) throws SQLException {
		
		String sql = "SELECT * FROM escritorios WHERE id_escritorio="+i;
		
		ResultSet result = ConnectionManager.getCurrentConnection().prepareStatement(sql).executeQuery();
		
		Escritorio e = null;
		
		if(result.next()) {
			e = new Escritorio();
			e.setCodigo(i);
			e.setNome(result.getString("nome_escritorio"));
		}
		return e;
	}
	
	@Override
	public void delete(Integer i) throws SQLException {
		
	}
	
	//@Override
	public List<Escritorio> readAll() throws SQLException {
		
		String sql = "SELECT * FROM escritorios";
		
		ResultSet result = ConnectionManager.getCurrentConnection().prepareStatement(sql).executeQuery();
		
		Escritorio e = null;
		
		List<Escritorio> escritorios = new ArrayList<Escritorio>();
		
		while(result.next()) {
			e = new Escritorio();
			e.setCodigo(result.getInt("id_escritorio"));
			e.setNome(result.getString("nome_escritorio"));
			
			escritorios.add(e);
		}
		return escritorios;
	}
	
}
