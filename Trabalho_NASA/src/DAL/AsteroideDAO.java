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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class AsteroideDAO {

    private BdConexao conn = new BdConexao();

    // Itera sobre cada Asteroide da ArrayList, inserindo no banco
    public void insertLstAsteroides(ArrayList<Asteroide> lstAsteroides) {
        for (int i = 0; i < lstAsteroides.size(); i++) {
            Asteroide temp = lstAsteroides.get(i);
            insertAsteroide(temp);
        }
    }
    
    // Insere um objeto Asteroide no banco de dados
    public void insertAsteroide(Asteroide ast) {
        String insertQuery = "INSERT INTO Asteroides (date, id, id_neo_referencia, nome, data_aproximacao_maxima, " +
                "velocidade_relativa_em_kms, distancia_min_da_terra_em_km, diametro_estimado_em_km, corpo_orbitante, " +
                "potencialmente_perigoso, nivel_ameaca) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
         // Prepara a String de consulta
        try (PreparedStatement stmt = conn.getConnection().prepareStatement(insertQuery)) {
            
            stmt.setString(1, ast.getDate().toString());                    // Data da consulta
            stmt.setString(2, ast.getId());                                 // id
            stmt.setString(3, ast.getId_neo_referencia());                  // id_neo_referencia
            stmt.setString(4, ast.getNome());                               // nome
            stmt.setString(5, ast.getData_aproximacao_maxima().toString()); // data_aproximacao_maxima
            stmt.setDouble(6, ast.getVelocidade_relativa_em_kms());         // velocidade_relativa_em_kms
            stmt.setDouble(7, ast.getDistancia_min_da_terra_em_km());       // distancia_min_da_terra_em_km
            stmt.setDouble(8, ast.getDiametro_estimado_em_km());            // diametro_estimado_em_km
            stmt.setString(9, ast.getCorpo_orbitante());                    // corpo_orbitante
            stmt.setInt(10, ast.getPotencialmente_perigoso() ? 1 : 0);      // potencialmente_perigoso
            stmt.setString(11, ast.getNivel_ameaca());                      // nivel_ameaca

            try {
                // Executa o Insert
                stmt.executeUpdate();
                System.out.println("Data: " + ast.getDate().toString() + ", ID: " + ast.getId() + ", Inserido com sucesso!");

            } catch (java.sql.SQLIntegrityConstraintViolationException e) {
                // Se o ID já está na base, ignora o erro de duplicidade gerado pelo MariaDB
                System.out.println("Erro de duplicidade ignorado com sucesso! " + e.getMessage());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AsteroideDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @return dados dos asteroides
     */
    public ArrayList<Asteroide> consultarTodosAsteroides() {
        ArrayList<Asteroide> lstAsteroides = new ArrayList<>();
        try {

            String sql = "SELECT * FROM Asteroides";
            PreparedStatement st = conn.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Asteroide ast = new Asteroide(rs.getString("id"), rs.getString("nome"));
                ast.setDate(LocalDate.parse(rs.getString("date")));                             // Data consultada
                ast.setId(rs.getString("id"));                             // id
                ast.setId_neo_referencia(rs.getString("id_neo_referencia"));                             // id_neo_referencia
                ast.setData_aproximacao_maxima(LocalDate.parse(rs.getString("data_aproximacao_maxima"))); // data_aproximacao_maxima
                ast.setVelocidade_relativa_em_kms(rs.getDouble("velocidade_relativa_em_kms")); // velocidade_relativa_em_kms
                ast.setDistancia_min_da_terra_em_km(rs.getDouble("distancia_min_da_terra_em_km")); // distancia_min_da_terra_em_km
                ast.setDiametro_estimado_em_km(rs.getDouble("diametro_estimado_em_km"));  // diametro_estimado_em_km
                ast.setCorpo_orbitante(rs.getString("corpo_orbitante")); // corpo_orbitante
                ast.setPotencialmente_perigoso(rs.getBoolean("potencialmente_perigoso")); // potencialmente_perigoso
                ast.setNivel_ameaca(rs.getString("nivel_ameaca")); // nivel_ameaca
                
                lstAsteroides.add(ast);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AsteroideDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AsteroideDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            conn = null;
        }
        return lstAsteroides;
    }
    
    /**
     *
     * @param ordenacao opções que poderão vir distancia_min_da_terra_em_km, potencialmente_perigoso,
     * velocidade_relativa_em_kms e diametro_estimado_em_km.
     * @param filtro distancia_min_da_terra_em_km, velocidade_relativa_em_kms, diametro_estimado_em_km
     * @param comeco  do filtro
     * @param fim do filtro
     * @return dados dos asteroides
     */
    public ArrayList<Asteroide> consultarTodosAsteroidesPorFiltroEOrdenacao(String ordenacao, String filtro, Double comeco, Double fim) {
        ArrayList<Asteroide> lstAsteroides = new ArrayList<>();
        try {

            String sql = "SELECT * FROM Asteroides WHERE ? BETWEEN ? AND ? ORDER BY ?";
            PreparedStatement st = conn.getConnection().prepareStatement(sql);
            st.setString(1, filtro);
            st.setDouble(2, comeco);
            st.setDouble(3, fim);
            st.setString(4, ordenacao);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Asteroide ast = new Asteroide(rs.getString("id"), rs.getString("nome"));
                ast.setDate(LocalDate.parse(rs.getString("date")));  // Data consultada
                ast.setId(rs.getString("id")); // id
                ast.setId_neo_referencia(rs.getString("id_neo_referencia"));                             // id_neo_referencia
                ast.setData_aproximacao_maxima(LocalDate.parse(rs.getString("data_aproximacao_maxima"))); // data_aproximacao_maxima
                ast.setVelocidade_relativa_em_kms(rs.getDouble("velocidade_relativa_em_kms")); // velocidade_relativa_em_kms
                ast.setDistancia_min_da_terra_em_km(rs.getDouble("distancia_min_da_terra_em_km")); // distancia_min_da_terra_em_km
                ast.setDiametro_estimado_em_km(rs.getDouble("diametro_estimado_em_km"));  // diametro_estimado_em_km
                ast.setCorpo_orbitante(rs.getString("corpo_orbitante")); // corpo_orbitante
                ast.setPotencialmente_perigoso(rs.getBoolean("potencialmente_perigoso")); // potencialmente_perigoso
                ast.setNivel_ameaca(rs.getString("nivel_ameaca")); // nivel_ameaca
                
                lstAsteroides.add(ast);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AsteroideDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AsteroideDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            conn = null;
        }
        return lstAsteroides;
    }
    
    /**
     * 
     * @param filtro distancia_min_da_terra_em_km, velocidade_relativa_em_kms, diametro_estimado_em_km
     * @param comeco range de começo do filtro
     * @param fim range de fim do filtro
     * @return asteroides filtrados conforme queira
     */
    public ArrayList<Asteroide> consultarTodosAsteroidesPorFiltro(String filtro, Double comeco, Double fim) {
        ArrayList<Asteroide> lstAsteroides = new ArrayList<>();
        try {

            String sql = "SELECT * FROM Asteroides WHERE ? BETWEEN ? AND ?";
            PreparedStatement st = conn.getConnection().prepareStatement(sql);
            st.setString(1, filtro);
            st.setDouble(2, comeco);
            st.setDouble(3, fim);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Asteroide ast = new Asteroide(rs.getString("id"), rs.getString("nome"));
                ast.setDate(LocalDate.parse(rs.getString("date")));  // Data consultada
                ast.setId(rs.getString("id")); // id
                ast.setId_neo_referencia(rs.getString("id_neo_referencia"));                             // id_neo_referencia
                ast.setData_aproximacao_maxima(LocalDate.parse(rs.getString("data_aproximacao_maxima"))); // data_aproximacao_maxima
                ast.setVelocidade_relativa_em_kms(rs.getDouble("velocidade_relativa_em_kms")); // velocidade_relativa_em_kms
                ast.setDistancia_min_da_terra_em_km(rs.getDouble("distancia_min_da_terra_em_km")); // distancia_min_da_terra_em_km
                ast.setDiametro_estimado_em_km(rs.getDouble("diametro_estimado_em_km"));  // diametro_estimado_em_km
                ast.setCorpo_orbitante(rs.getString("corpo_orbitante")); // corpo_orbitante
                ast.setPotencialmente_perigoso(rs.getBoolean("potencialmente_perigoso")); // potencialmente_perigoso
                ast.setNivel_ameaca(rs.getString("nivel_ameaca")); // nivel_ameaca
                
                lstAsteroides.add(ast);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AsteroideDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AsteroideDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            conn = null;
        }
        return lstAsteroides;
    }
    
    /**
     * 
     * @param ordenacao opções que poderão vir distancia_min_da_terra_em_km, potencialmente_perigoso,
     * velocidade_relativa_em_kms e diametro_estimado_em_km.
     * @return asteroides ordenados
     */
    public ArrayList<Asteroide> consultarTodosAsteroidesPorOrdenacao(String ordenacao) {
        ArrayList<Asteroide> lstAsteroides = new ArrayList<>();
        try {

            String sql = "SELECT * FROM Asteroides ORDER BY ?";
            PreparedStatement st = conn.getConnection().prepareStatement(sql);
            st.setString(1, ordenacao);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Asteroide ast = new Asteroide(rs.getString("id"), rs.getString("nome"));
                ast.setDate(LocalDate.parse(rs.getString("date")));  // Data consultada
                ast.setId(rs.getString("id")); // id
                ast.setId_neo_referencia(rs.getString("id_neo_referencia"));                             // id_neo_referencia
                ast.setData_aproximacao_maxima(LocalDate.parse(rs.getString("data_aproximacao_maxima"))); // data_aproximacao_maxima
                ast.setVelocidade_relativa_em_kms(rs.getDouble("velocidade_relativa_em_kms")); // velocidade_relativa_em_kms
                ast.setDistancia_min_da_terra_em_km(rs.getDouble("distancia_min_da_terra_em_km")); // distancia_min_da_terra_em_km
                ast.setDiametro_estimado_em_km(rs.getDouble("diametro_estimado_em_km"));  // diametro_estimado_em_km
                ast.setCorpo_orbitante(rs.getString("corpo_orbitante")); // corpo_orbitante
                ast.setPotencialmente_perigoso(rs.getBoolean("potencialmente_perigoso")); // potencialmente_perigoso
                ast.setNivel_ameaca(rs.getString("nivel_ameaca")); // nivel_ameaca
                
                lstAsteroides.add(ast);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AsteroideDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AsteroideDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            conn = null;
        }
        return lstAsteroides;
    }
    
    public Integer contadorDeAsteroidesProximosATerra(){
        Integer objetosProximosATerra = 0;
        try {
             String sql = "select count(*) as numero from asteroides";
             PreparedStatement st = conn.getConnection().prepareStatement(sql);
             ResultSet rs = st.executeQuery();
             while(rs.next()){
                 objetosProximosATerra = rs.getInt("numero");
             }
             
             
        } catch (SQLException ex) {
            Logger.getLogger(AsteroideDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AsteroideDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            conn = null;
        }
       return objetosProximosATerra;
    }

}
