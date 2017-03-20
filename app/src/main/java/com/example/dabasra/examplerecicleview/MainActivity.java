package com.example.dabasra.examplerecicleview;

/**
 * Created by dabasra .
 */

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.dabasra.examplerecicleview.model.Ticket;

public class MainActivity extends AppCompatActivity {

    public static MainActivity getMainActivity() {
        return mainActivity;
    }

    private static void setMainActivity(MainActivity mainActivity) {
        MainActivity.mainActivity = mainActivity;
    }

    private static MainActivity mainActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivity.setMainActivity(this);
        MainFragment fragment = new MainFragment();

        FragmentManager fm = getSupportFragmentManager();
         MainFragment mainFragment = MainFragment.newInstance();
            fm.beginTransaction().replace(R.id.fragmentInMain,fragment).commit();

    }

    public void loadDetailActivity(Ticket ticketSelected){

        Log.d("ticket", "this is the ticket = "+ticketSelected.getTitle());
        Intent intent = new Intent(this,DetailActivity.class);
        startActivity(intent);
    }

}
