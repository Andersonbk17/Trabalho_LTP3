/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.DataAccess;

import br.edu.ifnmg.tads.Ltp3.Model.ErroValidacaoException;
import br.edu.ifnmg.tads.Ltp3.Model.Estoque;
import br.edu.ifnmg.tads.Ltp3.Model.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author aluno
 */
public class ProdutoDAO {
    private Bd bd;
    
    /*########  Construtor ############*/
    public ProdutoDAO(){
        bd = new Bd();
    }
    /*#################################*/
    
    
    public boolean Salvar(Produto obj){
        try{
            if(obj.getId() == 0){
                PreparedStatement comando = bd.getConexao()
                        .prepareStatement("INSERT INTO produtos (nome,descricao,valor_uni_Compra,valor_uni_Venda) VALUES (?,?,?,?)");
                comando.setString(1, obj.getNome());
                comando.setString(2, obj.getDescricao());
                comando.setDouble(3, obj.getValorUnidadeCompra());
                comando.setDouble(4,obj.getValorUnidadeVenda());
                
                comando.executeUpdate();
                
                //busca do id do produto
                PreparedStatement comando2 = bd.getConexao()
                        .prepareStatement("Select max(id)  FROM produtos");
                
                
                ResultSet consulta = comando2.executeQuery();
                consulta.first();
                
                //setando o estoque com o novo id
                PreparedStatement comando3 = bd.getConexao()
                        .prepareStatement("INSERT INTO estoques (id,quantidade) VALUES (?,?)");
                comando3.setInt(1,consulta.getInt("max(id)"));
                comando3.setInt(2, obj.getEstoque().getQuantidade());
                
                comando3.executeUpdate();
                
                comando.getConnection().commit();
                comando2.getConnection().commit();
                comando3.getConnection().commit();
                return true;
            }else{
            
                PreparedStatement comando = bd.getConexao()
                        .prepareStatement("UPDATE produtos SET nome = ?,descricao = ?,valor_uni_Compra = ?,valor_Uni_Venda =? WHERE id =?");
                comando.setString(1, obj.getNome());
                comando.setString(2, obj.getDescricao());
                comando.setDouble(3, obj.getValorUnidadeCompra());
                comando.setDouble(4, obj.getValorUnidadeVenda());
                comando.setInt(5, obj.getId());
                
                comando.executeUpdate();
            
                comando = bd.getConexao()
                        .prepareStatement("UPDATE estoques SET quantidade = ? WHERE id = ?");
                comando.setInt(1, obj.getEstoque().getQuantidade());
                comando.setInt(2, obj.getEstoque().getId());
                
                return true;
            
            }
        
        
        }catch(SQLException ex){
            new ErroValidacaoException(ex.getMessage());
            return false;
        
        }
     
    }
    
    public boolean Abrir(){
    
    return true;
    }
    
    public List<Produto> listarTodos() {
        List<Produto> produtos = new LinkedList<>();
        try{
            
            
            PreparedStatement comando = bd.getConexao()
                    .prepareStatement("SELECT p.id,nome,descricao,valor_Uni_Venda,valor_Uni_Compra,quantidade  FROM produtos p INNER JOIN estoques e on e.id = p.id");
            ResultSet consulta = comando.executeQuery();
            
            while(consulta.next()){
                Produto novo = new Produto();
                Estoque novoE = new Estoque();
                
                
                novo.setDescricao(consulta.getString("descricao"));
                try{
                    novo.setId(consulta.getInt("id"));
                    novo.setNome(consulta.getString("nome"));
                    novo.setValorUnidadeCompra(consulta.getDouble("valor_uni_Compra"));
                    novo.setValorUnidadeVenda(consulta.getDouble("valor_Uni_Venda"));

                    novoE.setId(consulta.getInt("id"));
                    novoE.setQuantidade(consulta.getInt("quantidade"));
                }catch(ErroValidacaoException ex){
                    ex.printStackTrace();
                }
                
                novo.setEstoque(novoE);
                
                produtos.add(novo);
                      
            }
            
            return produtos;
        
        
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    
    
    }
    
}



/*
 
 * salvar
 * 
 * for (Itemveda iv: itens){
 *  if(iv.getAtivo() == true){
 *      if(iv.getid() == 0){
 *          insert ...
 * }else{
 *          update
 * 
 * }else{
 *          delete
 * 
 * }
 * }
 * }
 
 * 
 * abrir
 * 
 * 
 * preparedStatemat cmd = con.prepareStatement("select * from itensVendas where venda = ?");
 * cmd.setInt(1,id);
 * ResultSet res = cmd.executeQuery();
 * List<IntemVenda> its = new LinkedList<ItenVenda>();
 * while(res.next()){
 *  itemVenda tmp = ...
 * 
 * its.add(tmp);
 * 
 * }
 
 *venda.setItens(its);
 
 
 
 */


//inserir com cliente

/*
 
 resultset resultado = comando.execulteQuery();
 * resultado.next();
 * venda tmp = new venda();
 * tmp.setId(resultado.getId('id'));
 * 
 * 
 * clientedao cli = new clientedao();
 * tmp.setcliente(cli.abrir(resultado.getInt("cliente")));
 * 
 * 
 * 
 * 
 * preparedStatement cmd = con.preapreStatemant(insert into venda(cliente) values(?....?))
 * cmd.setInt(obj.getVenda().getId());
 
 
 
 
 */