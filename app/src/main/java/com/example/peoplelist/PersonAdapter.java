package com.example.peoplelist;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PersonAdapter extends BaseAdapter {

    Activity myActivity;
    MyFriends myFriends;

    //PersonAdapter constructor with Activity parameter and MyFriends parameter
    public PersonAdapter(Activity myActivity, MyFriends myFriends) {
        this.myActivity = myActivity;
        this.myFriends = myFriends;
    }

    @Override
    //get count method returning size of list
    public int getCount() {
        //returns how many people are in the list
        return myFriends.getMyFriendsList().size();
    }

    @Override
    //create method to get a specific contact at a specific position
    public Person getItem(int position) {
        //returns a specific contact from the list.
        return myFriends.getMyFriendsList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View onePersonLine;

        LayoutInflater inflater = (LayoutInflater) myActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        onePersonLine = inflater.inflate(R.layout.person_one_line, parent, false);

        TextView tv_name = onePersonLine.findViewById(R.id.tv_name);
        TextView tv_ageValue = onePersonLine.findViewById(R.id.tv_ageValue);
        ImageView iv_icon = onePersonLine.findViewById(R.id.iv_icon);

        //create a person that holds the values of the specific contact that was clicked
        Person p = this.getItem(position);

        tv_name.setText(p.getName());
        tv_ageValue.setText(Integer.toString(p.getAge()));

        //create int array holding all the contact images
        int icon_resource_numbers[] = {
                R.drawable.icon01_01,
                R.drawable.icon01_02,
                R.drawable.icon01_03,
                R.drawable.icon01_04,
                R.drawable.icon01_05,
                R.drawable.icon01_06,
                R.drawable.icon01_07,
                R.drawable.icon01_08,
                R.drawable.icon01_09,
                R.drawable.icon01_10,
                R.drawable.icon01_11,
                R.drawable.icon01_12,
                R.drawable.icon01_13,
                R.drawable.icon01_14,
                R.drawable.icon01_15,
                R.drawable.icon01_16,
                R.drawable.icon01_17,
                R.drawable.icon01_18,
                R.drawable.icon01_19,
                R.drawable.icon01_20,
                R.drawable.icon01_21,
                R.drawable.icon01_22,
                R.drawable.icon01_23,
                R.drawable.icon01_24,
                R.drawable.icon01_25,
                R.drawable.icon01_26,
                R.drawable.icon01_27,
                R.drawable.icon01_28,
                R.drawable.icon01_29,
                R.drawable.icon01_30,

        };

        //store image for contact using image Array
        iv_icon.setImageResource(icon_resource_numbers[p.getPictureNumber()]);



        return onePersonLine;
    }
}
