package entrega_4.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexao.ConexaoMySQL;
import entrega_1.modelo.Calcado;

public class CalcadoRepository {
	public void inserir(Calcado calcado) {
		String query = buildQueryInsert(calcado);
		try {
			Statement statement = ConexaoMySQL.getConexaoMySQL().createStatement();
			statement.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(Calcado calcado){
		String query = "DELETE FROM lp1.calcado WHERE id_calcado = " + calcado.getIdCalcado() + ";";
		try {
			Statement statement = ConexaoMySQL.getConexaoMySQL().createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void editar(Calcado calcado) {
		String query = buildQueryUpdate(calcado);
		try {
			Statement statement = ConexaoMySQL.getConexaoMySQL().createStatement();
			statement.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Calcado> listarTodos() {
		try {
			PreparedStatement preparedStatement = ConexaoMySQL.getConexaoMySQL()
					.prepareStatement("SELECT * FROM lp1.calcado");
			ResultSet rs = preparedStatement.executeQuery();
			List<Calcado> listaRetorno = new ArrayList<Calcado>();

			while (rs.next()) {
				listaRetorno.add(new Calcado(rs.getInt("numero"), rs.getString("fabricante"), rs.getString("cor"),
						rs.getString("modelo"), rs.getBoolean("aberto"), rs.getBoolean("mata_barata"),
						rs.getString("genero").charAt(0), rs.getInt("id_calcado")));
			}
			return listaRetorno;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	private String buildQueryUpdate(Calcado calcado) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE lp1.calcado SET ");
		if (calcado.getNumero() != null) {
			sql.append("numero = ");
			sql.append(calcado.getNumero());
			sql.append(", ");
		}
		if (calcado.getFabricante() != null) {
			sql.append("fabricante = '");
			sql.append(calcado.getFabricante());
			sql.append("', ");
		}
		if (calcado.getCor() != null) {
			sql.append("cor = '");
			sql.append(calcado.getCor());
			sql.append("', ");
		}
		if (calcado.getModelo() != null) {
			sql.append("modelo = '");
			sql.append(calcado.getModelo());
			sql.append("', ");
		}
		if (calcado.getGenero() != null) {
			sql.append("genero = '");
			sql.append(calcado.getGenero());
			sql.append("', ");
		}
		if (calcado.getMataBarata() != null) {
			sql.append("mata_barata = ");
			sql.append(calcado.getMataBarata() ? "1" : "0");
			sql.append(", ");
		}
		if (calcado.getAberto() != null){
			sql.append("aberto = ");
			sql.append(calcado.getAberto() ? "1" : "0");
		}

		sql.append(" WHERE id_calcado = ");
		sql.append(calcado.getIdCalcado());
		sql.append(";");
		System.out.println(sql.toString());
		return sql.toString();
	}

	private String buildQueryInsert(Calcado calcado) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO lp1.calcado(numero, fabricante, cor, modelo, genero, mata_barata, aberto) VALUES (");
		sql.append(calcado.getNumero());
		sql.append(", '");
		sql.append(calcado.getFabricante());
		sql.append("', '");
		sql.append(calcado.getCor());
		sql.append("', '");
		sql.append(calcado.getModelo());
		sql.append("', '");
		sql.append(calcado.getGenero());
		sql.append("', ");
		sql.append(calcado.getMataBarata() ? "1" : "0");
		sql.append(", ");
		sql.append(calcado.getAberto()  ? "1" : "0");
		sql.append(")");
		System.out.println(sql.toString());
		return sql.toString();
	}
}
