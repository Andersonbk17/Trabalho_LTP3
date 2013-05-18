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
                        .prepareStatement("INSERT INTO pessoas (nome,rg,cpf,"
                       + "data_nascimento,ativo) VALUES (?,?,?,?,?)");
                comando.setString(1, obj.getNome());
                comando.setString(2, obj.getRg());
                comando.setString(3, obj.getCpf());
                Date dataBd = new Date(obj.getDataNascimento().getTime());
                comando.setDate(4, dataBd);
                comando.setInt(5, obj.getAtivo());
                              
                comando.executeUpdate();
                PreparedStatement comando2 = banco.getConexao()
                        .prepareStatement("SELECT MAX(id) FROM pessoas WHERE ativo = 1");
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
                        .prepareStatement("UPDATE pessoas SET nome = ?, rg = ?, cpf = ?, "
                        + "data_nascimento = ? WHERE id = ? ");
                comando.setString(1, obj.getNome());
                comando.setString(2, obj.getRg());
                comando.setString(3, obj.getCpf());
                Date dataBd = new Date(obj.getDataNascimento().getTime());
                comando.setDate(4, dataBd);
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
    
    public Pessoa Abrir(int idPessoa) throws Exception{
        Pessoa pessoa = null;
        try{
            
            PreparedStatement comando = banco.getConexao()
                    .prepareStatement("SELECT * FROM pessoas WHERE id = ? ");
            comando.setInt(1, idPessoa);
            
            ResultSet consulta = comando.executeQuery();
            comando.getConnection().commit();
            
            if(consulta.first()){
                pessoa = new Pessoa();
                pessoa.setCpf(consulta.getString("cpf"));
                pessoa.setDataNascimento(consulta.getDate("data_nascimento"));
                pessoa.setId(idPessoa);
                pessoa.setNome(consulta.getString("nome"));
                pessoa.setRg(consulta.getString("rg"));
                //asd conferr a data
                
                //Preencher telefones
                
                List<Telefone> listaTelefones;
                
                TelefoneDAO daoTelefone = new TelefoneDAO();
                listaTelefones =  daoTelefone.listarTodos(idPessoa);
                pessoa.setTelefones(listaTelefones);
                System.out.print(listaTelefones);
                
                //Preencher Enderecos
                
                List<Endereco> listaEnderecos;
                EnderecoDAO daoEndereco = new EnderecoDAO();
                listaEnderecos = daoEndereco.listarTodos(idPessoa);
                pessoa.setEnderecos(listaEnderecos);
                System.out.print(listaEnderecos);      
                
                //Preenche emails
                
                List<Email> listaEmails = new LinkedList<>();
                
                EmailDAO daoEmails = new EmailDAO();
                listaEmails = daoEmails.listarTodos(idPessoa);
                pessoa.setEmails(listaEmails);
                System.out.print(listaEmails);
                
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
                    .prepareStatement("UPDATE pessoas SET ativo = 0 WHERE id = ?");
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
