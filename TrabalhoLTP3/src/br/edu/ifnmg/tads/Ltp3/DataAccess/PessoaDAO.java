/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.DataAccess;

import br.edu.ifnmg.tads.Ltp3.Model.Email;
import br.edu.ifnmg.tads.Ltp3.Model.Endereco;
import br.edu.ifnmg.tads.Ltp3.Model.Pessoa;
import br.edu.ifnmg.tads.Ltp3.Model.Telefone;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.sql.Date;

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
        PreparedStatement comando = null;
        int id = 0;
        try{
            if(obj.getId() == 0){
               comando = banco.getConexao()
                        .prepareStatement("INSERT INTO pessoas (nome,rg,cpf,data_nascimento) VALUES (?,?,?,?)");
                comando.setString(1, obj.getNome());
                comando.setString(2, obj.getRg());
                comando.setString(3, obj.getCpf());
                Date dataBd = new Date(obj.getDataNascimento().getTime());
                comando.setDate(4, dataBd);
                              
                comando.executeUpdate();
                PreparedStatement comando2 = banco.getConexao().prepareStatement("SELECT MAX(id) FROM pessoas");
                ResultSet consulta = comando2.executeQuery();
                consulta.first();
                id = consulta.getInt("MAX(id)");
                comando.getConnection().commit(); //verificar
                //Inserindo os enderecos
                
                if(!obj.getEnderecos().isEmpty()){
                    List<Endereco> listaEnderecos = obj.getEnderecos();
                    EnderecoDAO daoEndereco = new EnderecoDAO();

                    for(Endereco e : listaEnderecos){
                        daoEndereco.Salvar(e, id);

                    }
                }
                
                // Inserindo os telefones
                
                if(!obj.getTelefones().isEmpty()){
                    List<Telefone> listaTelefone = obj.getTelefones();
                    TelefoneDAO daoTelefone = new TelefoneDAO();
                    
                    for(Telefone t : listaTelefone){
                        daoTelefone.Salvar(t,id);
                    }
                
                
                }
                
                //Inserindo os Emails
                
                if(!obj.getEmails().isEmpty()){
                    List<Email> listaEmails = obj.getEmails();
                    EmailDAO daoEmail = new EmailDAO();
                    
                    for(Email e : listaEmails){
                        daoEmail.Salvar(e, id);
                    }
                }
                
                
                
                //comando.getConnection().commit();
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
    
    public Pessoa Abrir(int id) throws Exception{
        Pessoa pessoa = null;
        try{
            
            PreparedStatement comando = banco.getConexao()
                    .prepareStatement("SELECT * FROM pessoas WHERE id = ?");
            comando.setInt(1, id);
            
            ResultSet consulta = comando.executeQuery();
            comando.getConnection().commit();
            
            if(consulta.first()){
                pessoa = new Pessoa();
                pessoa.setCpf(consulta.getString("cpf"));
                pessoa.setDataNascimento(consulta.getDate("data_nascimento"));
                pessoa.setId(id);
                pessoa.setNome(consulta.getString("nome"));
                pessoa.setRg(consulta.getString("rg"));
                //asd conferr a data
                
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
                comando3.setInt(1, id);
                
                ResultSet consulta3 = comando3.executeQuery();
                comando3.getConnection().commit();
                
                List<Endereco> listaEnderecos = new LinkedList<>();
                while(consulta3.next()){
                    Endereco endereco = new Endereco();
                    endereco.setBairro(consulta3.getString("bairro"));
                    endereco.setCep(consulta3.getString("cep"));
                    endereco.setCidade(consulta3.getString("cidade"));
                    endereco.setEstado(consulta3.getString("estado"));
                    endereco.setId(consulta3.getInt("id"));
                    endereco.setNumero(Integer.parseInt(consulta3.getString("numero")));
                    endereco.setRua(consulta3.getString("rua"));
                    listaEnderecos.add(endereco);
                    
                    
                }
                
                pessoa.setEnderecos(listaEnderecos);
                
                //Preenche emails
                PreparedStatement comando4 = banco.getConexao()
                        .prepareStatement("SELECT * FROM emails WHERE id_pessoa = ?");
                comando4.setInt(1, id);
                
                ResultSet consulta4 = comando4.executeQuery();
                comando4.getConnection().commit();
                List<Email> listaEmails = new LinkedList<>();
                while(consulta4.next()){
                    Email temp = new Email();
                    temp.setEndereco(consulta4.getString("endereco"));
                    temp.setId(consulta4.getInt("id"));
                    listaEmails.add(temp);
                    
                }
                pessoa.setEmails(listaEmails);
                
                
            }
            
            return pessoa;    
        
        
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    
    
    
    }
    
    public boolean Apagar(int id){
       // boolean ok = false;
        try{
           EmailDAO emailDAO = new EmailDAO();
           TelefoneDAO telefoneDAO= new TelefoneDAO();
           EnderecoDAO enderecoDAO = new EnderecoDAO();
                      
           emailDAO.ApagarTodosQuandoExcluiPessoa(id);
           telefoneDAO.ApagarTodosQuandoExcluiPessoa(id);
           enderecoDAO.ApagarTodosQuandoExcluiPessoa(id);
            
            PreparedStatement comando = banco.getConexao()
                    .prepareStatement("DELETE FROM pessoas WHERE id = ?");
            comando.setInt(1, id);
            comando.executeUpdate();
            comando.getConnection().commit();
            return true;
            
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    
    
    }
    
    
    
    
    
    
}
