package com.example.kingpin;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.kingpin.game.Game;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Lets user enter scores and proccess information into a Game Object
 */
public class EnterScore extends Fragment {

    // array of scores  frame 1 --> 10
    private final int [] arrayScores =  new int[20];

    EditText enterName;

    int num1=0, num2=0;

    //frame scores
    EditText frame1_roll1;
    EditText frame1_roll2;


    Button frame_BTN1;

    EditText frame2_roll1;
    EditText frame2_roll2;

    Button frame_BTN2;

    EditText frame3_roll1;
    EditText frame3_roll2;

    Button frame_BTN3;

    EditText frame4_roll1;
    EditText frame4_roll2;

    Button frame_BTN4;

    EditText frame5_roll1;
    EditText frame5_roll2;

    Button frame_BTN5;

    EditText frame6_roll1;
    EditText frame6_roll2;

    Button frame_BTN6;

    EditText frame7_roll1;
    EditText frame7_roll2;

    Button frame_BTN7;

    EditText frame8_roll1;
    EditText frame8_roll2;

    Button frame_BTN8;

    EditText frame9_roll1;
    EditText frame9_roll2;

    Button frame_BTN9;

    EditText frame10_roll1;
    EditText frame10_roll2;
    EditText frame10_roll3;

    Button frame_BTN10;

    Button bottomScore;

    TextView displayTotalScore;

    ListView listView;

    public String gameName;
    public String Url = "https://bowlingkingpi-default-rtdb.europe-west1.firebasedatabase.app";



//    Button mButton;
//    EditText mEdit;
//    TextView mText;

    ///////////////////

    private SharedPreferences gamePrefs;
    public static final String GAME_PREFS = "ArithmeticFile";



    ///////////////////
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState

    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.enter_score, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        enterName = view.findViewById(R.id.enterNameText);

        listView = view.findViewById(R.id.listViewGames);

        bottomScore = view.findViewById(R.id.savescoreBTN);

        displayTotalScore = view.findViewById(R.id.totalScore);
//        bottomScore.setEnabled(false);

        //Frame 1 Roll1 and Roll2
        frame1_roll1 = view.findViewById(R.id.frame1_roll1);
        frame1_roll2 = view.findViewById(R.id.frame1_roll2);

        //Frame 2 Roll1 and Roll2
        frame2_roll1 = view.findViewById(R.id.frame2_roll1);
        frame2_roll2 = view.findViewById(R.id.frame2_roll2);

        //frame 3 Roll1 and Roll2
        frame3_roll1 = view.findViewById(R.id.frame3_roll1);
        frame3_roll2 = view.findViewById(R.id.frame3_roll2);

        //frame 4 Roll1 and Roll2
        frame4_roll1 = view.findViewById(R.id.frame4_roll1);
        frame4_roll2 = view.findViewById(R.id.frame4_roll2);

        //frame 5 Roll1 and Roll2
        frame5_roll1 = view.findViewById(R.id.frame5_roll1);
        frame5_roll2 = view.findViewById(R.id.frame5_roll2);

        //frame 6 Roll1 and Roll2
        frame6_roll1 = view.findViewById(R.id.frame6_roll1);
        frame6_roll2 = view.findViewById(R.id.frame6_roll2);

        //frame 7 Roll1 and Roll2
        frame7_roll1 = view.findViewById(R.id.frame7_roll1);
        frame7_roll2 = view.findViewById(R.id.frame7_roll2);

        //frame 8 Roll1 and Roll2
        frame8_roll1 = view.findViewById(R.id.frame8_roll1);
        frame8_roll2 = view.findViewById(R.id.frame8_roll2);

        //frame 9 Roll1 and Roll2
        frame9_roll1 = view.findViewById(R.id.frame9_roll1);
        frame9_roll2 = view.findViewById(R.id.frame9_roll2);

        //frame 10 Roll1 and Roll2 and Roll3
        frame10_roll1 = view.findViewById(R.id.frame10_roll1);
        frame10_roll2 = view.findViewById(R.id.frame10_roll2);
        frame10_roll3 = view.findViewById(R.id.frame10_roll3);



        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();



        String userId = user.getUid();

        gameName = enterName.getText().toString();

        HashMap<String, Object> game = new HashMap<>();

        FirebaseDatabase.getInstance(Url).getReference().child(userId).child("Games").child(gameName).updateChildren(game);

        int frame[] = new int[21];

        view.findViewById(R.id.frame1BTN).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Convert user input for roll1 and roll2 to int
                num1 = Integer.parseInt(frame1_roll1.getText().toString());
                num2 = Integer.parseInt(frame1_roll2.getText().toString());

