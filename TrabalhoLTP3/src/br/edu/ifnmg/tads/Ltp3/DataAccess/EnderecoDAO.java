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
                        .prepareStatement("INSERT INTO enderecos (rua,cep,bairro,numero,id_pessoa,cidade,estado,ativo) "
                        + "VALUES(?,?,?,?,?,?,?,?)");
                comando.setString(1, obj.getRua());
                comando.setString(2, obj.getCep());
                comando.setString(3, obj.getBairro());
                comando.setString(4, String.valueOf(obj.getNumero()));
                comando.setInt(5, idPessoa);
                comando.setString(6, obj.getCidade());
                comando.setString(7, obj.getEstado());
                comando.setInt(8, obj.getAtivo());
                
                comando.executeUpdate();
                comando.getConnection().commit();
            }else{
                PreparedStatement comando = banco.getConexao()
                        .prepareStatement("UPDATE enderecos SET rua =? ,cep = ?"
                        + ",bairro= ?,numero = ?,id_pessoa = ?,cidade = ?,estado = ? ativo = ? WHERE id = ?");
                comando.setString(1, obj.getRua());
                comando.setString(2, obj.getCep());
                comando.setString(3, obj.getBairro());
                comando.setString(4, String.valueOf(obj.getNumero()));
                comando.setInt(5, idPessoa);
                comando.setString(6, obj.getCidade());
                comando.setString(7, obj.getEstado());
                comando.setInt(8, obj.getAtivo());
                comando.setInt(9, obj.getId());
                
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
                    .prepareStatement("UPDATE enderecos SET ativo = 0 WHERE id= ?");
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
                    .prepareStatement("SELECT * FROM enderecos WHERE id_pessoa = ? "
                    + "AND ativo = 1");
            comando.setInt(1, idPessoa);
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
    
    public Endereco Abrir(int idEndereco){
        try{
            PreparedStatement comando = banco.
                    getConexao().prepareStatement("SELECT * FROM enderecos WHERE id =? AND ativo = 1");
            comando.setInt(1, idEndereco);
            ResultSet consulta = comando.executeQuery();
            comando.getConnection().commit();
            
            Endereco tmp = null;
            if(consulta.first()){
                tmp = new Endereco();
                tmp.setBairro(consulta.getString("bairro"));
                tmp.setCep(consulta.getString("cpf"));
                tmp.setCidade(consulta.getString("cidade"));
                tmp.setEstado(consulta.getString("estado"));
                tmp.setId(consulta.getInt("id"));
                tmp.setNumero(Integer.parseInt(consulta.getString("numero")));
                tmp.setRua(consulta.getString("rua"));
            
            }
            
            return tmp;
        
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    
    
    
    }
    public boolean ApagarTodosQuandoExcluiPessoa(int idPessoa){
        try{
            PreparedStatement comando = banco.getConexao()
                    .prepareStatement("UPDATE enderecos SET ativo = 0 WHERE id_pessoa= ?");
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

