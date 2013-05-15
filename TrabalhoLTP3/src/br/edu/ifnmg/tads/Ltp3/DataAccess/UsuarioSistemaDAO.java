/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.DataAccess;

import br.edu.ifnmg.tads.Ltp3.Model.ErroValidacaoException;
import br.edu.ifnmg.tads.Ltp3.Model.Pessoa;
import br.edu.ifnmg.tads.Ltp3.Model.UsuarioSistema;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author modric
 */
public class UsuarioSistemaDAO {
    private Bd banco;
    
    public UsuarioSistemaDAO(){
        banco = new Bd();
    }
    
    public boolean Salvar(UsuarioSistema obj) throws ErroValidacaoException, Exception{
        try{
            
            PessoaDAO dao = new PessoaDAO();
            Pessoa tempPessoa = new Pessoa();
            
            tempPessoa.setCpf(obj.getCpf());
            tempPessoa.setDataNascimento(obj.getDataNascimento());
            tempPessoa.setEmails(obj.getEmails());
            tempPessoa.setEnderecos(obj.getEnderecos());
            tempPessoa.setNome(obj.getNome());
            tempPessoa.setRg(obj.getRg());
            tempPessoa.setTelefones(obj.getTelefones());
            
            int id = dao.Salvar(tempPessoa);
            
            PreparedStatement comando = banco.getConexao()
                    .prepareStatement("INSERT INTO usuarios_sistema (usuario,senha, id_pessoa) VALUES(?,?,?)");
            comando.setString(1, obj.getUsuario());
            comando.setString(2, obj.getSenha());
            comando.setInt(3, id);
            comando.executeUpdate();
            comando.getConnection().commit();
            return true;
        }catch(SQLException ex ){
            ex.printStackTrace();
            return false;
        }
    
    }
    
}
