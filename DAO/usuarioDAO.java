package biblioteca.DAO;
import biblioteca.model.estudante;
import biblioteca.connection.conexaoBD;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class usuarioDAO {

    public void cadastrarUsuario(estudante estudante){
        String sql = "insert into usuario (idusuario, nome, email, curso, matricula) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = conexaoBD.getCon().prepareStatement(sql);
            ps.setInt(1, estudante.getId());
            ps.setString(2,estudante.getNome());
            ps.setString(3, estudante.getEmail());
            ps.setString(4,estudante.getCurso() );
            ps.setInt(5, estudante.getMatricula());

            ps.execute();
            ps.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public estudante consultarUsuariobyId(estudante estudante)
            throws SQLException {

        String sql = "SELECT * FROM usuario WHERE idusuario = ?";

        try (
                Connection con = conexaoBD.getCon();
                PreparedStatement comando = con.prepareStatement(sql)
        ) {
            comando.setInt(1, estudante.getId());

            try (ResultSet rs = comando.executeQuery()) {

                if (rs.next()) {
                    estudante est = new estudante(
                            rs.getInt("idusuario"),
                            rs.getString("nome"),
                            rs.getString("email"),
                            rs.getString("curso"),
                            rs.getInt("matricula")
                    );

                    return est;
                }
            }
        }

        return null;
    }

}

