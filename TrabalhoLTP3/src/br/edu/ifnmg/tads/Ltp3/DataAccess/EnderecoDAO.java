/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.DataAccess;

import br.edu.ifnmg.tads.Ltp3.Model.Endereco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/**
 *
 * @author modric
 */
public class EnderecoDAO {
    private Bd banco;
    
    public EnderecoDAO (){
        banco = new Bd();
    }
    
    public boolean Salvar(Endereco obj,int idPessoa){
        try{
            if(obj.getId() == 0){
                PreparedStatement comando = banco.getConexao()
                        .prepareStatement("INSERT INTO enderecos (rua,cep,bairro,numero,id_pessoa,cidade,estado) "
                        + "VALUES(?,?,?,?,?,?,?)");
                comando.setString(1, obj.getRua());
                comando.setString(2, obj.getCep());
                comando.setString(3, obj.getBairro());
                comando.setString(4, String.valueOf(obj.getNumero()));
                comando.setInt(5, idPessoa);
                comando.setString(6, obj.getCidade());
                comando.setString(7, obj.getEstado());
                
                comando.executeUpdate();
                comando.getConnection().commit();
            }
            
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
  
    
    }
    
    public boolean Apagar(Endereco obj){
        try{
            PreparedStatement comando = banco.getConexao()
                    .prepareStatement("DELETE FROM enderecos WHERE id= ?");
            comando.setInt(1, obj.getId());
            comando.getConnection().commit();
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    
    }
    
    public List<Endereco> listarTodos(int idPessoa){
        try{
            PreparedStatement comando = banco.getConexao()
                    .prepareStatement("SELECT * FROM enderecos");
            ResultSet consulta = comando.executeQuery();
            comando.getConnection().commit();
            List<Endereco> listaEnderecos = new LinkedList<>();
            
            while(consulta.next()){
                Endereco tmp = new Endereco();
                
                tmp.setBairro(consulta.getString("bairro"));
                tmp.setCep(consulta.getString("cpf"));
                tmp.setCidade(consulta.getString("cidade"));
                tmp.setEstado(consulta.getString("estado"));
                tmp.setId(consulta.getInt("id"));
                tmp.setNumero(Integer.parseInt(consulta.getString("numero")));
                tmp.setRua(consulta.getString("rua"));
                listaEnderecos.add(tmp);
            
            }
            
            return listaEnderecos;
            
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }
    
    
    public boolean ApagarTodosQuandoExcluiPessoa(int idPessoa){
        try{
            PreparedStatement comando = banco.getConexao()
                    .prepareStatement("DELETE FROM enderecos WHERE id_pessoa= ?");
            comando.setInt(1, idPessoa);
            comando.executeUpdate();
            comando.getConnection().commit();
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    
    }
    
}

