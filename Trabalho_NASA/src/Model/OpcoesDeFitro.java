/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author User
 */
public class OpcoesDeFitro {
    private String coluna;
    private String textoNome; 

    public OpcoesDeFitro(String coluna, String textoNome) {
        this.coluna = coluna;
        this.textoNome = textoNome;
    }

    public String getColuna() {
        return coluna;
    }

    public void setColuna(String coluna) {
        this.coluna = coluna;
    }

    public String getTextoNome() {
        return textoNome;
    }

    public void setTextoNome(String textoNome) {
        this.textoNome = textoNome;
    }

    @Override
    public String toString() {
        return textoNome;
    }
    
    
}
