package basicJava.chapter5;

abstract class Animal {
  abstract void speak();
}

class Dog extends Animal {
  void speak() {
    System.out.println("멍멍");
  }
}

class Cat extends Animal {

  void speak() {
    System.out.println("냐옹");
  }
}

public class OOPEx07 {

  public static void main(String[] args) {
    Animal a1 = new Dog();
    Animal a2 = new Cat();
    a1.speak();
    a2.speak();

  }
}
