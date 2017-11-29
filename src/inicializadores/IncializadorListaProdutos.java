/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicializadores;

import helpers.gerenciadores.GerenciadorListaProdutos;
import java.io.IOException;
import java.rmi.RemoteException;
import produto.Produto;
import rmiimplementacao.LanceLeilaoController;
import rmiimplementacao.ProdutoLeilaoController;

/**
 *
 * @author Vitor
 */
public class IncializadorListaProdutos {
    public static void inicializarListaDeProdutos() throws RemoteException, IOException{
        ProdutoLeilaoController produtoLeilaoController = new ProdutoLeilaoController();
        
        Produto produto = new Produto("Produto 1", "Descrição 1", 10, true);
        produtoLeilaoController.adicionarProduto(produto);
        produto = new Produto("Produto 2", "Descrição 2", 20, true);
        produtoLeilaoController.adicionarProduto(produto);
        produto = new Produto("Produto 3", "Descrição 3", 30, true);
        produtoLeilaoController.adicionarProduto(produto);
        produto = new Produto("Produto 4", "Descrição 4", 40, true);
        produtoLeilaoController.adicionarProduto(produto);
        produto = new Produto("Produto 5", "Descrição 5", 50, true);
        produtoLeilaoController.adicionarProduto(produto);
    }
}
