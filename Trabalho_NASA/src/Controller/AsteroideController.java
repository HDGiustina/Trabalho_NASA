/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Asteroide;
import DAL.AsteroideDAO;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class AsteroideController {

    private AsteroideDAO asteroidesDao = new AsteroideDAO();

    public ArrayList<Asteroide> getAsteroides(String ordenacaoDesejada) {
        return asteroidesDao.consultarTodosAsteroides(ordenacaoDesejada);
    }

    public void cadastrarDadosAsteroidesApi(Date dataInicio, Date dataFinal) {
        /*  
            //verificar se as datas passadas nao sao de 7 dias atras e etc
             //fazer funcao para chamar dados da api e 
            cadastrar os asteroides com o asteroide DAO de cadastrarAsteroide
            fazendo um foreach e passando models de Asteroide
         */
    }
}
