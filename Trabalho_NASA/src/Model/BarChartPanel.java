/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author iury2
 */
import java.awt.BorderLayout;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarChartPanel extends JPanel {

    public BarChartPanel() {
        initComponents();
        
        // Criar dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(15, "Series 1", "Category 1");
        dataset.addValue(25, "Series 1", "Category 2");
        dataset.addValue(35, "Series 1", "Category 3");
        
        // Criar o gráfico de barras
        JFreeChart chart = ChartFactory.createBarChart(
                "Frêquencia de Asteroides", // título do gráfico
                "Categoria", // rótulo do eixo X
                "Valor", // rótulo do eixo Y
                dataset, // dados
                PlotOrientation.VERTICAL, // orientação do gráfico
                true, // incluir legenda
                true, // exibir tooltips
                false // URLs (não usado aqui)
        );
        
        // Criar o painel de gráfico e adicionar ao JPanel
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(400,300));
   
        this.setLayout(new BorderLayout());
        this.add(chartPanel, BorderLayout.CENTER);
    }

    // Método gerado pelo NetBeans para inicialização de componentes
    private void initComponents() {
        // Componentes adicionais podem ser inicializados aqui, se necessário
    }
}
