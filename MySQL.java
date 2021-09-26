package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MySQL {
    	public String url1 = "jdbc:mysql://localhost:3308/crud";
    	public String user = "root";
    	public String password = "";
    	
    	public static void main(String[] args) {
	    
    	Scanner scanner = new Scanner(System.in);
    	int count = 1;
    	while(count > 0) {
       	System.out.println("\n1 - Nova Quest�o, 2 - Editar Quest�o, 3 - Excluir Quest�o, 4 - Visualizar Quest�es 5 - Responder Quest�es 6 - Pesquisar Quest�o 0 - Sair");
    	int MenuInicio = scanner.nextInt();
    	scanner.nextLine();
    	
    		switch(MenuInicio) {
    		case 1:	
    			new MyInsertValue();
    			break;
    		case 2:
    			new MyUpdateValue();
    			break;
    		case 3:
    			new MyDeleteValue();
    			break;
    		case 4:
    			new MySelect();
    			break;
    		case 5:
    			new questao();
    			break;
    		case 6:
    			new SelectID();
    			break;
    			}
    		
    		if(MenuInicio == 0) {
    			scanner.close();
    			System.exit(1);
    			}
    		}	
    	}
	}







