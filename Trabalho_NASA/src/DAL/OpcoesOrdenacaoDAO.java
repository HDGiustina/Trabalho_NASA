/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Bd.BdConexao;
import Model.OpcoesOrdenacao;
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
public class OpcoesOrdenacaoDAO {

    private BdConexao conn;

    public ArrayList<OpcoesOrdenacao> consultarTodasOrdenacoesPossiveis() {
        conn = new BdConexao();
        ArrayList<OpcoesOrdenacao> lstDeOpcoes = new ArrayList<>();

        try {
            String sql = "SELECT * FROM opcoesdeordenacaoEFiltro";
            PreparedStatement st = conn.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                OpcoesOrdenacao opcao = new OpcoesOrdenacao(
                        rs.getInt("id"), rs.getString("ordenacao"), rs.getString("texto"));
                
                lstDeOpcoes.add(opcao);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AsteroideDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AsteroideDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn = null;
        }
        return lstDeOpcoes;
    }
}
