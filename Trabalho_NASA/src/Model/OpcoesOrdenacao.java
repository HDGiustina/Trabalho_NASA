/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author User
 */
public class OpcoesOrdenacao {
    private Integer id;
    private String ordenacao;
    private String texto;

    public OpcoesOrdenacao(Integer id, String ordenacao, String texto) {
        this.id = id;
        this.ordenacao = ordenacao;
        this.texto = texto;
    }

    public OpcoesOrdenacao(String ordenacao) {
        this.ordenacao = ordenacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrdenacao() {
        return ordenacao;
    }

    public void setOrdenacao(String ordenacao) {
        this.ordenacao = ordenacao;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    @Override
    public String toString() {
        return texto;
    }
}
