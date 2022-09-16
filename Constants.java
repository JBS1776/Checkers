
import java.awt.*;
import java.util.*;
import javax.swing.*;
public class Constants implements java.io.Serializable{
  
 public static int TIME = 900;
  
 public static int FULLSCREENWIDTH = 1280;
 
 public static int FULLSCREENHEIGHT = 800;
 
 public static final int BOARDWIDTH = 600; // Height
 
 public static final int BOARDHEIGHT = 600; // Width, If JMenu set to (BOARDWIDTH + 26) otherwise BOARDWIDTH
 
 public static int SCREENPOSX = (FULLSCREENWIDTH - BOARDWIDTH) / 2;
 
 public static int SCREENPOSY = (FULLSCREENHEIGHT - BOARDHEIGHT) / 4;
 
 public static final int TILEWIDTH = BOARDWIDTH / 8;
 
 public static final int TILEHEIGHT = BOARDHEIGHT / 8;
 
 public static final Color[] colors = {Color.WHITE, Color.BLACK};
 
 public static final Color HIGHLIGHTER = Color.PINK;
 
 public static final Color BACKGROUNDCOL = new Color(127, 127, 127);
 
 public static final int aiLevel = 0;
 
 public static final int aiColor = 1;
 
 public static final int balanceFactor = 10;
 
 public static final int PieceAppearance = 0;
 
 public static final ArrayList<LinkedList<Piece>> CAPTUREDPIECES = null;
 
 public static final ArrayList<String> MOVELIST = null;
 
 public static final Piece ENPASS = null;
 
 public static final boolean isPromotionEnabled = false;
 
 public static final ArrayList<Piece>[] STARTCONFIG = null;
 
 public static final int STARTTURNCOUNT = 0;
 
 public static final boolean isKingInCheck = false;
 
 public static final boolean startCastle = false;
 
 public static final boolean isEndGame = false;
 
 public static final boolean isTimeEnabled = false;
 
 public static final boolean takeMeChess = false;
 
 
 public static final String[][] names = {{"sprites/BlackPiece.png", "sprites/BlackKing.png"}, {"sprites/WhitePiece.png", "sprites/WhiteKing.png"}};
 
 public static final Random rand = new Random();
 
 public static final ImageIcon[] blackimages = {new ImageIcon(names[0][0], "BlackPiece"), new ImageIcon(names[0][1], "BlackKing")};
 public static final ImageIcon[] whiteimages = {new ImageIcon(names[1][0], "WhitePiece"), new ImageIcon(names[1][1], "WhiteKing")};
 
 public static final ImageIcon[][] images = {blackimages, whiteimages};
 
}
