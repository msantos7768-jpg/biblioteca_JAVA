package biblioteca.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import io.github.cdimascio.dotenv.Dotenv;

public class conexaoBD {
    private static final Dotenv dotenv = Dotenv.load(); //buscando as credenciais pelo nome da variável

    private static final String url = dotenv.get("DB_URL"); //passando o caminho do banco
    private static final String user = dotenv.get("DB_USER"); //criando usuário
    private static final String password = dotenv.get("DB_PASSWORD"); //criando senha

    private static Connection con;

    public static Connection getCon(){ //criando a conexão
            try{ //tratamento de exceção
                if(con == null || con.isClosed()){ //caso a conexão não exista, ela é criada no mesmo instante
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
