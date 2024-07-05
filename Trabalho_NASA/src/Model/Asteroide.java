/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDate;

/**
 *
 * @author User
 */
public class Asteroide {
    LocalDate date, data_aproximacao_maxima;
    String id, id_neo_referencia, nome, corpo_orbitante, nivel_ameaca;
    Double velocidade_relativa_em_kms, distancia_min_da_terra_em_km, diametro_estimado_em_km;
    Boolean potencialmente_perigoso;

//LocalDate date, String id, String  id_neo_referencia, String nome, LocalDate data_aproximacao_maxima, Double velocidade_relativa_em_kms, Double distancia_min_da_terra_em_km, Double diametro_estimado_em_km, String corpo_orbitante, Boolean potencialmente_perigoso, String nivel_ameaca
    public Asteroide(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }
/*LocalDate date, String id, String  id_neo_referencia, String nome, LocalDate, data_aproximacao_maxima, Double velocidade_relativa_em_kms, 
    Double distancia_min_da_terra_em_km, Double diametro_estimado_em_km, String corpo_orbitante, Bool potencialmente_perigoso, String nivel_ameaca)*/

    // Função abaixo identifica o nível de ameaça do objeto com bases em alguns critérios lógicos
    // Possíveis valores: Extrema, Alta, Moderada e Baixa
    public static String avaliarAmeaca(double diametro_estimado_em_km, double velocidade_relativa_em_kms,
                                        double distancia_min_da_terra_em_km, boolean potencPerigoso) {
        String nivelAmeaca;

        // Configuração dos limites (valores estimados)
        double diametreoAlto = 1.0; // em km
        double diametroModerado = 0.05; // em km
        double velocidadeAlta = 15.0; // em km/s
        double distanciaMinimaBaixa = 7500000; // em km (7.5 milhões de km)
        double distanciaMinimaModerada = 384400; // em km (distância à lua)

        // Presume nível de ameaça
        if (!potencPerigoso) {
            nivelAmeaca = "Nenhuma";
        } else {
            if (diametro_estimado_em_km > diametreoAlto) {
                if (velocidade_relativa_em_kms >= velocidadeAlta) {
                    if (distancia_min_da_terra_em_km < distanciaMinimaModerada) {
                        nivelAmeaca = "Extrema";
                    } else if (distancia_min_da_terra_em_km < distanciaMinimaBaixa) {
                        nivelAmeaca = "Alta";
                    } else {
                        nivelAmeaca = "Moderada";
                    }
                } else {
                    if (distancia_min_da_terra_em_km < distanciaMinimaModerada) {
                        nivelAmeaca = "Alta";
                    } else if (distancia_min_da_terra_em_km < distanciaMinimaBaixa) {
                        nivelAmeaca = "Moderada";
                    } else {
                        nivelAmeaca = "Baixa";
                    }
                }
            } else if (diametro_estimado_em_km > diametroModerado) {
                if (velocidade_relativa_em_kms >= velocidadeAlta) {
                    if (distancia_min_da_terra_em_km < distanciaMinimaModerada) {
                        nivelAmeaca = "Alta";
                    } else if (distancia_min_da_terra_em_km < distanciaMinimaBaixa) {
                        nivelAmeaca = "Moderada";
                    } else {
                        nivelAmeaca = "Baixa";
                    }
                } else {
                    if (distancia_min_da_terra_em_km < distanciaMinimaModerada) {
                        nivelAmeaca = "Moderada";
                    } else {
                        nivelAmeaca = "Baixa";
                    }
                }
            } else {
                nivelAmeaca = "Baixa";
            }
        }

        return nivelAmeaca;
    } 
        
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getData_aproximacao_maxima() {
        return data_aproximacao_maxima;
    }

    public void setData_aproximacao_maxima(LocalDate data_aproximacao_maxima) {
        this.data_aproximacao_maxima = data_aproximacao_maxima;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_neo_referencia() {
        return id_neo_referencia;
    }

    public void setId_neo_referencia(String id_neo_referencia) {
        this.id_neo_referencia = id_neo_referencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCorpo_orbitante() {
        return corpo_orbitante;
    }

    public void setCorpo_orbitante(String corpo_orbitante) {
        this.corpo_orbitante = corpo_orbitante;
    }

    public String getNivel_ameaca() {
        return nivel_ameaca;
    }

    public void setNivel_ameaca(String nivel_ameaca) {
        this.nivel_ameaca = nivel_ameaca;
    }

    public Double getVelocidade_relativa_em_kms() {
        return velocidade_relativa_em_kms;
    }

    public void setVelocidade_relativa_em_kms(Double velocidade_relativa_em_kms) {
        this.velocidade_relativa_em_kms = velocidade_relativa_em_kms;
    }

    public Double getDistancia_min_da_terra_em_km() {
        return distancia_min_da_terra_em_km;
    }

    public void setDistancia_min_da_terra_em_km(Double distancia_min_da_terra_em_km) {
        this.distancia_min_da_terra_em_km = distancia_min_da_terra_em_km;
    }

    public Double getDiametro_estimado_em_km() {
        return diametro_estimado_em_km;
    }

    public void setDiametro_estimado_em_km(Double diametro_estimado_em_km) {
        this.diametro_estimado_em_km = diametro_estimado_em_km;
    }

    public Boolean getPotencialmente_perigoso() {
        return potencialmente_perigoso;
    }

    public void setPotencialmente_perigoso(Boolean potencialmente_perigoso) {
        this.potencialmente_perigoso = potencialmente_perigoso;
    }




}
