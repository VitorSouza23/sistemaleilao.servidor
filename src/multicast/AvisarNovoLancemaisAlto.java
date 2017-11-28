/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multicast;

import helpers.multcastconfig.MultcastConfig;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

/**
 *
 * @author Vitor
 */
public class AvisarNovoLancemaisAlto {
    private final MulticastSocket _soket;

    public AvisarNovoLancemaisAlto() throws IOException {
        this._soket = new MulticastSocket();
    }
    
    public void enviarAviso() throws UnknownHostException, IOException{
        System.out.println("Avisando sobre novo lance mais alto...");
        String mensagem = MultcastConfig.YES_MESSAGE;
        byte[] buffer = mensagem.getBytes();
        DatagramPacket msgOut = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(MultcastConfig.MULTCAST_ADDRESS), MultcastConfig.MULTCAST_PORT);
        this._soket.send(msgOut);
        System.out.println("Mensagem enviada!");
    }
    
}
