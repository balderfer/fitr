package com.example.fitr;

public class OutsideFuncs {
	/*----------NEED TO IMPLEMENT CALORIE COUNTER SOMEHOW-------*/

    public static double getConstant(String input){
        //the constant generated is used in minNeeded function to calc
        //the number of minutes needed to burn X amount of calories
        if (input.equals("slowBike")){
            return .060667;
        }
        else if (input.equals("fastBike")){
            return .090889;
        }
        else if (input.equals("slowRun")){
            return .060667;
        }
        else if (input.equals("fastRun")){
            return .121111;
        }
        else if (input.equals("slowSwim")){
            return .052889;
        }
        else if (input.equals("fastSwim")){
            return .075778;
        }
        else if (input.equals("trash")){
            return .022667;
        }
        else if (input.equals("bird")){
            return .018889;
        }
        else {
            //the constant if walking
            return .024889;
        }

    }
    public static int minNeeded(int calToBurn, double weight, double constant){
        //this function is called to calc calories to get to final target
        int min = (int)(calToBurn/(constant*weight));
        return min;
    }
    public static int calorieTarget(int age, boolean isMale, int height, int weight){
        //this is the target based on age and weight (doesn't take into account weight loss yet)
        int calTarget =0;
        if (isMale==true){
            calTarget = (int)((22.0462*weight)+(2.46063125*height)-(5*age) + 5);
        }
        else {
            calTarget = (int)((22.0462*weight)+(2.46063125*height)-(5*age) + -161);
        }
        return calTarget;
    }
    public static int weightLoss(int weeks, int poundsToLose){
        int calReduc = 3500 * poundsToLose;
        int dayToLose = calReduc/(weeks * 7);
        //calPerDay is the amount of calories below RECOMMENDED that you need to be below
        return dayToLose;

    }


    public static int calsToLose (int calTarget, int currentCal, boolean toLose, int dayToLose){
        //this function gives you the calories you need to burn per day based on your current diet
        //so you get to 2000 calories (or lower if you want to lose weight)
        int calToLose = 0;
        if (toLose == false){
            calToLose = currentCal - calTarget;
        }
        else{
            calToLose = currentCal - calTarget + dayToLose;
        }
        return calToLose;
    }
}
