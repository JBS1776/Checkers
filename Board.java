import javax.swing.JOptionPane;
import java.awt.*;
import java.io.Serializable;
import java.util.*;
public class Board implements Serializable{
	private static final long serialVersionUID = 1L;


private ArrayList<Piece>[] pieces = new ArrayList[2];
private HashMap<Piece, ArrayList<Tile>> take = new HashMap<Piece, ArrayList<Tile>>();
private ArrayList<Piece>[] removedPieces = new ArrayList[2];
private Tile[][] tiles = new Tile[8][8];
private int[][] maxPieceIds = new int[2][2];
private boolean windowDisplayed = false;
public Board() {
  for (int i = 0; i < 2; i++) {
    pieces[i] = new ArrayList<Piece>();
  }
}
private class Duple {
	  Tile button;
	  boolean isRemoved;
	  public Duple(Tile button, boolean isRemoved) {
	    this.button = button;
	    this.isRemoved = isRemoved;
	  }
}
Tile[][] fillTiles(int startX, int startY, int setting) {
Tile[][] tis = this.tiles;
int x = startX;
int y = startY;
int n = Constants.TILEWIDTH;
int m = Constants.TILEHEIGHT;
int identification = 1;
for (int i = 0; i < 8; i++) {
	for (int j = 0; j < 8; j++) {
		int colIndex = (i + j) & 1;
		Tile t = new Tile(n, m, x, y, Constants.colors[colIndex], null);
		t.setPosition(j, i);
		t.setColor(Constants.colors[(i & 1) == 0 ? (j & 1) : ((j + 1) & 1)]);
		if (i == 0 || i == 2) {
			if ((j & 1) == 1) {
				t.setImage(Constants.images[0][0]);
				t.setPiece(new Peasant(identification, Constants.colors[1], new Position(j, i), t.getImage()));
				pieces[0].add(t.getPiece());
			}
		}
		if (i == 1) {
			if ((j & 1) == 0) {
				t.setImage(Constants.images[0][0]);
				t.setPiece(new Peasant(identification, Constants.colors[1], new Position(j, i), t.getImage()));
				pieces[0].add(t.getPiece());
			}
		}
		if (i == 5 || i == 7) {
			if ((j & 1) == 0) {
				t.setImage(Constants.images[1][0]);
				t.setPiece(new Peasant(identification, Constants.colors[0], new Position(j, i), t.getImage()));
				pieces[1].add(t.getPiece());
			}
		}
		if (i == 6) {
			if ((j & 1) == 1) {
				t.setImage(Constants.images[1][0]);
				t.setPiece(new Peasant(identification, Constants.colors[0], new Position(j, i), t.getImage()));
				pieces[1].add(t.getPiece());
			}
		}
		tis[i][j] = t;
		x += n;
		if ((j & 7) == 7) {
			x = startX;
			y += m;
		}
 	}
}
return tis;
}
Tile[][] fillTiles2(int startX, int startY, int setting, ArrayList<Piece>[] lis) {
	 Tile[][] tis = this.tiles;
	 int x = startX;
	 int y = startY;
	 int n = Constants.TILEWIDTH;
	 int m = Constants.TILEHEIGHT;
	 for (int i = 0; i < 8; i++) {
	  for (int j = 0; j < 8; j++) {
	   int colIndex = (i + j) & 1;
	   Tile t = new Tile(n, m, x, y, Constants.colors[colIndex], null);
	   t.setPosition(j, i);
	   tis[i][j] = t;
	   x += n;
	   if ((j & 7) == 7) {
	     x = startX;
	     y += m;
	   }
	}
	 }
	 this.pieces = lis;
	 for (int i = 0; i < 2; i++) {
	   for (Piece p : this.pieces[i]) {
	       Position pos = p.getPosition();
	       x = pos.getX();
	       y = pos.getY();
	       tis[y][x].setPiece(p);
	       tis[y][x].setImage(p.getImage());
	 }
	}
	  return tis;
	}
void setPieces(Game g) {
	  for (int i = 0; i < this.pieces.length; i++) {
	  for (Piece p : this.pieces[i]) {
		  if (p instanceof Peasant)
			  this.maxPieceIds[i][0] = Math.max(this.maxPieceIds[i][0], p.getId());
		  if (p instanceof King)
			  this.maxPieceIds[i][1] = Math.max(this.maxPieceIds[i][1], p.getId());
	    p.getPath().clear();
	    Position pos = p.getPosition();
	    int x = pos.getX();
	    int y = pos.getY();
	    p.setPath(g, g.getBoard().tiles[y][x]);
	  }
	  }
	  }
void move(Tile prev, Tile next, Game g) {
	  int currTurn = g.getTurnCount();
	  Piece p = prev.getPiece();
	  Piece q = next.getPiece();
	  Position posPrev = prev.getPosition();
	  Position pos = next.getPosition();
	  if (q != null) {
		g.getMoveList().add((g.getMoveList().size() + 1) + ". " + p.getName() + p.getId() + ": " + posPrev + " X " + pos);
	    p.setHasMoved(true);
	    next.setIcon(prev.getImage());
	    next.setPiece(p);
	    next.setImage(prev.getImage());
	    next.getPiece().setPosition(pos);
	    prev.setIcon(null);
	    prev.setPiece(null);
	    prev.setImage(null);
	    this.pieces[(currTurn + 1) & 1].remove(q);
	    g.getCapturedPieces().get(q.findIndex(Constants.colors[(currTurn + 1) & 1])).add(q);
	  }
	  else {
	    if (p instanceof Peasant) {
	      int posDiff = Math.abs(pos.getY() - posPrev.getY());
	      if (posDiff == 2) {

	      }
	      else {
	        int posDiffx = Math.abs(pos.getX() - posPrev.getX());
	        int posDiffy = Math.abs(pos.getY() - posPrev.getY());
	        if (posDiffx == 1 && posDiffy == 1) {
	          Tile tb1 = this.tiles[pos.getY() - 1][pos.getX()];
	          Tile tb2 = this.tiles[pos.getY() + 1][pos.getX()];
	          Tile[] tils = {tb1, tb2};
	          for (Tile but : tils) {
	          but.setIcon(null);
	          but.setPiece(null);
	          but.setImage(null);
	          }
	        }
	      }
	    }
		g.getMoveList().add((g.getMoveList().size() + 1) + ". " + p.getName() + p.getId() + ": " + posPrev + pos);
	    p.setHasMoved(true);
	    next.setIcon(prev.getImage());
	    next.setPiece(p);
	    next.setImage(prev.getImage());
	    next.getPiece().setPosition(pos);
	    prev.setIcon(null);
	    prev.setPiece(null);
	    prev.setImage(null);
	  }
	}
void clearPaint(Game g) {
    for (Tile[] tis : g.getBoard().tiles)
      for (Tile but : tis)
    	  but.setBackground(but.getColor());
}
private ArrayList<Tile> intersection(ArrayList<Tile> a, ArrayList<Tile> b) {
    ArrayList<Tile> lis = new ArrayList<Tile>();
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
Piece getRandomPiece(Game g, Color c) {
	int index = c.equals(Constants.colors[0]) ? 0 : 1;
	int randPiece = Constants.rand.nextInt(g.getBoard().pieces[index].size());
	return g.getBoard().pieces[index].get(randPiece);
}
public Tile[][] getTiles() {
	return this.tiles;
}
public ArrayList<Piece>[] getPieces() {
	return this.pieces;
}
public HashMap<Piece, ArrayList<Tile>> getTake() {
  return this.take;
}
public int[][] getMaxPieceIds() {
	return this.maxPieceIds;
}
public void setMaxPieceIds(int i, int j, int val) {
	this.maxPieceIds[i][j] = val;
}
}