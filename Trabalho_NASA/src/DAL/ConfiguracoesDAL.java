/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;
import Bd.BdConexao;
import Model.Configuracoes;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class ConfiguracoesDAL {
    private BdConexao conn = new BdConexao();
    
    /**
     * 
     * @param configuracoes
     * funcao de atualizar as configurações no banco de dados
     */
    public void updateConfiguracoes(Configuracoes configuracoes){
        try {
            String sql = "UPDATE configuracoes SET nomeBanco = ?, chaveApi = ? WHERE id = 1";
            PreparedStatement psmt = conn.getConnection().prepareStatement(sql);
            psmt.setString(1, configuracoes.getNomeBanco());
            psmt.setString(2, configuracoes.getChaveApi());
            psmt.executeUpdate();
        }catch (SQLException ex){
            Logger.getLogger(ConfiguracoesDAL.class.getName()).log(Level.SEVERE, null, ex);
        }   
        catch (Exception ex) {
            Logger.getLogger(ConfiguracoesDAL.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            conn = null;
        }
    }
}
