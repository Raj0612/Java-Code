package DesignPatterns.Behavioral.Interpreter.baeldung;

import java.util.List;

public interface Expression {
    List<String> interpret(Context ctx);
}
