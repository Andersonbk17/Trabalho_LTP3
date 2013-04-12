/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.Model;
import java.util.List;
import java.util.LinkedList;
import java.util.Date;
import java.util.Objects;
import javax.swing.text.AbstractDocument;
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
    
    
    /*----- Construtor ----------*/
    public Venda(){
        id = 0;
        valor = 0;
        itens =  new LinkedList<ItemVenda>();
        horario = new Date();
        
        
    
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.valor) ^ (Double.doubleToLongBits(this.valor) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.itens);
        hash = 97 * hash + Objects.hashCode(this.horario);
        hash = 97 * hash + Objects.hashCode(this.cliente);
        hash = 97 * hash + Objects.hashCode(this.usuario);
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
        if (Double.doubleToLongBits(this.valor) != Double.doubleToLongBits(other.valor)) {
            return false;
        }
        if (!Objects.equals(this.itens, other.itens)) {
            return false;
        }
        if (!Objects.equals(this.horario, other.horario)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
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
