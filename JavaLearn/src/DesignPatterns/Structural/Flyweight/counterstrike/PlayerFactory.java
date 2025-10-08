package DesignPatterns.Structural.Flyweight.counterstrike;

import java.util.HashMap;

public class PlayerFactory {
    private static HashMap<String, Player> hm =
            new HashMap<String, Player>();

    public static Player getPlayer(String type)  {
        Player p = null;

        /* If an object for TS or CT has already been created simply return its reference */
        if (hm.containsKey(type))
            p = hm.get(type);
        else {
            /* create an object of TS/CT  */
            switch(type) {
                case "Terrorist":
                    System.out.println("Terrorist Created");
                    p = new Terrorist();
                    break;
                case "CounterTerrorist":
                    System.out.println("Counter Terrorist Created");
                    p = new CounterTerrorist();
                    break;
                default :
                    System.out.println("Unreachable code!");
            }
            hm.put(type, p);
        }
        return p;
    }

    static int getPayersSize(){
        return hm.size();
    }
}
