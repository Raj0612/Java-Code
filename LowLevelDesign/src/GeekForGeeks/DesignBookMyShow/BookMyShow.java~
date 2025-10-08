package LowLevelDesign.GeekForGeeks.DesignBookMyShow;

import LowLevelDesign.GeekForGeeks.DesignBookMyShow.enums.Genre;
import LowLevelDesign.GeekForGeeks.DesignBookMyShow.enums.Language;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class BookMyShow {

    private ArrayList<User> usersList;
    private ArrayList<Theatre> theaters;

    private HashMap<String, ArrayList<Show>> movieMap;

    public BookMyShow(ArrayList<Theatre> theaters) {
        this.usersList = new ArrayList<>();
        this.theaters = theaters;
        this.movieMap = new HashMap<>();
        generateMovieMap();

    }

    private void generateMovieMap(){

        for(Theatre theater: this.theaters) {
            for (Show show : theater.getShows()) {
                if (this.movieMap.containsKey(show.getMovie().getName())) {
                    this.movieMap.get(show.getMovie().getName()).add(show);
                } else {
                    ArrayList<Show> showList = new ArrayList<>();
                    showList.add(show);
                    this.movieMap.put(show.getMovie().getName(),showList);
                }
            }
        }
    }

    public ArrayList<Show> searchShows(String movieName) throws Exception{
        if(movieMap.containsKey(movieName))
            return movieMap.get(movieName);
        else
            throw new Exception("No shows present for the movie");
    }

    public ArrayList<Show> searchShowsByTheater(String theatreName) throws Exception{

        for(Theatre theater: this.theaters){
            if(theatreName.equals(theater.getName())){
                return theater.getShows();
            }
        }
            throw new Exception("No Shows in the theater " + theatreName);
    }
    public static void main(String[] args) throws ParseException {

        RegisteredUser raj = new RegisteredUser("Raj");
        RegisteredUser krish = new RegisteredUser("Krish");
        GuestUser guest = new GuestUser("Guest");

        Movie ironMan = new Movie("Iron Man", Language.ENGLISH, Genre.ACTION);
        Movie troy = new Movie("Troy", Language.ENGLISH, Genre.ACTION);
        Movie leo = new Movie("Leo", Language.HINDI, Genre.ACTION);

        Theatre pvr = new Theatre("PVR", "Chennai", 30);
        Theatre ags = new Theatre("AGS", "Chennai", 30);

        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMM dd, yyyy HH:mm:ss a" );
        Show ironManShow = new Show(formatter.parse("Friday, May 10, 2025 10:00:00 AM"),ironMan, pvr);
        Show ironManShow1 = new Show(formatter.parse("Friday, May 10, 2025 11:00:00 PM"),ironMan, pvr);
        Show troyShow = new Show(formatter.parse("Friday, May 10, 2025 10:00:00 AM"),troy, ags);
        Show leoShow = new Show(formatter.parse("Friday, May 10, 2025 10:00:00 PM"),leo, ags);


        ArrayList<Theatre> theaters = new ArrayList<>();
        theaters.add(pvr);
        theaters.add(ags);

        BookMyShow bookMyShow = new BookMyShow(theaters);

        //search shows
        try{
            ArrayList<Show> searchShows =bookMyShow.searchShows("Iron Man");
            System.out.println("Shows: " + searchShows);
        } catch (Exception e){
            System.out.println("No Shows found");
        }

        //search shows by theater
        try{
            ArrayList<Show> searchShowsByTheater =bookMyShow.searchShowsByTheater("PVR");
            System.out.println("searchShowsByTheater: " + searchShowsByTheater);
        } catch (Exception e){
            System.out.println("No Shows found");
        }

        try{
            Ticket ticket =bookMyShow.bookTicketByTheaterAndShow("PVR",1, 4, raj );
            System.out.println("bookTicketByTheaterAndShow: " + ticket.getTicketInfo());
        } catch (Exception e){
            System.out.println("No Shows found");
        }

        try{
            Ticket rajTicket = bookMyShow.bookTicket(ironManShow,3,raj, pvr.getName());
            System.out.println(rajTicket.getTicketInfo());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try{
            Ticket guestTicket = bookMyShow.bookTicket(ironManShow,3, guest, pvr.getName());
            System.out.println(guestTicket.getTicketInfo());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    private Ticket bookTicket(Show show, int seats, User user, String theater) throws Exception{

        if(user instanceof  RegisteredUser){
            return show.bookTickets(seats, user, theater);
        }else{
            throw new Exception("Please register first");
        }
    }

    private Ticket bookTicketByTheaterAndShow(String theaterName, int showId, int seats, User user) throws Exception{

        Theatre theater = theaters.stream().filter(theater1 -> theaterName.equals(theater1.getName())).findAny().orElse(null);
        Show show = theater.getShows().stream().filter(show1 -> showId == show1.getId()).findAny().orElse(null);
        if(user instanceof  RegisteredUser){
            return show.bookTickets(seats, user, theaterName);
        }else{
            throw new Exception("Please register first");
        }

    }
}
