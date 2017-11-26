/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiimplementacao;

import helpers.geradorid.GeradorId;
import helpers.gerenciadores.GerenciadorListaProdutos;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import produto.Produto;
import rmiinterfaces.produto.IProdutoLeilaoController;

/**
 *
 * @author Vitor
 */
public class ProdutoLeilaoController extends UnicastRemoteObject implements IProdutoLeilaoController{
    private final GerenciadorListaProdutos _gerenciadorProdutos;
    private final GeradorId _geradorId;
    
    public ProdutoLeilaoController() throws RemoteException{
        super();
        this._gerenciadorProdutos = GerenciadorListaProdutos.getInstance();
        this._geradorId = GeradorId.getInstance();
    }

    @Override
    public Produto adicionarProduto(Produto produto) throws RemoteException {
        if(produto.getId() == 0){
            produto.setId(this._geradorId.getNewID());
        }
        if(this._gerenciadorProdutos.add(produto)){
            return produto;
        }
        return null;
    }

    @Override
    public boolean removerProduto(Produto produto) throws RemoteException {
        if(this._gerenciadorProdutos.remove(produto)){
            this._geradorId.deleteID(produto.getId());
            return true;
        }
        return false;
    }

    @Override
    public List<Produto> getAllProdutos() throws RemoteException {
        return this._gerenciadorProdutos.getAll();
    }
    
}
