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
import Model.Utils;

/**
 *
 * @author User
 */
public class UtilsDAO {

    private final BdConexao conn = new BdConexao();

    public ArrayList<String> getFiltrosColuna(String coluna) {
        ArrayList<String> niveisDeAmeaça = new ArrayList<>();
        try {
            String sql = "SELECT " + coluna + " as filtro FROM asteroides group by  " + coluna;
            PreparedStatement st = conn.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                niveisDeAmeaça.add(rs.getString("filtro"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AsteroideDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AsteroideDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return niveisDeAmeaça;
    }

    public ArrayList<Utils> getFiltrosColunaDouble(String coluna) {
        ArrayList<Utils> niveis = new ArrayList<>();
        try {
            Integer arredondamento = 0;

            if (coluna.equals("diametro_estimado_em_km")) {
                arredondamento = 2;
            }

            String sql = "WITH filtro_intervals AS (\n"
                    + "    SELECT \n"
                    + "        " + coluna + " AS coluna,\n"
                    + "        NTILE(4) OVER (ORDER BY " + coluna + ") AS parte\n"
                    + "    FROM \n"
                    + "        asteroides\n"
                    + ")\n"
                    + "SELECT \n"
                    + "    parte,\n"
                    + "     ROUND(MIN(coluna), ?) AS min,\n"
                    + "     ROUND(MAX(coluna), ?) AS max\n"
                    + "FROM \n"
                    + "    filtro_intervals\n"
                    + "GROUP BY \n"
                    + "    parte\n"
                    + "ORDER BY \n"
                    + "    parte;";
            PreparedStatement st = conn.getConnection().prepareStatement(sql);
            st.setInt(1, arredondamento);
            st.setInt(2, arredondamento);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Utils util = new Utils(rs.getString("parte"), rs.getDouble("max"), rs.getDouble("min"));
                niveis.add(util);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AsteroideDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AsteroideDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return niveis;
    }

}
