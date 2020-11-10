package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {

	public static String status = "Não conectou...";

	// Método Construtor da Classe//

	public ConexaoMySQL() {

	}

	// Método de Conexão//

	public static java.sql.Connection getConexaoMySQL() {

		Connection connection = null;

		try {

			String driverName = "com.mysql.jdbc.Driver";

			Class.forName(driverName);

			String serverName = "localhost";

			String mydatabase = "lp1";

			String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

			String username = "root";

			String password = "Aleixo@123";

			connection = DriverManager.getConnection(url, username, password);

			if (connection != null) {

				status = ("STATUS--->Conectado com sucesso!");

			} else {

				status = ("STATUS--->Não foi possivel realizar conexão");

			}

			return connection;

		} catch (ClassNotFoundException e) { // Driver não encontrado

			System.out.println("O driver expecificado nao foi encontrado.");

			return null;

		} catch (SQLException e) {

			System.out.println("Nao foi possivel conectar ao Banco de Dados.");

			return null;

		}

	}

	public static String statusConection() {

		return status;

	}

	public static boolean FecharConexao() {

		try {

			ConexaoMySQL.getConexaoMySQL().close();

			return true;

		} catch (SQLException e) {

			return false;

		}

	}

	public static java.sql.Connection ReiniciarConexao() {

		FecharConexao();

		return ConexaoMySQL.getConexaoMySQL();

	}

}
