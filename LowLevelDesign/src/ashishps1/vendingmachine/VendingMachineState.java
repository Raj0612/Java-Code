package ashishps1.vendingmachine;

import ashishps1.vendingmachine.enums.Coin;
import ashishps1.vendingmachine.enums.Note;

public interface VendingMachineState {
    void selectProduct(Product product);

    void insertCoin(Coin coin);

    void insertNote(Note note);

    void dispenseProduct();

    void returnChange();
}