                //Save score to frame[]
                frame[0] = num1;
                frame[1] = num2;


//                Toast.makeText(this, "Workout added", Toast.LENGTH_LONG).show();
            }
        });

        view.findViewById(R.id.frame2BTN).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Convert user input for roll1 and roll2 to int
                num1 = Integer.parseInt(frame2_roll1.getText().toString());
                num2 = Integer.parseInt(frame2_roll2.getText().toString());

                //Save score to frame[]
                frame[2] = num1;
                frame[3] = num2;

            }
        });



        view.findViewById(R.id.frame3BTN).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Convert user input for roll1 and roll2 to int
                num1 = Integer.parseInt(frame3_roll1.getText().toString());
                num2 = Integer.parseInt(frame3_roll2.getText().toString());

                //Save score to frame[]
                frame[4] = num1;
                frame[5] = num2;
            }
        });


        view.findViewById(R.id.frame4BTN).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Convert user input for roll1 and roll2 to int
                num1 = Integer.parseInt(frame4_roll1.getText().toString());
                num2 = Integer.parseInt(frame4_roll2.getText().toString());

                //Save score to frame[]
                frame[6] = num1;
                frame[7] = num2;
            }
        });

        view.findViewById(R.id.frame5BTN).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Convert user input for roll1 and roll2 to int
                num1 = Integer.parseInt(frame5_roll1.getText().toString());
                num2 = Integer.parseInt(frame5_roll2.getText().toString());

                //Save score to frame[]
                frame[8] = num1;
                frame[9] = num2;
            }
        });

        view.findViewById(R.id.frame6BTN).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                num1 = Integer.parseInt(frame6_roll1.getText().toString());
                num2 = Integer.parseInt(frame6_roll2.getText().toString());

                frame[10] = num1;
                frame[11] = num2;
            }
        });


        view.findViewById(R.id.frame7BTN).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                num1 = Integer.parseInt(frame7_roll1.getText().toString());
                num2 = Integer.parseInt(frame7_roll2.getText().toString());

                frame[12] = num1;
                frame[13] = num2;
            }
        });

        view.findViewById(R.id.frame8BTN).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                num1 = Integer.parseInt(frame8_roll1.getText().toString());
                num2 = Integer.parseInt(frame8_roll2.getText().toString());

                frame[14] = num1;
                frame[15] = num2;
            }
        });

        view.findViewById(R.id.frame9BTN).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                num1 = Integer.parseInt(frame9_roll1.getText().toString());
                num2 = Integer.parseInt(frame9_roll2.getText().toString());

                frame[16] = num1;
                frame[17] = num2;
            }
        });

        view.findViewById(R.id.frame10BTN2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num3=0;

                num1 = Integer.parseInt(frame10_roll1.getText().toString());
                num2 = Integer.parseInt(frame10_roll2.getText().toString());
                if(!frame10_roll3.getText().toString().isEmpty()){
                    num3 = Integer.parseInt(frame10_roll3.getText().toString());
                }


                frame[18] = num1;
                frame[19] = num2;
                frame[20] = num3;
            }
        });

        bottomScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                HashMap<String, Object> totalFrames = new HashMap<>();

                gameName = enterName.getText().toString();
                game.put("Name", gameName);

                //HashMap holds each frame --> Roll 1, Roll 2, Score, Total, Type
                HashMap<String, Object> addFrame = new HashMap<>();
                int frameScore;

                //Calculate running total after every frame
                int subTotalScore = 0;

                //String type of frame score --> Strike Spare -
                String type = "";

                //String to add frame + number to database
                String frameName="Frames";

                //Frame counter 1-10
                int x = 0;

                //For loop to add frame scores to database
                for(int i = 0; i < 18; i++){

                    if(i % 2 != 0){
                        x++;
                        frameName = "Frame" + x;
                        addFrame.put(frameName+"roll1",String.valueOf(frame[i-1]));
                        addFrame.put(frameName+"roll2",String.valueOf(frame[i]));
                        frameScore = calcScore(frame[i-1], frame[i], frame[i+1]);
                        subTotalScore += frameScore;
                        type = calcType(frame[i-1], frame[i]);

                        addFrame.put(frameName+"score",String.valueOf(frameScore));
                        addFrame.put(frameName+"total", String.valueOf(subTotalScore));
                        addFrame.put(frameName+"type", type);
                        FirebaseDatabase.getInstance(Url).getReference().child(userId).child("Games").child(gameName).updateChildren(addFrame);
                        addFrame.clear();
                    }//end if

                }//end for

                HashMap<String, Object> addFrame10 = new HashMap<>();
                frameName = "Frame10";
                addFrame10.put(frameName+"roll1",String.valueOf(frame[18]));
                addFrame10.put(frameName+"roll2",String.valueOf(frame[19]));
                addFrame10.put(frameName+"roll3",String.valueOf(frame[20]));
                frameScore = calcFrame10(frame[18], frame[19], frame[20]);
                subTotalScore += frameScore;
                type = calcType(frame[18], frame[19]);

                addFrame10.put(frameName+"score",String.valueOf(frameScore));
                addFrame10.put(frameName+"total", String.valueOf(subTotalScore));
                addFrame10.put(frameName+"type", type);
                FirebaseDatabase.getInstance(Url).getReference().child(userId).child("Games").child(gameName).updateChildren(addFrame10);
                addFrame10.clear();

                game.put("totalScore", String.valueOf(subTotalScore));
                FirebaseDatabase.getInstance(Url).getReference().child(userId).child("Games").child(gameName).updateChildren(game);

                displayTotalScore.setText(String.valueOf(subTotalScore));
            }

        });


        view.findViewById(R.id.imageButton3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(EnterScore.this).navigate(R.id.action_EnterFragment_to_SavedScore);
            }
        });



    }





    public int calcScore(int r1, int r2, int bonus){

        int subScore = r1 + r2;

        if(r1 == 10){
            subScore += 10;
        }
        else if(subScore == 10){
            subScore += bonus;
        }
        else{
            subScore += 0;
        }

        return subScore;
    }

    public String calcType(int r1, int r2){
        String type ="";
        int subScore = r1 + r2;

        if(r1 == 10){
            type = "Strike";
        }
        else if(subScore == 10){
            type = "Spare";
        }
        else{
            type ="-";
        }

        return type;
    }

    public int calcFrame10(int r1, int r2, int r3){
        //FRAME 10 case
        boolean roll3 = false;
        int sub=0;
        int score = r1+r2;
        if(r1==10){
           sub = 10;
           sub+=(r2+r3);
           score = sub;
        }
        else if(score == 10){
            score += r3;
        }
        return score;
    }


}