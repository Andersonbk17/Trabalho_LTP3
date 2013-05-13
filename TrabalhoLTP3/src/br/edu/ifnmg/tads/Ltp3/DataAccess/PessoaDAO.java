/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.DataAccess;

import br.edu.ifnmg.tads.Ltp3.Model.Endereco;
import br.edu.ifnmg.tads.Ltp3.Model.Pessoa;
import br.edu.ifnmg.tads.Ltp3.Model.Telefone;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author modric
 */
public class PessoaDAO {
    private Bd banco;
    
    public PessoaDAO(){
        this.banco = new Bd();
    }
    
    public int Salvar(Pessoa obj){
        PreparedStatement comando;
        int id = 0;
        try{
            if(obj.getId() == 0){
               comando = banco.getConexao()
                        .prepareStatement("INSERT INTO pessoas (nome,rg,cpf,data_nascimento) VALUES (?,?,?,?)");
                comando.setString(1, obj.getNome());
                comando.setString(2, obj.getRg());
                comando.setString(3, obj.getCpf());
                //Date data = new Date();
                //comando.setDate(4, ); 
                
                //falta a data
                
                comando.executeUpdate();
                PreparedStatement comando2 = banco.getConexao().prepareStatement("SELECT MAX(id) FROM pessoas");
                ResultSet consulta = comando2.executeQuery();
                consulta.first();
                id = consulta.getInt("MAX(id)");
                
                comando.getConnection().commit();
                comando2.getConnection().commit();
                
            
            }else{
                comando = banco.getConexao()
                        .prepareStatement("UPDADE pessoas SET nome = ?, rg = ?, cpf = ?,data_nascimento = ? WHERE id = ?");
                comando.setString(1, obj.getNome());
                comando.setString(2, obj.getRg());
                comando.setString(3, obj.getCpf());
                comando.setInt(5, obj.getId());
                
                comando.executeUpdate();
                comando.getConnection().commit();
            
            }
            return id;
           }catch(SQLException ex){
                ex.printStackTrace();
                return 0;
            }
        
    }
    
    public boolean Abrir(int id) throws Exception{
        try{
            Pessoa pessoa = new Pessoa();
            PreparedStatement comando = banco.getConexao()
                    .prepareStatement("SELECT * FROM pessoas WHERE id = ?");
            comando.setInt(1, id);
            
            ResultSet consulta = comando.executeQuery();
            comando.getConnection().commit();
            
            if(consulta.first()){
                pessoa.setCpf(consulta.getString("cpf"));
                pessoa.setDataNascimento(consulta.getDate("data_nascimento"));
                pessoa.setId(id);
                pessoa.setNome(consulta.getString("nome"));
                pessoa.setRg(consulta.getString("rg"));
                
                
                //Preencher telefones
                PreparedStatement comando2 = banco.getConexao()
                        .prepareStatement("SELECT * from telefones WHERE id_pessoa = ?");
                comando2.setInt(1, id);
                
                ResultSet consulta2 = comando2.executeQuery();
                comando2.getConnection().commit();
                
                List<Telefone> listaTelefone = new LinkedList<>();
                while(consulta2.next()){
                    Telefone temp = new Telefone();
                    temp.setId(consulta2.getInt("id"));
                    temp.setDdd(consulta2.getInt("ddd"));
                    temp.setNumero(consulta2.getInt("numero"));
                    listaTelefone.add(temp);
                    
                }
                pessoa.setTelefones(listaTelefone);
                
                //Preencher Enderecos
                PreparedStatement comando3 = banco.getConexao()
                        .prepareStatement("SELECT * from enderecos WHERE id_pessoa = ?");
                comando2.setInt(1, id);
                
                ResultSet consulta3 = comando2.executeQuery();
                comando2.getConnection().commit();
                
                List<Endereco> listaEnderecos = new LinkedList<>();
                
            }
            
            
        
        
        }catch(SQLException ex){
        
            return null;
        }
    
    
    
    }
    
}
