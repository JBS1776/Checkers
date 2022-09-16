import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;

class TileButton extends JButton implements java.io.Serializable{  
    private Tile tile;
    private Board board = new Board();
    public TileButton(Tile tile) {
      this.tile = tile;
    }
    public void select(ArrayList<TileButton> tiles) {
      for (TileButton t : tiles) {
        t.setBackground(Constants.HIGHLIGHTER);
      }
    }
    public void deSelect(ArrayList<TileButton> tiles) {
      for (TileButton t : tiles) {
        t.setBackground(t.getTile().getColor());
      }
      if (!Gamewindow.takeMeChess) {
      if (Game.currKingCheck)
      Game.board.kingsButton[Game.turnCount % 2].setBackground(Constants.CHECKHIGHLIGHT);
      else
        Game.board.kingsButton[Game.turnCount % 2].setBackground(Color.GREEN);
    }
    }
    public static void clearPaint() {
      for (TileButton[] tis : Game.board.tiles)
        for (TileButton but : tis)
        but.setBackground(but.getTile().getColor());
    }
      public Tile getTile() {
       return this.tile;
      }
      public static ArrayList<TileButton> intersection(ArrayList<TileButton> a, ArrayList<TileButton> b) {
        ArrayList<TileButton> lis = new ArrayList<TileButton>();
        for (int i = 0; i < a.size(); i++) {
          for (int j = 0; j < b.size(); j++) {
            if (a.get(i).equals(b.get(j)) && !lis.contains(a.get(i))) {
              lis.add(a.get(i));
              break;
            }
          }
        }
        return lis;
      }
    }
