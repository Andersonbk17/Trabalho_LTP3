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
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                        .prepareStatement("UPDATE produtos SET nome = ?,descricao = ?,valor_uni_Compra = ?,valor_uni_Venda =? WHERE id =?");
                comando.setString(1, obj.getNome());
                comando.setString(2, obj.getDescricao());
                comando.setDouble(3, obj.getValorUnidadeCompra());
                comando.setDouble(4, obj.getValorUnidadeVenda());
                comando.setInt(5, obj.getId());
                
                comando.executeUpdate();
            
                PreparedStatement comando2 = bd.getConexao()
                        .prepareStatement("UPDATE estoques SET quantidade = ? WHERE id = ?");
                comando2.setInt(1, obj.getEstoque().getQuantidade());
                comando2.setInt(2, obj.getEstoque().getId());
                
                comando.getConnection().commit();
                comando2.getConnection().commit();
                
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
                    .prepareStatement("SELECT p.id,nome,descricao,valor_uni_Venda,valor_Uni_Compra,quantidade  FROM produtos p INNER JOIN estoques e on e.id = p.id");
            ResultSet consulta = comando.executeQuery();
            
            while(consulta.next()){
                Produto novo = new Produto();
                Estoque novoE = new Estoque();
                
                
                novo.setDescricao(consulta.getString("descricao"));
                try{
                    novo.setId(consulta.getInt("id"));
                    novo.setNome(consulta.getString("nome"));
                    novo.setValorUnidadeCompra(consulta.getDouble("valor_uni_Compra"));
                    novo.setValorUnidadeVenda(consulta.getDouble("valor_uni_Venda"));

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
    
    
    public List<Produto> buscar(Produto filtro){
        try{
            String sql = "select p.id, p.nome, p.valor_uni_Compra, "
                    + "p.valor_uni_Venda, p.descricao, es.id as quantidade from "
                    + "produtos p INNER JOIN estoques es on es.id = p.id";
            String where = "";
            
            if(!filtro.getNome().isEmpty()){
                where = "nome like'%"+filtro.getNome()+"%'";
            }
            
            // Se tiver mais algum valor de compra
            if(filtro.getValorUnidadeCompra() >0 ){
                if(where.length() > 0){
                    where = where + " AND ";
                }
                where = where +" valor_uni_Compra = "+filtro.getValorUnidadeCompra();
            
            }
            
            // Se tiver mais algum valor de venda
            if(filtro.getValorUnidadeVenda() >0 ){
                if(where.length() > 0){
                    where = where + " AND ";
                }
                where = where +" valor_uni_Venda = "+filtro.getValorUnidadeVenda();
            
            }
            
            //Se tiver algum id
            if(filtro.getId() > 0 ){
                if(where.length() > 0){
                    where = where + " AND ";
                }
                where = where +" id = "+filtro.getId();
            
            }
            
            //Se tiver alguma descrição
            if(!filtro.getDescricao().isEmpty() ){
                if(where.length() > 0){
                    where = where + " AND ";
                }
                where = where +" descricao = "+filtro.getDescricao();
            
            }
            
            if(!where.isEmpty()){
                sql = sql + " WHERE " + where;
            }
            
            Statement comando = bd.getConexao().createStatement();
            
            ResultSet consulta = comando.executeQuery(sql);
            
            List<Produto> lista = new LinkedList<>();
            
            //Adiciona produtos a lista
            while(consulta.next()){
                Produto novo = new Produto();
                Estoque estoque = new Estoque();
                try {
                    novo.setId(consulta.getInt("p.id"));
                    novo.setValorUnidadeCompra(consulta.getDouble("p.valor_uni_Compra"));
                    novo.setValorUnidadeVenda(consulta.getDouble("p.valor_uni_Venda"));
                    novo.setNome(consulta.getString("p.nome"));
                    novo.setDescricao(consulta.getString("p.descricao"));
                    estoque.setId(consulta.getInt("es.id"));
                    estoque.setQuantidade(consulta.getInt("es.quantidade"));
                    
                } catch (ErroValidacaoException ex) {
                    Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                }
                
                lista.add(novo);
            
            }
            
            return lista;
        
        
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
        
    
    }
    
}

