
package projetofumantes;

import static projetofumantes.ProjetoFumantes.v;

public class Cliente implements Runnable {
    
    private String nomeInicialProduto;// nome do produto inicial do fumante;
    private boolean[] produto= new boolean[3];// vetor de produtos;

    //Distribui processos inicialmente;
    public Cliente distribuiProdutoInicialmente(String nome, Cliente c) {
        setNomeInicialProduto(nome);

        if (nome.equals("papel")) {
            c.produto[0] = true;//papel;
            c.produto[1] = false;//fumo;
            c.produto[2] = false;//fosforo;
        } else {
            if (nome.equals("fumo")) {
                c.produto[0] = false;//papel;
                c.produto[1] = true;//fumo;
                c.produto[2] = false;//fósforo;
            } else {
                c.produto[0] = false;//papel;
                c.produto[1] = false;//fumo;
                c.produto[2] = true;//fósforo;
            }
        }

        return c;
    }
    
    /**
     * @return the nomeInicialProduto
     */
    public String getNomeInicialProduto() {
        return nomeInicialProduto;
    }

    /**
     * @param nomeInicialProduto the nomeInicialProduto to set
     */
    public void setNomeInicialProduto(String nomeInicialProduto) {
        this.nomeInicialProduto = nomeInicialProduto;
    }

    public boolean terminado(boolean disponivel[],Cliente c){
        int i=0; boolean terminado=true;
        while(terminado && i<=2){
            if(disponivel[i]){
                terminado=false;
            }
            i++;
        }
        return terminado;
    }

    @Override
    public void run() {
        boolean processamento = true;

        while (processamento) {

            try {
                // Caso o fumante precisar do recurso, ele fica com ele,
                // senão ele o devolve ao vendedor;
                boolean vendeu = false;
                boolean disponivel[] = v.balcaoDeVenda();

                
                for(int i=0;i<=2;i++){
                    if(produto[i]){
                        if(disponivel[i]){
                            vendeu=true;
                        }
                    }
                }
                
                if (!vendeu) {
                    System.out.println("O produto não foi vendido!\n");
                    v.liberaVendedor = true;
                } else {
                    System.out.println("O cliente já pode fumar.\n-----------------------\n");
                    v = v.vendaAtualmente(v);
                }

                
            } catch (Exception e) {
                System.out.println("Erro na execução!");
            }

        }
    }

 
    
    
}
