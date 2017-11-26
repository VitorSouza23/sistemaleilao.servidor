/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import threads.ClienteLeilaoControllerThread;
import threads.LanceLeilaoControllerThread;
import threads.ProdutoLeilaoControllerThread;

/**
 *
 * @author Vitor
 */
public class ServidorStarter {
    public static void main(String[] args) {
        ClienteLeilaoControllerThread clct = new ClienteLeilaoControllerThread();
        clct.start();
        ProdutoLeilaoControllerThread plct = new ProdutoLeilaoControllerThread();
        plct.start();
        LanceLeilaoControllerThread llct = new LanceLeilaoControllerThread();
        llct.start();
    }
}
