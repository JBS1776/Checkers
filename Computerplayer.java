import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Computerplayer implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Piece computerpiece;
	private Tile tile;
	// Easy difficulty, does completely random move
	public Computerplayer cpuMoveEasy(Game g, Color c) {
		Piece piece = g.getBoard().getRandomPiece(g, c);
		while (piece.getPath().size() <= 1) {
			piece = g.getBoard().getRandomPiece(g, c);
		}
		int x = piece.getPosition().getX();
		int y = piece.getPosition().getY();
		Tile til = g.getBoard().getTiles()[y][x];
		this.computerpiece = piece;
		this.tile = til;
		return this;
	}
	// Currently adjusted so that it will capture a piece when it can
	public Computerplayer cpuMoveHard(Game g, Color c) {
		/*HashMap<Piece, Boolean> toCapture = new HashMap<Piece, Boolean>();
		int turn = (c.equals(Constants.colors[0])) ? 0 : 1;
		for (Piece p : g.getBoard().getPieces()[turn]) {
			boolean found = false;
			if (p instanceof Pawn) {
				boolean diagFound = false;
				for (Tile t : p.getPath()) {
					if (t.getX() != p.getPosition().getX()) {
						diagFound = true;
						break;
					}
				}
				if (diagFound) {
					found = true;
					Iterator<Tile> iter = p.getPath().iterator();
					while (iter.hasNext()) {
						Tile til = iter.next();
						if (til.getX() == p.getPosition().getX()) {
							iter.remove();
						}
					}
				}
			}
			else {
				for (Tile t : p.getPath()) {
					if (t.getPiece() != null) {
						if (!c.equals(t.getPiece().getColor())) {
							found = true;
							Iterator<Tile> iter = p.getPath().iterator();
							while (iter.hasNext()) {
								Tile til = iter.next();
								if (til.getPiece() == null) {
									iter.remove();
								}
							}
						}
					}
				}
			}
			toCapture.put(p, found);
		}
		for (Piece p : g.getBoard().getPieces()[turn]) {
			if (!toCapture.get(p)) {
				p.getPath().clear();
				p.getPath().add(g.getBoard().getTiles()[p.getPosition().getY()][p.getPosition().getX()]);
			}
		}*/
		boolean pieceFound = false;
		for (Piece p : g.getBoard().getPieces()[c.equals(Constants.colors[0]) ? 0 : 1]) {
			for (Tile t : p.getPath()) {
				if (t.getPiece() != null) {
					if (!c.equals(t.getPiece().getColor())) {
						pieceFound = true;
						break;
					}
				}
			}
		}
		if (pieceFound) {
		for (Piece p : g.getBoard().getPieces()[c.equals(Constants.colors[0]) ? 0 : 1]) {
			Iterator<Tile> iter = p.getPath().iterator();
			//TODO consider enpassant capture
			while (iter.hasNext()) {
				Tile t = iter.next();
				if (t.getPiece() == null)
					iter.remove();
			}
		}
		}
		return this.cpuMoveEasy(g, c);
	}
	public Piece getPiece() {
		return this.computerpiece;
	}
	public Tile getTile() {
		return this.tile;
	}
}