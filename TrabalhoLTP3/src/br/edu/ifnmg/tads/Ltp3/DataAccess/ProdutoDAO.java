/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.DataAccess;

import br.edu.ifnmg.tads.Ltp3.Model.Produto;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
                        .prepareStatement("INSERT INTO produtos (nome,descricao,valorUnidadeCompra,valorUnidadeVenda) VALUES (?,?,?,?)");
                comando.setString(1, obj.getNome());
                comando.setString(2, obj.getDescricao());
                comando.setDouble(3, obj.getValorUnidadeCompra());
                comando.setDouble(4,obj.getValorUnidadeVenda());
                
                // falta inserir o estoque            
            }else{
            
                PreparedStatement comando = bd.getConexao()
                        .prepareStatement("UPDATE");
            
            
            }
        
        
        }catch(SQLException ex){}
        
        
        
        
        
        
        return false;
    
    
    
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