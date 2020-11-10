package entrega_4.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexao.ConexaoMySQL;
import entrega_1.modelo.Profissional;

public class ProfissionalRepository {
	public void inserir(Profissional profissional) {
		String query = buildQueryInsert(profissional);
		try {
			Statement statement = ConexaoMySQL.getConexaoMySQL().createStatement();
			statement.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(Profissional profissional) {
		String query = "DELETE FROM lp1.profissional WHERE id_profissional = " + profissional.getIdProfissional() + ";";
		try {
			Statement statement = ConexaoMySQL.getConexaoMySQL().createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void editar(Profissional profissional) {
		String query = buildQueryUpdate(profissional);
		try {
			Statement statement = ConexaoMySQL.getConexaoMySQL().createStatement();
			statement.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Profissional> listarTodos() {
		try {
			PreparedStatement preparedStatement = ConexaoMySQL.getConexaoMySQL()
					.prepareStatement("SELECT * FROM lp1.profissional");
			ResultSet rs = preparedStatement.executeQuery();
			List<Profissional> listaRetorno = new ArrayList<Profissional>();

			while (rs.next()) {
				listaRetorno.add(new Profissional(rs.getString("cargo"), rs.getDouble("salario"), rs.getString("area"),
						rs.getInt("id_profissional")));
			}
			return listaRetorno;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	private String buildQueryUpdate(Profissional profissional) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE lp1.profissional SET ");
		if (profissional.getCargo() != null) {
			sql.append("cargo = '");
			sql.append(profissional.getCargo());
			sql.append("', ");
		}
		if (profissional.getSalario() != null) {
			sql.append("salario = ");
			sql.append(profissional.getSalario());
			sql.append(", ");
		}
		if (profissional.getArea() != null) {
			sql.append("area = '");
			sql.append(profissional.getArea());
			sql.append("' ");
		}

		sql.append(" WHERE id_profissional = ");
		sql.append(profissional.getIdProfissional());
		sql.append(";");
		System.out.println(sql.toString());
		return sql.toString();
	}

	private String buildQueryInsert(Profissional profissional) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO lp1.profissional(cargo, salario, area) VALUES ('");
		sql.append(profissional.getCargo());
		sql.append("', ");
		sql.append(profissional.getSalario());
		sql.append(", '");
		sql.append(profissional.getArea());
		sql.append("'");
		sql.append(")");
		System.out.println(sql.toString());
		return sql.toString();
	}
}
