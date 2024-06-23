/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class BdConexao {

    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost/" + "bancoTrabalhoPa";
    private final String usuario = "root";
    private final String senha = "root";

    private Connection conexao;

    public BdConexao() {
        try {
            Class.forName(driver);//carrega o driver

            //abre a conexão com os parâmetros informados
            conexao = DriverManager.getConnection(url, usuario, senha);

        } catch (Exception ex) {
            Logger.getLogger(BdConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnection() {
        return conexao;
    }
}
