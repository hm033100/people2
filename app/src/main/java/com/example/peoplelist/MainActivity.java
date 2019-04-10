package com.example.peoplelist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {


    Button b_sortABC;
    Button b_sortAge;
    Button b_add;

    ListView lv_friendsList;

    PersonAdapter pa;

    MyFriends myFriends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //default myFriends constructor
        myFriends = ((MyApplication) this.getApplication()).getMyFriends();


        b_sortABC = findViewById(R.id.b_sortABC);
        b_sortAge = findViewById(R.id.b_sortAge);
        b_add = findViewById(R.id.b_add);
        lv_friendsList = findViewById(R.id.lv_friendsList);



        //create new PersonAdapter with parameters
        pa = new PersonAdapter(MainActivity.this, myFriends);

        //set the adapter to list view "lv_friendsList"
        lv_friendsList.setAdapter(pa);


        //listen for incoming messages from other forms when app is launched
        Bundle incomingMessages = getIntent().getExtras();
        if (incomingMessages != null) {

            //capture incoming data
            String name = incomingMessages.getString("name");
            int age = Integer.parseInt(incomingMessages.getString("age"));
            int pictureNumber = Integer.parseInt(incomingMessages.getString("picture number"));
            int positionEdited = incomingMessages.getInt("edit");

            //create new persons object
            Person p = new Person(name, age, pictureNumber);


            //if position of person edited is greater than 0, then it's an edit person
            if (positionEdited > -1){
                myFriends.getMyFriendsList().remove(positionEdited);
            }
            //add person to the list
            myFriends.getMyFriendsList().add(p);
            //update "pa" adapter
            pa.notifyDataSetChanged();

        }
        b_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), NewPersonForm.class);
                startActivity(i);
            }
        });

        b_sortAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Collections.sort(myFriends.getMyFriendsList(), new Comparator<Person>() {
                    @Override
                    public int compare(Person p1, Person p2) {


                        return p1.getAge() - p2.getAge();
                    }
                });

                pa.notifyDataSetChanged();


            }
        });

        b_sortABC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Collections.sort(myFriends.getMyFriendsList());
                pa.notifyDataSetChanged();

            }
        });


        lv_friendsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                editPerson(position);
            }
        });


    }


    public void editPerson(int position) {
        Intent i = new Intent(getApplicationContext(), NewPersonForm.class);

        //get the contents of the person clicked
        Person p = myFriends.getMyFriendsList().get(position);

        i.putExtra("edit", position);
        i.putExtra("name", p.getName());
        i.putExtra("age", p.getAge());
        i.putExtra("pictureNumber", p.getPictureNumber());
        startActivity(i);

    }
}
