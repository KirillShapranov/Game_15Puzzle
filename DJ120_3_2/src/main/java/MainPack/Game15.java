package MainPack;

import javax.swing.*;
import java.awt.*;

public class Game15 {
JButton buttonShaffle=new JButton("Shaffle");
    JButton buttonReset=new JButton("Reset");
    JButton [] buttons=new JButton[15];
JFrame frame;

public int buttonHeight;
public int buttonWidth;
GameController gameController=new GameController(this);
public Game15(){
frame=new JFrame();
}

    public void init(){
        frame.setTitle("Game15");
        frame.setSize(225,300);
        System.out.println(frame.getSize()+"   "+frame.getHeight());


        frame.setResizable(false);
        frame.setLayout(null);



        buttonHeight=(frame.getHeight()-37-55)/4;
        buttonWidth= buttonHeight;

        for (int c=0; c<4;c++) {
            for (int d = 0; d < 4; d++) {
                if (c == 3 && d == 3) break;

                buttons[c * 4 + d] = new JButton(String.valueOf(1 + c * 4 + d));
                buttons[c * 4 + d].setBounds(d * buttonWidth, c * buttonHeight, buttonWidth, buttonHeight);
                buttons[c * 4 + d].addActionListener(gameController);
                frame.add(buttons[c * 4 + d]);

            }
        }

        buttonShaffle.setBounds(0,4*buttonHeight,buttonWidth*2,buttonHeight);
        buttonReset.setBounds(2*buttonWidth,4*buttonHeight,buttonWidth*2,buttonHeight);



        frame.add(buttonShaffle);
        buttonReset.addActionListener(gameController);
        buttonShaffle.addActionListener(gameController);
        frame.add(buttonReset);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
}


}
