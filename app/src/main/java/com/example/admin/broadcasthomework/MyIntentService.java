package com.example.admin.broadcasthomework;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyIntentService extends IntentService {

    private static final String TAG = "MyIntentServiceTag";
    private static final String ACTION = "receiveList";
    private static final String KEY = "data";

    ArrayList<Person> personList = new ArrayList<>();

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent: Creating array.");

        /*
        personList.add( new Person( "Jarrett",
                                    "Adkins",
                                    new Random().nextInt( 50 ),
                                    new Random().nextInt( 400 ) ));
        personList.add( new Person( "Ryne",
                                    "Green",
                                    new Random().nextInt( 50 ),
                                    new Random().nextInt( 400 ) ));
        personList.add( new Person( "Mac",
                                    "Myers",
                                    new Random().nextInt( 50 ),
                                    new Random().nextInt( 400 ) ));
                                    */

        for (int i = 0; i < 10; i++) {
            String first = "";

            for (int j = 0; j < 5; j++) {
                final int min = 97;
                final int max = 122;
                final int random = new Random().nextInt((max - min) + 1) + min;

                first += (char) random;
            }

            String last = "";

            for (int j = 0; j < 5; j++) {
                final int min = 97;
                final int max = 122;
                final int random = new Random().nextInt((max - min) + 1) + min;

                last += (char) random;
            }

            personList.add( new Person( first,
                                        last,
                                        new Random().nextInt( 50 ),
                                        new Random().nextInt( 400 )));
        }

        //broadcast
        Log.d(TAG, "onHandleIntent: Broadcasting");
        Intent broadcast = new Intent();
        broadcast.setAction( ACTION );
        broadcast.putParcelableArrayListExtra( KEY, personList );

        sendBroadcast( broadcast );
    }

}
