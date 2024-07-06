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
    private String periodo;
    private Integer numeroPorMes;

    public AsteroidesPorPeriodo(String periodo, Integer numeroPorMes) {
        this.periodo = periodo;
        this.numeroPorMes = numeroPorMes;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Integer getNumeroPorMes() {
        return numeroPorMes;
    }

    public void setNumeroPorMes(Integer numeroPorMes) {
        this.numeroPorMes = numeroPorMes;
    }

    

    
}
