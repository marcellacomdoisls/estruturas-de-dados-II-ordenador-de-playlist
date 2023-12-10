public class Node {
  Music music;
  Node left, right;

  public Node(Music music) {
    this.music = music;
    left = right = null;
  }

  public Music getMusic() {
    return this.music;
  }

  public void setMusic(Music music) {
    this.music = music;
  }

  public Node getLeft() {
    return this.left;
  }

  public void setLeft(Node left) {
    this.left = left;
  }

  public Node getRight() {
    return this.right;
  }

  public void setRight(Node right) {
    this.right = right;
  }
}
