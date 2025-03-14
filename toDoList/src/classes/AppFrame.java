package classes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AppFrame extends JFrame {

    private Titulo titulo;
    private Lista lista;
    private BarraDeBotoes btnPanel;

    private JButton addTask;
    private JButton clear;

    private JPanel backgroundPanel;

    // Construtor
    AppFrame() {
        this.setSize(400, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        backgroundPanel = new JPanel();
        backgroundPanel.setLayout(new BorderLayout());
        backgroundPanel.setBackground(new Color(50, 50, 50));
        this.setContentPane(backgroundPanel);

        titulo = new Titulo();
        lista = new Lista();
        btnPanel = new BarraDeBotoes();

     
        backgroundPanel.add(titulo, BorderLayout.NORTH);
        backgroundPanel.add(btnPanel, BorderLayout.SOUTH);
        backgroundPanel.add(lista, BorderLayout.CENTER);

        addTask = btnPanel.getAddTask();
        clear = btnPanel.getClear();

        addListener();

        this.setVisible(true);
    }

    public void addListener() {
        addTask.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Tarefas tarefa = new Tarefas();
                lista.add(tarefa);
                lista.updateNumber();

                tarefa.getConcluido().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        tarefa.mudaStatus();
                        revalidate();
                    }
                });
                revalidate();
            }
        });

        clear.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Component[] listItems = lista.getComponents();

                for (int i = listItems.length - 1; i >= 0; i--) {
                    if (listItems[i] instanceof Tarefas) {
                        Tarefas tarefa = (Tarefas) listItems[i];
                        if (tarefa.isVerificado()) {
                            lista.remove(tarefa);
                        }
                    }
                }

                lista.updateNumber();
                lista.revalidate();
                lista.repaint();
            }
        });
    }
}
