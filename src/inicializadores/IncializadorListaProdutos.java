/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicializadores;

import helpers.gerenciadores.GerenciadorListaProdutos;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;
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
        List<inicializadores.webservice.Produto> webserviceList = obterTodosOsProdutos();
        for(inicializadores.webservice.Produto webProduto : webserviceList){
            Produto prodtoAux = new Produto(webProduto.getNome(), webProduto.getDescricao(), webProduto.getLanceInicial(), true);
            produtoLeilaoController.adicionarProduto(prodtoAux);
        }
       
    }

    private static java.util.List<inicializadores.webservice.Produto> obterTodosOsProdutos() {
        inicializadores.webservice.SistemaLeilaoWebService_Service service = new inicializadores.webservice.SistemaLeilaoWebService_Service();
        inicializadores.webservice.SistemaLeilaoWebService port = service.getSistemaLeilaoWebServicePort();
        return port.obterTodosOsProdutos();
    }
}
