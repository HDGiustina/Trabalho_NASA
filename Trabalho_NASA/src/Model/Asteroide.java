/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author User
 */
public class Asteroide {

    private Integer id;
    private String nome;
    private Float distanciaDaTerra;
    private Boolean potencialRisco;
    private Float velocidadeKmHr;
    private Float tamanhoDoAsteroide;

    public Asteroide(String nome, Float distanciaDaTerra, Boolean potencialRisco, Float velocidadeKmHr, Float tamanhoDoAsteroide) {
        this.nome = nome;
        this.distanciaDaTerra = distanciaDaTerra;
        this.potencialRisco = potencialRisco;
        this.velocidadeKmHr = velocidadeKmHr;
        this.tamanhoDoAsteroide = tamanhoDoAsteroide;
    }

    public Asteroide(Integer id, String nome, Float distanciaDaTerra, Boolean potencialRisco, Float velocidadeKmHr, Float tamanhoDoAsteroide) {
        this.id = id;
        this.nome = nome;
        this.distanciaDaTerra = distanciaDaTerra;
        this.potencialRisco = potencialRisco;
        this.velocidadeKmHr = velocidadeKmHr;
        this.tamanhoDoAsteroide = tamanhoDoAsteroide;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getDistanciaDaTerra() {
        return distanciaDaTerra;
    }

    public void setDistanciaDaTerra(Float distanciaDaTerra) {
        this.distanciaDaTerra = distanciaDaTerra;
    }

    public Boolean getPotencialRisco() {
        return potencialRisco;
    }

    public void setPotencialRisco(Boolean potencialRisco) {
        this.potencialRisco = potencialRisco;
    }

    public Float getVelocidadeKmHr() {
        return velocidadeKmHr;
    }

    public void setVelocidadeKmHr(Float velocidadeKmHr) {
        this.velocidadeKmHr = velocidadeKmHr;
    }

    public Float getTamanhoDoAsteroide() {
        return tamanhoDoAsteroide;
    }

    public void setTamanhoDoAsteroide(Float tamanhoDoAsteroide) {
        this.tamanhoDoAsteroide = tamanhoDoAsteroide;
    }

}
