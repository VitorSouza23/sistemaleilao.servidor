/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiimplementacao;

import cliente.Cliente;
import helpers.geradorid.GeradorId;
import helpers.gerenciadores.GerenciadorListaClientes;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import rmiinterfaces.cliente.IClienteLeilaoController;

/**
 *
 * @author Vitor
 */
public class ClienteLeilaoController extends UnicastRemoteObject implements IClienteLeilaoController {

    private final GerenciadorListaClientes _gerenciadorClientes;
    private final GeradorId _geradorId;

    public ClienteLeilaoController() throws RemoteException {
        super();
        this._gerenciadorClientes = GerenciadorListaClientes.getInstance();
        this._geradorId = GeradorId.getInstance();
    }

    @Override
    public Cliente cadstrarClienteNoServidor(Cliente cliente) throws RemoteException {
        if (cliente.getId() == 0) {
            cliente.setId(this._geradorId.getNewID());
        }
        if (this._gerenciadorClientes.add(cliente)) {
            return cliente;
        }

        return null;
    }

    @Override
    public boolean removerClienteDoServidor(Cliente cliente) throws RemoteException {
        if(this._gerenciadorClientes.remove(cliente)){
            this._geradorId.deleteID(cliente.getId());
            return true;
        }
        return false;
    }

}
