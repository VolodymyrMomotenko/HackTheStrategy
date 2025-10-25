package simulator.core;

import javax.swing.*;


public class GameMap{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Game");
        frame.setSize(1000, 600); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); 
        boolean flag = true;
        for (int i = 0; i < 10; i++) {
            
            int y = 0;
            y = y + 50 * i;
            if (flag == true){
                for (int j = 0; j < 10; j++){
                    JButton Field = new JButton("1");
                    Field.setBounds(150 + 50*j, y, 50, 50); 
                    frame.add(Field);
                }
                flag = false;
            }else{
                for (int j = 0; j < 10; j++){
                    JButton Field = new JButton("2");
                    Field.setBounds(125 + 50*j, y, 50, 50); 
                    frame.add(Field);
                    
                }
                flag = true;
            }
        }
        frame.setVisible(true);


        

    }
 
}