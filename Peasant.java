import java.awt.Color;
import java.util.ArrayList;

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
	  this.getCapturePath().clear();
	  for (Tile s : board.neighbors(t)) {
		  if (t.getPiece().getColor().equals(Constants.colors[0])) {
			  if (s.getPosition().getY() < y) {
				  if (s.getPiece() == null) {
					  this.getPath().add(s);
				  }
			  }
		  }
		  else {
			  if (s.getPosition().getY() > y) {
				  if (s.getPiece() == null) {
					  this.getPath().add(s);
				  }
			  }
		  }
	  }
	  recursCapPath(g, t);
	  this.getPath().addAll(this.getCapturePath());
	}
ArrayList<Tile> setCapturePath(Game g, Tile b) {
	ArrayList<Tile> tiles = new ArrayList<Tile>();
	int x = b.getPosition().getX();
	int y = b.getPosition().getY();
	for (Tile s : g.getBoard().neighbors(b)) {
		int xdiff = s.getPosition().getX();
		int ydiff = s.getPosition().getY();
		if (s.getPiece() != null) {
			if (g.getTurnColor().equals(Constants.colors[0])) {
				if (!s.getPiece().getColor().equals(g.getTurnColor())) {
					if (x - xdiff == 1 && y - ydiff == 1) {
						// Also must check for duplicates so we don't get stackbased overflow!!
						if (xdiff - 1 >= 0 && ydiff - 1 >= 0 && g.getBoard().getTiles()[ydiff - 1][xdiff - 1].getPiece() == null
								&& !this.getCapturePath().contains(g.getBoard().getTiles()[ydiff - 1][xdiff - 1]))
							tiles.add(g.getBoard().getTiles()[ydiff - 1][xdiff - 1]);
					}
					if (x - xdiff == -1 && y - ydiff == 1) {
						if (xdiff + 1 < 8 && ydiff - 1 >= 0 && g.getBoard().getTiles()[ydiff - 1][xdiff + 1].getPiece() == null
								&& !this.getCapturePath().contains(g.getBoard().getTiles()[ydiff - 1][xdiff + 1]))
							tiles.add(g.getBoard().getTiles()[ydiff - 1][xdiff + 1]);
						}
					}
				}
			else {
				if (!s.getPiece().getColor().equals(g.getTurnColor())) {
					if (x - xdiff == 1 && y - ydiff == -1) {
						if (xdiff - 1 >= 0 && ydiff + 1 < 8 && g.getBoard().getTiles()[ydiff + 1][xdiff - 1].getPiece() == null
								&& !this.getCapturePath().contains(g.getBoard().getTiles()[ydiff + 1][xdiff - 1]))
							tiles.add(g.getBoard().getTiles()[ydiff + 1][xdiff - 1]);
					}
					if (x - xdiff == -1 && y - ydiff == -1) {
						if (xdiff + 1 < 8 && ydiff + 1 < 8 && g.getBoard().getTiles()[ydiff + 1][xdiff + 1].getPiece() == null
								&& !this.getCapturePath().contains(g.getBoard().getTiles()[ydiff + 1][xdiff + 1]))
							tiles.add(g.getBoard().getTiles()[ydiff + 1][xdiff + 1]);
					}
				}
			}
		}
	}
	this.getCapturePath().addAll(tiles);
	return tiles;
	}
//Yep had to use recursion here as we have to account for multiple directions!
private void recursCapPath(Game g, Tile b) {
	ArrayList<Tile> caps = this.getCapturePath();
	ArrayList<Tile> adds = this.setCapturePath(g, b);
	if (adds.isEmpty()) {
		return;
	}
	else {
		for (Tile t : adds) {
			recursCapPath(g, t);
		}
	}
}
}