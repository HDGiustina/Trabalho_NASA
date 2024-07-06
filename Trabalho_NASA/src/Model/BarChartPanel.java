package Model;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import java.util.ArrayList;

public class BarChartPanel extends JPanel {

    private DefaultCategoryDataset dataset;

    public BarChartPanel(ArrayList<AsteroidesPorPeriodo> asteroidesPorPeriodo) {
        initComponents();

        // Criar dataset inicial com os dados fornecidos
        dataset = new DefaultCategoryDataset();
        for (AsteroidesPorPeriodo periodo : asteroidesPorPeriodo) {
            dataset.addValue(periodo.getNumeroPorMes(), "Asteroides", periodo.getPeriodo());
        }

        // Criar o gráfico de barras inicial
        JFreeChart chart = ChartFactory.createBarChart(
                "Frequência de Asteroides por Mês", // título do gráfico
                "Mês", // rótulo do eixo X
                "Número de Asteroides", // rótulo do eixo Y
                dataset, // dados
                PlotOrientation.VERTICAL, // orientação do gráfico
                true, // incluir legenda
                true, // exibir tooltips
                false // URLs (não usado aqui)
        );

        // Criar o painel de gráfico e adicionar ao JPanel
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(400, 300));

        this.setLayout(new BorderLayout());
        this.add(chartPanel, BorderLayout.CENTER);
    }

    // Método para atualizar os dados do gráfico
    public void atualizarDados(ArrayList<AsteroidesPorPeriodo> asteroidesPorPeriodo) {
        // Limpar dados existentes
        dataset.clear();

        // Adicionar novos dados ao dataset
        for (AsteroidesPorPeriodo periodo : asteroidesPorPeriodo) {
            dataset.addValue(periodo.getNumeroPorMes(), "Asteroides", periodo.getPeriodo());
        }
    }

    // Método gerado pelo NetBeans para inicialização de componentes
    private void initComponents() {
        // Componentes adicionais podem ser inicializados aqui, se necessário
    }
}
