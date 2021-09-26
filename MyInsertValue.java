package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MyInsertValue extends MySQL { 
		String id1;
		String def = "DEFAULT";
	{
    		
		Scanner scanner = new Scanner(System.in);
			
		System.out.println("Escreva a questao: ");
		String questao = scanner.nextLine();

		System.out.println("primeira alternativa: ");
		String alt1 = scanner.nextLine();

		System.out.println("segunda alternativa: ");
		String alt2 = scanner.nextLine();

		System.out.println("terceira alternativa: ");
		String alt3 = scanner.nextLine();		
		
		System.out.println("quarta alternativa: ");
		String alt4 = scanner.nextLine();
		
		System.out.println("alternativa correta (A, B, C ou D): ");	//atualizar depois	
		String altcerta = scanner.nextLine();		
			
		
		try {
			Connection connection = DriverManager.getConnection(url1, user, password);

			String sql = "INSERT INTO questao (id, questao, alt1, alt2, alt3, alt4, altcerta) VALUES (?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement statment = connection.prepareStatement(sql);
			statment.setString(1, null);
			statment.setString(2, questao);
			statment.setString(3, alt1);
			statment.setString(4, alt2);
			statment.setString(5, alt3);
			statment.setString(6, alt4);
			statment.setString(7, altcerta);
        
			int rows = statment.executeUpdate();
			if (rows > 0) {
				System.out.println("Questão inserida.");
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
