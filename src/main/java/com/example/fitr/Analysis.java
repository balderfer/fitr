package com.example.fitr;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by benjaminalderfer on 2/9/14.
 */
public class Analysis extends Activity implements OnItemClickListener {
    int calLose;
    ListView exer1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent k = getIntent();

        setContentView(R.layout.activity_smartstats);

        TextView calOver = (TextView)findViewById(R.id.calOver);
        TextView highPercent = (TextView)findViewById(R.id.highPercent);
        TextView highCal = (TextView)findViewById(R.id.highCal);
        TextView textView = (TextView)findViewById(R.id.textView);

        boolean toLose = true;
        int calPerDayXtra = 0;
        if (MainActivity.selected == false){
            int howFast = MainActivity.weekIn;
            int howMuch = MainActivity.weight - MainActivity.targetWeight;
            calPerDayXtra = OutsideFuncs.weightLoss(howFast, howMuch);
        }
        if (MainActivity.selected == true){
            toLose = false;
        }

        Typeface font = Typeface.createFromAsset(getAssets(), "CaeciliaLTStd-Light.otf");
        Typeface font2 = Typeface.createFromAsset(getAssets(), "CaeciliaLTStd-Heavy.otf");
        calOver.setTypeface(font);
        highPercent.setTypeface(font);
        highCal.setTypeface(font);
        textView.setTypeface(font2);

        calLose = OutsideFuncs.calsToLose(MainActivity.recCalories, (int)FoodPage.calTot, toLose, calPerDayXtra);


        calOver.setText("Hey " + MainActivity.name + ", you are " + calLose + " calories over your daily goal.");


        highPercent.setText(FoodPage.messagePercentHigh);
        highCal.setText(FoodPage.messageCalorieHigh);


    }
    public void analysis1(View view) {

        setContentView(R.layout.activity_inputactivity);


        TextView exerMin = (TextView)findViewById(R.id.exerMin);


        exer1 = (ListView) findViewById(R.id.exer12);
        exer1.setOnItemClickListener(this);

    }

    public void startOver(View view) {

        Intent kc = new Intent(this, MainActivity.class);
        startActivity(kc);


    }

    public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
        String val =(String) adapter.getItemAtPosition(position);
        //get constant value
        String exerType = "";
        if (val.equals("Leisurely Swimming")){
            exerType = "slowSwim";
        }
        else if (val.equals("Rigorous Swimming")){
            exerType = "fastSwim";
        }
        else if (val.equals("Taking out the Trash")){
            exerType = "trash";
        }
        else if (val.equals("Light Jog")){
            exerType = "slowRun";
        }
        else if (val.equals("Fast Paced Run")){
            exerType = "fastRun";
        }
        else if (val.equals("Bird Watching")){
            exerType = "bird";
        }
        else if (val.equals("Casual Biking")){
            exerType = "slowBike";
        }
        else if (val.equals("Sprint Biking")){
            exerType = "fastBike";
        }
        else if (val.equals("Walking")){
            exerType = "walk";
        }
        double c = OutsideFuncs.getConstant(exerType);
        //
        int min = OutsideFuncs.minNeeded(calLose, MainActivity.weight, c);


        TextView exerMin = (TextView)findViewById(R.id.exerMin);
        TextView actTitle = (TextView)findViewById(R.id.actTitle);

        Typeface font = Typeface.createFromAsset(getAssets(), "CaeciliaLTStd-Heavy.otf");
        Typeface font2 = Typeface.createFromAsset(getAssets(), "CaeciliaLTStd-Light.otf");
        exerMin.setTypeface(font2);
        actTitle.setTypeface(font);

        exerMin.setText("You need to exercise for " + min + " minutes doing " + val + " in order to burn off all of your excess calories!");

    }

}
