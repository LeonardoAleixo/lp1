package entrega_4.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexao.ConexaoMySQL;
import entrega_1.modelo.InstrumentoMusical;

public class InstrumentoRepository {
	public void inserir(InstrumentoMusical instrumento) {
		String query = buildQueryInsert(instrumento);
		try {
			Statement statement = ConexaoMySQL.getConexaoMySQL().createStatement();
			statement.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(InstrumentoMusical instrumento) {
		String query = "DELETE FROM lp1.instrumento WHERE id_instrumento = " + instrumento.getIdInstrumento() + ";";
		try {
			Statement statement = ConexaoMySQL.getConexaoMySQL().createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void editar(InstrumentoMusical instrumento) {
		String query = buildQueryUpdate(instrumento);
		try {
			Statement statement = ConexaoMySQL.getConexaoMySQL().createStatement();
			statement.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<InstrumentoMusical> listarTodos() {
		try {
			PreparedStatement preparedStatement = ConexaoMySQL.getConexaoMySQL()
					.prepareStatement("SELECT * FROM lp1.instrumento");
			ResultSet rs = preparedStatement.executeQuery();
			List<InstrumentoMusical> listaRetorno = new ArrayList<InstrumentoMusical>();

			while (rs.next()) {
				listaRetorno.add(new InstrumentoMusical(rs.getString("nome"), rs.getString("marca"),
						rs.getString("modelo"), rs.getBoolean("possui_cordas"), rs.getInt("id_instrumento"), rs.getBoolean("afinado")));
			}
			return listaRetorno;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	private String buildQueryUpdate(InstrumentoMusical instrumento) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE lp1.instrumento SET ");
		if (instrumento.getNome() != null) {
			sql.append("nome = '");
			sql.append(instrumento.getNome());
			sql.append("', ");
		}
		if (instrumento.getMarca() != null) {
			sql.append("marca = '");
			sql.append(instrumento.getMarca());
			sql.append("', ");
		}
		if (instrumento.getModelo() != null) {
			sql.append("modelo = '");
			sql.append(instrumento.getModelo());
			sql.append("', ");
		}
		if (instrumento.getAfinado() != null){
			sql.append("afinado = ");
			sql.append(instrumento.getAfinado());
			sql.append(", ");
		}
		if (instrumento.getPossuiCordas() != null) {
			sql.append("possui_cordas = ");
			sql.append(instrumento.getPossuiCordas());
			sql.append(" ");
		}

		sql.append(" WHERE id_instrumento = ");
		sql.append(instrumento.getIdInstrumento());
		sql.append(";");
		System.out.println(sql.toString());
		return sql.toString();
	}

	private String buildQueryInsert(InstrumentoMusical instrumento) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO lp1.instrumento(nome, marca, possui_cordas, afinado, modelo) VALUES ('");
		sql.append(instrumento.getNome());
		sql.append("', '");
		sql.append(instrumento.getMarca());
		sql.append("', ");
		sql.append(instrumento.getPossuiCordas() ? "1" : "0");
		sql.append(", ");
		sql.append(instrumento.getAfinado() ? "1" : "0");
		sql.append(", '");
		sql.append(instrumento.getModelo());
		sql.append("'");
		sql.append(")");
		System.out.println(sql.toString());
		return sql.toString();
	}
}
