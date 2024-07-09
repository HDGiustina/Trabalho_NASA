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
            // Atualiza a configuração do gráfico no banco
            String sql = "UPDATE configuracoes SET valor = ? WHERE configuracao = 'periodo_grafico';";
            PreparedStatement psmt = conn.getConnection().prepareStatement(sql);
            psmt.setString(1, configuracoes.getPeriodo_grafico());
            psmt.executeUpdate();
            
            // Atualiza a configuração da API_KEY no banco
            sql = "UPDATE configuracoes SET valor = ? WHERE configuracao = 'api_key';";
            PreparedStatement psmt_2 = conn.getConnection().prepareStatement(sql);
            psmt_2.setString(1, configuracoes.getApiKey());
            System.out.println(configuracoes.getApiKey());
            psmt_2.executeUpdate();
        }catch (SQLException ex){
            Logger.getLogger(ConfiguracoesDAL.class.getName()).log(Level.SEVERE, null, ex);
        }   
        catch (Exception ex) {
            Logger.getLogger(ConfiguracoesDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 
     * @return1 periodo que está send utilizado no grafico 
     */
    public String consultarPeridoDoGrafico() {
        conn = new BdConexao();
        String periodo = "";
        try {
            String sql = "SELECT valor FROM configuracoes WHERE configuracao = 'periodo_grafico';";
            PreparedStatement st = conn.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                periodo = rs.getString("valor");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AsteroideDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AsteroideDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return periodo;
    }
    
    public void updateApiKey(Configuracoes configuracoes){
        conn = new BdConexao();
        try {
            String sql = "UPDATE configuracoes SET valor = ? WHERE configuracao = 'api_key';";
            PreparedStatement psmt = conn.getConnection().prepareStatement(sql);
            psmt.setString(1, configuracoes.getApiKey());
            psmt.executeUpdate();
        }catch (SQLException ex){
            Logger.getLogger(ConfiguracoesDAL.class.getName()).log(Level.SEVERE, null, ex);
        }   
        catch (Exception ex) {
            Logger.getLogger(ConfiguracoesDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    /**
     * 
     * @return consuta a chave da api sendo utilizada  
     */
    public String consultarApiKey() {
        conn = new BdConexao();
        String api_key = "";
        try {
            String sql = "SELECT valor FROM configuracoes WHERE configuracao = 'api_key';";
            PreparedStatement st = conn.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                api_key = rs.getString("valor");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AsteroideDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AsteroideDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return api_key;
    }
}
