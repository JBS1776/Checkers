import java.util.List;
import java.util.*;
import java.awt.Color;
import java.util.ArrayList;
public class Position implements java.io.Serializable{
 private int x;
 private int y;
 private Board b = new Board();
 private HashMap<Position, Tile> tiles;
 public Position(int x, int y) {
  this.x = x;
  this.y = y;
 }
 public void setX(int x) {
  this.x = x;
 }
 public void setY(int y) {
  this.y = y;
 }
 public int getX() {
  return this.x;
 }
 public int getY() {
  return this.y;
 }
 public int toCoordX() {
  int n = Constants.TILEWIDTH;
  int x = this.getX() * n;
  return x;
 }
 public int toCoordY() {
  int n = Constants.TILEWIDTH;
  int y = this.getY() * n;
  return y;
 }
 public boolean onBoard() {
  if (this.getX() >= 0 && this.getX() <= 8 && this.getY() > 0 && this.getY() <= 8)
   return true;
  return false;
 }
 public Position NW() {
  if (this.onBoard()) {
   Tile tile = this.tiles.get(this);
   Position p = tile.getPosition();
  return new Position(x - 1, y - 1);
  }
  return null;
 }
 public Position N() {
  if (this.onBoard())
  return new Position(x, y - 1);
  return null;
 }
 public Position NE() {
  if (this.onBoard())
  return new Position(x + 1, y - 1);
  return null;
 }
 public Position W() {
  if (this.onBoard())
  return new Position(x - 1, y);
  return null;
 }
 public Position E() {
  if (this.onBoard())
  return new Position(x + 1, y);
  return null;
 }
 public Position SW() {
  if (this.onBoard())
  return new Position(x - 1, y + 1);
  return null;
 }
 public Position S() {
  if (this.onBoard())
  return new Position(x, y + 1);
  return null;
 }
 public Position SE() {
  if (this.onBoard())
  return new Position(x + 1, y + 1);
  return null;
 }
 public List<Position> neighbors() {
  Position[] nbors = {NW(), N(), NE(), W(), E(), SW(), S(), SE()};
  List<Position> nayghbors = new ArrayList<Position>();
  for (Position places : nbors) {
   nayghbors.add(places);
  }
  return nayghbors;
 }
 public String toString() {
  return "" + "(" + this.x + ", " + this.y + ")";
 }
 public static void main(String[] args) {
  Position pos = new Position('E', 4);
  Board b = new Board();
  Position q = new Position('B', 1);
 }

}
