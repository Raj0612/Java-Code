package Educative.Cricinfo.core;

import Educative.Cricinfo.accounts.Player;
import Educative.Cricinfo.commentary.Commentary;
import Educative.Cricinfo.enums.BallType;

import java.util.*;

public class Ball {
    private Player bowledBy;
    private Player playedBy;
    private BallType type;
    private List<Run> runs;
    private Wicket wicket;
    private final List<Commentary> commentaryList;

    public Ball(Player bowledBy, Player playedBy, BallType type) {
        this.bowledBy = bowledBy;
        this.playedBy = playedBy;
        this.type = type;
        this.runs = new ArrayList<>();
        this.commentaryList = new ArrayList<>();
    }

    public boolean addCommentary(Commentary commentary) {
        return commentaryList.add(commentary);
    }

    public Player getBowledBy() {
        return bowledBy;
    }

    public Player getPlayedBy() {
        return playedBy;
    }

    public BallType getType() {
        return type;
    }

    public List<Run> getRuns() {
        return Collections.unmodifiableList(runs);
    }

    public Wicket getWicket() {
        return wicket;
    }

    public List<Commentary> getCommentaryList() {
        return Collections.unmodifiableList(commentaryList);
    }

    public void setBowledBy(Player bowledBy) {
        this.bowledBy = bowledBy;
    }

    public void setPlayedBy(Player playedBy) {
        this.playedBy = playedBy;
    }

    public void setType(BallType type) {
        this.type = type;
    }

    public void setWicket(Wicket wicket) {
        this.wicket = wicket;
    }

    public void addRun(Run run) {
        runs.add(run);
    }
}
