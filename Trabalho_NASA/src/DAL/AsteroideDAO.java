/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Bd.BdConexao;
import Model.Asteroide;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class AsteroideDAO {

    private BdConexao conn = new BdConexao();

    /**
     *
     * @param asteroide cadastrar asteroide
     */
    public void cadastrarAsteroide(Model.Asteroide asteroide) {
        try {
            String sql = "INSERT INTO Asteroides (nome, distanciaDaTerra, potencialRisco, velocidadeKmHr, tamanhoDoAsteroide)"
                    + "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement psmt = conn.getConnection().prepareStatement(sql);
            psmt.setString(1, asteroide.getNome());
            psmt.setFloat(2, asteroide.getDistanciaDaTerra());
            psmt.setBoolean(3, asteroide.getPotencialRisco());
            psmt.setFloat(4, asteroide.getVelocidadeKmHr());
            psmt.setFloat(5, asteroide.getTamanhoDoAsteroide());
            psmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AsteroideDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AsteroideDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param ordenacao opções que poderão vir distância, tamanho do objeto,
     * velocidade e potencial de risco.
     * @return dados dos asteroides
     */
    public ArrayList<Asteroide> consultarTodosAsteroides(String ordenacao) {
        ArrayList<Asteroide> lstAsteroides = new ArrayList<>();
        try {

            String sql = "SELECT * FROM Asteroides ORDER BY " + ordenacao;
            PreparedStatement st = conn.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Asteroide asteroide = new Asteroide(rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getFloat("distanciaDaTerra"),
                        rs.getBoolean("potencialRisco"),
                        rs.getFloat("velocidadeKmHr"),
                        rs.getFloat("tamanhoDoAsteroide"));
                lstAsteroides.add(asteroide);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AsteroideDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AsteroideDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstAsteroides;
    }

}
