/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.DataAccess;

import br.edu.ifnmg.tads.Ltp3.Model.ItemVenda;
import br.edu.ifnmg.tads.Ltp3.Model.Venda;
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
public class VendaDAO {
    private Bd conexao;
    
    public VendaDAO(){
        conexao = new Bd();
    }
    
    
    public boolean Salvar(Venda obj){
        boolean ok = false;
        try{
            if(obj.getId() == 0){
                PreparedStatement comando = conexao
                    .getConexao().prepareStatement("INSERT INTO vendas (horario,id_usuario, "
                        + "id_cliente,id_tipo_pagamento) VALUES (?,?,?,?)");
                Date data = new Date(obj.getHorario().getTime());
                comando.setDate(1, data);
                comando.setInt(2, obj.getUsuario().getIdUsuario());
                comando.setInt(3, obj.getCliente().getIdCliente());
                comando.setInt(4, obj.getFormaPagamento().getId());
                comando.executeUpdate();
                Statement comando0 = conexao.getConexao().createStatement();
                comando0.getConnection().commit();
                comando.getConnection().commit();//ver a hora de comitar
                ResultSet cons = comando0.executeQuery("SELECT max(id) FROM vendas");
                cons.first();
                int idVenda = cons.getInt("max(id)");
                
                
                for(ItemVenda iv : obj.getItens()){
                    if(iv.getId() == 0){
                        PreparedStatement comando1 = conexao
                                .getConexao().prepareStatement("INSERT INTO itens_venda "
                                + "(id_produto,id_venda,quantidade,id_tipo_pagamento) VALUES (?,?,?,?)");
                        comando1.setInt(1, iv.getProduto().getId());
                        comando1.setInt(2, idVenda);
                        comando1.setInt(3, iv.getQuantidade());
                        comando1.setInt(4, obj.getFormaPagamento().getId());
                        comando1.executeUpdate();
                        comando1.getConnection().commit();
                    
                    }
                
                
                }
            
                
                ok = true;
                
            }    
        }catch(SQLException ex){
            
            ex.printStackTrace();
            return false;
        }
    return ok;
    
    }
    
    
   /* public List<Vendas> listarTodas(){
        try{
            PreparedStatement comando = conexao
                    .getConexao().prepareStatement("select v.id,horario,us.id "
                    + "as usuario,c.id as cliente,tp.id as tipo FROM vendas v "
                    + "INNER JOIN usuarios_sistema us on us.id = v.id INNER JOIN "
                    + "clientes c on c.id = v.id_cliente INNER JOIN tipo_pagamento "
                    + "tp on tp.id = v.id_tipo_pagamento");
            ResultSet consulta = comando.executeQuery();
            
            List<Venda> listaVendas = new LinkedList<>();
            while(consulta.next()){
                Venda tmp = new Venda();
                tmp.set
            
            }
            
            
            
        }catch(SQLException ex){
        
        }
    
    }
    * */
}
