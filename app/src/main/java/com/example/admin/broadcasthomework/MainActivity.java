package com.example.admin.broadcasthomework;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.LevelListDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTag";
    private static final String ACTION = "receiveList";
    private static final String KEY = "data";

    MyReceiver myReceiver;
    Button changeImageButton;
    Button intentServiceButton;
    ImageView imageView;
    ListView listView;

    private int level = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        changeImageButton = (Button) findViewById( R.id.btnChangeImage );
        intentServiceButton = (Button) findViewById( R.id.btnIntentService );
        imageView = (ImageView) findViewById( R.id.ivImage );
        listView = (ListView) findViewById( R.id.lvPeople );
    }

    @Override
    protected void onStart() {
        super.onStart();

        myReceiver = new MyReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction( ACTION );
        registerReceiver( myReceiver, intentFilter );
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver( myReceiver );
    }

    public void buttonPressed(View view) {
        switch( view.getId() ) {
            case R.id.btnChangeImage:

                level = (level < 2) ? level+1 : 0;
                Toast.makeText(this, "" + level, Toast.LENGTH_SHORT).show();
                imageView.setImageLevel( level );

                break;
            case R.id.btnIntentService:

                Log.d(TAG, "buttonPressed: Starting Service");
                Intent intService = new Intent(this, MyIntentService.class);
                startService(intService);

                break;
        }
    }

    private class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "onReceive: Broadcast Received, Checking Action");
            String action = intent.getAction();

            switch ( action ) {
                case ACTION:
                    Log.d(TAG, "onReceive: Fetching data");
                    ArrayList<Person> personArrayList = intent.getParcelableArrayListExtra( KEY );

                    PersonListAdapter psa = new PersonListAdapter( MainActivity.this, R.layout.list_view_item,
                            personArrayList);

                    listView.setAdapter( psa );
                    break;
            }
        }
    }
}

/*
1. Create an application to use 5 systems broadcasts
X 2. Create an IntentService to create a list of random objects (The objects should have at least 4
fields). And communicate back to the main activity with a broadcast receiver and update a listView.
3. Create a feature which changes the image on every button click using LevelListDrawable
4. Change the state of the button using StateListDrawable

-Use Custom permission for the broadcast receiver
 */