/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.OpcoesOrdenacao;
import DAL.OpcoesOrdenacaoDAO;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class OpcoesOrdenacaoController {

    private OpcoesOrdenacaoDAO opcoesOrdenacao = new OpcoesOrdenacaoDAO();

    public ArrayList<OpcoesOrdenacao> getOpcoesDeOrdenacao() {
        return opcoesOrdenacao.consultarTodasOrdenacoesPossiveis();
    }

}
