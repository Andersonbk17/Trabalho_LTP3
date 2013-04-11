/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.Model;

import java.util.Objects;

/**
 *
 * @author anderson
 */
public class UsuarioSistema  extends Pessoa{
    private int idUsuario;
    private String usuario;
    private String senha;
    
    /*--------Construtores ---------*/
    public UsuarioSistema(){
    
    }

    public UsuarioSistema(int idUsuario, String usuario, String senha) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.senha = senha;
    }
    
    /*-------------------------------*/

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.idUsuario;
        hash = 23 * hash + Objects.hashCode(this.usuario);
        hash = 23 * hash + Objects.hashCode(this.senha);
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
        final UsuarioSistema other = (UsuarioSistema) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UsuarioSistema{" + "usuario=" + usuario + '}';
    }
    
    
    
    
}
