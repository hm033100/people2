package com.example.peoplelist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewPersonForm extends AppCompatActivity {

    Button b_ok, b_cancel;
    EditText et_name, et_age, et_pictureNumber;
    int editPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_person_form);

        b_ok = findViewById(R.id.b_ok);
        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);
        et_pictureNumber = findViewById(R.id.et_pictureNumber);

        Bundle incomingIntent = getIntent().getExtras();

        //if intent isn't empty
        if (incomingIntent != null){
            String sentName = incomingIntent.getString("name");
            int sentAge  = incomingIntent.getInt("age");
            int sentPictureNumber = incomingIntent.getInt("pictureNumber");
            editPosition = incomingIntent.getInt("edit");

            //fill in the form

            et_name.setText(sentName);
            et_age.setText(Integer.toString(sentAge));
            et_pictureNumber.setText(Integer.toString(sentPictureNumber));

        }


        b_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //get user entered strings from edit text view objects
                String newName = et_name.getText().toString();
                String newAge = et_age.getText().toString();
                String newPictureNumber = et_pictureNumber.getText().toString();
                if (Integer.parseInt(newPictureNumber) > 30){
                    Toast.makeText(NewPersonForm.this, "Enter in number less than 30", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent i = new Intent(v.getContext(), MainActivity.class);
                    i.putExtra("edit", editPosition);
                    i.putExtra("name", newName);
                    i.putExtra("age", newAge);
                    i.putExtra("picture number", newPictureNumber);
                    startActivity(i);

                }



            }

            //put the string into a message in the main activity

        });
    }
}
