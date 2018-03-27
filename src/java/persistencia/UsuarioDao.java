package persistencia;
import entidade.Usuario;
import java.util.ArrayList;
import java.util.List;
import sun.security.provider.MD5;

public class UsuarioDao extends Dao{
    
    public void cadastrar(Usuario u) throws Exception{
        abrirConexao();
        
        String sql = "INSERT INTO usuarios VALUES (NULL, ?, ?, ?, MD5(?), ?)";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, u.getNome());
        stmt.setString(2, u.getCpf());
        stmt.setString(3, u.getUsername());
        stmt.setString(4, u.getPassword());
        stmt.setInt(5, u.getPerfil_id());
        stmt.execute();
        stmt.close();
        
        fecharConexao();
    }
    
    public Boolean loginUsuario(String login, String password) throws Exception{
        abrirConexao();
        
        String sql = "SELECT * FROM usuarios WHERE (username = ? AND password = ?) AND status = 1";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, login);
        stmt.setString(2, password);
        rs = stmt.executeQuery();
        
        if(rs.next()){
            return true;
        } else {
            return false;
        }
    }
    
    public List<Usuario> getUsuarios() throws Exception{
        abrirConexao();
        
        String sql = "SELECT * FROM usuarios WHERE status  = 1";
        stmt = con.prepareStatement(sql);
        rs = stmt.executeQuery();
        
        List<Usuario> dados = new ArrayList<>();
        
        
        while(rs.next()){
            Usuario u = new Usuario();
            u.setId(rs.getInt("id"));
            u.setNome(rs.getString("nome"));
            u.setCpf(rs.getString("cpf"));
            u.setUsername(rs.getString("username"));
            u.setPerfil_id(rs.getInt("perfis_id"));
            u.setDtCadastro(rs.getDate("dtCadastro"));
            u.setStatus(rs.getBoolean("status"));
            dados.add(u);
        }
        
        return dados;
    }
    
    public List<Usuario> getUsuarioById(int id) throws Exception{
        abrirConexao();
        
        String sql = "SELECT * FROM usuarios WHERE id = ? AND status = 1";
        stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        rs = stmt.executeQuery();
        
        List<Usuario> dados = new ArrayList<>();
        
        
        while(rs.next()){
            Usuario u = new Usuario();
            u.setId(rs.getInt("id"));
            u.setNome(rs.getString("nome"));
            u.setCpf(rs.getString("cpf"));
            u.setUsername(rs.getString("username"));
            u.setPerfil_id(rs.getInt("perfis_id"));
            u.setDtCadastro(rs.getDate("dtCadastro"));
            u.setStatus(rs.getBoolean("status"));
            dados.add(u);
        }
        
        return dados;
    }
    
    public List<Usuario> getUsuarioByName(String nome) throws Exception{
        abrirConexao();
        
        String sql = "SELECT * FROM usuarios WHERE nome LIKE ?% AND status = 1";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, nome);
        rs = stmt.executeQuery();
        
        List<Usuario> dados = new ArrayList<>();
        
        
        while(rs.next()){
            Usuario u = new Usuario();
            u.setId(rs.getInt("id"));
            u.setNome(rs.getString("nome"));
            u.setCpf(rs.getString("cpf"));
            u.setUsername(rs.getString("username"));
            u.setPerfil_id(rs.getInt("perfis_id"));
            u.setDtCadastro(rs.getDate("dtCadastro"));
            u.setStatus(rs.getBoolean("status"));
            dados.add(u);
        }
        
        return dados;
    }
    
    public List<Usuario> getUsuariosInativos() throws Exception{
        abrirConexao();
        
        String sql = "SELECT * FROM usuarios WHERE status = 0";
        stmt = con.prepareStatement(sql);
        rs = stmt.executeQuery();
        
        List<Usuario> dados = new ArrayList<>();
        
        
        while(rs.next()){
            Usuario u = new Usuario();
            u.setId(rs.getInt("id"));
            u.setNome(rs.getString("nome"));
            u.setCpf(rs.getString("cpf"));
            u.setUsername(rs.getString("username"));
            u.setPerfil_id(rs.getInt("perfis_id"));
            u.setDtCadastro(rs.getDate("dtCadastro"));
            u.setStatus(rs.getBoolean("status"));
            dados.add(u);
        }
        
        return dados;
    
    }
    
    public void alteraStatusUsuario(int status, int id) throws Exception{
        abrirConexao();
        
        String sql = "UPDATE usuarios SET status = ? WHERE id = ?";
        stmt = con.prepareStatement(sql);
        stmt.setInt(1, status);
        stmt.setInt(2, id);
        stmt.execute();
        stmt.close();
        
        fecharConexao();
    }
    
    
}
