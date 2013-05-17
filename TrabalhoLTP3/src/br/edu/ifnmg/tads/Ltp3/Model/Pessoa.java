/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.Model;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author anderson
 */
public class Pessoa {
    private int id;
    private String nome;
    private String rg;
    private String cpf;
    private Date dataNascimento;
    private List<Endereco> Enderecos;
    private List<Email> Emails;
    private List<Telefone> Telefones;
    private int ativo;
    

    /*-------- Construtores -----------*/
    public Pessoa(){
        this.dataNascimento = new Date();
        this.id = 0;
        this.nome = "";
        this.cpf = "";
        this.rg = "";
        this.Emails = new LinkedList<>();
        this.Enderecos = new LinkedList<>();
        this.Telefones = new LinkedList<>();
        this.ativo = 1;
        
    
    
    }

    public Pessoa(int id, String nome, String rg, String cpf, Date dataNascimento, List<Endereco> Enderecos, List<Email> Emails, List<Telefone> Telefones) {
        this.id = id;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.Enderecos = Enderecos;
        this.Emails = Emails;
        this.Telefones = Telefones;
    }
    
    
    
    /*-----------------------------------*/
    public int getId() {
        return id;
    }

   public void setId(int id) throws ErroValidacaoException  {
        if(id < 0 ) {
           throw new ErroValidacaoException("O id não pode ser menor que 0 !");
       }
        else {
           this.id = id;
       }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws ErroValidacaoException{
        if(nome.length() < 3 || nome.length() > 255) {
            throw new ErroValidacaoException("O nome deve ser maior que 3 caracteres e menor que 255 caracteres !");
        }
        else {
            this.nome = nome;
        }
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
        
    }

    public void setDataNascimento(Date dataNascimento) throws Exception{
        Date dataMinima = new Date("1990/01/01");
        if(!dataNascimento.before(dataMinima)) {
            this.dataNascimento = dataNascimento;
        }
        else {
            throw new Exception ("A data não pode ser inferior a 01/01/1990");
        }
    }

    public List<Endereco> getEnderecos() {
        return Enderecos;
    }

    public void setEnderecos(List<Endereco> Enderecos) {
        this.Enderecos = Enderecos;
    }

    public List<Email> getEmails() {
        return Emails;
    }

    public void setEmails(List<Email> Emails) {
        this.Emails = Emails;
    }

    public List<Telefone> getTelefones() {
        return Telefones;
    }

    public void setTelefones(List<Telefone> Telefones) {
        this.Telefones = Telefones;
    }
    
    public void addEmail(Email email){
        if(!this.Emails.equals(email)){
            this.Emails.add(email);
        }
    
    }
    
    public void addTelefone(Telefone telefone){
        if(!this.Telefones.equals(telefone)){
            this.Telefones.add(telefone);
        }
    }
    
    public void removeEmail(Email email){
        if(this.Emails.equals(email)){
            this.Emails.remove(email);
        }
    
    }
    
    
    public void removeTelefone(Telefone telefone){
        if(!this.Telefones.equals(telefone)){
            this.Telefones.add(telefone);
        }
    }
    
    
    public void addEndereco(Endereco endereco){
        if(!this.Enderecos.equals(endereco)){
            Enderecos.add(endereco);
        }
    }
    
    public void removeEndereco(Endereco endereco){
        if(this.Enderecos.equals(endereco)){
            this.Enderecos.remove(endereco);
        }
    
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.id;
        hash = 11 * hash + Objects.hashCode(this.nome);
        hash = 11 * hash + Objects.hashCode(this.rg);
        hash = 11 * hash + Objects.hashCode(this.cpf);
        hash = 11 * hash + Objects.hashCode(this.dataNascimento);
        hash = 11 * hash + Objects.hashCode(this.Enderecos);
        hash = 11 * hash + Objects.hashCode(this.Emails);
        hash = 11 * hash + Objects.hashCode(this.Telefones);
        hash = 11 * hash + this.ativo;
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
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (this.ativo != other.ativo) {
            return false;
        }
        return true;
    }

   
    @Override
    public String toString() {
        return this.nome ;
    }
 
}
