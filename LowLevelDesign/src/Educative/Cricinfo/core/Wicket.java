package Educative.Cricinfo.core;

import Educative.Cricinfo.accounts.Player;
import Educative.Cricinfo.enums.WicketType;

public class Wicket {
    private WicketType type;
    private Player playerOut;
    private Player bowledBy;
    private Player caughtBy;
    private Player runoutBy;
    private Player stumpedBy;

    public Wicket(WicketType type, Player playerOut) {
        this.type = type;
        this.playerOut = playerOut;
    }

    public WicketType getType() {
        return type;
    }

    public Player getPlayerOut() {
        return playerOut;
    }

    public Player getBowledBy() {
        return bowledBy;
    }

    public Player getCaughtBy() {
        return caughtBy;
    }

    public Player getRunoutBy() {
        return runoutBy;
    }

    public Player getStumpedBy() {
        return stumpedBy;
    }

    public void setType(WicketType type) {
        this.type = type;
    }

    public void setPlayerOut(Player playerOut) {
        this.playerOut = playerOut;
    }

    public void setBowledBy(Player bowledBy) {
        this.bowledBy = bowledBy;
    }

    public void setCaughtBy(Player caughtBy) {
        this.caughtBy = caughtBy;
    }

    public void setRunoutBy(Player runoutBy) {
        this.runoutBy = runoutBy;
    }

    public void setStumpedBy(Player stumpedBy) {
        this.stumpedBy = stumpedBy;
    }
}
