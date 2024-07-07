/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.*;
import DAL.*;

/**
 *
 */
public class ConfiguracoesController {
    private final ConfiguracoesDAL config = new ConfiguracoesDAL();
    
    /**
     * 
     * @param configuracoes
     * @throws Exception 
     * funcao que atualizara os dados de configuracoes disponiveis
     */
    public void updateConfiguracoes(Configuracoes configuracoes) throws Exception{
        if(configuracoes.getPeriodo_grafico().isEmpty())throw  new Exception("Informe a periodo desejado, por favor");
        config.updateConfiguracoes(configuracoes);
    }
    
    public String consultarPeridoDoGrafico(){
        String periodo = config.consultarPeridoDoGrafico();
        return periodo;
    }
}
