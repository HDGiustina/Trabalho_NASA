/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayList;
import DAL.UtilsDAO;
import Model.Utils;

/**
 *
 * @author User
 */
public class UtilsController {
    private final UtilsDAO utilsDao = new UtilsDAO();
    
    public ArrayList<String> getFiltrosColuna(String coluna){
        return utilsDao.getFiltrosColuna(coluna);
    }
    
    public ArrayList<Utils> getFiltrosColunaDouble(String coluna){
        return utilsDao.getFiltrosColunaDouble(coluna);
    }
}
