package biblioteca.DAO;
import biblioteca.model.estudante;
import biblioteca.connection.conexaoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class usuarioDAO {

    public void cadastrarUsuario(estudante estudante){
        String sql = "INSERT INTO USUARIO (idusuario, nome, email, curso, matricula) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = conexaoBD.getCon().prepareStatement(sql);
            ps.setInt(1, estudante.getId());
            ps.setString(2,estudante.getNome());
            ps.setString(3, estudante.getEmail());
            ps.setString(4,estudante.getCurso() );
            ps.setInt(5,estudante.getMatricula());

            ps.execute();
            ps.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}

