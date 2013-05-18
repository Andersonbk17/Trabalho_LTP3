/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.DataAccess;

import br.edu.ifnmg.tads.Ltp3.Model.ErroValidacaoException;
import br.edu.ifnmg.tads.Ltp3.Model.ItemVenda;
import br.edu.ifnmg.tads.Ltp3.Model.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author modric
 */
public class ItemVendaDAO {
    private Bd conexao;
    
    public ItemVendaDAO(){
        conexao = new Bd();
    }
    
    public boolean Salvar(List<ItemVenda> obj, int idVenda){
        try{
            for(ItemVenda iv : obj){
                    if(iv.getId() == 0){
                        PreparedStatement comando1 = conexao
                                .getConexao().prepareStatement("INSERT INTO itens_venda "
                                + "(id_produto,id_venda,quantidade) VALUES (?,?,?)");
                        comando1.setInt(1, iv.getProduto().getId());
                        comando1.setInt(2, idVenda);
                        comando1.setInt(3, iv.getQuantidade());
                        comando1.executeUpdate();
                        comando1.getConnection().commit();
                    
                    }
            }
        return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        
        }
   }
    
    
    public List<ItemVenda> listarTodos(int idVenda) throws ErroValidacaoException, Exception{
        try{
            PreparedStatement comando = conexao
                    .getConexao().prepareStatement("SELECT * FROM itens_venda WHERE id_venda = ?");
            comando.setInt(1, idVenda);
            ResultSet consulta = comando.executeQuery();
            comando.getConnection().commit();
            
            List<ItemVenda> listaDeItens = new LinkedList<>();
            
            ProdutoDAO daoProduto = new ProdutoDAO();
            
            while(consulta.next()){
                ItemVenda tmp = new ItemVenda();
                Produto tmpProduto = new Produto();
                
                tmpProduto = daoProduto.Abrir(consulta.getInt("id_produto"));
                
                tmp.setId(consulta.getInt("id")); 
                tmp.setQuantidade(consulta.getInt("quantidade"));
                tmp.setProduto(tmpProduto);
                
                listaDeItens.add(tmp);
            
            }
                    
        return listaDeItens;
            
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        
        
        }
    
    }
    
}
