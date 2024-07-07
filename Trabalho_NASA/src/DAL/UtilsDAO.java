/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import Bd.BdConexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class UtilsDAO {

    private final BdConexao conn = new BdConexao();

    public ArrayList<String> getFiltrosColuna(String coluna) {
        ArrayList<String> niveisDeAmeaça = new ArrayList<>();
        try {
            String sql = "SELECT" + coluna + " FROM asteroides group by  " + coluna;
            PreparedStatement st = conn.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                niveisDeAmeaça.add("nivel_ameaca");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AsteroideDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AsteroideDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return niveisDeAmeaça;
    }
}
