/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.OpcoesDeFitro;
import DAL.OpcoesDeFitroDAO;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class OpcoesDeFitroController {
    private OpcoesDeFitroDAO opcoesDeFitroDAO = new OpcoesDeFitroDAO();
    public ArrayList<OpcoesDeFitro> getOpcoesDeFiltro(){
        return opcoesDeFitroDAO.consultarTodosFiltros();
    }
}
