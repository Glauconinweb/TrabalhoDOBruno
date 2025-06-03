import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClinicaApp {
    private FilaEncadeada fila = new FilaEncadeada();

    public ClinicaApp() {
        JFrame frame = new JFrame("Fila de Atendimento - Clínica Médica");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JTextField campoNome = new JTextField();
        JButton botaoAdicionar = new JButton("Adicionar Paciente");
        JButton botaoChamar = new JButton("Chamar Próximo");
        JTextArea areaFila = new JTextArea();
        areaFila.setEditable(false);

        botaoAdicionar.addActionListener(e -> {
            String nome = campoNome.getText().trim();
            if (!nome.isEmpty()) {
                fila.enqueue(nome);
                campoNome.setText("");
                atualizarFila(areaFila);
            }
        });

        botaoChamar.addActionListener(e -> {
            String chamado = fila.dequeue();
            if (chamado != null) {
                JOptionPane.showMessageDialog(frame, "Chamando: " + chamado);
                atualizarFila(areaFila);
            } else {
                JOptionPane.showMessageDialog(frame, "Fila vazia!");
            }
        });

        JPanel painelTopo = new JPanel(new BorderLayout());
        painelTopo.add(campoNome, BorderLayout.CENTER);
        painelTopo.add(botaoAdicionar, BorderLayout.EAST);

        JPanel painelBaixo = new JPanel(new BorderLayout());
        painelBaixo.add(botaoChamar, BorderLayout.NORTH);
        painelBaixo.add(new JScrollPane(areaFila), BorderLayout.CENTER);

        frame.add(painelTopo, BorderLayout.NORTH);
        frame.add(painelBaixo, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private void atualizarFila(JTextArea area) {
        area.setText(fila.listarFila());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ClinicaApp());
    }
}