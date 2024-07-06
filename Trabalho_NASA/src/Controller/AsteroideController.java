/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Asteroide;
import DAL.AsteroideDAO;
import java.util.ArrayList;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLException;
import java.time.LocalDate;


public class AsteroideController {
    private static final String API_KEY = "c7rNf6fd2psQW282XAHRMjSyhlUZtpkHWbHd5k1K";
    private static final String BASE_URL = "https://api.nasa.gov/neo/rest/v1/feed";

    private AsteroideDAO asteroidesDao = new AsteroideDAO();

    public ArrayList<Asteroide> getAsteroides() {
        return asteroidesDao.consultarTodosAsteroides();
    }
    
    public ArrayList<Asteroide> getAsteroidesFiltroEOrdenacao(String ordenacao, String filtro, Double comeco, Double fim) {
        return asteroidesDao.consultarTodosAsteroidesPorFiltroEOrdenacao(ordenacao, filtro, comeco, fim);
    }
    
    public ArrayList<Asteroide> getAsteroidesFiltro(String filtro, Double comeco, Double fim) {
        return asteroidesDao.consultarTodosAsteroidesPorFiltro(filtro, comeco, fim);
    }
    
    public ArrayList<Asteroide> getAsteroidesOrdenacao(String ordenacao) {
        return asteroidesDao.consultarTodosAsteroidesPorOrdenacao(ordenacao);
    }
    
    public Integer getNumeroAsteroidesProximosATerra(){
        return asteroidesDao.contadorDeAsteroidesProximosATerra();
    }

    // Função abaixo consulta todos os asteroides no período informado na API e os retorna como ArrayList<Asteroide>
    public ArrayList<Asteroide> consultarAsteroidesAPI(LocalDate dataInicio, LocalDate dataFinal) throws IOException, InterruptedException, SQLException {
        ArrayList<Asteroide> lstAsteroides = new ArrayList<>();
        /*  
            //verificar se as datas passadas nao sao de 7 dias atras e etc
             //fazer funcao para chamar dados da api e 
            cadastrar os asteroides com o asteroide DAO de cadastrarAsteroide
            fazendo um foreach e passando models de Asteroide
         */
        
        // Cria cliente para executar consulta(s) na API
        HttpClient client = HttpClient.newHttpClient();

        // Itera sobre o intervalo de pesquisa de 7 em 7 dias, pois é o limite máximo de consulta na API
        for (LocalDate data_pesquisa = dataInicio; !data_pesquisa.isAfter(dataFinal); data_pesquisa = data_pesquisa.plusDays(8)) {

            // Monta a string de consulta e a executa
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + "?start_date=" + data_pesquisa + "&end_date=" + data_pesquisa.plusDays(7) + "&api_key=" + API_KEY))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Se a consulta ocorreu com sucesso, realiza o tratamento de dados
            if (response.statusCode() == 200) {

                // Converte o retorno em um Json
                JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();
                JsonObject nearEarthObjects = jsonResponse.getAsJsonObject("near_earth_objects");

                // Loop para cada dia dentro do Json
                for (String data : nearEarthObjects.keySet()) {

                    // Converte o asteróide em um Json
                    JsonArray objectsArray = nearEarthObjects.getAsJsonArray(data);

                    // Loop para cada asteróide daquele dia
                    for (JsonElement element : objectsArray) {
                        
                        // Instancia o objeto do asteróide
                        JsonObject neo = element.getAsJsonObject();
                        Asteroide ast = new Asteroide(neo.get("id").getAsString(), neo.get("name").getAsString());
                        
                        //LocalDate date, String id, String  id_neo_referencia, String nome, LocalDate, data_aproximacao_maxima, Double velocidade_relativa_em_kms, Double distancia_min_da_terra_em_km, Double diametro_estimado_em_km, String corpo_orbitante, Bool potencialmente_perigoso, String nivel_ameaca)
                        
                        ast.setDate(LocalDate.parse(data));                             // Data consultada
                        ast.setId(neo.get("id").getAsString());                             // id
                        ast.setId_neo_referencia(neo.get("neo_reference_id").getAsString());                             // id_neo_referencia
                        
                        // data_aproximacao_maxima
                        JsonObject closeApproachData = neo.getAsJsonArray("close_approach_data").get(0).getAsJsonObject();
                        ast.setData_aproximacao_maxima(LocalDate.parse(closeApproachData.get("close_approach_date").getAsString())); 

                        // velocidade_relativa_em_kms
                        JsonObject relativeVelocity = closeApproachData.getAsJsonObject("relative_velocity");
                        double velocidade = relativeVelocity.get("kilometers_per_second").getAsDouble();
                        ast.setVelocidade_relativa_em_kms(velocidade);

                        // distancia_min_da_terra_em_km
                        JsonObject missDistance = closeApproachData.getAsJsonObject("miss_distance");
                        double distanciaMinima = missDistance.get("kilometers").getAsDouble();
                        ast.setDistancia_min_da_terra_em_km(distanciaMinima);

                        // diametro_estimado_em_km (será a média entre o diâmetro mínimo e máximo encontrados na API)
                        JsonObject diametroEstimado = neo.getAsJsonObject("estimated_diameter").getAsJsonObject("kilometers");
                        double diameter = (diametroEstimado.get("estimated_diameter_min").getAsDouble() +
                                diametroEstimado.get("estimated_diameter_max").getAsDouble()) / 2;
                        ast.setDiametro_estimado_em_km(diameter);

                        // corpo_orbitante
                        ast.setCorpo_orbitante(closeApproachData.get("orbiting_body").getAsString());

                        // potencialmente_perigoso
                        ast.setPotencialmente_perigoso(neo.get("is_potentially_hazardous_asteroid").getAsBoolean());

                        // nivel_ameaca
                        String nivelAmeaca = Asteroide.avaliarAmeaca(diameter, velocidade, distanciaMinima, neo.get("is_potentially_hazardous_asteroid").getAsBoolean());
                        ast.setNivel_ameaca(nivelAmeaca);
                        
                        lstAsteroides.add(ast);
                        System.out.println("Asteróide " + neo.get("name").getAsString() + " consultado na API com sucesso!");
                        
                    }
                }
            } else {
                System.out.println("Erro na consulta da API: " + response.body());
            }
        }
        
        return lstAsteroides;
    }
}
