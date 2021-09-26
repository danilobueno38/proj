package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MyDeleteValue extends  MySQL{ {

    Scanner scanner = new Scanner(System.in);
    
	System.out.println("Qual o n° da questão que deseja excluir? ");
		String idExcluir = scanner.nextLine();
  
	System.out.println("Tem certeza que quer excluir a questão? (1) Sim, (2) Não");
  		int check = scanner.nextInt();
  		scanner.nextLine();
  	
  		if(check==2) { System.exit(1);
  		}
  		
    try {    		    	  
        Connection connection = DriverManager.getConnection(url1, user, password);
        
	  	String sql = "DELETE FROM questao WHERE id = ?";
        
	  	PreparedStatement statment1 = connection.prepareStatement(sql);
      
        statment1.setString(1, idExcluir);
        
        int rows = statment1.executeUpdate();
        if (rows > 0) {
        	System.out.println("A questão foi excluida do banco de dados.");
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

