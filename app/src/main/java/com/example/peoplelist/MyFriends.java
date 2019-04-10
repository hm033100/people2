package com.example.peoplelist;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyFriends {

    List<Person> myFriendsList;


    //constructor with parameter
    public MyFriends(List<Person> myFriendsList) {
        this.myFriendsList = myFriendsList;
    }

    //default constructor with preset properties
    public MyFriends(){
        String[] startingNames = {"Adam", "Bob", "Carl"};
        this.myFriendsList = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < startingNames.length; i++){
            //create new person for each person in startingNames Array
            Person p = new Person(startingNames[i], rnd.nextInt(50) + 15, rnd.nextInt(30));
            //add the person into the String List
            myFriendsList.add(p);
        }
    }

    //get list constructor
    public List<Person> getMyFriendsList() {
        return myFriendsList;
    }

    //set list constructor
    public void setMyFriendsList(List<Person> myFriendsList) {
        this.myFriendsList = myFriendsList;
    }
}
