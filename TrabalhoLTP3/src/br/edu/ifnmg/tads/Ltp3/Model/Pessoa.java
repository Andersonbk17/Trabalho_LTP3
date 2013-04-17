/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.Model;
import java.util.List;
import java.util.Date;
import java.util.LinkedList;
import java.util.Objects;

/**
 *
 * @author anderson
 */
public class Pessoa {
    private int id;
    private String nome;
    private int rg;
    private String cpf;
    private Date dataNascimento;
    private List<Endereco> Enderecos;
    private List<Email> Emails;
    private List<Telefone> Telefones;
    //Falta add item etc...

    /*-------- Construtores -----------*/
    public Pessoa(){
    dataNascimento = new Date();
    
    }

    public Pessoa(int id, String nome, int rg, String cpf, Date dataNascimento, List<Endereco> Enderecos, List<Email> Emails, List<Telefone> Telefones) {
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
        if(id < 0 )
               throw new ErroValidacaoException("O id não pode ser menor que 0 !");
        else
            this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws ErroValidacaoException{
        if(nome.length() < 3 || nome.length() > 255)
            throw new ErroValidacaoException("O nome deve ser maior que 3 caracteres e menor que 255 caracteres !");
        else
            this.nome = nome;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
        hash = 67 * hash + Objects.hashCode(this.nome);
        hash = 67 * hash + this.rg;
        hash = 67 * hash + Objects.hashCode(this.cpf);
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
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + '}';
    }
    
    
    
    
    
}
