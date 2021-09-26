package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MyUpdateValue extends MySQL { {
     
    Scanner scanner = new Scanner(System.in);
    
	System.out.println("Qual n° da questão que deseja editar? ");
	String idAlterar = scanner.nextLine();
  
	System.out.println("Qual campo deseja editar? 1 - Corpo da questão, 2 - Alternativa A, 3 - Alternativa B, 4 - Alternativa C, 5 - Alternativa D, 6 - Alternativa Certa");
  	int campo = scanner.nextInt();
  	scanner.nextLine();
  	
  	System.out.println("Novo valor: ");
  	String novoValor = scanner.nextLine();
  
    try {    		    	  
        Connection connection = DriverManager.getConnection(url1, user, password);
        
        String sql = "";
        
	  	switch(campo) {
	  	case 1:
	  		sql = "UPDATE questao SET questao = ? WHERE id = ?";
	  		break;
	  	case 2:
	  		sql = "UPDATE questao SET alt1 = ? WHERE id = ?";
	  		break;
	  	case 3:
	  		sql = "UPDATE questao SET alt2 = ? WHERE id = ?";
	  		break;
	  	case 4:
	  		sql = "UPDATE questao SET alt3 = ? WHERE id = ?";
	  		break;
	  	case 5:
	  		sql = "UPDATE questao SET alt4 = ? WHERE id = ?";
	  		break;
	  	case 6:
	  		sql = "UPDATE questao SET altCerta = ? WHERE id = ?";
	  		
	  	}
	      		        
	  	PreparedStatement statment1 = connection.prepareStatement(sql);
      
        statment1.setString(1, novoValor);
        statment1.setString(2, idAlterar);
        
        int rows = statment1.executeUpdate();
        if (rows > 0) {
        	System.out.println("O Valor foi Alterado.");
        }             
        
        statment1.close();
        connection.close();

    }
    catch (SQLException ex) {
        System.out.println("An error occurred.");
        ex.printStackTrace();
    }
}
}
