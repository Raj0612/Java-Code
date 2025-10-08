package DesignPatterns.Structural.Flyweight.character;

public class ConcreteCharacter implements Character {
    private char character;
    public ConcreteCharacter(char character) {
        this.character = character;
    }
    @Override
    public void display(String font) {
        System.out.println("Character: " + character + ", Font: " + font);
    }
}

