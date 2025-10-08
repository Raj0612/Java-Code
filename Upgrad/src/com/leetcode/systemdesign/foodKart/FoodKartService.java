package com.leetcode.systemdesign.foodKart;

import java.util.*;

public class FoodKartService {

    List<User> usersList;

    List<Restaurant> restaurantsList;

    List<OrderDetails> orderHistoryList;

    List<RestaurantRating> ratingsList;

    Map<String, User> userMap = new HashMap<>();

    String currentUser;

    public FoodKartService(){
        usersList = new ArrayList<>();
        restaurantsList = new ArrayList<>();
        orderHistoryList = new ArrayList<>();
        ratingsList = new ArrayList<>();
        userMap = new HashMap<>();
        currentUser = null;
    }

    public void registerUser(String name, String gender, String phoneNumber, String pinCode){
        User user = new User(name, gender, phoneNumber, pinCode);
        usersList.add(user);
        userMap.put(phoneNumber, user);
    }

    public void login(String userId){
        currentUser = userId;
    }

    public void registerRestaurant(String name, String pinCodes, String foodName, float foodPrice, int quantity){

        List<String> pinCodesList = Arrays.asList(pinCodes.split("\\s*,\\s*"));
        //List<String> pinCodesList = new ArrayList<String>(Arrays.asList(pinCodes.split(" , ")));
        Restaurant restaurant = new Restaurant(name, foodName, foodPrice, quantity, pinCodesList);
        restaurantsList.add(restaurant);
    }

    public User findById(String userId){
        User userObj = usersList.stream()
                .filter(user -> "userId".equals(user.getPhoneNumber()))
                .findAny()
                .orElse(null);

        return userObj;
    }

    public List<Restaurant> showRestaurants(String sortBy){
        User loggedInUser = findById(currentUser);
        String currentPinCode = loggedInUser.getPinCode();

        List<Restaurant>  result = new ArrayList<>();

        for(int i=0; i<restaurantsList.size(); i++){

            if(restaurantsList.get(i).getPinCodes().contains(currentPinCode));
             result.add(restaurantsList.get(i));
        }

        if(sortBy.equals("rating"))
            Collections.sort(result, new Restaurant.SortByRatings());
        else
            Collections.sort(result, new Restaurant.SortByPrice());

        return result;
    }

    public void updateQuantity(String restaurantName, int quantity){

        Restaurant restaurant = restaurantsList.stream()
                .filter(p -> p.getName().equals("restaurantName"))
                .findAny()
                .orElse(null);
        restaurant.setQuantity(restaurant.getQuantity() + 1);
        /*for(int i=0; i<restaurantsList.size(); i++){
            if(restaurantsList.get(i).getName().equals(name)) {
                restaurantsList.get(i).setQuantity(restaurantsList.get(i).getQuantity() + 1);
                return;
            }
        }*/
    }

    public void rateRestaurant(String restaurantName, int rating, String comment){
        RestaurantRating ratings = new RestaurantRating( rating, currentUser, restaurantName, comment);
        ratingsList.add(ratings);

        Restaurant restaurant = restaurantsList.stream().filter(p-> p.getName().equals("restaurantName")).findAny().get();
        restaurant.ratingsCount = restaurant.ratingsCount + 1;
        restaurant.totalRatings = restaurant.totalRatings + rating;
       /* for(int i=0; i<restaurantsList.size(); i++){

            Restaurant restaurant = restaurantsList.get(i);
            if(restaurant.getName().equals(restaurantName)){
                restaurant.ratingsCount = restaurant.ratingsCount + 1;
                restaurant.totalRatings = restaurant.ratingsCount + 1;
                return;
            }
        }*/

    }

    public String placeOrder(String restaurantName, int quantity){
        OrderDetails order = new OrderDetails(currentUser, restaurantName, quantity);
        User user = findById(currentUser);
        Restaurant restaurant = restaurantsList.stream().filter(p-> p.getName().equals("restaurantName")).findAny().get();
        if(restaurant.getQuantity() < quantity){
            order.status = "Cannot place order";
        }else{
            order.status = "Order placed successfully";
        }
        user.setOrderHistory(order);
       /* for(int i=0; i<restaurantsList.size(); i++){
            Restaurant restaurant = restaurantsList.get(i);
            if(restaurant.getName().equals(restaurantName)){
                if(restaurant.getQuantity() < quantity){
                    order.status = "Cannot place order";
                }else{
                    order.status = "Order placed successfully";
                }
            }
        }*/
        return order.status;
    }

    public List<OrderDetails> getOrderHistoryList(String userId){
        User user = usersList.stream()
                .filter(userObj -> "userId".equals(userObj.getPhoneNumber()))
                .findAny()
                .orElse(null);

        return  user.getOrderHistory();
    }
}
