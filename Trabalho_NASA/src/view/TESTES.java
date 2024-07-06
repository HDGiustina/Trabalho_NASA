package view;

import Controller.AsteroideController;
import Model.Asteroide;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import DAL.AsteroideDAO;
import java.util.ArrayList;

public class TESTES {
    public static void main(String[] args) {
        // Instancia e mostra o formulário
        
        LocalDate dt_inicio = LocalDate.parse("2024-06-01");
        LocalDate dt_fim = LocalDate.parse("2024-07-04");
        ArrayList<Asteroide> lstAsteroides;
        AsteroideController controller = new AsteroideController();
        
        try {
            // Exemplo de consulta na API
            lstAsteroides = controller.consultarAsteroidesAPI(dt_inicio, dt_fim);
            
            
           
            // Exemplo de como guardar os dados no banco
            AsteroideDAO DAO = new AsteroideDAO();
            DAO.insertLstAsteroides(lstAsteroides);
        } catch (IOException | InterruptedException | SQLException ex) {
            Logger.getLogger(TESTES.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
