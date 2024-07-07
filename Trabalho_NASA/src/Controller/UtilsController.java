/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayList;
import DAL.UtilsDAO;

/**
 *
 * @author User
 */
public class UtilsController {
    private final UtilsDAO utilsDao = new UtilsDAO();
    
    public ArrayList<String> getFiltrosColuna(String coluna){
        return utilsDao.getFiltrosColuna(coluna);
    }
}
