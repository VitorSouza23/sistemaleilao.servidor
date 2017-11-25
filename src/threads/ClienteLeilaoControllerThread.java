/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import helpers.rmicofigs.RMIHelper;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmiimplementacao.ClienteLeilaoController;

/**
 *
 * @author Vitor
 */
public class ClienteLeilaoControllerThread extends Thread{
    private Registry registro;
    
    @Override
    public void run() {
        try {
            System.out.println("Inializando thread de controle de clientes...");
            this.registro = LocateRegistry.createRegistry(RMIHelper.CLIENTE_LEILAO_CONTROLLER_PORT);
            this.registro.bind(RMIHelper.CLIENTE_LEILAO_CONTROLLER_NAEME, new ClienteLeilaoController());
            System.out.println("Thred de controle de clientes: status [OK]");
            System.out.println("\tOuvindo requisições...");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
    
}
