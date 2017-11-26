/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import helpers.rmicofigs.RMIHelper;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmiimplementacao.ProdutoLeilaoController;

/**
 *
 * @author Vitor
 */
public class ProdutoLeilaoControllerThread extends Thread{
    private Registry registro;

    @Override
    public void run() {
        try {
            System.out.println("Incicializando thread de controle de produtos...");
            this.registro = LocateRegistry.createRegistry(RMIHelper.PRODUTO_LEILAO_CONTROLLER_PORT);
            this.registro.bind(RMIHelper.PRODUTO_LEILAO_CONTROLLER_NAEME, new ProdutoLeilaoController());
            System.out.println("Thread de controle de produtos: status [OK]");
            System.out.println("\tOuvindo requisições...");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
    
    
}
