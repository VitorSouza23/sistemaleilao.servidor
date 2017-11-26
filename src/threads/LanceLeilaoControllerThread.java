/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import helpers.rmicofigs.RMIHelper;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmiimplementacao.LanceLeilaoController;

/**
 *
 * @author Vitor
 */
public class LanceLeilaoControllerThread extends Thread{
    private Registry registro;
    
    @Override
    public void run() {
        try {
            System.out.println("Inializando thread de controle de lances...");
            this.registro = LocateRegistry.createRegistry(RMIHelper.LANCE_LEILAO_CONTROLLER_PORT);
            this.registro.bind(RMIHelper.LANCE_LEILAO_CONTROLLER_NAEME, new LanceLeilaoController());
            System.out.println("Thred de controle de lances: status [OK]");
            System.out.println("\tOuvindo requisições...");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
