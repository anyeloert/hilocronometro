
package hilocronometro;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class InterfazCronometro extends JFrame implements ActionListener{
    
    //Atributos
    
    JLabel labelCrono;
    JButton btnIniciar;
    JButton btnParar;
    static Boolean iniciarCronometro=false;
    
    
    //Constructor

    public InterfazCronometro(String nombre) throws HeadlessException {
        super(nombre);
        setSize(300, 140);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        crearContenido();
        
    }
    
    public void crearContenido(){
        JPanel panelCronometro = new JPanel();
        labelCrono = new JLabel("00.00.00");
        labelCrono.setFont(new Font("Segoe UI",Font.PLAIN,30));
        panelCronometro.add(labelCrono);
        panelCronometro.setLayout(new FlowLayout());
        
        JPanel panelBtn = new JPanel();
        btnIniciar = new JButton("Iniciar");
        btnIniciar.addActionListener(this);
        btnParar = new JButton("Parar");
        btnParar.addActionListener(this);
        panelBtn.add(btnIniciar);
        panelBtn.add(btnParar);
        panelBtn.setLayout(new FlowLayout());
        
        
        add(panelCronometro, BorderLayout.CENTER);
        add(panelBtn, BorderLayout.SOUTH);
        
        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnIniciar){
            if (iniciarCronometro==false){            
            iniciarCronometro=true;
            iniciarHilo();
            }
        }else{
            if (iniciarCronometro==true){
            iniciarCronometro=false;            
            }            
        }
    }
    
    public void iniciarHilo(){
        Cronometro hilo = new Cronometro(labelCrono);
        hilo.start();
    }
    
}
