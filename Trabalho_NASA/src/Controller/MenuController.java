/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import javax.swing.*;

/**
 *
 * 
 */
public class MenuController {
    
    JFrame frame;

    public MenuController(JFrame frame) {
        this.frame = frame;
    }
    
    public void telaDashboard(JFrame dash){
        this.frame.dispose();
        dash.setVisible(true);
    }
    
    public void telaAtualiza(JFrame atualiza){
        this.frame.dispose();
        atualiza.setVisible(true);
    }
    
    public void telaResultados(JFrame result){
        this.frame.dispose();
        result.setVisible(true);
    }
    
    public void telaConfiguracoes(JFrame config){
        this.frame.dispose();
        config.setVisible(true);
    }
    
    public void telaSobre(JFrame sobre){
        this.frame.dispose();
        sobre.setVisible(true);
    }
    
    public void Sair(){
        this.frame.dispose();
    }
    
    
}
