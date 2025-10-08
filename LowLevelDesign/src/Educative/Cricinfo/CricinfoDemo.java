package Educative.Cricinfo;
import Educative.Cricinfo.accounts.*;
import Educative.Cricinfo.commentary.*;
import Educative.Cricinfo.core.*;
import Educative.Cricinfo.enums.*;
import Educative.Cricinfo.matches.*;
import Educative.Cricinfo.patterns.*;
import Educative.Cricinfo.stats.*;
import Educative.Cricinfo.teams.*;
import Educative.Cricinfo.tournaments.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
public class CricinfoDemo {
    public static void main(String[] args) {
        // 1. Create Admin
        Admin admin = new Admin("SuperAdmin");

        // 2. Create Coaches
        Coach coach1 = new Coach("Rahul Dravid", 48, "India");
        Coach coach2 = new Coach("Ricky Ponting", 47, "Australia");

        // 3. Create Players
        Player p1 = new Player("Virat Kohli", 35, "India", PlayingPosition.BATTING);
        Player p2 = new Player("Rohit Sharma", 37, "India", PlayingPosition.BATTING);
        Player p3 = new Player("Pat Cummins", 32, "Australia", PlayingPosition.BOWLING);
        Player p4 = new Player("David Warner", 38, "Australia", PlayingPosition.BATTING);

        // 4. Create Teams and add Players
        Team india = new Team("India", coach1);
        india.addPlayer(p1);
        india.addPlayer(p2);

        Team aus = new Team("Australia", coach2);
        aus.addPlayer(p3);
        aus.addPlayer(p4);

        // 5. Admin adds Players and Teams to the System
        admin.addPlayer(p1);
        admin.addPlayer(p2);
        admin.addPlayer(p3);
        admin.addPlayer(p4);
        admin.addTeam(india);
        admin.addTeam(aus);

        // 6. Create Tournament and Squads
        Tournament worldCup = new Tournament(LocalDate.of(2025, 10, 10));
        TournamentSquad squadIndia = new TournamentSquad(worldCup);
        squadIndia.addPlayer(p1);
        squadIndia.addPlayer(p2);

        TournamentSquad squadAus = new TournamentSquad(worldCup);
        squadAus.addPlayer(p3);
        squadAus.addPlayer(p4);

        worldCup.addTeam(squadIndia);
        worldCup.addTeam(squadAus);

        admin.addTournament(worldCup);

        // 7. Select Playing11
        Playing11 playing11India = new Playing11();
        playing11India.addPlayer(p1);
        playing11India.addPlayer(p2);

        Playing11 playing11Aus = new Playing11();
        playing11Aus.addPlayer(p3);
        playing11Aus.addPlayer(p4);

        // 8. Create a Match using Factory and add to Tournament
        MatchFactory matchFactory = new ConcreteMatchFactory();
        Match match = matchFactory.createMatch("T20", LocalDateTime.of(2025, 10, 12, 19, 0));
        match.addTeam(playing11India);
        match.addTeam(playing11Aus);

        worldCup.addMatch(match);
        admin.addMatch(match);

        // 9. Assign Stadium, Umpire, Commentator
        Stadium stadium = new Stadium("MCG", new Address(3000, "Brunton Ave", "Melbourne", "Victoria", "Australia"), 100000);
        Umpire umpire = new Umpire("Aleem Dar", 55, "Pakistan");
        Commentator commentator = new Commentator("Harsha Bhogle");

        match.assignStadium(stadium);
        match.assignUmpire(umpire);
        commentator.assignMatch(match);

        // 10. Record Innings, Overs, Balls, Runs, Wickets, Commentary
        Innings firstInnings = new Innings(playing11Aus, playing11India);
        Over over1 = new Over(1, p3);

        Ball ball1 = new Ball(p3, p1, BallType.NORMAL);
        ball1.addRun(new Run(4, RunType.FOUR, p1));
        ball1.addCommentary(new Commentary("Great cover drive for four!", commentator));

        Ball ball2 = new Ball(p3, p1, BallType.WICKET);
        Wicket wicket = new Wicket(WicketType.CAUGHT, p1);
        wicket.setCaughtBy(p4);
        ball2.setWicket(wicket);
        ball2.addCommentary(new Commentary("Caught at slip! Big wicket.", commentator));

        over1.addBall(ball1);
        over1.addBall(ball2);

        firstInnings.addOver(over1);
        match.addInnings(firstInnings);

        // 11. Add News
        News news = new News(LocalDate.now(), "India vs Australia T20 World Cup Opener!", new ArrayList<>(), india);
        admin.addNews(news);

        // 12. Update Tournament Statistics with sample data
        TournamentStat tStat = new TournamentStat();
        Map<Player, Integer> runsMap = new HashMap<>();
        runsMap.put(p1, 4);
        Map<Player, Integer> wicketsMap = new HashMap<>();
        wicketsMap.put(p4, 1);

        tStat.addMatchPerformance(
                4, 1.0,
                0, 0.0,
                4,
                runsMap,
                wicketsMap,
                india
        );
        tStat.updateStats();
        squadIndia.addStat(tStat);

        // 13. Demo Output
        System.out.println("Tournament: " + worldCup.getId());
        System.out.println("Teams: ");
        for (TournamentSquad sq : worldCup.getTeams()) {
            System.out.println("  Squad for: " + sq.getTournament().getId());
            for (Player pl : sq.getPlayers()) {
                System.out.println("Player: " + pl.getName());
            }
        }
        System.out.println("Match at: " + match.getStadium().getName());
        System.out.println("First ball commentary: " + over1.getBalls().get(0).getCommentaryList().get(0).getText());
        System.out.println("News: " + news.getText());
        System.out.println("Top Run Scorer: " + tStat.getTopRunScorer().getName());
    }
}
