package biblioteca.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexaoBD {
    private static final String url = System.getenv("DB_URL"); //passando o caminho do banco
    private static final String user = System.getenv("DB_USER"); //criando usuário
    private static final String password = System.getenv("DB_PASSWORD"); //criando senha

    private static Connection con;

    public static Connection getCon(){ //criando a conexão
            try{ //tratamento de exceção
                if(con == null){ //caso a conexão não exista, ela é criada no mesmo instante
                    con = DriverManager.getConnection(url,user,password);
                    return con;
                }else { //Caso exista, apenas retorna a conexão
                    return con;
                }
            }catch (SQLException e){ //exceção tratada
                e.printStackTrace();
                return null;
            }
    }
}
