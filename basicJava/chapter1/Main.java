package basicJava.chapter1;

class FishBread {
  private int price;
  private String taste;
  private String color;

  FishBread(int price, String taste, String color) {
    this.price = price;
    this.taste = taste;
    this.color = color;
  }

  @Override
  public String toString() {
    return "FishBread{" +
            "price=" + price +
            ", taste='" + taste + '\'' +
            ", color='" + color + '\'' +
            '}';
  }
}

public class Main {

  public static void main(String[] args) {
    FishBread fishBread = new FishBread(1000, "달콤함", "노란색");
    System.out.println(fishBread);
  }
}
