/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.Model;

import br.edu.ifnmg.tads.Ltp3.DataAccess.ProdutoDAO;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author anderson
 */
public class NewClass {
    public static void main (String [] args) throws ErroValidacaoException {
        
        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> produtos = new LinkedList<>();
        
        produtos = dao.listarTodos();
        System.out.print(produtos);
    
    }
}
