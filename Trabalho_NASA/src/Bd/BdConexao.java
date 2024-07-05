/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class BdConexao {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/" + "bancoTrabalhoPa";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    private Connection conexao;

    public BdConexao() {
        try {
            
            //abre a conexão com os parâmetros informados
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
          //  Class.forName(DRIVER);//carrega o driver
            //conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            
            // Cria a tabela no banco, se ainda não existe
            criaTabelaSeNaoExiste(conexao);

        } catch (SQLException ex) {
            Logger.getLogger(BdConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnection() {
        return conexao;
    }
    
    private static void criaTabelaSeNaoExiste(Connection conn) throws SQLException {
        // Statement para criar a tabela caso não exista ainda
        String createTableQuery = "CREATE TABLE IF NOT EXISTS Asteroides (" +
                "date DATE, " +
                "id VARCHAR(255), " +
                "id_neo_referencia VARCHAR(255), " +
                "nome VARCHAR(255), " +
                "data_aproximacao_maxima DATE, " +
                "velocidade_relativa_em_kms DOUBLE, " +
                "distancia_min_da_terra_em_km DOUBLE, " +
                "diametro_estimado_em_km DOUBLE, " +
                "corpo_orbitante VARCHAR(255), " +
                "potencialmente_perigoso BOOL, " +
                "nivel_ameaca VARCHAR(255), " +
                "PRIMARY KEY (id, date)" +
                ");";

        // Executa o statement acima
        try (PreparedStatement stmt = conn.prepareStatement(createTableQuery)) {
            stmt.execute();
        }
    }
}
