/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofumantes;

import static java.lang.Thread.sleep;
import java.util.Random;
import static projetofumantes.ProjetoFumantes.v;

/**
 *
 * @author Universidade
 */
public class Vendedor {
     public  boolean[] vender= new boolean[3];
     public  boolean liberaVendedor=false;
     
    public Vendedor distribuiProdutoInicialmente(Vendedor v) {
        for (int i = 0; i <= 2; i++) {
            vender[i] = true;
        }
        return v;
    }
   
    public Vendedor vendaAtualmente(Vendedor v) {
        Random retiraVenda = new Random();
        
        // O vendedor libera dois produtos aleatórios para serem vendidos;
        for (int i = 0; i <= 2; i++) {
            vender[i] = true;
        }
        // e retira um;
        vender[retiraVenda.nextInt(3)] = false;
        liberaVendedor = true;

        return v;
    }
   
    public  synchronized boolean[] balcaoDeVenda() {
        //Enquanto o vendedor não liberar o acesso ao balcão, o fumante não ultrapassa esse ponto;
        //Quando ele libera, o cliente tem direito a acessar o balcao de venda, pede exclusividade
        // ao vendedor  e pega o recurso disponível somente pra ele;   
        try {
            while (!v.liberaVendedor) {
                //do_nothing;
            }

            System.out.println(Thread.currentThread().getName() + " viu recurso! ");
            v.liberaVendedor = false;
            sleep(2000);
            return vender;

        } catch (Exception e) {
            System.out.println("Erro!");
        }
        return vender;
    }
}
