/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.Model;
import java.util.List;
import java.util.LinkedList;
import java.util.Date;
import java.util.Objects;
/**
 *
 * @author anderson
 */
public class Venda {
    private int id;
    private double valor;
    private List<ItemVenda> itens;
    private Date horario;
    private Cliente cliente;
    private UsuarioSistema usuario;
    private FormasPagamento formaPagamento;
    private int ativo;
    
    
    /*----- Construtor ----------*/
    public Venda(){
        id = 0;
        valor = 0;
        itens =  new LinkedList<>();
        horario = new Date();
        formaPagamento = new FormasPagamento();
        this.ativo = 1;
        
        
    
    }
    
    public Venda(int id, double valor, List<ItemVenda> itens, Date horario, Cliente cliente, UsuarioSistema usuario) {
        this.id = id;
        this.valor = valor;
        this.itens = itens;
        this.horario = horario;
        this.cliente = cliente;
        this.usuario = usuario;
    }
    /*-----------------------------*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public UsuarioSistema getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioSistema usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Venda{" + "valor=" + valor + ", itens=" + itens + ", horario=" + horario + ", cliente=" + cliente + ", usuario=" + usuario + '}';
    }

    public FormasPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormasPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.id;
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.valor) ^ (Double.doubleToLongBits(this.valor) >>> 32));
        hash = 17 * hash + Objects.hashCode(this.itens);
        hash = 17 * hash + Objects.hashCode(this.horario);
        hash = 17 * hash + Objects.hashCode(this.cliente);
        hash = 17 * hash + Objects.hashCode(this.usuario);
        hash = 17 * hash + Objects.hashCode(this.formaPagamento);
        hash = 17 * hash + this.ativo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Venda other = (Venda) obj;
        if (!Objects.equals(this.horario, other.horario)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.formaPagamento, other.formaPagamento)) {
            return false;
        }
        if (this.ativo != other.ativo) {
            return false;
        }
        return true;
    }
    

    
    
    public void addItemVenda(ItemVenda i){
        if(!itens.contains(i)){
             itens.add(i);
             valor+= i.getProduto().getValorUnidadeVenda() * i.getQuantidade();
        }
    
    }
    
    public void removeItemVenda(ItemVenda i){
        if(itens.contains(i)){
            itens.remove(i);
            valor -= i.getProduto().getValorUnidadeVenda() * i.getQuantidade();
        }
    }

    
    
}
