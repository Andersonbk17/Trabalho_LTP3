/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.DataAccess;

import br.edu.ifnmg.tads.Ltp3.Model.Cliente;
import br.edu.ifnmg.tads.Ltp3.Model.FormasPagamento;
import br.edu.ifnmg.tads.Ltp3.Model.ItemVenda;
import br.edu.ifnmg.tads.Ltp3.Model.UsuarioSistema;
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
                    .getConexao().prepareStatement("INSERT INTO vendas (horario,id_usuario,"
                        + "id_cliente,id_tipo_pagamento,ativo,valor_total) VALUES "
                        + "(?,?,?,?,1,?)");
                Date data = new Date(obj.getHorario().getTime());
                comando.setDate(1, data);
                comando.setInt(2, obj.getUsuario().getIdUsuario());
                comando.setInt(3, obj.getCliente().getIdCliente());
                comando.setInt(4, obj.getFormaPagamento().getId());
                comando.setDouble(5, obj.getValor());
                //comando.setInt(5, obj.getAtivo());
                comando.executeUpdate();
                Statement comando0 = conexao.getConexao().createStatement();
                comando0.getConnection().commit();
                comando.getConnection().commit();//ver a hora de comitar
                
                ResultSet cons = comando0.executeQuery("SELECT max(id) FROM "
                        + "vendas");
                cons.first();
                int idVenda = cons.getInt("max(id)");
                
                ItemVendaDAO daoItemVenda = new ItemVendaDAO();
                
                daoItemVenda.Salvar(obj.getItens(), idVenda);
               
                
                
            
                
                ok = true;
                
            }    
        }catch(SQLException ex){
            
            ex.printStackTrace();
            return false;
        }
    return ok;
    
    }
    
    
    public List<Venda> listarTodas() throws Exception{
        try{
          
            PreparedStatement comando = conexao
                    .getConexao().prepareStatement("SELECT * FROM vendas WHERE ativo = 1");
            ResultSet consulta = comando.executeQuery();
            comando.getConnection().commit();
            
            List<Venda> listaVendas = new LinkedList<>();
            while(consulta.next()){
                Venda tmpVenda = new Venda();
                Cliente tmpCliente;
                FormasPagamento tmpFormaPagamento;
                UsuarioSistema tmpusuario;
                List<ItemVenda> listaDeItens;
                 
                
                
                UsuarioSistemaDAO daoUsuario = new UsuarioSistemaDAO();
                ClienteDAO daoCliente = new ClienteDAO();
                FormasPagamentoDAO daoFormasPagamento = new FormasPagamentoDAO();
                ItemVendaDAO daoItemVenda = new ItemVendaDAO();
                
                // Listando os usuarios da venda
                tmpusuario = daoUsuario.Abrir(consulta.getInt("id_usuario"));
                tmpFormaPagamento = daoFormasPagamento.Abrir(consulta.getInt("id_tipo_pagamento"));
                tmpCliente = daoCliente.Abrir(consulta.getInt("id_cliente"));
                listaDeItens = daoItemVenda.listarTodos(consulta.getInt("id"));
                //System.out.print(tmpCliente);
                
                
                tmpVenda.setId(consulta.getInt("id"));
                tmpVenda.setHorario(consulta.getDate("horario"));
                tmpVenda.setValor(consulta.getFloat("valor_total"));
                tmpVenda.setCliente(tmpCliente);
                tmpVenda.setFormaPagamento(tmpFormaPagamento);
                tmpVenda.setUsuario(tmpusuario);
                tmpVenda.setItens(listaDeItens);
                
                listaVendas.add(tmpVenda);
                
                
            
            }
            
            
            return listaVendas;
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    
    }
   
}
