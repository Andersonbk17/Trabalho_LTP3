/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.DataAccess;

import br.edu.ifnmg.tads.Ltp3.Model.ErroValidacaoException;
import br.edu.ifnmg.tads.Ltp3.Model.Telefone;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author modric
 */
public class TelefoneDAO {
    private Bd banco;
    
    public TelefoneDAO(){
        banco = new Bd();
    }
    
    public boolean Salvar(Telefone obj, int idPessoa){
        try{
                if(obj.getId() == 0 ){
                PreparedStatement comando = banco
                        .getConexao().prepareStatement("INSERT INTO telefones (ddd,numero,id_pessoa) VALUES(?,?,?)");

                comando.setInt(1, obj.getDdd());
                comando.setInt(2, obj.getNumero());
                comando.setInt(3, idPessoa);

                comando.executeUpdate();
                comando.getConnection().commit();
                
            }
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    public Telefone Abrir(int id) {
        Telefone tmp = null;
        try{
            if(id != 0){
                PreparedStatement comando = banco.getConexao()
                        .prepareStatement("SELECT * FROM telefones WHERE id = ?");
                comando.setInt(1, id);
                ResultSet consulta = comando.executeQuery();
                comando.getConnection().commit();
                
                
                if(consulta.first()){
                    tmp = new Telefone();
                    tmp.setDdd(consulta.getInt("ddd"));
                    
                    tmp.setId(consulta.getInt("id"));
                    
                    tmp.setNumero(consulta.getInt("numero"));
                    
                }

            }
            return tmp;
        }catch(SQLException ex ){
            ex.printStackTrace();
            return null;
        }
        catch(ErroValidacaoException ex){
            return null;
        }
    
    
    }
    
    
    public boolean Apagar(Telefone obj){
        try{
            PreparedStatement comando = banco
                    .getConexao().prepareStatement("DELETE FROM telefones WHERE id = ?");
            comando.setInt(1, obj.getId());
            comando.executeUpdate();
            comando.getConnection().commit();
                    
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    
    }
    
    public List<Telefone> listarTodos(int idPessoa){
        try{
            PreparedStatement comando = banco.getConexao()
                    .prepareStatement("SELECT * FROM telefones");
            ResultSet consulta = comando.executeQuery();
            comando.getConnection().commit();
            List<Telefone> listaTelefones = new LinkedList<>();
            
            while(consulta.next()){
                Telefone tmp = new Telefone();
                tmp.setDdd(consulta.getInt("ddd"));
                tmp.setId(consulta.getInt("id"));
                tmp.setNumero(consulta.getInt("numero"));
                listaTelefones.add(tmp);
            }
            return listaTelefones;
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }catch(ErroValidacaoException ex){
            ex.printStackTrace();
            return null;
        }
    
    }
    
    public boolean ApagarTodosQuandoExcluiPessoa(int idPessoa){
        try{
            PreparedStatement comando = banco.getConexao()
                    .prepareStatement("DELETE FROM telefones WHERE id_pessoa= ?");
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
