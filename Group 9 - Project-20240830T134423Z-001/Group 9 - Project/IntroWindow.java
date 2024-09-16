import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

public class IntroWindow {

    public static void introWindow() {
        JFrame frame = new JFrame("Welcome to UniPoint");
        frame.setSize(1010, 650);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(null);

        ImageIcon image = new ImageIcon("UnipointIntro.png");
        JLabel label = new JLabel(image);
        label.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());

        JButton btnUnipointWindow = new JButton("Start Searching");
        btnUnipointWindow.setBounds(40, 360, 160, 50);
        btnUnipointWindow.setBackground(new Color(114,2,2,200));
        btnUnipointWindow.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2, true));
        btnUnipointWindow.setForeground(Color.YELLOW);
        btnUnipointWindow.setFocusable(false);
        btnUnipointWindow.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
            frame.setVisible(false);
            new ProjUnipoint();
            }
        });
        
        panel.add(label);
        panel.add(btnUnipointWindow);
        frame.add(panel);
        frame.getContentPane();

        frame.setVisible(true);

    }

    public static void main(String[] args) {
        introWindow();
    }
}