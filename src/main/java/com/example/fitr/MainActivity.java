package com.example.fitr;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Activity;
import android.view.*;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;
import android.view.View.OnClickListener;
import android.view.View;



public class MainActivity extends Activity implements OnItemClickListener {
    static int weight;
    static String name;
    int height;
    static int targetWeight;
    boolean isMale;
    int calToLose;
    static int recCalories;
    ListView exer1;
    int age;
    static int weekIn;
    static boolean selected;
    int calPerDay;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent kc = getIntent();

        setContentView(R.layout.activity_userinput);

    }

    public void sendMessage1(View view) {
        setContentView(R.layout.activity_userinput);

    }

    public void moreInfo(View view) {
        setContentView(R.layout.activity_info);

    }

    public void sendMessage2(View view) {

        ImageView fitrLogo = (ImageView)findViewById(R.id.fitrLogo);
        EditText nameIn = (EditText)findViewById(R.id.nameIn);
        EditText heightIn = (EditText)findViewById(R.id.heightIn);
        EditText weightIn = (EditText)findViewById(R.id.weightIn);
        EditText ageIn = (EditText)findViewById(R.id.ageIn);
        RadioGroup gender = (RadioGroup)findViewById(R.id.radioGender);

        int selected;
        selected = gender.indexOfChild(findViewById(gender.getCheckedRadioButtonId()));
        if (selected == 0){
            isMale = true;
        }
        else{
            isMale = false;
        }

        age = Integer.parseInt(ageIn.getText().toString());
        name = nameIn.getText().toString();
        weight = Integer.parseInt(weightIn.getText().toString());
        height = Integer.parseInt(heightIn.getText().toString());
        recCalories = OutsideFuncs.calorieTarget(age,isMale,height,weight);

        setContentView(R.layout.activity_planinput);

    }

    public void sendMessage3(View view) {

        TextView weightPrompt = (TextView)findViewById(R.id.weightPrompt);
        EditText goalWeight = (EditText)findViewById(R.id.goalWeight);
        CheckBox maintainWeight = (CheckBox)findViewById(R.id.maintainWeight);
        EditText duration = (EditText)findViewById(R.id.duration);

        weekIn = Integer.parseInt(duration.getText().toString());

        try {
            targetWeight = Integer.parseInt(goalWeight.getText().toString());
        }
        catch(Throwable t) {
            t.printStackTrace();
            targetWeight = 0;
        }

        selected = maintainWeight.isChecked();

        // Create custom font object.
        Typeface font = Typeface.createFromAsset(getAssets(), "CaeciliaLTStd-Light.otf");
        weightPrompt.setTypeface(font);

        Intent intent = new Intent(this, FoodPage.class);
        startActivity(intent);

    }

    public void sendMessage4(View view) {
/*
        TextView display = (TextView)findViewById(R.id.display);

        boolean toLose = true;
        int calPerDayXtra = 0;
        if (selected == false){
            int howFast = weekIn;
            int howMuch = weight - targetWeight;
            calPerDayXtra = OutsideFuncs.weightLoss(howFast, howMuch);
        }
        if (selected == true){
            toLose = false;
        }


        calToLose = OutsideFuncs.calsToLose(recCalories, FoodPage.calTot, toLose, calPerDayXtra);

        display.setText("You need to burn " + calToLose + "calories per day");

        setContentView(R.layout.activity_inputactivity);

        exer1 = (ListView) findViewById(R.id.exer12);
        exer1.setOnItemClickListener(this);
*/
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    //will execute once you select one of the lists in the scroll menu
    public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
        String val =(String) adapter.getItemAtPosition(position);
        //get constant value
        String exerType = "";
        if (val.equals("Easy Swimming")){
            exerType = "slowSwim";
        }
        else if (val.equals("Hard Swimming")){
            exerType = "fastSwim";
        }
        else if (val.equals("Easy Running")){
            exerType = "slowRun";
        }
        else if (val.equals("Hard Running")){
            exerType = "fastRun";
        }
        else if (val.equals("Easy Biking")){
            exerType = "slowBike";
        }
        else if (val.equals("Hard Biking")){
            exerType = "fastBike";
        }
        else if (val.equals("Walking")){
            exerType = "walk";
        }
        double c = OutsideFuncs.getConstant(exerType);
        //
        int min = OutsideFuncs.minNeeded(calToLose, weight, c);



        TextView exerMin = (TextView)findViewById(R.id.exerMin);
        exerMin.setText("You need to exercise for " + min + " minutes doing " + val);

    }

}
