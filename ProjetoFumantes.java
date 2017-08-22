
package projetofumantes;

/**
 *
 * @author Bruno Dourado Miranda
 */
public class ProjetoFumantes {

    /**
     * @param args the command line arguments
     */
    public static Vendedor v= new Vendedor();
    public static Cliente um= new Cliente();
    public static Cliente dois = new Cliente();
    public static Cliente tres= new Cliente();
    
    public static void main(String[] args) {
    
        um= um.distribuiProdutoInicialmente("papel",um);// Cliente um recebe o recurso inicial;
        
        dois= dois.distribuiProdutoInicialmente("fumo",dois);// Cliente dois recebe o recurso inicial;
        
        tres= tres.distribuiProdutoInicialmente("fósforo",tres);// Cliente três recebe o recurso inicial;
        
        v=v.distribuiProdutoInicialmente(v);//distribui os produtos inicialmente;
        
        Thread cliente1= new Thread(um);//Cliente se prepara para ir a loja;
        cliente1.setName(um.getNomeInicialProduto());
        
        Thread cliente2= new Thread(dois);//Cliente se prepara para ir a loja;
        cliente2.setName(dois.getNomeInicialProduto());
        
        Thread cliente3= new Thread(tres);//Cliente se prepara para ir a loja;
        cliente3.setName(tres.getNomeInicialProduto());
        
        cliente1.start();//cliente um vai à loja;
        cliente2.start();//cliente dois vai à loja;
        cliente3.start();//cliente três vai à loja;
        
        v=v.vendaAtualmente(v);
    }
    
}
