/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author User
 */
public class Configuracoes {

    private String nomeBanco;
    private String chaveApi;

    public Configuracoes(String nomeBanco, String chaveApi) {
        this.nomeBanco = nomeBanco;
        this.chaveApi = chaveApi;
    }
      
    public Configuracoes() {
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    public String getChaveApi() {
        return chaveApi;
    }

    public void setChaveApi(String chaveApi) {
        this.chaveApi = chaveApi;
    }
    
    

}
