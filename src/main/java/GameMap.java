package src.main.java;

import javax.swing.*;


public class GameMap{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Game");
        frame.setSize(1000, 600); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); 
        frame.setVisible(true);

        for (int i = 0; i < 10; i++) {
            int y = 0;
            y = y + 50 * i;
            for (int j = 0; j < 6; j++){
                JButton Field = new JButton("N");
                Field.setBounds(150 + 50*j, y, 50, 50); // x pos, y pos, width, height
                frame.add(Field);
            }
                
            
          }
          
          


        

    }
 
}