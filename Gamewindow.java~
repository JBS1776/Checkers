import java.awt.*;



import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.Timer;
public class Gamewindow extends JFrame implements Runnable, java.io.Serializable{
  private Gamewindow frame;
  private Game game;
  static Timer timer = null;
  static boolean isEnabled = false;
  static boolean takeMeChess = false;
  static ArrayList<Piece>[] savedGame = new ArrayList[2];
  Random rand = new Random();
  ColorChooserExample colorChooser = new ColorChooserExample();
  public Gamewindow(ArrayList<Piece>[] start, int turns) {
    try {
    game = new Game(start, turns);
    this.add(game);
    this.setVisible(true);
    this.setSize(new Dimension(Constants.FULLSCREENWIDTH, Constants.FULLSCREENHEIGHT));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.initializeMenu();
      timer = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          try {
          game.setTime();
          }
          catch (InterruptedException ex) {
          }
    }
      });
    }
    catch (InterruptedException e) {
      
    }
    timer.start();
  }
 public void initializeMenu() {
 JMenuBar menu = new JMenuBar();
 JMenu menu1 = new JMenu("File");
 JMenu menu2 = new JMenu("Settings");
 JMenu menu3 = new JMenu("Instructions");
 JMenuItem stuff = new JMenuItem("Who reads them these days?");
 //JMenuItem hint = new JMenuItem("Hint (only available in take-me chess)");
 JMenuItem save = new JMenuItem("save: It's always good to save");
 JMenuItem open = new JMenuItem("open: Load a saved game");
 JMenuItem reset = new JMenuItem("surrender ONLY LOSERS SURRENDER!!");
 JMenuItem appearance = new JMenuItem("Change appearance");
 JMenuItem setTime = new JMenuItem("Change rules");
 menu1.add(open);
 menu1.add(save);
 menu1.add(reset);
 menu2.add(appearance);
 menu2.add(setTime);
 menu3.add(stuff);
 //menu3.add(hint);
 menu.add(menu1);
 menu.add(menu2);
 menu.add(menu3);
 save.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
     newSavedGame();
   }
 });
 setTime.addActionListener(new ActionListener() {
  @Override
  public void actionPerformed(ActionEvent e) {
    JFrame frame = new JFrame("Frame");
    int multiplyer = 10;
    int index = 0;
    //frame.add(isEnabled);
    frame.setLayout(null);
    frame.setResizable(false);
    JCheckBox enableTime = new JCheckBox("Enable time", Gamewindow.isEnabled);
    enableTime.setBounds(0, 10, 500, 20);
    frame.add(enableTime);
    Gamewindow.isEnabled = enableTime.isSelected();
    boolean oldEnabled = Gamewindow.isEnabled;
    boolean oldTakeMe = Gamewindow.takeMeChess;
    enableTime.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
        Gamewindow.isEnabled = enableTime.isSelected();
      }
    });
    JRadioButton[] buttons = new JRadioButton[2];
    buttons[0] = new JRadioButton("Regular Chess");
    buttons[0].setBounds(0, 50, 200, 20);
    frame.add(buttons[0]);
    buttons[0].setSelected(!Gamewindow.takeMeChess);
    buttons[1] = new JRadioButton("Take-me Chess");
    buttons[1].setBounds(0, 70, 200, 20);
    frame.add(buttons[1]);
    buttons[1].setSelected(Gamewindow.takeMeChess);
    for (JRadioButton buts : buttons) {
      buts.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          Object o = e.getSource();
          if (o instanceof JRadioButton) {
            JRadioButton curr = (JRadioButton) o;
            for (int i = 0; i < buttons.length; i++) {
              if (buttons[i].equals(curr)) {
                if (!buttons[i].isSelected()) {
                  buttons[i].setSelected(true);
                  buttons[(i + 1) % 2].setSelected(false);
                }
                else {
                  buttons[(i + 1) % 2].setSelected(false);
                  buttons[i].setSelected(true);
                }
              }
            }
            Gamewindow.takeMeChess = buttons[1].isSelected();
        }
        }
      });
    }
    JButton cancel = new JButton("Cancel");
    cancel.setBounds(200, 350, 100, 20);
    cancel.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Gamewindow.takeMeChess = oldTakeMe;
        Gamewindow.isEnabled = oldEnabled;
        frame.dispose();
      }
    });
    frame.add(cancel);
    JButton apply = new JButton("Apply");
    frame.add(apply);
    apply.setBounds(350, 350, 100, 20);
    apply.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        frame.dispose();
        newGame();
   }
  });
    JLabel label = new JLabel();
    label.setText("Hitting Apply will start a new game with the applied settings.");
    label.setBounds(20, 200, 400, 20);
    JLabel label2 = new JLabel();
    label2.setText("Hitting Cancel will revert to default settings.");
    label2.setBounds(20, 230, 400, 20);
    JLabel label3 = new JLabel();
    label3.setText("When time is enabled, 15 minutes are alloted for each move.");
    label3.setBounds(20, 35, 400, 10);
  frame.add(label);
  frame.add(label2);
  frame.add(label3);
  frame.setSize(500, 400);
  frame.setVisible(true);
  frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
  }
 });
 appearance.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
     Color color=JColorChooser.showDialog(game,"Select a color",Constants.BACKGROUNDCOL);
     game.setBackground(color);
   }
 });
 reset.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
     Game.timeEnabled = Gamewindow.isEnabled;
     newGame();
   }
 });
 /*hint.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
     if (!Gamewindow.takeMeChess) {
     JOptionPane.showMessageDialog(null, "No hints can be provided!  Refer to the chessReadme.docx document for the rules!  Think very carefully about your next move!", "A hint", JOptionPane.ERROR_MESSAGE, ((Game.turnCount % 2) == 0) ? Constants.whiteimages[rand.nextInt(Constants.whiteimages.length)] : Constants.blackimages[rand.nextInt(Constants.blackimages.length)]);
     }
     else {
       if (Board.take.isEmpty()) {
         JOptionPane.showMessageDialog(null, "Your pieces currently don't have any restricted range!", "No hints available!", JOptionPane.ERROR_MESSAGE, ((Game.turnCount % 2) == 0) ? Constants.whiteimages[rand.nextInt(Constants.whiteimages.length)] : Constants.blackimages[rand.nextInt(Constants.blackimages.length)]);
       }
       else {
         int randIndex = rand.nextInt(Board.take.size());
         String player = "";
         String enemy = "";
         int i = 0;
         for (Piece p : Board.take.keySet()) {
           if (i == randIndex) {
         player = Board.take.get(p).get(0).getTile().getPiece().getName();
         enemy = Board.take.get(p).get(1).getTile().getPiece().getName();
           }
           i++;
         }
         JOptionPane.showMessageDialog(null, "Try to use your " + player + " to take your opponent's " + enemy + ".", "Here's an idea!", JOptionPane.ERROR_MESSAGE, ((Game.turnCount % 2) == 0) ? Constants.whiteimages[rand.nextInt(Constants.whiteimages.length)] : Constants.blackimages[rand.nextInt(Constants.blackimages.length)]);
       }
     }
   }
 });*/
  this.setJMenuBar(menu);
  }
 @Override
 public void run() {

 }
 public void newSavedGame() {
   Gamewindow.timer.stop();
   dispose();
     try {
   //System.setProperty("apple.laf.useScreenMenuBar", "true");
   //System.setProperty("com.apple.mrj.application.apple.menu.about.name", "WikiTeX");
   UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
      //UIManager.setLookAndFeel(new javax.swing.plaf.metal.MetalLookAndFeel());
  } catch (Exception ex) {
      System.err.println("Cannot set LookAndFeel");
  }
  SwingUtilities.invokeLater(new Gamewindow(Game.board.pieces, Game.turnCount));
 }
 public void newGame() {
   Gamewindow.timer.stop();
   dispose();
     try {
   //System.setProperty("apple.laf.useScreenMenuBar", "true");
   //System.setProperty("com.apple.mrj.application.apple.menu.about.name", "WikiTeX");
   UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
      //UIManager.setLookAndFeel(new javax.swing.plaf.metal.MetalLookAndFeel());
  } catch (Exception ex) {
      System.err.println("Cannot set LookAndFeel");
  }
  SwingUtilities.invokeLater(new Gamewindow(null, 0));
 }
  public static void main(String[] args) {
    try {
   //System.setProperty("apple.laf.useScreenMenuBar", "true");
   //System.setProperty("com.apple.mrj.application.apple.menu.about.name", "WikiTeX");
   UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
      //UIManager.setLookAndFeel(new javax.swing.plaf.metal.MetalLookAndFeel());
  } catch (Exception ex) {
      System.err.println("Cannot set LookAndFeel");
  }
  SwingUtilities.invokeLater(new Gamewindow(null, 0));
  }
}
