package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySelect extends MySQL { {
	try {
        Connection connection = DriverManager.getConnection(url1, user, password);
        
        String sql = "SELECT * FROM questao;";
        
        Statement statment = connection.createStatement();
        ResultSet result = statment.executeQuery(sql);
                		
        while (result.next()) {
        	String id = result.getString(1);
        	String questao = result.getString(2);
        	String alt1 = result.getString(3);
        	String alt2 = result.getString(4);
        	String alt3 = result.getString(5);
        	String alt4 = result.getString(6);
        	String altcerta = result.getString(7);
        	System.out.println("Questão n°" + id + ": " + questao + " "
        	+ "\nA) " + alt1 + " | B) " + alt2 + " | C) " + alt3 + " | D) " + alt4 + 
        	"\nAlternativa certa: (" + altcerta + ") \n ");
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