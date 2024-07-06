/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author User
 */
public class AsteroidesPorPeriodo {
    private String mes;
    private Integer numeroPorMes;

    public AsteroidesPorPeriodo(String mes, Integer numeroPorMes) {
        this.mes = mes;
        this.numeroPorMes = numeroPorMes;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public Integer getNumeroPorMes() {
        return numeroPorMes;
    }

    public void setNumeroPorMes(Integer numeroPorMes) {
        this.numeroPorMes = numeroPorMes;
    }
    
    
}
