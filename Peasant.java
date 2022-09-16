import java.awt.Color;

import javax.swing.ImageIcon;

public class Peasant extends Piece implements java.io.Serializable{
 /**
	 * 
	 */
 private static final long serialVersionUID = 1L;
 public Peasant(int id, Color color, Position pos, ImageIcon image) {
	 super(id, color, pos, image);
 }
void setPath(Game g, Tile t) {
	  Board board = g.getBoard();
	  Color c = this.getColor();
	  this.getPath().clear();
	  int x = t.getPosition().getX();
	  int y = t.getPosition().getY();
	  this.getPath().add(t);
	  this.getAllies().clear();
	  if (t.getPiece().getColor().equals(Constants.colors[0])) {
		  if (y - 1 >= 0 && x - 1 >= 0) {
			  if (board.getTiles()[y - 1][x - 1].getPiece() == null)
				  this.getPath().add(board.getTiles()[y - 1][x - 1]);
		  }
		  if (y - 1 >= 0 && x + 1 < 8) {
			  if (board.getTiles()[y - 1][x + 1].getPiece() == null)
				  this.getPath().add(board.getTiles()[y - 1][x + 1]);
		  }
	  }
	  else {
		  if (y + 1 < 8 && x + 1 < 8) {
			  if (board.getTiles()[y + 1][x + 1].getPiece() == null)
				  this.getPath().add(board.getTiles()[y + 1][x + 1]);
		  }
		  if (y + 1 < 8 && x - 1 >= 0) {
			  if (board.getTiles()[y + 1][x - 1].getPiece() == null)
				  this.getPath().add(board.getTiles()[y + 1][x - 1]);
		  }
	  }
	}
}