/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 */
public class Configuracoes {
    private String periodo_grafico;

    public Configuracoes(String periodo_grafico) {
        this.periodo_grafico = periodo_grafico;
    }

    public Configuracoes() {
    }

    public String getPeriodo_grafico() {
        return periodo_grafico;
    }

    public void setPeriodo_grafico(String periodo_grafico) {
        this.periodo_grafico = periodo_grafico;
    } 
}
