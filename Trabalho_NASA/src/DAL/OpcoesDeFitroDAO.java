/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Bd.BdConexao;
import Model.*;
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
public class OpcoesDeFitroDAO {
    private BdConexao conn;

    public ArrayList<OpcoesDeFitro> consultarTodasOrdenacoesPossiveis() {
        conn = new BdConexao();
        ArrayList<OpcoesDeFitro> opcoesDeFitro = new ArrayList<>();

        try {
            String sql = "SELECT * FROM opcoesDeFitro";
            PreparedStatement st = conn.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                OpcoesDeFitro opcao = new OpcoesDeFitro(
                        rs.getString("filtro"), rs.getString("texto"));
                
                opcoesDeFitro.add(opcao);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AsteroideDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AsteroideDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return opcoesDeFitro;
    }
}
