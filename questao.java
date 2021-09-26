package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class questao extends Resp {

		String url1 = "jdbc:mysql://localhost:3308/crud";
		String user = "root";
		String password = "";
		String altcerta;
		Scanner scanner = new Scanner(System.in); {
		
		try {
			for (int idQuestao = 1; idQuestao < 6;) {
	        Connection connection = DriverManager.getConnection(url1, user, password);
	        
	        String sql = "SELECT * FROM questao WHERE id = ('"+ idQuestao +"')";
	        
	        Statement statment = connection.createStatement();
	        ResultSet result = statment.executeQuery(sql);
	        
	       
	        while (result.next()) {
	        	String id = result.getString(1);
	        	String questao = result.getString(2);
	        	String alt1 = result.getString(3);
	        	String alt2 = result.getString(4);
	        	String alt3 = result.getString(5);
	        	String alt4 = result.getString(6);
	        	altcerta = result.getString(7);
	        	
	        	System.out.printf("Questão n°" + id + "\n" + questao + "\nA) " + alt1 + "\nB) " + alt2 + "\nC) " + alt3 + "\nD) " + alt4 + "\n");
	        	}
			System.out.printf("\nEscolha a alternativa correta: ");
			String questaoEscolha = scanner.nextLine();
			
			if(altcerta.equals(questaoEscolha)) { 
				System.out.println("\nResposta certa \n-----------------------------------------------------------------------");	
			}
			else {
				System.out.println("\nResposta errada, a alternativa correta é: " + altcerta + "\n-----------------------------------------------------------------------");
				
			}
			
			idQuestao++;
			
	        statment.close();
	        connection.close(); 
	        
			}
			
			System.out.println("=======================Questionário finalizado==========================");
		}
		
		catch (SQLException ex) {
	        System.out.println("An error occurred. Maybe user/password is invalid");
	        ex.printStackTrace();
	    	}
		
		
		}		
}


