/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiimplementacao;

import exceptions.lance.ValorLanceInvalidoException;
import helpers.geradorid.GeradorId;
import helpers.gerenciadores.GerenciadorListaLances;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import lance.Lance;
import rmiinterfaces.lance.ILanceLeiaoController;

/**
 *
 * @author Vitor
 */
public class LanceLeilaoController extends UnicastRemoteObject implements ILanceLeiaoController{
    
    private final GerenciadorListaLances _gerneciadorListaLances;
    private final GeradorId _geradorId;
    
    public LanceLeilaoController() throws RemoteException{
        super();
        this._gerneciadorListaLances = GerenciadorListaLances.getInstance();
        this._geradorId = GeradorId.getInstance();
    }

    @Override
    public Lance fazerUmLance(Lance lance) throws RemoteException, ValorLanceInvalidoException {
        if(lance.getValor() < this._gerneciadorListaLances.getLanceMaisAltoProduto(lance.getProduto()).getValor()){
            throw new ValorLanceInvalidoException("O valor do lance é menor que o valor de lance mais alto no momento!");
        }
        lance.setId(this._geradorId.getNewID());
        this._gerneciadorListaLances.add(lance);
        //Avisar a todos os cliente o valor no novo lance
        
        return lance;
        
    }

    @Override
    public boolean removerLance(Lance lance) throws RemoteException {
        if(this._gerneciadorListaLances.remove(lance)){
            this._geradorId.deleteID(lance.getId());
            return true;
        }
        return false;
    }

    @Override
    public List<Lance> getAlllances() throws RemoteException {
        return this._gerneciadorListaLances.getAll();
    }
    
}
