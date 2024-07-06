/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Configuracoes;
import DAL.ConfiguracoesDAL;

/**
 *
 * @author User
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
        if(configuracoes.getChaveApi().isEmpty())throw  new Exception("Informe a chave da Api por favor");
        if(configuracoes.getNomeBanco().isEmpty())throw  new Exception("Informe o nome do banco por favor");    
        config.updateConfiguracoes(configuracoes);
    }
}
