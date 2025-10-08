package Educative.Cricinfo.teams;

import Educative.Cricinfo.accounts.Player;
import Educative.Cricinfo.stats.TournamentStat;
import Educative.Cricinfo.tournaments.Tournament;

import java.util.Collections;
import java.util.*;

public class TournamentSquad {
    private final UUID id;
    private List<Player> players;
    private Tournament tournament;
    private List<TournamentStat> stats;

    public TournamentSquad(Tournament tournament) {
        this.id = UUID.randomUUID();
        this.tournament = tournament;
        this.players = new ArrayList<>();
        this.stats = new ArrayList<>();
    }

    public boolean addPlayer(Player player) {
        if (!players.contains(player)) {
            players.add(player);
            return true;
        }
        return false;
    }

    public UUID getId() {
        return id;
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public Tournament getTournament() {
        return tournament;
    }

    public List<TournamentStat> getStats() {
        return Collections.unmodifiableList(stats);
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public void addStat(TournamentStat stat) {
        stats.add(stat);
    }
}
