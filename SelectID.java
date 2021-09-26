package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectID extends MySQL {

	String sql;
	{

		Scanner scanner = new Scanner(System.in);

		System.out.println("Qual o n° da questão? ");
		String id = scanner.nextLine();

		sql = "SELECT * FROM questao WHERE (id = '" + id + "')";

		try {
			Connection connection = DriverManager.getConnection(url1, user, password);

			Statement statment = connection.createStatement();
			ResultSet result = statment.executeQuery(sql);

			while (result.next()) {
				String id1 = result.getString(1);
				String questao = result.getString(2);
				String alt1 = result.getString(3);
				String alt2 = result.getString(4);
				String alt3 = result.getString(5);
				String alt4 = result.getString(6);
				String altCerta = result.getString(7);

				System.out.println("Questão n°: " + id1 + "\n" + questao + 
						"\nA) " + alt1 + "\nB) " + alt2 + "\nC) " + alt3 + "\nD) "
						+ alt4 + "\nAlternativa Certa: " + altCerta + "\n ");
			}
			
			statment.close();
			connection.close();

		}

		catch (SQLException ex) {
			System.out.println("An error occurred.");
			ex.printStackTrace();

		}
	}
}
