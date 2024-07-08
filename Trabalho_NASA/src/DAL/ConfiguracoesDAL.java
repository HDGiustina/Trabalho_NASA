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
 */
public class ConfiguracoesDAL {
    private BdConexao conn;

    /**
     * 
     * @param configuracoes
     * funcao de atualizar as configurações no banco de dados
     */
    public void updateConfiguracoes(Configuracoes configuracoes){
        conn = new BdConexao();
        try {
            String sql = "UPDATE configuracoes SET periodo_grafico = ? WHERE id = 1";
            PreparedStatement psmt = conn.getConnection().prepareStatement(sql);
            psmt.setString(1, configuracoes.getPeriodo_grafico());
            psmt.executeUpdate();
        }catch (SQLException ex){
            Logger.getLogger(ConfiguracoesDAL.class.getName()).log(Level.SEVERE, null, ex);
        }   
        catch (Exception ex) {
            Logger.getLogger(ConfiguracoesDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String consultarPeridoDoGrafico() {
        conn = new BdConexao();
        String periodo = "";
        try {
            String sql = "SELECT periodo_grafico FROM configuracoes WHERE id = 1;";
            PreparedStatement st = conn.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                periodo = rs.getString("periodo_grafico");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AsteroideDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AsteroideDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return periodo;
    }
}
