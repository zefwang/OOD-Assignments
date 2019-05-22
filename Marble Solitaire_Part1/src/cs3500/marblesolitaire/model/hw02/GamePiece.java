package cs3500.marblesolitaire.model.hw02;

public enum GamePiece {
  INVALID(" "), MARBLE("O"), EMPTY("_");

  private String text;

  GamePiece(String text){
    this.text = text;
  }

  @Override
  public String toString(){
    return this.text;
  }
}
