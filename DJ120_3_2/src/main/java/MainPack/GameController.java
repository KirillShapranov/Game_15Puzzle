package MainPack;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController implements ActionListener {

   Game15 parent; // ссылка на класс с визуальной частью
    public GameController(Game15 parent){  //конструктор с ссылкой на визуальную часть
        this.parent=parent;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        int button14=0,button15=0;
        JButton currentButton=(JButton) e.getSource();
      if (currentButton.getActionCommand()=="Reset") {

          int res=JOptionPane.showConfirmDialog(null,"Вы уверены?","Reset",JOptionPane.YES_NO_OPTION);

          if (res==0) {
              reset();
              return;
          }else return;
      } else if (currentButton.getActionCommand()=="Shaffle") {
          shaffle();return;
      } else {

          if (checkPoint(currentButton.getX() + parent.buttonWidth, currentButton.getY()) && currentButton.getX() < 3 * parent.buttonWidth) {
              currentButton.setBounds(currentButton.getX() + parent.buttonWidth, currentButton.getY()
                      , parent.buttonWidth, parent.buttonHeight);
          } else if (checkPoint(currentButton.getX() - parent.buttonWidth, currentButton.getY()) && currentButton.getX() > 0) {
              currentButton.setBounds(currentButton.getX() - parent.buttonWidth, currentButton.getY()
                      , parent.buttonWidth, parent.buttonHeight);
          } else if (checkPoint(currentButton.getX(), currentButton.getY() + parent.buttonHeight) && currentButton.getY() < 3 * parent.buttonHeight) {
              currentButton.setBounds(currentButton.getX(), currentButton.getY() + parent.buttonHeight
                      , parent.buttonWidth, parent.buttonHeight);
          } else if (checkPoint(currentButton.getX(), currentButton.getY() - parent.buttonHeight) && currentButton.getY() > 0) {
              currentButton.setBounds(currentButton.getX(), currentButton.getY() - parent.buttonHeight
                      , parent.buttonWidth, parent.buttonHeight);
          }

          for (int c = 0; c < parent.buttons.length; c++) {
              int textButton = Integer.valueOf(parent.buttons[c].getText());
              if (textButton == 14) button14 = c;
              if (textButton == 15) button15 = c;
              int a = 0;
              if (textButton >= 1 && textButton <= 4) a = 0;
              else if (textButton >= 5 && textButton <= 8) a = 1;
              else if (textButton >= 9 && textButton <= 12) a = 2;
              else if (textButton >= 10 && textButton <= 15) a = 3;
              int coordX = (textButton - 4 * a - 1) * parent.buttonWidth;
              int coordY = a * parent.buttonHeight;



              if (textButton < 14) {
                  if (parent.buttons[c].getX() != coordX || parent.buttons[c].getY() != coordY)
                      return;
              }


          }
      }


        if (parent.buttons[button14].getX()==parent.buttonWidth&&parent.buttons[button15].getX()==2* parent.buttonWidth){

        JOptionPane.showMessageDialog(null,"Вы выиграли","Поздравляем",JOptionPane.INFORMATION_MESSAGE);}
        else if (parent.buttons[button15].getX()==parent.buttonWidth&&parent.buttons[button14].getX()==2* parent.buttonWidth) {

            JOptionPane.showMessageDialog(null,"И так сойдет)","Ничего)",JOptionPane.INFORMATION_MESSAGE);
        }

    }
    private  boolean checkPoint(int x,int y){
        for (int c=0; c<parent.buttons.length; c++){
            if (parent.buttons[c].getX()==x&&parent.buttons[c].getY()==y)
            return false;
        }

        return true;
    }
    public void reset(){

        for (int c=0; c<4;c++) {
            for (int d = 0; d < 4; d++) {
                if (c == 3 && d == 3) break;

                parent.buttons[c * 4 + d].setText(String.valueOf(1 + c * 4 + d));
                parent.buttons[c * 4 + d].setBounds(d * parent.buttonWidth, c * parent.buttonHeight,
                        parent.buttonWidth, parent.buttonHeight);


            }
        }


    }
    public void shaffle(){
        int []temp=new int[15];

        for (int c=0;c<15;c++){

            temp[c]=(int)(Math.random()*(16-1)+1);
            for( int d=0; d<c;d++){
                if(temp[d]==temp[c]) {
                    c--;break;}
            }
        }
        for (int c=0; c<4;c++) {
            for (int d = 0; d < 4; d++) {
                if (c == 3 && d == 3) break;
                parent.buttons[c * 4 + d].setText(String.valueOf(temp[c * 4 + d]));


            }
        }
    }
}
