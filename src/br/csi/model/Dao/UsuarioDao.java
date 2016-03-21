package br.csi.model.Dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

import br.csi.model.Usuario;
import br.csi.model.util.conectaBDPostgres;
import jdk.management.resource.internal.inst.StaticInstrumentation;

public class UsuarioDao {
	
	public static void main(String[] args){
		
		Usuario u = new Usuario();
		u.setLogin("liu");
		u.setSenha("123");
		
		try {
			
			System.out.println("autenticado?"+new UsuarioDao().autenticado(u));
			new UsuarioDao().autenticado(u);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public boolean autenticado(Usuario u) throws SQLException{
		
		boolean autenticado = false;
		
		Connection c = conectaBDPostgres.getConexao();
		Statement stmt = c.createStatement();
		String sql = "select * from usuario where login = '"+u.getLogin()+"' and senha = '"+u.getSenha()+"';";
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next()){
			long id = rs.getLong("id");
			String login = rs.getString("login");
			String senha = rs.getString("senha");
		}
		
		
		return autenticado;
	}
	

}
