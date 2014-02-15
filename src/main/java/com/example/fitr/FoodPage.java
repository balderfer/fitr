package com.example.fitr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.lang.Math;
import android.app.*;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.*;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView.*;

public class FoodPage extends ListActivity implements OnItemClickListener{
	private EditText filterText = null;
	ArrayAdapter<String> adapter = null;
	ListView total1;
	static double calTot = 0;
    static double sweetsTot = 0;
    static double beveragesTot = 0;
    static double meatsTot = 0;
    static double dairyTot = 0;
    static double fruitTot = 0;
    static double veggieTot = 0;
    static double grainTot = 0;
    static double combinedTot = 0;
    static double highCal = 0;
    static double sweetPer, bevPer, meatPer, dairyPer, fruitPer, veggiePer, grainPer, combPer;
    static double MaxPercent, highCalPerc;
    static String maxPercentType;
    static String highCalId;
    static String messagePercentHigh;
    static String messageCalorieHigh;

    public void navigate1(View view) {

        Intent k = new Intent(this, Analysis.class);
        startActivity(k);

    }

	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
        Intent intent = getIntent();

	    setContentView(R.layout.food_page);

        TextView title = (TextView)findViewById(R.id.title);
        Typeface font = Typeface.createFromAsset(getAssets(), "CaeciliaLTStd-Heavy.otf");
        title.setTypeface(font);

	    String[] food_names = getResources().getStringArray(R.array.food_array);
	    
	    ArrayList<String> fA = new ArrayList<String>(Arrays.asList(food_names));

	    filterText = (EditText) findViewById(R.id.search);
	    filterText.addTextChangedListener(filterTextWatcher);

	    adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, fA);
	    setListAdapter(adapter); 
	    
	    total1 = (ListView)findViewById(android.R.id.list);
	    total1.setOnItemClickListener(this);
	    
	    
	}

	private TextWatcher filterTextWatcher = new TextWatcher() {

	    public void afterTextChanged(Editable s) {
	    }

	    public void beforeTextChanged(CharSequence s, int start, int count,
	            int after) {
	    }

	    public void onTextChanged(CharSequence s, int start, int before,
	            int count) {
	        adapter.getFilter().filter(s);
	    }

	};
	protected void onDestroy() {
	    super.onDestroy();
	    filterText.removeTextChangedListener(filterTextWatcher);
	}
	public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
		String food_val = (String) adapter.getItemAtPosition(position);
		double cal = 0;
		String group = "";
		if (food_val.equals("100% Natural Cereal 1 Oz")){
			cal =135;
			group = "g";
		}
		else if (food_val.equals("40% Bran Flakes; KelloggS 1 Oz")){
			cal =90;
			group = "g";
		}
		else if (food_val.equals("40% Bran Flakes; Post 1 Oz")){
			cal =90;
			group = "g";
		}
		else if (food_val.equals("Alfalfa Seeds; Sprouted; Raw 1 Cup")){
			cal =10;
			group = "g";
		}
		else if (food_val.equals("All-Bran Cereal 1 Oz")){
			cal =70;
			group = "g";
		}
		else if (food_val.equals("Almonds; Slivered 1 Cup")){
			cal =795;
			group = "m";
		}
		else if (food_val.equals("Almonds; Whole 1 Oz")){
			cal =165;
			group = "m";
		}
		else if (food_val.equals("Angelfood Cake; From Mix 1 Cake")){
			cal =1510;
			group = "s";
		}
		else if (food_val.equals("Angelfood Cake; From Mix 1 Piece")){
			cal =125;
			group = "s";
		}
		else if (food_val.equals("Apple Juice; Canned 1 Cup")){
			cal =115;
			group = "b";
		}
		else if (food_val.equals("Apple Pie 1 Pie")){
			cal =2420;
			group = "s";
		}
		else if (food_val.equals("Apple Pie 1 Piece")){
			cal =405;
			group = "s";
		}
		else if (food_val.equals("Apples; Dried; Sulfured 10 Rings")){
			cal =155;
			group = "f";
		}
		else if (food_val.equals("Apples; Raw; Peeled; Sliced 1 Cup")){
			cal =65;
			group = "f";
		}
		else if (food_val.equals("Apples; Raw; Unpeeled;2 Per Lb1 Apple")){
			cal =125;
			group = "f";
		}
		else if (food_val.equals("Apples; Raw; Unpeeled;3 Per Lb1 Apple")){
			cal =80;
			group = "f";
		}
		else if (food_val.equals("Applesauce; Canned; Sweetened 1 Cup")){
			cal =195;
			group = "f";
		}
		else if (food_val.equals("Applesauce; Canned;Unsweetened1 Cup")){
			cal =105;
			group = "f";
		}
		else if (food_val.equals("Apricot Nectar; No Added Vit C1 Cup")){
			cal =140;
			group = "b";
		}
		else if (food_val.equals("Apricot; Canned; Heavy Syrup 1 Cup")){
			cal =215;
			group = "f";
		}
		else if (food_val.equals("Apricot; Canned; Heavy Syrup 3 Halves")){
			cal =70;
			group = "f";
		}
		else if (food_val.equals("Apricots; Canned; Juice Pack 1 Cup")){
			cal =120;
			group = "f";
		}
		else if (food_val.equals("Apricots; Canned; Juice Pack 3 Halves")){
			cal =40;
			group = "f";
		}
		else if (food_val.equals("Apricots; Dried; Cooked;Unswtn1 Cup")){
			cal =210;
			group = "f";
		}
		else if (food_val.equals("Apricots; Dried; Uncooked 1 Cup")){
			cal =310;
			group = "f";
		}
		else if (food_val.equals("Apricots; Raw 3 Aprcot")){
			cal =50;
			group = "f";
		}
		else if (food_val.equals("Artichokes; Globe; Cooked; Drn1 Artchk")){
			cal =55;
			group = "v";
		}
		else if (food_val.equals("Asparagus; Ckd Frm Frz;Dr;Sper4 Spears")){
			cal =15;
			group = "v";
		}
		else if (food_val.equals("Asparagus; Ckd Frm Frz;Drn;Cut1 Cup")){
			cal =50;
			group = "v";
		}
		else if (food_val.equals("Asparagus; Ckd Frm Raw; Dr;Cut1 Cup")){
			cal =45;
			group = "v";
		}
		else if (food_val.equals("Asparagus; Ckd Frm Raw;Dr;Sper4 Spears")){
			cal =15;
			group = "v";
		}
		else if (food_val.equals("Asparagus;Canned;Spears;Nosalt4 Spears")){
			cal =10;
			group = "v";
		}
		else if (food_val.equals("Asparagus;Canned;Spears;W/Salt4 Spears")){
			cal =10;
			group = "v";
		}
		else if (food_val.equals("Avocados; California 1 Avocdo")){
			cal =305;
			group = "f";
		}
		else if (food_val.equals("Avocados; Florida 1 Avocdo")){
			cal =340;
			group = "f";
		}
		else if (food_val.equals("Bagels; Egg 1 Bagel")){
			cal =200;
			group = "g";
		}
		else if (food_val.equals("Bagels; Plain 1 Bagel")){
			cal =200;
			group = "g";
		}
		else if (food_val.equals("Baking Pwdr Biscuits;From Mix 1 Biscut")){
			cal =95;
			group = "g";
		}
		else if (food_val.equals("Baking Pwdr Biscuits;Homerecpe1 Biscut")){
			cal =100;
			group = "g";
		}
		else if (food_val.equals("Baking Pwdr Biscuits;Refrgdogh1 Biscut")){
			cal =65;
			group = "g";
		}
		else if (food_val.equals("Bamboo Shoots; Canned; Drained1 Cup")){
			cal =25;
			group = "v";
		}
		else if (food_val.equals("Bananas 1 Banana")){
			cal =105;
			group = "f";
		}
		else if (food_val.equals("Bananas; Sliced 1 Cup")){
			cal =140;
			group = "f";
		}
		else if (food_val.equals("Barley; Pearled;Light; Uncookd1 Cup")){
			cal =700;
			group = "g";
		}
		else if (food_val.equals("Bean Sprouts; Mung; Cookd;Dran1 Cup")){
			cal =25;
			group = "v";
		}
		else if (food_val.equals("Bean Sprouts; Mung; Raw 1 Cup")){
			cal =30;
			group = "v";
		}
		else if (food_val.equals("Bean With Bacon Soup; Canned 1 Cup")){
			cal =170;
			group = "v";
		}
		else if (food_val.equals("Beans;Dry;Canned;W/Frankfurter1 Cup")){
			cal =365;
			group = "m";
		}
		else if (food_val.equals("Beans;Dry;Canned;W/Pork+Swtsce1 Cup")){
			cal =385;
			group = "m";
		}
		else if (food_val.equals("Beans;Dry;Canned;W/Pork+Tomsce1 Cup")){
			cal =310;
			group = "m";
		}
		else if (food_val.equals("Beef And Vegetable Stew;Hm Rcp1 Cup")){
			cal =220;
			group = "c";
		}
		else if (food_val.equals("Beef Broth; Boulln; Consm;Cnnd1 Cup")){
			cal =15;
			group = "c";
		}
		else if (food_val.equals("Beef Gravy; Canned 1 Cup")){
			cal =125;
			group = "c";
		}
		else if (food_val.equals("Beef Heart; Braised 3 Oz")){
			cal =150;
			group = "m";
		}
		else if (food_val.equals("Beef Liver; Fried 3 Oz")){
			cal =185;
			group = "m";
		}
		else if (food_val.equals("Beef Noodle Soup; Canned 1 Cup")){
			cal =85;
			group = "c";
		}
		else if (food_val.equals("Beef Potpie; Home Recipe 1 Piece")){
			cal =515;
			group = "c";
		}
		else if (food_val.equals("Beef Roast; Eye O Rnd; Lean 2.6 Oz")){
			cal =135;
			group = "m";
		}
		else if (food_val.equals("Beef Roast; Eye O Rnd;Lean+Fat3 Oz")){
			cal =205;
			group = "m";
		}
		else if (food_val.equals("Beef Roast; Rib; Lean + Fat 3 Oz")){
			cal =315;
			group = "m";
		}
		else if (food_val.equals("Beef Roast; Rib; Lean Only 2.2 Oz")){
			cal =150;
			group = "m";
		}
		else if (food_val.equals("Beef Steak;Sirloin;Broil;Lean 2.5 Oz")){
			cal =150;
			group = "m";
		}
		else if (food_val.equals("Beef Steak;Sirloin;Broil;Ln+Ft3 Oz")){
			cal =240;
			group = "m";
		}
		else if (food_val.equals("Beef; Canned; Corned 3 Oz")){
			cal =185;
			group = "m";
		}
		else if (food_val.equals("Beef; Ckd;Bttm Round;Lean Only2.8 Oz")){
			cal =175;
			group = "m";
		}
		else if (food_val.equals("Beef; Ckd;Bttm Round;Lean+ Fat3 Oz")){
			cal =220;
			group = "m";
		}
		else if (food_val.equals("Beef; Ckd;Chuck Blade;Lean+Fat3 Oz")){
			cal =325;
			group = "m";
		}
		else if (food_val.equals("Beef; Ckd;Chuck Blade;Leanonly2.2 Oz")){
			cal =170;
			group = "m";
		}
		else if (food_val.equals("Beef; Dried; Chipped 2.5 Oz")){
			cal =145;
			group = "m";
		}
		else if (food_val.equals("Beer; Light 12 Fl Oz")){
			cal =95;
			group = "b";
		}
		else if (food_val.equals("Beer; Regular 12 Fl Oz")){
			cal =150;
			group = "b";
		}
		else if (food_val.equals("Beet Greens; Cooked; Drained 1 Cup")){
			cal =40;
			group = "v";
		}
		else if (food_val.equals("Beets; Canned; Drained;No Salt1 Cup")){
			cal =55;
			group = "v";
		}
		else if (food_val.equals("Beets; Canned; Drained;W/ Salt1 Cup")){
			cal =55;
			group = "v";
		}
		else if (food_val.equals("Beets; Cooked; Drained; Diced 1 Cup")){
			cal =55;
			group = "v";
		}
		else if (food_val.equals("Beets; Cooked; Drained; Whole 2 Beets")){
			cal =30;
			group = "v";
		}
		else if (food_val.equals("Black Beans; Dry; Cooked;Drand1 Cup")){
			cal =225;
			group = "m";
		}
		else if (food_val.equals("Blackberries; Raw 1 Cup")){
			cal =75;
			group = "f";
		}
		else if (food_val.equals("Blackeye Peas; Immatr;Raw;Cked1 Cup")){
			cal =180;
			group = "m";
		}
		else if (food_val.equals("Blackeye Peas;Immtr;Frzn;Cked 1 Cup")){
			cal =225;
			group = "m";
		}
		else if (food_val.equals("Black-Eyed Peas; Dry; Cooked 1 Cup")){
			cal =190;
			group = "m";
		}
		else if (food_val.equals("Blue Cheese 1 Oz")){
			cal =100;
			group = "d";
		}
		else if (food_val.equals("Blueberries; Frozen; Sweetened1 Cup")){
			cal =185;
			group = "f";
		}
		else if (food_val.equals("Blueberries; Frozen; Sweetened10 Oz")){
			cal =230;
			group = "f";
		}
		else if (food_val.equals("Blueberries; Raw 1 Cup")){
			cal =80;
			group = "f";
		}
		else if (food_val.equals("Blueberry Muffins; Home Recipe1 Muffin")){
			cal =135;
			group = "c";
		}
		else if (food_val.equals("Blueberry Muffins;From Com Mix1 Muffin")){
			cal =140;
			group = "c";
		}
		else if (food_val.equals("Blueberry Pie 1 Pie")){
			cal =2285;
			group = "c";
		}
		else if (food_val.equals("Blueberry Pie 1 Piece")){
			cal =380;
			group = "c";
		}
		else if (food_val.equals("Bologna 2 Slices")){
			cal =180;
			group = "m";
		}
		else if (food_val.equals("Boston Brown Bread;W/Whtecrnm 1 Slice")){
			cal =95;
			group = "s";
		}
		else if (food_val.equals("Boston Brown Bread;W/Yllwcrnml1 Slice")){
			cal =95;
			group = "s";
		}
		else if (food_val.equals("Bouillon; Dehydrtd; Unprepared1 Pkt")){
			cal =15;
			group = "c";
		}
		else if (food_val.equals("Bran Muffins; From Commerl Mix1 Muffin")){
			cal =140;
			group = "g";
		}
		else if (food_val.equals("Bran Muffins; Home Recipe 1 Muffin")){
			cal =125;
			group = "g";
		}
		else if (food_val.equals("Brazil Nuts 1 Oz")){
			cal =185;
			group = "m";
		}
		else if (food_val.equals("Bread Stuffing;From Mx;Drytype1 Cup")){
			cal =500;
			group = "c";
		}
		else if (food_val.equals("Bread Stuffing;From Mx;Moist 1 Cup")){
			cal =420;
			group = "c";
		}
		else if (food_val.equals("Breadcrumbs; Dry; Grated 1 Cup")){
			cal =390;
			group = "g";
		}
		else if (food_val.equals("Broccoli; Frzn; Cooked; Draned1 Cup")){
			cal =50;
			group = "v";
		}
		else if (food_val.equals("Broccoli; Frzn; Cooked; Draned1 Piece")){
			cal =10;
			group = "v";
		}
		else if (food_val.equals("Broccoli; Raw 1 Spear")){
			cal =40;
			group = "v";
		}
		else if (food_val.equals("Broccoli; Raw; Cooked; Drained1 Cup")){
			cal =45;
			group = "v";
		}
		else if (food_val.equals("Broccoli; Raw; Cooked; Drained1 Spear")){
			cal =50;
			group = "v";
		}
		else if (food_val.equals("Brown And Serve Sausage;Brwnd 1 Link")){
			cal =50;
			group = "m";
		}
		else if (food_val.equals("Brown Gravy From Dry Mix 1 Cup")){
			cal =80;
			group = "c";
		}
		else if (food_val.equals("Brownies W/ Nuts;Frm Home Recp1 Browne")){
			cal =95;
			group = "c";
		}
		else if (food_val.equals("Brownies W/ Nuts;Frstng;Cmmrcl1 Browne")){
			cal =100;
			group = "c";
		}
		else if (food_val.equals("Brussels Sprouts; Frzn; Cooked1 Cup")){
			cal =65;
			group = "v";
		}
		else if (food_val.equals("Brussels Sprouts; Raw; Cooked 1 Cup")){
			cal =60;
			group = "v";
		}
		else if (food_val.equals("Buckwheat Flour; Light; Sifted1 Cup")){
			cal =340;
			group = "g";
		}
		else if (food_val.equals("Butter; Salted 1 Pat")){
			cal =35;
			group = "d";
		}
		else if (food_val.equals("Butter; Salted 1 Tbsp")){
			cal =100;
			group = "d";
		}
		else if (food_val.equals("Butter; Salted 1/2 Cup")){
			cal =810;
			group = "d";
		}
		else if (food_val.equals("Butter; Unsalted 1 Pat")){
			cal =35;
			group = "d";
		}
		else if (food_val.equals("Butter; Unsalted 1 Tbsp")){
			cal =100;
			group = "d";
		}
		else if (food_val.equals("Butter; Unsalted 1/2 Cup")){
			cal =810;
			group = "d";
		}
		else if (food_val.equals("Buttermilk; Dried 1 Cup")){
			cal =465;
			group = "d";
		}
		else if (food_val.equals("Buttermilk; Fluid 1 Cup")){
			cal =100;
			group = "d";
		}
		else if (food_val.equals("Cabbage; Chinese; Pak-Choi;Ckd1 Cup")){
			cal =20;
			group = "v";
		}
		else if (food_val.equals("Cabbage; Chinese;Pe-Tsai; Raw 1 Cup")){
			cal =10;
			group = "v";
		}
		else if (food_val.equals("Cabbage; Common; Cooked; Drned1 Cup")){
			cal =30;
			group = "v";
		}
		else if (food_val.equals("Cabbage; Common; Raw 1 Cup")){
			cal =15;
			group = "v";
		}
		else if (food_val.equals("Cabbage; Red; Raw 1 Cup")){
			cal =20;
			group = "v";
		}
		else if (food_val.equals("Cabbage; Savoy; Raw 1 Cup")){
			cal =20;
			group = "v";
		}
		else if (food_val.equals("Cake Or Pastry Flour; Sifted 1 Cup")){
			cal =350;
			group = "s";
		}
		else if (food_val.equals("Camembert Cheese 1 Wedge")){
			cal =115;
			group = "d";
		}
		else if (food_val.equals("Cantaloup; Raw 1/2 Meln")){
			cal =95;
			group = "f";
		}
		else if (food_val.equals("CapN Crunch Cereal 1 Oz")){
			cal =120;
			group = "g";
		}
		else if (food_val.equals("Caramels; Plain Or Chocolate 1 Oz")){
			cal =115;
			group = "s";
		}
		else if (food_val.equals("Carrot Cake;Cremchese Frst;Rec1 Cake")){
			cal =6175;
			group = "s";
		}
		else if (food_val.equals("Carrot Cake;Cremchese Frst;Rec1 Piece")){
			cal =385;
			group = "s";
		}
		else if (food_val.equals("Carrots; Canned; Drn; W/ Salt 1 Cup")){
			cal =35;
			group = "v";
		}
		else if (food_val.equals("Carrots; Canned;Drnd; W/O Salt1 Cup")){
			cal =35;
			group = "v";
		}
		else if (food_val.equals("Carrots; Cooked From Frozen 1 Cup")){
			cal =55;
			group = "v";
		}
		else if (food_val.equals("Carrots; Cooked From Raw 1 Cup")){
			cal =70;
			group = "v";
		}
		else if (food_val.equals("Carrots; Raw; Grated 1 Cup")){
			cal =45;
			group = "v";
		}
		else if (food_val.equals("Carrots; Raw; Whole 1 Carrot")){
			cal =30;
			group = "v";
		}
		else if (food_val.equals("Cashew Nuts; Dry Roastd;Salted1 Oz")){
			cal =165;
			group = "m";
		}
		else if (food_val.equals("Cashew Nuts; Dry Roastd;Unsalt1 Cup")){
			cal =785;
			group = "m";
		}
		else if (food_val.equals("Cashew Nuts; Dry Roastd;Unsalt1 Oz")){
			cal =165;
			group = "m";
		}
		else if (food_val.equals("Cashew Nuts; Dry Roasted;Saltd1 Cup")){
			cal =785;
			group = "m";
		}
		else if (food_val.equals("Cashew Nuts; Oil Roastd;Salted1 Cup")){
			cal =750;
			group = "m";
		}
		else if (food_val.equals("Cashew Nuts; Oil Roastd;Salted1 Oz")){
			cal =165;
			group = "m";
		}
		else if (food_val.equals("Cashew Nuts; Oil Roastd;Unsalt1 Cup")){
			cal =750;
			group = "m";
		}
		else if (food_val.equals("Cashew Nuts; Oil Roastd;Unsalt1 Oz")){
			cal =165;
			group = "m";
		}
		else if (food_val.equals("Catsup 1 Cup")){
			cal =290;
			group = "c";
		}
		else if (food_val.equals("Catsup 1 Tbsp")){
			cal =15;
			group = "c";
		}
		else if (food_val.equals("Cauliflower; Cooked From Frozn1 Cup")){
			cal =35;
			group = "v";
		}
		else if (food_val.equals("Cauliflower; Cooked From Raw 1 Cup")){
			cal =30;
			group = "v";
		}
		else if (food_val.equals("Cauliflower; Raw 1 Cup")){
			cal =25;
			group = "v";
		}
		else if (food_val.equals("Celery Seed 1 Tsp")){
			cal =10;
			group = "v";
		}
		else if (food_val.equals("Celery; Pascal Type; Raw;Piece1 Cup")){
			cal =20;
			group = "v";
		}
		else if (food_val.equals("Celery; Pascal Type; Raw;Stalk1 Stalk")){
			cal =5;
			group = "v";
		}
		else if (food_val.equals("Cheddar Cheese 1 Cu In")){
			cal =70;
			group = "d";
		}
		else if (food_val.equals("Cheddar Cheese 1 Oz")){
			cal =115;
			group = "d";
		}
		else if (food_val.equals("Chedddar Cheese; Shredded 1 Cup")){
			cal =455;
			group = "d";
		}
		else if (food_val.equals("Cheerios Cereal 1 Oz")){
			cal =110;
			group = "g";
		}
		else if (food_val.equals("Cheese Crackers; Plain 10 Crack")){
			cal =50;
			group = "c";
		}
		else if (food_val.equals("Cheese Crackers; Sandwch;Peant1 Sandwh")){
			cal =40;
			group = "c";
		}
		else if (food_val.equals("Cheeseburger; 4Oz Patty 1 Sandwh")){
			cal =525;
			group = "c";
		}
		else if (food_val.equals("Cheeseburger; Regular 1 Sandwh")){
			cal =300;
			group = "c";
		}
		else if (food_val.equals("Cheesecake 1 Cake")){
			cal =3350;
			group = "s";
		}
		else if (food_val.equals("Cheesecake 1 Piece")){
			cal =280;
			group = "s";
		}
		else if (food_val.equals("Cherries; Sour;Red;Cannd;Water1 Cup")){
			cal =90;
			group = "f";
		}
		else if (food_val.equals("Cherries; Sweet; Raw 10 Chery")){
			cal =50;
			group = "f";
		}
		else if (food_val.equals("Cherry Pie 1 Pie")){
			cal =2465;
			group = "c";
		}
		else if (food_val.equals("Cherry Pie 1 Piece")){
			cal =410;
			group = "c";
		}
		else if (food_val.equals("Chestnuts; European; Roasted 1 Cup")){
			cal =350;
			group = "m";
		}
		else if (food_val.equals("Chicken A La King; Home Recipe1 Cup")){
			cal =470;
			group = "c";
		}
		else if (food_val.equals("Chicken And Noodles; Home Recp1 Cup")){
			cal =365;
			group = "c";
		}
		else if (food_val.equals("Chicken Chow Mein; Canned 1 Cup")){
			cal =95;
			group = "c";
		}
		else if (food_val.equals("Chicken Chow Mein; Home Recipe1 Cup")){
			cal =255;
			group = "c";
		}
		else if (food_val.equals("Chicken Frankfurter 1 Frank")){
			cal =115;
			group = "m";
		}
		else if (food_val.equals("Chicken Gravy From Dry Mix 1 Cup")){
			cal =85;
			group = "c";
		}
		else if (food_val.equals("Chicken Gravy; Canned 1 Cup")){
			cal =190;
			group = "c";
		}
		else if (food_val.equals("Chicken Liver; Cooked 1 Liver")){
			cal =30;
			group = "m";
		}
		else if (food_val.equals("Chicken Noodle Soup; Canned 1 Cup")){
			cal =75;
			group = "c";
		}
		else if (food_val.equals("Chicken Noodle Soup;Dehyd;Prpd1 Pkt")){
			cal =40;
			group = "c";
		}
		else if (food_val.equals("Chicken Potpie; Home Recipe 1 Piece")){
			cal =545;
			group = "c";
		}
		else if (food_val.equals("Chicken Rice Soup; Canned 1 Cup")){
			cal =60;
			group = "c";
		}
		else if (food_val.equals("Chicken Roll; Light 2 Slices")){
			cal =90;
			group = "c";
		}
		else if (food_val.equals("Chicken; Canned; Boneless 5 Oz")){
			cal =235;
			group = "m";
		}
		else if (food_val.equals("Chicken; Fried; Batter; Breast4.9 Oz")){
			cal =365;
			group = "m";
		}
		else if (food_val.equals("Chicken; Fried; Batter;Drmstck2.5 Oz")){
			cal =195;
			group = "m";
		}
		else if (food_val.equals("Chicken; Fried; Flour; Breast 3.5 Oz")){
			cal =220;
			group = "m";
		}
		else if (food_val.equals("Chicken; Fried; Flour; Drmstck1.7 Oz")){
			cal =120;
			group = "m";
		}
		else if (food_val.equals("Chicken; Roasted; Breast 3.0 Oz")){
			cal =140;
			group = "m";
		}
		else if (food_val.equals("Chicken; Roasted; Drumstick 1.6 Oz")){
			cal =75;
			group = "m";
		}
		else if (food_val.equals("Chicken; Stewed; Light + Dark 1 Cup")){
			cal =250;
			group = "m";
		}
		else if (food_val.equals("Chickpeas; Cooked; Drained 1 Cup")){
			cal =270;
			group = "v";
		}
		else if (food_val.equals("Chili Con Carne W/ Beans; Cnnd1 Cup")){
			cal =340;
			group = "c";
		}
		else if (food_val.equals("Chocolate Chip Cookies;Commrcl4 Cookie")){
			cal =180;
			group = "s";
		}
		else if (food_val.equals("Chocolate Chip Cookies;Hme Rcp4 Cookie")){
			cal =185;
			group = "s";
		}
		else if (food_val.equals("Chocolate Chip Cookies;Refrig 4 Cookie")){
			cal =225;
			group = "s";
		}
		else if (food_val.equals("Chocolate Milk; Lowfat 1% 1 Cup")){
			cal =160;
			group = "d";
		}
		else if (food_val.equals("Chocolate Milk; Lowfat 2% 1 Cup")){
			cal =180;
			group = "d";
		}
		else if (food_val.equals("Chocolate Milk; Regular 1 Cup")){
			cal =210;
			group = "d";
		}
		else if (food_val.equals("Chocolate; Bitter Ot Baking 1 Oz")){
			cal =145;
			group = "s";
		}
		else if (food_val.equals("Chop Suey W/ Beef + Pork;Hmrcp1 Cup")){
			cal =300;
			group = "c";
		}
		else if (food_val.equals("Cinnamon 1 Tsp")){
			cal =5;
			group = "s";
		}
		else if (food_val.equals("Clam Chowder; Manhattan; Cannd1 Cup")){
			cal =80;
			group = "c";
		}
		else if (food_val.equals("Clam Chowder; New Eng; W/ Milk1 Cup")){
			cal =165;
			group = "c";
		}
		else if (food_val.equals("Clams; Canned; Drained 3 Oz")){
			cal =85;
			group = "m";
		}
		else if (food_val.equals("Clams; Raw 3 Oz")){
			cal =65;
			group = "m";
		}
		else if (food_val.equals("Club Soda 12 Fl Oz")){
			cal =0;
			group = "b";
		}
		else if (food_val.equals("Coca Pwdr W/O Nofat Drymlk;Prd1 Servng")){
			cal =225;
			group = "s";
		}
		else if (food_val.equals("Coca Pwdr W/O Nonfat Dry Milk 3/4 Oz")){
			cal =75;
			group = "s";
		}
		else if (food_val.equals("Cocoa Pwdr W/ Nofat Drmlk;Prpd1 Servng")){
			cal =100;
			group = "s";
		}
		else if (food_val.equals("Cocoa Pwdr With Nonfat Drymilk1 Oz")){
			cal =100;
			group = "s";
		}
		else if (food_val.equals("Coconut; Dried; Sweetnd;Shredd1 Cup")){
			cal =470;
			group = "f";
		}
		else if (food_val.equals("Coconut; Raw; Piece 1 Piece")){
			cal =160;
			group = "f";
		}
		else if (food_val.equals("Coconut; Raw; Shredded 1 Cup")){
			cal =285;
			group = "f";
		}
		else if (food_val.equals("Coffee; Brewed 6 Fl Oz")){
			cal =0;
			group = "b";
		}
		else if (food_val.equals("Coffee; Instant; Prepared 6 Fl Oz")){
			cal =0;
			group = "b";
		}
		else if (food_val.equals("Coffeecake; Crumb; From Mix 1 Cake")){
			cal =1385;
			group = "s";
		}
		else if (food_val.equals("Coffeecake; Crumb; From Mix 1 Piece")){
			cal =230;
			group = "s";
		}
		else if (food_val.equals("Cola; Diet; Aspartame Only 12 Fl Oz")){
			cal =0;
			group = "b";
		}
		else if (food_val.equals("Cola; Diet; Asprtame + Sacchrn12 Fl Oz")){
			cal =0;
			group = "b";
		}
		else if (food_val.equals("Cola; Diet; Saccharin Only 12 Fl Oz")){
			cal =0;
			group = "b";
		}
		else if (food_val.equals("Cola; Regular 12 Fl Oz")){
			cal =160;
			group = "b";
		}
		else if (food_val.equals("Collards; Cooked From Frozen 1 Cup")){
			cal =60;
			group = "v";
		}
		else if (food_val.equals("Collards; Cooked From Raw 1 Cup")){
			cal =25;
			group = "v";
		}
		else if (food_val.equals("Corn Chips 1 Oz")){
			cal =155;
			group = "g";
		}
		else if (food_val.equals("Corn Flakes; KelloggS 1 Oz")){
			cal =110;
			group = "g";
		}
		else if (food_val.equals("Corn Flakes; Toasties 1 Oz")){
			cal =110;
			group = "g";
		}
		else if (food_val.equals("Corn Grits; Cooked; Instant 1 Pkt")){
			cal =80;
			group = "g";
		}
		else if (food_val.equals("Corn Grits;Ckd;Reg;Whte;Nosalt1 Cup")){
			cal =145;
			group = "g";
		}
		else if (food_val.equals("Corn Grits;Ckd;Reg;Whte;W/Salt1 Cup")){
			cal =145;
			group = "g";
		}
		else if (food_val.equals("Corn Grits;Ckd;Reg;Yllw;Nosalt1 Cup")){
			cal =145;
			group = "g";
		}
		else if (food_val.equals("Corn Grits;Ckd;Reg;Yllw;W/Salt1 Cup")){
			cal =145;
			group = "g";
		}
		else if (food_val.equals("Corn Muffins; From Commerl Mix1 Muffin")){
			cal =145;
			group = "g";
		}
		else if (food_val.equals("Corn Muffins; Home Recipe 1 Muffin")){
			cal =145;
			group = "g";
		}
		else if (food_val.equals("Corn; Cnnd;Crm Stl;Whit;No Sal1 Cup")){
			cal =185;
			group = "g";
		}
		else if (food_val.equals("Corn; Cnnd;Crm Stl;Whit;W/Salt1 Cup")){
			cal =185;
			group = "g";
		}
		else if (food_val.equals("Corn; Cnnd;Crm Stl;Yllw;No Sal1 Cup")){
			cal =185;
			group = "g";
		}
		else if (food_val.equals("Corn; Cnnd;Crm Stl;Yllw;W/Salt1 Cup")){
			cal =185;
			group = "g";
		}
		else if (food_val.equals("Corn; Cooked Frm Frozn; White 1 Cup")){
			cal =135;
			group = "g";
		}
		else if (food_val.equals("Corn; Cooked Frm Frozn; White 1 Ear")){
			cal =60;
			group = "g";
		}
		else if (food_val.equals("Corn; Cooked Frm Frozn; Yellow1 Cup")){
			cal =135;
			group = "g";
		}
		else if (food_val.equals("Corn; Cooked Frm Frozn; Yellow1 Ear")){
			cal =60;
			group = "g";
		}
		else if (food_val.equals("Corn; Cooked From Raw; White 1 Ear")){
			cal =85;
			group = "g";
		}
		else if (food_val.equals("Corn; Cooked From Raw; Yellow 1 Ear")){
			cal =85;
			group = "g";
		}
		else if (food_val.equals("Corn;Cnnd;Whl Krnl;Whte;No Sal1 Cup")){
			cal =165;
			group = "g";
		}
		else if (food_val.equals("Corn;Cnnd;Whl Krnl;Whte;W/Salt1 Cup")){
			cal =165;
			group = "g";
		}
		else if (food_val.equals("Corn;Cnnd;Whl Krnl;Yllw;No Sal1 Cup")){
			cal =165;
			group = "g";
		}
		else if (food_val.equals("Corn;Cnnd;Whl Krnl;Yllw;W/Salt1 Cup")){
			cal =165;
			group = "g";
		}
		else if (food_val.equals("Cornmeal;Bolted;Dry Form 1 Cup")){
			cal =440;
			group = "g";
		}
		else if (food_val.equals("Cornmeal;Degermed;Enrched;Cook1 Cup")){
			cal =120;
			group = "g";
		}
		else if (food_val.equals("Cornmeal;Degermed;Enriched;Dry1 Cup")){
			cal =500;
			group = "g";
		}
		else if (food_val.equals("Cornmeal;Whole-Grnd;Unbolt;Dry1 Cup")){
			cal =435;
			group = "g";
		}
		else if (food_val.equals("Cottage Cheese;Cremd;Lrge Curd1 Cup")){
			cal =235;
			group = "d";
		}
		else if (food_val.equals("Cottage Cheese;Cremd;Smll Curd1 Cup")){
			cal =215;
			group = "d";
		}
		else if (food_val.equals("Cottage Cheese;Cremd;W/Fruit 1 Cup")){
			cal =280;
			group = "d";
		}
		else if (food_val.equals("Cottage Cheese;Lowfat 2% 1 Cup")){
			cal =205;
			group = "d";
		}
		else if (food_val.equals("Cottage Cheese;Uncreamed 1 Cup")){
			cal =125;
			group = "d";
		}
		else if (food_val.equals("Cr Of Chicken Soup W/ H20;Cnnd1 Cup")){
			cal =115;
			group = "c";
		}
		else if (food_val.equals("Cr Of Chicken Soup W/ Mlk;Cnnd1 Cup")){
			cal =190;
			group = "c";
		}
		else if (food_val.equals("Cr Of Mushrom Soup W/ H2O;Cnnd1 Cup")){
			cal =130;
			group = "c";
		}
		else if (food_val.equals("Cr Of Mushrom Soup W/ Mlk;Cnnd1 Cup")){
			cal =205;
			group = "c";
		}
		else if (food_val.equals("Crabmeat; Canned 1 Cup")){
			cal =135;
			group = "m";
		}
		else if (food_val.equals("Cracked-Wheat Bread 1 Loaf")){
			cal =1190;
			group = "g";
		}
		else if (food_val.equals("Cracked-Wheat Bread 1 Slice")){
			cal =65;
			group = "g";
		}
		else if (food_val.equals("Cracked-Wheat Bread; Toasted 1 Slice")){
			cal =65;
			group = "g";
		}
		else if (food_val.equals("Cranberry Juice Cocktal W/Vitc1 Cup")){
			cal =145;
			group = "s";
		}
		else if (food_val.equals("Cranberry Sauce; Canned;Swtnd 1 Cup")){
			cal =420;
			group = "s";
		}
		else if (food_val.equals("Cream Cheese 1 Oz")){
			cal =100;
			group = "d";
		}
		else if (food_val.equals("Cream Of Wheat;Ckd;Mix N Eat 1 Pkt")){
			cal =100;
			group = "c";
		}
		else if (food_val.equals("Creme Pie 1 Pie")){
			cal =2710;
			group = "c";
		}
		else if (food_val.equals("Creme Pie 1 Piece")){
			cal =455;
			group = "c";
		}
		else if (food_val.equals("Crm Wheat;Ckd; Quick; No Salt 1 Cup")){
			cal =140;
			group = "c";
		}
		else if (food_val.equals("Crm Wheat;Ckd;Quick; W/ Salt 1 Cup")){
			cal =140;
			group = "c";
		}
		else if (food_val.equals("Crm Wheat;Ckd;Reg;Inst;No Salt1 Cup")){
			cal =140;
			group = "c";
		}
		else if (food_val.equals("Crm Wheat;Ckd;Reg;Inst;W/Salt 1 Cup")){
			cal =140;
			group = "c";
		}
		else if (food_val.equals("Croissants 1 Crosst")){
			cal =235;
			group = "g";
		}
		else if (food_val.equals("Cucumber; W/ Peel 6 Slices")){
			cal =5;
			group = "v";
		}
		else if (food_val.equals("Custard Pie 1 Pie")){
			cal =1985;
			group = "s";
		}
		else if (food_val.equals("Custard Pie 1 Piece")){
			cal =330;
			group = "s";
		}
		else if (food_val.equals("Custard; Baked 1 Cup")){
			cal =305;
			group = "s";
		}
		else if (food_val.equals("Dandelion Greens; Cooked; Drnd1 Cup")){
			cal =35;
			group = "v";
		}
		else if (food_val.equals("Danish Pastry; Fruit 1 Pastry")){
			cal =235;
			group = "s";
		}
		else if (food_val.equals("Danish Pastry; Plain; No Nuts 1 Oz")){
			cal =110;
			group = "s";
		}
		else if (food_val.equals("Danish Pastry; Plain; No Nuts 1 Pastry")){
			cal =220;
			group = "s";
		}
		else if (food_val.equals("Danish Pastry; Plain; No Nuts 1 Ring")){
			cal =1305;
			group = "s";
		}
		else if (food_val.equals("Dates 10 Dates")){
			cal =230;
			group = "f";
		}
		else if (food_val.equals("Dates; Chopped 1 Cup")){
			cal =490;
			group = "f";
		}
		else if (food_val.equals("DevilS Food Cake;Chocfrst;Fmx1 Cake")){
			cal =3755;
			group = "s";
		}
		else if (food_val.equals("DevilS Food Cake;Chocfrst;Fmx1 Cupcak")){
			cal =120;
			group = "s";
		}
		else if (food_val.equals("DevilS Food Cake;Chocfrst;Fmx1 Piece")){
			cal =235;
			group = "s";
		}
		else if (food_val.equals("Doughnuts; Cake Type; Plain 1 Donut")){
			cal =210;
			group = "s";
		}
		else if (food_val.equals("Doughnuts; Yeast-Leavend;Glzed1 Donut")){
			cal =235;
			group = "s";
		}
		else if (food_val.equals("Duck; Roasted; Flesh Only 1/2 Duck")){
			cal =445;
			group = "m";
		}
		else if (food_val.equals("Eggnog 1 Cup")){
			cal =340;
			group = "d";
		}
		else if (food_val.equals("Eggplant; Cooked; Steamed 1 Cup")){
			cal =25;
			group = "v";
		}
		else if (food_val.equals("Eggs; Cooked; Fried 1 Egg")){
			cal =90;
			group = "m";
		}
		else if (food_val.equals("Eggs; Cooked; Hard-Cooked 1 Egg")){
			cal =75;
			group = "m";
		}
		else if (food_val.equals("Eggs; Cooked; Poached 1 Egg")){
			cal =75;
			group = "m";
		}
		else if (food_val.equals("Eggs; Cooked; Scrambled/Omelet1 Egg")){
			cal =100;
			group = "m";
		}
		else if (food_val.equals("Eggs; Raw; White 1 White")){
			cal =15;
			group = "m";
		}
		else if (food_val.equals("Eggs; Raw; Whole 1 Egg")){
			cal =75;
			group = "m";
		}
		else if (food_val.equals("Eggs; Raw; Yolk 1 Yolk")){
			cal =60;
			group = "m";
		}
		else if (food_val.equals("Enchilada 1 Enchld")){
			cal =235;
			group = "c";
		}
		else if (food_val.equals("Eng Muffin; Egg; Cheese; Bacon1 Sandwh")){
			cal =360;
			group = "g";
		}
		else if (food_val.equals("English Muffins; Plain 1 Muffin")){
			cal =140;
			group = "g";
		}
		else if (food_val.equals("English Muffins; Plain; Toastd1 Muffin")){
			cal =140;
			group = "g";
		}
		else if (food_val.equals("Evaporated Milk; Skim; Canned 1 Cup")){
			cal =200;
			group = "d";
		}
		else if (food_val.equals("Evaporated Milk; Whole; Canned1 Cup")){
			cal =340;
			group = "d";
		}
		else if (food_val.equals("Feta Cheese 1 Oz")){
			cal =75;
			group = "d";
		}
		else if (food_val.equals("Fig Bars 4 Cookie")){
			cal =210;
			group = "s";
		}
		else if (food_val.equals("Figs; Dried 10 Figs")){
			cal =475;
			group = "f";
		}
		else if (food_val.equals("Filberts; (Hazelnuts) Chopped 1 Cup")){
			cal =725;
			group = "m";
		}
		else if (food_val.equals("Filberts; (Hazelnuts) Chopped 1 Oz")){
			cal =180;
			group = "m";
		}
		else if (food_val.equals("Fish Sandwich; Lge; W/O Cheese1 Sandwh")){
			cal =470;
			group = "c";
		}
		else if (food_val.equals("Fish Sandwich; Reg; W/ Cheese 1 Sandwh")){
			cal =420;
			group = "c";
		}
		else if (food_val.equals("Fish Sticks; Frozen; Reheated 1 Stick")){
			cal =70;
			group = "c";
		}
		else if (food_val.equals("Flounder Or Sole; Baked; Buttr3 Oz")){
			cal =120;
			group = "m";
		}
		else if (food_val.equals("Flounder Or Sole; Baked;Margrn3 Oz")){
			cal =120;
			group = "m";
		}
		else if (food_val.equals("Flounder Or Sole; Baked;W/Ofat3 Oz")){
			cal =80;
			group = "m";
		}
		else if (food_val.equals("French Bread 1 Slice")){
			cal =100;
			group = "g";
		}
		else if (food_val.equals("French Or Vienna Bread 1 Loaf")){
			cal =1270;
			group = "g";
		}
		else if (food_val.equals("French Toast; Home Recipe 1 Slice")){
			cal =155;
			group = "g";
		}
		else if (food_val.equals("Fried Pie; Apple 1 Pie")){
			cal =255;
			group = "c";
		}
		else if (food_val.equals("Fried Pie; Cherry 1 Pie")){
			cal =250;
			group = "c";
		}
		else if (food_val.equals("Froot Loops Cereal 1 Oz")){
			cal =110;
			group = "g";
		}
		else if (food_val.equals("Fruit Cocktail;Cnnd;Heavysyrup1 Cup")){
			cal =185;
			group = "f";
		}
		else if (food_val.equals("Fruit Cocktail;Cnnd;Juice Pack1 Cup")){
			cal =115;
			group = "f";
		}
		else if (food_val.equals("Fruit Punch Drink; Canned 6 Fl Oz")){
			cal =85;
			group = "b";
		}
		else if (food_val.equals("Fruitcake;Dark; From Homerecip1 Cake")){
			cal =5185;
			group = "s";
		}
		else if (food_val.equals("Fruitcake;Dark; From Homerecip1 Piece")){
			cal =165;
			group = "s";
		}
		else if (food_val.equals("Fudge; Chocolate; Plain 1 Oz")){
			cal =115;
			group = "s";
		}
		else if (food_val.equals("Gelatin Dessert; Prepared 1/2 Cup")){
			cal =70;
			group = "s";
		}
		else if (food_val.equals("Gelatin; Dry 1 Envelp")){
			cal =25;
			group = "s";
		}
		else if (food_val.equals("Gin;Rum;Vodka;Whisky 80-Proof 1.5 F Oz")){
			cal =95;
			group = "b";
		}
		else if (food_val.equals("Gin;Rum;Vodka;Whisky 86-Proof 1.5 F Oz")){
			cal =105;
			group = "b";
		}
		else if (food_val.equals("Gin;Rum;Vodka;Whisky 90-Proof 1.5 F Oz")){
			cal =110;
			group = "b";
		}
		else if (food_val.equals("Ginger Ale 12 Fl Oz")){
			cal =125;
			group = "b";
		}
		else if (food_val.equals("Gingerbread Cake; From Mix 1 Cake")){
			cal =1575;
			group = "s";
		}
		else if (food_val.equals("Gingerbread Cake; From Mix 1 Piece")){
			cal =175;
			group = "s";
		}
		else if (food_val.equals("Golden Grahams Cereal 1 Oz")){
			cal =110;
			group = "g";
		}
		else if (food_val.equals("Graham Cracker; Plain 2 Crackr")){
			cal =60;
			group = "g";
		}
		else if (food_val.equals("Grape Drink; Canned 6 Fl Oz")){
			cal =100;
			group = "b";
		}
		else if (food_val.equals("Grape Juice; Canned 1 Cup")){
			cal =155;
			group = "b";
		}
		else if (food_val.equals("Grape Soda 12 Fl Oz")){
			cal =180;
			group = "b";
		}
		else if (food_val.equals("Grapefrt Jce;Frzn;Cncn;Unswten6 Fl Oz")){
			cal =300;
			group = "b";
		}
		else if (food_val.equals("Grapefrt Jce;Frzn;Dltd;Unswten1 Cup")){
			cal =100;
			group = "b";
		}
		else if (food_val.equals("Grapefruit Juice; Canned;Swtnd1 Cup")){
			cal =115;
			group = "b";
		}
		else if (food_val.equals("Grapefruit Juice; Canned;Unswt1 Cup")){
			cal =95;
			group = "b";
		}
		else if (food_val.equals("Grapefruit Juice; Raw 1 Cup")){
			cal =95;
			group = "b";
		}
		else if (food_val.equals("Grapefruit; Canned; Syrup Pack1 Cup")){
			cal =150;
			group = "f";
		}
		else if (food_val.equals("Grapefruit; Raw; Pink 1/2 Frut")){
			cal =40;
			group = "f";
		}
		else if (food_val.equals("Grapefruit; Raw; White 1/2 Frut")){
			cal =40;
			group = "f";
		}
		else if (food_val.equals("Grapejce;Frzn;Concen;Swtnd;W/C6 Fl Oz")){
			cal =385;
			group = "b";
		}
		else if (food_val.equals("Grapejce;Frzn;Dilutd;Swtnd;W/C1 Cup")){
			cal =125;
			group = "b";
		}
		else if (food_val.equals("Grape-Nuts Cereal 1 Oz")){
			cal =100;
			group = "g";
		}
		else if (food_val.equals("Grapes; European; Raw; Thompsn10 Grape")){
			cal =35;
			group = "f";
		}
		else if (food_val.equals("Grapes; European; Raw; Tokay 10 Grape")){
			cal =40;
			group = "f";
		}
		else if (food_val.equals("Gravy And Turkey; Frozen 5 Oz")){
			cal =95;
			group = "c";
		}
		else if (food_val.equals("Great Northn Beans;Dry;Ckd;Drn1 Cup")){
			cal =210;
			group = "m";
		}
		else if (food_val.equals("Ground Beef; Broiled; Lean 3 Oz")){
			cal =230;
			group = "m";
		}
		else if (food_val.equals("Ground Beef; Broiled; Regular 3 Oz")){
			cal =245;
			group = "m";
		}
		else if (food_val.equals("Gum Drops 1 Oz")){
			cal =100;
			group = "s";
		}
		else if (food_val.equals("Haddock; Breaded; Fried 3 Oz")){
			cal =175;
			group = "m";
		}
		else if (food_val.equals("Half And Half; Cream 1 Cup")){
			cal =315;
			group = "d";
		}
		else if (food_val.equals("Half And Half; Cream 1 Tbsp")){
			cal =20;
			group = "d";
		}
		else if (food_val.equals("Halibut; Broiled; Butter;Lemju3 Oz")){
			cal =140;
			group = "m";
		}
		else if (food_val.equals("Hamburger; 4Oz Patty 1 Sandwh")){
			cal =445;
			group = "m";
		}
		else if (food_val.equals("Hamburger; Regular 1 Sandwh")){
			cal =245;
			group = "m";
		}
		else if (food_val.equals("Hard Candy 1 Oz")){
			cal =110;
			group = "s";
		}
		else if (food_val.equals("Herring; Pickled 3 Oz")){
			cal =190;
			group = "m";
		}
		else if (food_val.equals("Hollandaise Sce; W/ H2O;Frm Mx1 Cup")){
			cal =240;
			group = "d";
		}
		else if (food_val.equals("Honey 1 Cup")){
			cal =1030;
			group = "s";
		}
		else if (food_val.equals("Honey 1 Tbsp")){
			cal =65;
			group = "s";
		}
		else if (food_val.equals("Honey Nut Cheerios Cereal 1 Oz")){
			cal =105;
			group = "g";
		}
		else if (food_val.equals("Honeydew Melon; Raw 1/10 Mel")){
			cal =45;
			group = "f";
		}
		else if (food_val.equals("Ice Cream; Vanlla; Regulr 11% 1 Cup")){
			cal =270;
			group = "s";
		}
		else if (food_val.equals("Ice Cream; Vanlla; Regulr 11% 1/2 Galn")){
			cal =2155;
			group = "s";
		}
		else if (food_val.equals("Ice Cream; Vanlla; Regulr 11% 3 Fl Oz")){
			cal =100;
			group = "s";
		}
		else if (food_val.equals("Ice Cream; Vanlla; Rich 16% Ft1 Cup")){
			cal =350;
			group = "s";
		}
		else if (food_val.equals("Ice Cream; Vanlla; Rich 16% Ft1/2 Gal")){
			cal =2805;
			group = "s";
		}
		else if (food_val.equals("Ice Cream; Vanlla; Soft Serve 1 Cup")){
			cal =375;
			group = "s";
		}
		else if (food_val.equals("Ice Milk; Vanilla; 4% Fat 1 Cup")){
			cal =185;
			group = "d";
		}
		else if (food_val.equals("Ice Milk; Vanilla; 4% Fat 1/2 Gal")){
			cal =1470;
			group = "d";
		}
		else if (food_val.equals("Ice Milk; Vanilla;Softserv 3% 1 Cup")){
			cal =225;
			group = "d";
		}
		else if (food_val.equals("Imitation Creamers; Liquid Frz1 Tbsp")){
			cal =20;
			group = "d";
		}
		else if (food_val.equals("Imitation Creamers; Powdered 1 Tsp")){
			cal =10;
			group = "d";
		}
		else if (food_val.equals("Imitation Whipped Topping;Frzn1 Cup")){
			cal =240;
			group = "d";
		}
		else if (food_val.equals("Imitation Whipped Topping;Frzn1 Tbsp")){
			cal =15;
			group = "d";
		}
		else if (food_val.equals("Imitatn Sour Dressing 1 Cup")){
			cal =415;
			group = "d";
		}
		else if (food_val.equals("Imitatn Sour Dressing 1 Tbsp")){
			cal =20;
			group = "d";
		}
		else if (food_val.equals("Imitatn Whipd Toping;Pressrzd 1 Cup")){
			cal =185;
			group = "d";
		}
		else if (food_val.equals("Imitatn Whipd Toping;Pressrzd 1 Tbsp")){
			cal =10;
			group = "d";
		}
		else if (food_val.equals("Imitatn Whipd Toping;Pwdrd;Prp1 Cup")){
			cal =150;
			group = "d";
		}
		else if (food_val.equals("Imitatn Whipd Toping;Pwdrd;Prp1 Tbsp")){
			cal =10;
			group = "d";
		}
		else if (food_val.equals("Italian Bread 1 Loaf")){
			cal =1255;
			group = "g";
		}
		else if (food_val.equals("Italian Bread 1 Slice")){
			cal =85;
			group = "g";
		}
		else if (food_val.equals("Jams And Preserves 1 Pkt")){
			cal =40;
			group = "s";
		}
		else if (food_val.equals("Jams And Preserves 1 Tbsp")){
			cal =55;
			group = "s";
		}
		else if (food_val.equals("Jellies 1 Pkt")){
			cal =40;
			group = "s";
		}
		else if (food_val.equals("Jellies 1 Tbsp")){
			cal =50;
			group = "s";
		}
		else if (food_val.equals("Jelly Beans 1 Oz")){
			cal =105;
			group = "s";
		}
		else if (food_val.equals("Jerusalem-Artichoke; Raw 1 Cup")){
			cal =115;
			group = "v";
		}
		else if (food_val.equals("Kale; Cooked From Frozen 1 Cup")){
			cal =40;
			group = "v";
		}
		else if (food_val.equals("Kale; Cooked From Raw 1 Cup")){
			cal =40;
			group = "v";
		}
		else if (food_val.equals("Kiwifruit; Raw 1 Kiwi")){
			cal =45;
			group = "f";
		}
		else if (food_val.equals("Kohlrabi; Cooked; Drained 1 Cup")){
			cal =50;
			group = "v";
		}
		else if (food_val.equals("Lamb; Rib; Roasted; Lean + Fat3 Oz")){
			cal =315;
			group = "m";
		}
		else if (food_val.equals("Lamb; Rib; Roasted; Lean Only 2 Oz")){
			cal =130;
			group = "m";
		}
		else if (food_val.equals("Lamb;Chops;Arm;Braised;Lean 1.7 Oz")){
			cal =135;
			group = "m";
		}
		else if (food_val.equals("Lamb;Chops;Arm;Braised;Lean+Ft2.2 Oz")){
			cal =220;
			group = "m";
		}
		else if (food_val.equals("Lamb;Chops;Loin;Broil;Lean 2.3 Oz")){
			cal =140;
			group = "m";
		}
		else if (food_val.equals("Lamb;Chops;Loin;Broil;Lean+Fat2.8 Oz")){
			cal =235;
			group = "m";
		}
		else if (food_val.equals("Lamb;Leg;Roasted; Lean Only 2.6 Oz")){
			cal =140;
			group = "m";
		}
		else if (food_val.equals("Lamb;Leg;Roasted; Lean+ Fat 3 Oz")){
			cal =205;
			group = "m";
		}
		else if (food_val.equals("Lemon Juice; Canned 1 Cup")){
			cal =50;
			group = "f";
		}
		else if (food_val.equals("Lemon Juice; Canned 1 Tbsp")){
			cal =5;
			group = "f";
		}
		else if (food_val.equals("Lemon Juice; Raw 1 Cup")){
			cal =60;
			group = "f";
		}
		else if (food_val.equals("Lemon Juice;Frzn;Single-Strngh6 Fl Oz")){
			cal =55;
			group = "f";
		}
		else if (food_val.equals("Lemon Meringue Pie 1 Pie")){
			cal =2140;
			group = "c";
		}
		else if (food_val.equals("Lemon Meringue Pie 1 Piece")){
			cal =355;
			group = "c";
		}
		else if (food_val.equals("Lemonade;Concen;Frzen;Diluted 6 Fl Oz")){
			cal =80;
			group = "b";
		}
		else if (food_val.equals("Lemonade;Concentrate;Frz;Undil6 Fl Oz")){
			cal =425;
			group = "b";
		}
		else if (food_val.equals("Lemon-Lime Soda 12 Fl Oz")){
			cal =155;
			group = "b";
		}
		else if (food_val.equals("Lemons; Raw 1 Lemon")){
			cal =15;
			group = "f";
		}
		else if (food_val.equals("Lentils; Dry; Cooked 1 Cup")){
			cal =215;
			group = "g";
		}
		else if (food_val.equals("Lettuce; Butterhead; Raw;Head 1 Head")){
			cal =20;
			group = "v";
		}
		else if (food_val.equals("Lettuce; Butterhead; Raw;Leave1 Leaf")){
			cal =0;
			group = "v";
		}
		else if (food_val.equals("Lettuce; Crisphead; Raw; Head 1 Head")){
			cal =70;
			group = "v";
		}
		else if (food_val.equals("Lettuce; Crisphead; Raw;Pieces1 Cup")){
			cal =5;
			group = "v";
		}
		else if (food_val.equals("Lettuce; Crisphead; Raw;Wedge 1 Wedge")){
			cal =20;
			group = "v";
		}
		else if (food_val.equals("Lettuce; Looseleaf 1 Cup")){
			cal =10;
			group = "v";
		}
		else if (food_val.equals("Light; Coffee Or Table Cream 1 Cup")){
			cal =470;
			group = "b";
		}
		else if (food_val.equals("Light; Coffee Or Table Cream 1 Tbsp")){
			cal =30;
			group = "b";
		}
		else if (food_val.equals("Lima Beans; Dry; Cooked;Draned1 Cup")){
			cal =260;
			group = "m";
		}
		else if (food_val.equals("Lima Beans;Baby; Frzn;Cked;Drn1 Cup")){
			cal =190;
			group = "m";
		}
		else if (food_val.equals("Lima Beans;Thick Seed;Frzn;Ckd1 Cup")){
			cal =170;
			group = "m";
		}
		else if (food_val.equals("Lime Juice; Raw 1 Cup")){
			cal =65;
			group = "f";
		}
		else if (food_val.equals("Lime Juice;Canned 1 Cup")){
			cal =50;
			group = "f";
		}
		else if (food_val.equals("Limeade;Concen;Frozen;Diluted 6 Fl Oz")){
			cal =75;
			group = "b";
		}
		else if (food_val.equals("Limeade;Concentrate;Frzn;Undil6 Fl Oz")){
			cal =410;
			group = "b";
		}
		else if (food_val.equals("Lucky Charms Cereal 1 Oz")){
			cal =110;
			group = "g";
		}
		else if (food_val.equals("Macadamia Nuts; Oilrstd;Salted1 Cup")){
			cal =960;
			group = "m";
		}
		else if (food_val.equals("Macadamia Nuts; Oilrstd;Salted1 Oz")){
			cal =205;
			group = "m";
		}
		else if (food_val.equals("Macadamia Nuts; Oilrstd;Unsalt1 Cup")){
			cal =960;
			group = "m";
		}
		else if (food_val.equals("Macadamia Nuts; Oilrstd;Unsalt1 Oz")){
			cal =205;
			group = "m";
		}
		else if (food_val.equals("Macaroni And Cheese; Canned 1 Cup")){
			cal =230;
			group = "c";
		}
		else if (food_val.equals("Macaroni And Cheese; Home Rcpe1 Cup")){
			cal =430;
			group = "c";
		}
		else if (food_val.equals("Macaroni; Cooked; Firm 1 Cup")){
			cal =190;
			group = "g";
		}
		else if (food_val.equals("Macaroni; Cooked; Tender; Hot 1 Cup")){
			cal =155;
			group = "g";
		}
		else if (food_val.equals("Macaroni; Cooked; Tender;Cold 1 Cup")){
			cal =115;
			group = "g";
		}
		else if (food_val.equals("Malted Milk; Chocolate; Powder3/4 Oz")){
			cal =85;
			group = "s";
		}
		else if (food_val.equals("Malted Milk;Chocolate; Pwdrppd1 Servng")){
			cal =235;
			group = "s";
		}
		else if (food_val.equals("Malted Milk;Natural; Powder 3/4 Oz")){
			cal =85;
			group = "s";
		}
		else if (food_val.equals("Malted Milk;Natural; Pwdr Pprd1 Servng")){
			cal =235;
			group = "s";
		}
		else if (food_val.equals("Mangos; Raw 1 Mango")){
			cal =135;
			group = "f";
		}
		else if (food_val.equals("Margarine; Imitation 40% Fat 1 Tbsp")){
			cal =50;
			group = "d";
		}
		else if (food_val.equals("Margarine; Imitation 40% Fat 8 Oz")){
			cal =785;
			group = "d";
		}
		else if (food_val.equals("Margarine; Regulr;Hard;80% Fat1 Pat")){
			cal =35;
			group = "d";
		}
		else if (food_val.equals("Margarine; Regulr;Hard;80% Fat1 Tbsp")){
			cal =100;
			group = "d";
		}
		else if (food_val.equals("Margarine; Regulr;Hard;80% Fat1/2 Cup")){
			cal =810;
			group = "d";
		}
		else if (food_val.equals("Margarine; Regulr;Soft;80% Fat1 Tbsp")){
			cal =100;
			group = "d";
		}
		else if (food_val.equals("Margarine; Regulr;Soft;80% Fat8 Oz")){
			cal =1625;
			group = "d";
		}
		else if (food_val.equals("Margarine; Spread;Hard;60% Fat1 Pat")){
			cal =25;
			group = "d";
		}
		else if (food_val.equals("Margarine; Spread;Hard;60% Fat1 Tbsp")){
			cal =75;
			group = "d";
		}
		else if (food_val.equals("Margarine; Spread;Hard;60% Fat1/2 Cup")){
			cal =610;
			group = "d";
		}
		else if (food_val.equals("Margarine; Spread;Soft;60% Fat1 Tbsp")){
			cal =75;
			group = "d";
		}
		else if (food_val.equals("Margarine; Spread;Soft;60% Fat8 Oz")){
			cal =1225;
			group = "d";
		}
		else if (food_val.equals("Marshmallows 1 Oz")){
			cal =90;
			group = "s";
		}
		else if (food_val.equals("Mayonnaise Type Salad Dressing1 Tbsp")){
			cal =60;
			group = "m";
		}
		else if (food_val.equals("Mayonnaise; Imitation 1 Tbsp")){
			cal =35;
			group = "m";
		}
		else if (food_val.equals("Mayonnaise; Regular 1 Tbsp")){
			cal =100;
			group = "m";
		}
		else if (food_val.equals("Melba Toast; Plain 1 Piece")){
			cal =20;
			group = "g";
		}
		else if (food_val.equals("Milk Chocolate Candy; Plain 1 Oz")){
			cal =145;
			group = "s";
		}
		else if (food_val.equals("Milk Chocolate Candy;W/ Almond1 Oz")){
			cal =150;
			group = "s";
		}
		else if (food_val.equals("Milk Chocolate Candy;W/ Penuts1 Oz")){
			cal =155;
			group = "s";
		}
		else if (food_val.equals("Milk Chocolate Candy;W/ Rice C1 Oz")){
			cal =140;
			group = "s";
		}
		else if (food_val.equals("Milk; Lofat; 1%; Added Solids 1 Cup")){
			cal =105;
			group = "d";
		}
		else if (food_val.equals("Milk; Lofat; 1%; No Addedsolid1 Cup")){
			cal =100;
			group = "d";
		}
		else if (food_val.equals("Milk; Lofat; 2%; Added Solids 1 Cup")){
			cal =125;
			group = "d";
		}
		else if (food_val.equals("Milk; Lofat; 2%; No Addedsolid1 Cup")){
			cal =120;
			group = "d";
		}
		else if (food_val.equals("Milk; Skim; Added Milk Solids 1 Cup")){
			cal =90;
			group = "d";
		}
		else if (food_val.equals("Milk; Skim; No Added Milksolid1 Cup")){
			cal =85;
			group = "d";
		}
		else if (food_val.equals("Milk; Whole; 3.3% Fat 1 Cup")){
			cal =150;
			group = "d";
		}
		else if (food_val.equals("Minestrone Soup; Canned 1 Cup")){
			cal =80;
			group = "c";
		}
		else if (food_val.equals("Mixed Grain Bread 1 Loaf")){
			cal =1165;
			group = "g";
		}
		else if (food_val.equals("Mixed Grain Bread 1 Slice")){
			cal =65;
			group = "g";
		}
		else if (food_val.equals("Mixed Grain Bread; Toasted 1 Slice")){
			cal =65;
			group = "g";
		}
		else if (food_val.equals("Mixed Nuts W/ Peants;Dry;Saltd1 Oz")){
			cal =170;
			group = "m";
		}
		else if (food_val.equals("Mixed Nuts W/ Peants;Dry;Unslt1 Oz")){
			cal =170;
			group = "m";
		}
		else if (food_val.equals("Mixed Nuts W/ Peants;Oil;Saltd1 Oz")){
			cal =175;
			group = "m";
		}
		else if (food_val.equals("Mixed Nuts W/ Peants;Oil;Unslt1 Oz")){
			cal =175;
			group = "m";
		}
		else if (food_val.equals("Molasses; Cane; Blackstrap 2 Tbsp")){
			cal =85;
			group = "s";
		}
		else if (food_val.equals("Mozzarella Cheese; Whole Milk 1 Oz")){
			cal =80;
			group = "d";
		}
		else if (food_val.equals("Mozzarella Chese;Skim; Lomoist1 Oz")){
			cal =80;
			group = "d";
		}
		else if (food_val.equals("Muenster Cheese 1 Oz")){
			cal =105;
			group = "d";
		}
		else if (food_val.equals("Mushroom Gravy; Canned 1 Cup")){
			cal =120;
			group = "c";
		}
		else if (food_val.equals("Mushrooms; Canned; Drnd;W/Salt1 Cup")){
			cal =35;
			group = "v";
		}
		else if (food_val.equals("Mushrooms; Cooked; Drained 1 Cup")){
			cal =40;
			group = "v";
		}
		else if (food_val.equals("Mushrooms; Raw 1 Cup")){
			cal =20;
			group = "v";
		}
		else if (food_val.equals("Mustard Greens; Cooked; Draned1 Cup")){
			cal =20;
			group = "v";
		}
		else if (food_val.equals("Mustard; Prepared; Yellow 1 Tsp")){
			cal =5;
			group = "v";
		}
		else if (food_val.equals("Nature Valley Granola Cereal 1 Oz")){
			cal =125;
			group = "g";
		}
		else if (food_val.equals("Nectarines; Raw 1 Nectrn")){
			cal =65;
			group = "f";
		}
		else if (food_val.equals("Nonfat Dry Milk; Instantized 1 Cup")){
			cal =245;
			group = "d";
		}
		else if (food_val.equals("Nonfat Dry Milk; Instantized 1 Envlpe")){
			cal =325;
			group = "d";
		}
		else if (food_val.equals("Noodles; Chow Mein; Canned 1 Cup")){
			cal =220;
			group = "g";
		}
		else if (food_val.equals("Noodles; Egg; Cooked 1 Cup")){
			cal =200;
			group = "g";
		}
		else if (food_val.equals("Oatmeal Bread 1 Loaf")){
			cal =1145;
			group = "g";
		}
		else if (food_val.equals("Oatmeal Bread 1 Slice")){
			cal =65;
			group = "g";
		}
		else if (food_val.equals("Oatmeal Bread; Toasted 1 Slice")){
			cal =65;
			group = "g";
		}
		else if (food_val.equals("Oatmeal W/ Raisins Cookies 4 Cookie")){
			cal =245;
			group = "g";
		}
		else if (food_val.equals("Oatmeal;Ckd;Instnt;Flvrd;Fortf1 Pkt")){
			cal =160;
			group = "g";
		}
		else if (food_val.equals("Oatmeal;Ckd;Instnt;Plain;Fortf1 Pkt")){
			cal =105;
			group = "g";
		}
		else if (food_val.equals("Oatmeal;Ckd;Rg;Qck;Inst;W/Osal1 Cup")){
			cal =145;
			group = "g";
		}
		else if (food_val.equals("Oatmeal;Ckd;Rg;Qck;Inst;W/Salt1 Cup")){
			cal =145;
			group = "g";
		}
		else if (food_val.equals("Ocean Perch; Breaded; Fried 1 Fillet")){
			cal =185;
			group = "m";
		}
		else if (food_val.equals("Okra Pods; Cooked 8 Pods")){
			cal =25;
			group = "v";
		}
		else if (food_val.equals("Olive Oil 1 Cup")){
			cal =1910;
			group = "v";
		}
		else if (food_val.equals("Olive Oil 1 Tbsp")){
			cal =125;
			group = "v";
		}
		else if (food_val.equals("Olives; Canned; Green 4 Medium")){
			cal =15;
			group = "v";
		}
		else if (food_val.equals("Olives; Canned; Ripe; Mission 3 Small")){
			cal =15;
			group = "v";
		}
		else if (food_val.equals("Onion Powder 1 Tsp")){
			cal =5;
			group = "v";
		}
		else if (food_val.equals("Onion Rings; Breaded;Frzn;Prpd2 Rings")){
			cal =80;
			group = "c";
		}
		else if (food_val.equals("Onion Soup; Dehydratd; Prepred1 Pkt")){
			cal =20;
			group = "c";
		}
		else if (food_val.equals("Onion Soup; Dehydrtd; Unprpred1 Pkt")){
			cal =20;
			group = "c";
		}
		else if (food_val.equals("Onions; Raw; Chopped 1 Cup")){
			cal =55;
			group = "v";
		}
		else if (food_val.equals("Onions; Raw; Cooked; Drained 1 Cup")){
			cal =60;
			group = "v";
		}
		else if (food_val.equals("Onions; Raw; Sliced 1 Cup")){
			cal =40;
			group = "v";
		}
		else if (food_val.equals("Onions; Spring; Raw 6 Onion")){
			cal =10;
			group = "v";
		}
		else if (food_val.equals("Orange + Grapefruit Juce;Cannd1 Cup")){
			cal =105;
			group = "b";
		}
		else if (food_val.equals("Orange Juice; Canned 1 Cup")){
			cal =105;
			group = "b";
		}
		else if (food_val.equals("Orange Juice; Chilled 1 Cup")){
			cal =110;
			group = "b";
		}
		else if (food_val.equals("Orange Juice; Raw 1 Cup")){
			cal =110;
			group = "b";
		}
		else if (food_val.equals("Orange Juice;Frozen Concentrte6 Fl Oz")){
			cal =340;
			group = "b";
		}
		else if (food_val.equals("Orange Juice;Frzn;Cncn;Diluted1 Cup")){
			cal =110;
			group = "b";
		}
		else if (food_val.equals("Orange Soda 12 Fl Oz")){
			cal =180;
			group = "b";
		}
		else if (food_val.equals("Oranges; Raw 1 Orange")){
			cal =60;
			group = "f";
		}
		else if (food_val.equals("Oranges; Raw; Sections 1 Cup")){
			cal =85;
			group = "f";
		}
		else if (food_val.equals("Oysters; Breaded; Fried 1 Oyster")){
			cal =90;
			group = "m";
		}
		else if (food_val.equals("Oysters; Raw 1 Cup")){
			cal =160;
			group = "m";
		}
		else if (food_val.equals("Pancakes; Buckwheat; From Mix 1 Pancak")){
			cal =55;
			group = "g";
		}
		else if (food_val.equals("Pancakes; Plain; From Mix 1 Pancak")){
			cal =60;
			group = "g";
		}
		else if (food_val.equals("Pancakes; Plain; Home Recipe 1 Pancak")){
			cal =60;
			group = "g";
		}
		else if (food_val.equals("Papayas; Raw 1 Cup")){
			cal =65;
			group = "f";
		}
		else if (food_val.equals("Parmesan Cheese; Grated 1 Cup")){
			cal =455;
			group = "d";
		}
		else if (food_val.equals("Parmesan Cheese; Grated 1 Oz")){
			cal =130;
			group = "d";
		}
		else if (food_val.equals("Parmesan Cheese; Grated 1 Tbsp")){
			cal =25;
			group = "d";
		}
		else if (food_val.equals("Parsley; Freeze-Dried 1 Tbsp")){
			cal =0;
			group = "v";
		}
		else if (food_val.equals("Parsley; Raw 10 Sprig")){
			cal =5;
			group = "v";
		}
		else if (food_val.equals("Parsnips; Cooked; Drained 1 Cup")){
			cal =125;
			group = "v";
		}
		else if (food_val.equals("Pasterzd Proces Cheese; Swiss 1 Oz")){
			cal =95;
			group = "d";
		}
		else if (food_val.equals("Pasterzd Proces Cheese;Americn1 Oz")){
			cal =105;
			group = "d";
		}
		else if (food_val.equals("Pasterzd Proces Chese Food;Amr1 Oz")){
			cal =95;
			group = "d";
		}
		else if (food_val.equals("Pasterzd Proces Chese Spred;Am1 Oz")){
			cal =80;
			group = "d";
		}
		else if (food_val.equals("Pea Beans; Dry; Cooked;Drained1 Cup")){
			cal =225;
			group = "m";
		}
		else if (food_val.equals("Pea; Green; Soup; Canned 1 Cup")){
			cal =165;
			group = "v";
		}
		else if (food_val.equals("Peach Pie 1 Pie")){
			cal =2410;
			group = "c";
		}
		else if (food_val.equals("Peach Pie 1 Piece")){
			cal =405;
			group = "c";
		}
		else if (food_val.equals("Peaches; Canned; Heavy Syrup 1 Cup")){
			cal =190;
			group = "f";
		}
		else if (food_val.equals("Peaches; Canned; Heavy Syrup 1 Half")){
			cal =60;
			group = "f";
		}
		else if (food_val.equals("Peaches; Canned; Juice Pack 1 Cup")){
			cal =110;
			group = "f";
		}
		else if (food_val.equals("Peaches; Canned; Juice Pack 1 Half")){
			cal =35;
			group = "f";
		}
		else if (food_val.equals("Peaches; Dried 1 Cup")){
			cal =380;
			group = "f";
		}
		else if (food_val.equals("Peaches; Dried;Cooked;Unswetnd1 Cup")){
			cal =200;
			group = "f";
		}
		else if (food_val.equals("Peaches; Frozen;Swetned;W/Vitc1 Cup")){
			cal =235;
			group = "f";
		}
		else if (food_val.equals("Peaches; Frozen;Swetned;W/Vitc10 Oz")){
			cal =265;
			group = "f";
		}
		else if (food_val.equals("Peaches; Raw 1 Peach")){
			cal =35;
			group = "f";
		}
		else if (food_val.equals("Peaches; Raw; Sliced 1 Cup")){
			cal =75;
			group = "f";
		}
		else if (food_val.equals("Peanut Butter 1 Tbsp")){
			cal =95;
			group = "m";
		}
		else if (food_val.equals("Peanut Butter Cookie;Home Recp4 Cookie")){
			cal =245;
			group = "s";
		}
		else if (food_val.equals("Peanuts; Oil Roasted; Salted 1 Cup")){
			cal =840;
			group = "m";
		}
		else if (food_val.equals("Peanuts; Oil Roasted; Salted 1 Oz")){
			cal =165;
			group = "m";
		}
		else if (food_val.equals("Peanuts; Oil Roasted; Unsalted1 Cup")){
			cal =840;
			group = "m";
		}
		else if (food_val.equals("Peanuts; Oil Roasted; Unsalted1 Oz")){
			cal =165;
			group = "m";
		}
		else if (food_val.equals("Pears; Canned; Heavy Syrup 1 Cup")){
			cal =190;
			group = "f";
		}
		else if (food_val.equals("Pears; Canned; Heavy Syrup 1 Half")){
			cal =60;
			group = "f";
		}
		else if (food_val.equals("Pears; Canned; Juice Pack 1 Cup")){
			cal =125;
			group = "f";
		}
		else if (food_val.equals("Pears; Canned; Juice Pack 1 Half")){
			cal =40;
			group = "f";
		}
		else if (food_val.equals("Pears; Raw; Bartlett 1 Pear")){
			cal =100;
			group = "f";
		}
		else if (food_val.equals("Pears; Raw; Bosc 1 Pear")){
			cal =85;
			group = "f";
		}
		else if (food_val.equals("Pears; Raw; DAnjou 1 Pear")){
			cal =120;
			group = "f";
		}
		else if (food_val.equals("Peas; Edible Pod; Cooked;Drned1 Cup")){
			cal =65;
			group = "v";
		}
		else if (food_val.equals("Peas; Green;Cnnd;Drnd; W/ Salt1 Cup")){
			cal =115;
			group = "v";
		}
		else if (food_val.equals("Peas; Green;Cnnd;Drnd;W/O Salt1 Cup")){
			cal =115;
			group = "v";
		}
		else if (food_val.equals("Peas; Split; Dry; Cooked 1 Cup")){
			cal =230;
			group = "v";
		}
		else if (food_val.equals("Peas;Grn; Frozen Cooked;Draned1 Cup")){
			cal =125;
			group = "v";
		}
		else if (food_val.equals("Pecan Pie 1 Pie")){
			cal =3450;
			group = "c";
		}
		else if (food_val.equals("Pecan Pie 1 Piece")){
			cal =575;
			group = "c";
		}
		else if (food_val.equals("Pecans; Halves 1 Cup")){
			cal =720;
			group = "m";
		}
		else if (food_val.equals("Pecans; Halves 1 Oz")){
			cal =190;
			group = "m";
		}
		else if (food_val.equals("Peppers; Hot Chili; Raw; Green1 Pepper")){
			cal =20;
			group = "v";
		}
		else if (food_val.equals("Peppers; Hot Chili; Raw; Red 1 Pepper")){
			cal =20;
			group = "v";
		}
		else if (food_val.equals("Peppers; Sweet; Cooked; Green 1 Pepper")){
			cal =15;
			group = "v";
		}
		else if (food_val.equals("Peppers; Sweet; Cooked; Red 1 Pepper")){
			cal =15;
			group = "v";
		}
		else if (food_val.equals("Peppers; Sweet; Raw; Green 1 Pepper")){
			cal =20;
			group = "v";
		}
		else if (food_val.equals("Peppers; Sweet; Raw; Red 1 Pepper")){
			cal =20;
			group = "v";
		}
		else if (food_val.equals("Pepper-Type Soda 12 Fl Oz")){
			cal =160;
			group = "b";
		}
		else if (food_val.equals("Pickles; Cucumber; Dill 1 Pickle")){
			cal =5;
			group = "v";
		}
		else if (food_val.equals("Pickles; Cucumber; Fresh Pack 2 Slices")){
			cal =10;
			group = "v";
		}
		else if (food_val.equals("Pickles; Cucumber; Swt Gherkin1 Pickle")){
			cal =20;
			group = "v";
		}
		else if (food_val.equals("Piecrust; From Mix 2 Crust")){
			cal =1485;
			group = "g";
		}
		else if (food_val.equals("Piecrust;From Home Recipe 1 Shell")){
			cal =900;
			group = "g";
		}
		else if (food_val.equals("Pine Nuts 1 Oz")){
			cal =160;
			group = "m";
		}
		else if (food_val.equals("Pineapple Juice; Canned;Unswtn1 Cup")){
			cal =140;
			group = "b";
		}
		else if (food_val.equals("Pineapple; Canned; Heavy Syrup1 Cup")){
			cal =200;
			group = "f";
		}
		else if (food_val.equals("Pineapple; Canned; Heavy Syrup1 Slice")){
			cal =45;
			group = "f";
		}
		else if (food_val.equals("Pineapple; Canned; Juice Pack 1 Cup")){
			cal =150;
			group = "f";
		}
		else if (food_val.equals("Pineapple; Canned; Juice Pack 1 Slice")){
			cal =35;
			group = "f";
		}
		else if (food_val.equals("Pineapple; Raw; Diced 1 Cup")){
			cal =75;
			group = "f";
		}
		else if (food_val.equals("Pineapple-Grapefruit Juicedrnk6 Fl Oz")){
			cal =90;
			group = "b";
		}
		else if (food_val.equals("Pinto Beans;Dry;Cooked;Drained1 Cup")){
			cal =265;
			group = "m";
		}
		else if (food_val.equals("Pistachio Nuts 1 Oz")){
			cal =165;
			group = "m";
		}
		else if (food_val.equals("Pita Bread 1 Pita")){
			cal =165;
			group = "g";
		}
		else if (food_val.equals("Pizza; Cheese 1 Slice")){
			cal =290;
			group = "c";
		}
		else if (food_val.equals("Plantains; Cooked 1 Cup")){
			cal =180;
			group = "f";
		}
		else if (food_val.equals("Plantains; Raw 1 Plantn")){
			cal =220;
			group = "f";
		}
		else if (food_val.equals("Plums; Canned; Heavy Syrup 1 Cup")){
			cal =230;
			group = "f";
		}
		else if (food_val.equals("Plums; Canned; Heavy Syrup 3 Plums")){
			cal =120;
			group = "f";
		}
		else if (food_val.equals("Plums; Canned; Juice Pack 1 Cup")){
			cal =145;
			group = "f";
		}
		else if (food_val.equals("Plums; Canned; Juice Pack 3 Plums")){
			cal =55;
			group = "f";
		}
		else if (food_val.equals("Plums; Raw; 1-1/2-In Diam 1 Plum")){
			cal =15;
			group = "f";
		}
		else if (food_val.equals("Plums; Raw; 2-1/8-In Diam 1 Plum")){
			cal =35;
			group = "f";
		}
		else if (food_val.equals("Popcorn; Air-Popped; Unsalted 1 Cup")){
			cal =30;
			group = "g";
		}
		else if (food_val.equals("Popcorn; Popped; Veg Oil;Saltd1 Cup")){
			cal =55;
			group = "g";
		}
		else if (food_val.equals("Popcorn; Sugar Syrup Coated 1 Cup")){
			cal =135;
			group = "g";
		}
		else if (food_val.equals("Popsicle 1 Popcle")){
			cal =70;
			group = "s";
		}
		else if (food_val.equals("Pork Chop; Loin; Broil; Lean 2.5 Oz")){
			cal =165;
			group = "m";
		}
		else if (food_val.equals("Pork Chop; Loin; Broil; Len+Ft3.1 Oz")){
			cal =275;
			group = "m";
		}
		else if (food_val.equals("Pork Chop; Loin;Panfry; Lean 2.4 Oz")){
			cal =180;
			group = "m";
		}
		else if (food_val.equals("Pork Chop; Loin;Panfry;Lean+Ft3.1 Oz")){
			cal =335;
			group = "m";
		}
		else if (food_val.equals("Pork Fresh Ham; Roastd; Lean 2.5 Oz")){
			cal =160;
			group = "m";
		}
		else if (food_val.equals("Pork Fresh Ham; Roastd;Lean+Ft3 Oz")){
			cal =250;
			group = "m";
		}
		else if (food_val.equals("Pork Fresh Rib; Roastd; Lean 2.5 Oz")){
			cal =175;
			group = "m";
		}
		else if (food_val.equals("Pork Fresh Rib; Roastd;Lean+Ft3 Oz")){
			cal =270;
			group = "m";
		}
		else if (food_val.equals("Pork Shoulder; Braisd; Lean 2.4 Oz")){
			cal =165;
			group = "m";
		}
		else if (food_val.equals("Pork Shoulder; Braisd;Lean+Fat3 Oz")){
			cal =295;
			group = "m";
		}
		else if (food_val.equals("Pork; Cured; Bacon; Regul;Cked3 Slice")){
			cal =110;
			group = "m";
		}
		else if (food_val.equals("Pork; Cured; Bacon;Canadn;Cked2 Slice")){
			cal =85;
			group = "m";
		}
		else if (food_val.equals("Pork; Cured; Ham; Canned;Roast3 Oz")){
			cal =140;
			group = "m";
		}
		else if (food_val.equals("Pork; Cured; Ham; Rosted;Lean 2.4 Oz")){
			cal =105;
			group = "m";
		}
		else if (food_val.equals("Pork; Cured; Ham; Rosted;Ln+Ft3 Oz")){
			cal =205;
			group = "m";
		}
		else if (food_val.equals("Pork; Link; Cooked 1 Link")){
			cal =50;
			group = "m";
		}
		else if (food_val.equals("Pork; Luncheon Meat;Canned 2 Slices")){
			cal =140;
			group = "m";
		}
		else if (food_val.equals("Pork; Luncheon Meat;Choppd Ham2 Slices")){
			cal =95;
			group = "m";
		}
		else if (food_val.equals("Pork; Luncheon Meat;Ckd Ham;Ln2 Slices")){
			cal =75;
			group = "m";
		}
		else if (food_val.equals("Pork; Luncheon Meat;Ckd Ham;Rg2 Slices")){
			cal =105;
			group = "m";
		}
		else if (food_val.equals("Potato Chips 10 Chips")){
			cal =105;
			group = "g";
		}
		else if (food_val.equals("Potato Salad Made W/ Mayonnais1 Cup")){
			cal =360;
			group = "c";
		}
		else if (food_val.equals("Potatoes; Au Gratin; From Mix 1 Cup")){
			cal =230;
			group = "c";
		}
		else if (food_val.equals("Potatoes; Au Gratin; Home Recp1 Cup")){
			cal =325;
			group = "c";
		}
		else if (food_val.equals("Potatoes; Baked Flesh Only 1 Potato")){
			cal =145;
			group = "g";
		}
		else if (food_val.equals("Potatoes; Baked With Skin 1 Potato")){
			cal =220;
			group = "g";
		}
		else if (food_val.equals("Potatoes; Boiled; Peeled After1 Potato")){
			cal =120;
			group = "g";
		}
		else if (food_val.equals("Potatoes; Boiled; Peeled Befor1 Potato")){
			cal =115;
			group = "g";
		}
		else if (food_val.equals("Potatoes; Hashed Brown;Fr Frzn1 Cup")){
			cal =340;
			group = "g";
		}
		else if (food_val.equals("Potatoes; Mashed;Frm Dehydrted1 Cup")){
			cal =235;
			group = "g";
		}
		else if (food_val.equals("Potatoes; Mashed;Recpe;Mlk+Mar1 Cup")){
			cal =225;
			group = "g";
		}
		else if (food_val.equals("Potatoes; Mashed;Recpe;W/ Milk1 Cup")){
			cal =160;
			group = "g";
		}
		else if (food_val.equals("Potatoes; Scalloped; From Mix 1 Cup")){
			cal =230;
			group = "c";
		}
		else if (food_val.equals("Potatoes; Scalloped; Home Recp1 Cup")){
			cal =210;
			group = "c";
		}
		else if (food_val.equals("Potatoes;French-Frd;Frzn;Fried10 Strip")){
			cal =160;
			group = "g";
		}
		else if (food_val.equals("Potatoes;French-Frd;Frzn;Oven 10 Strip")){
			cal =110;
			group = "g";
		}
		else if (food_val.equals("Pound Cake; Commercial 1 Loaf")){
			cal =1935;
			group = "s";
		}
		else if (food_val.equals("Pound Cake; Commercial 1 Slice")){
			cal =110;
			group = "s";
		}
		else if (food_val.equals("Pound Cake; From Home Recipe 1 Loaf")){
			cal =2025;
			group = "s";
		}
		else if (food_val.equals("Pound Cake; From Home Recipe 1 Slice")){
			cal =120;
			group = "s";
		}
		else if (food_val.equals("Pretzels; Stick 10 Pretz")){
			cal =10;
			group = "g";
		}
		else if (food_val.equals("Pretzels; Twisted; Dutch 1 Pretz")){
			cal =65;
			group = "g";
		}
		else if (food_val.equals("Pretzels; Twisted; Thin 10 Pretz")){
			cal =240;
			group = "g";
		}
		else if (food_val.equals("Product 19 Cereal 1 Oz")){
			cal =110;
			group = "g";
		}
		else if (food_val.equals("Provolone Cheese 1 Oz")){
			cal =100;
			group = "d";
		}
		else if (food_val.equals("Prune Juice; Canned 1 Cup")){
			cal =180;
			group = "b";
		}
		else if (food_val.equals("Prunes; Dried 5 Large")){
			cal =115;
			group = "f";
		}
		else if (food_val.equals("Prunes; Dried; Cooked;Unswtned1 Cup")){
			cal =225;
			group = "f";
		}
		else if (food_val.equals("Pudding; Choc; Cooked From Mix1/2 Cup")){
			cal =150;
			group = "s";
		}
		else if (food_val.equals("Pudding; Choc; Instant; Fr Mix1/2 Cup")){
			cal =155;
			group = "s";
		}
		else if (food_val.equals("Pudding; Chocolate;Canned 5 Oz")){
			cal =205;
			group = "s";
		}
		else if (food_val.equals("Pudding; Rice; From Mix 1/2 Cup")){
			cal =155;
			group = "s";
		}
		else if (food_val.equals("Pudding; Tapioca; Canned 5 Oz")){
			cal =160;
			group = "s";
		}
		else if (food_val.equals("Pudding; Tapioca; From Mix 1/2 Cup")){
			cal =145;
			group = "s";
		}
		else if (food_val.equals("Pudding; Vanilla; Canned 5 Oz")){
			cal =220;
			group = "s";
		}
		else if (food_val.equals("Pudding; Vnlla;Cooked From Mix1/2 Cup")){
			cal =145;
			group = "s";
		}
		else if (food_val.equals("Pudding; Vnlla;Instant Frm Mix1/2 Cup")){
			cal =150;
			group = "s";
		}
		else if (food_val.equals("Pumpernickel Bread 1 Loaf")){
			cal =1160;
			group = "g";
		}
		else if (food_val.equals("Pumpernickel Bread 1 Slice")){
			cal =80;
			group = "g";
		}
		else if (food_val.equals("Pumpernickel Bread; Toasted 1 Slice")){
			cal =80;
			group = "g";
		}
		else if (food_val.equals("Pumpkin And Squash Kernels 1 Oz")){
			cal =155;
			group = "v";
		}
		else if (food_val.equals("Pumpkin Pie 1 Pie")){
			cal =1920;
			group = "c";
		}
		else if (food_val.equals("Pumpkin Pie 1 Piece")){
			cal =320;
			group = "c";
		}
		else if (food_val.equals("Pumpkin; Canned 1 Cup")){
			cal =85;
			group = "c";
		}
		else if (food_val.equals("Pumpkin; Cooked From Raw 1 Cup")){
			cal =50;
			group = "c";
		}
		else if (food_val.equals("Quiche Lorraine 1 Slice")){
			cal =600;
			group = "c";
		}
		else if (food_val.equals("Radishes; Raw 4 Radish")){
			cal =5;
			group = "v";
		}
		else if (food_val.equals("Raisin Bran; KelloggS 1 Oz")){
			cal =90;
			group = "g";
		}
		else if (food_val.equals("Raisin Bran; Post 1 Oz")){
			cal =85;
			group = "g";
		}
		else if (food_val.equals("Raisin Bread 1 Loaf")){
			cal =1260;
			group = "g";
		}
		else if (food_val.equals("Raisin Bread 1 Slice")){
			cal =65;
			group = "g";
		}
		else if (food_val.equals("Raisin Bread; Toasted 1 Slice")){
			cal =65;
			group = "g";
		}
		else if (food_val.equals("Raisins 1 Cup")){
			cal =435;
			group = "v";
		}
		else if (food_val.equals("Raisins 1 Packet")){
			cal =40;
			group = "v";
		}
		else if (food_val.equals("Raspberries; Frozen; Sweetened1 Cup")){
			cal =255;
			group = "f";
		}
		else if (food_val.equals("Raspberries; Frozen; Sweetened10 Oz")){
			cal =295;
			group = "f";
		}
		else if (food_val.equals("Raspberries; Raw 1 Cup")){
			cal =60;
			group = "f";
		}
		else if (food_val.equals("Red Kidney Beans; Dry; Canned 1 Cup")){
			cal =230;
			group = "m";
		}
		else if (food_val.equals("Refried Beans; Canned 1 Cup")){
			cal =295;
			group = "m";
		}
		else if (food_val.equals("Relish; Sweet 1 Tbsp")){
			cal =20;
			group = "v";
		}
		else if (food_val.equals("Rhubarb; Cooked; Added Sugar 1 Cup")){
			cal =280;
			group = "f";
		}
		else if (food_val.equals("Rice Krispies Cereal 1 Oz")){
			cal =110;
			group = "g";
		}
		else if (food_val.equals("Rice; Brown; Cooked 1 Cup")){
			cal =230;
			group = "g";
		}
		else if (food_val.equals("Rice; White; Cooked 1 Cup")){
			cal =225;
			group = "g";
		}
		else if (food_val.equals("Rice; White; Instant; Cooked 1 Cup")){
			cal =180;
			group = "g";
		}
		else if (food_val.equals("Rice; White; Parboiled; Cooked1 Cup")){
			cal =185;
			group = "g";
		}
		else if (food_val.equals("Rice; White; Parboiled; Raw 1 Cup")){
			cal =685;
			group = "g";
		}
		else if (food_val.equals("Rice; White; Raw 1 Cup")){
			cal =670;
			group = "g";
		}
		else if (food_val.equals("Ricotta Cheese; Part Skim Milk1 Cup")){
			cal =340;
			group = "d";
		}
		else if (food_val.equals("Ricotta Cheese; Whole Milk 1 Cup")){
			cal =430;
			group = "d";
		}
		else if (food_val.equals("Roast Beef Sandwich 1 Sandwh")){
			cal =345;
			group = "c";
		}
		else if (food_val.equals("Rolls; Dinner; Commercial 1 Roll")){
			cal =85;
			group = "g";
		}
		else if (food_val.equals("Rolls; Dinner; Home Recipe 1 Roll")){
			cal =120;
			group = "g";
		}
		else if (food_val.equals("Rolls; Frankfurter + Hamburger1 Roll")){
			cal =115;
			group = "g";
		}
		else if (food_val.equals("Rolls; Hard 1 Roll")){
			cal =155;
			group = "g";
		}
		else if (food_val.equals("Rolls; Hoagie Or Submarine 1 Roll")){
			cal =400;
			group = "g";
		}
		else if (food_val.equals("Root Beer 12 Fl Oz")){
			cal =165;
			group = "b";
		}
		else if (food_val.equals("Rye Bread; Light 1 Loaf")){
			cal =1190;
			group = "g";
		}
		else if (food_val.equals("Rye Bread; Light 1 Slice")){
			cal =65;
			group = "g";
		}
		else if (food_val.equals("Rye Bread; Light; Toasted 1 Slice")){
			cal =65;
			group = "g";
		}
		else if (food_val.equals("Rye Wafers; Whole-Grain 2 Wafers")){
			cal =55;
			group = "g";
		}
		else if (food_val.equals("Salami; Cooked Type 2 Slices")){
			cal =145;
			group = "m";
		}
		else if (food_val.equals("Salami; Dry Type 2 Slices")){
			cal =85;
			group = "m";
		}
		else if (food_val.equals("Salmon; Baked; Red 3 Oz")){
			cal =140;
			group = "m";
		}
		else if (food_val.equals("Salmon; Canned; Pink; W/ Bones3 Oz")){
			cal =120;
			group = "m";
		}
		else if (food_val.equals("Salmon; Smoked 3 Oz")){
			cal =150;
			group = "m";
		}
		else if (food_val.equals("Saltines 4 Crackr")){
			cal =50;
			group = "g";
		}
		else if (food_val.equals("Sardines; Atlntc;Cnned;Oil;Drn3 Oz")){
			cal =175;
			group = "m";
		}
		else if (food_val.equals("Sauerkraut; Canned 1 Cup")){
			cal =45;
			group = "v";
		}
		else if (food_val.equals("Scallops; Breaded; Frzn;Reheat6 Scalop")){
			cal =195;
			group = "m";
		}
		else if (food_val.equals("Seaweed; Kelp; Raw 1 Oz")){
			cal =10;
			group = "v";
		}
		else if (food_val.equals("Seaweed; Spirulina; Dried 1 Oz")){
			cal =80;
			group = "v";
		}
		else if (food_val.equals("Self-Rising Flour; Unsifted 1 Cup")){
			cal =440;
			group = "g";
		}
		else if (food_val.equals("Semisweet Chocolate 1 Cup")){
			cal =860;
			group = "s";
		}
		else if (food_val.equals("Sesame Seeds 1 Tbsp")){
			cal =45;
			group = "g";
		}
		else if (food_val.equals("Shakes; Thick; Chocolate 10 Oz")){
			cal =335;
			group = "s";
		}
		else if (food_val.equals("Shakes; Thick; Vanilla 10 Oz")){
			cal =315;
			group = "s";
		}
		else if (food_val.equals("Sheetcake W/O Frstng;Homerecip1 Cake")){
			cal =2830;
			group = "s";
		}
		else if (food_val.equals("Sheetcake;W/ Whfrstng;Homercip1 Cake")){
			cal =4020;
			group = "s";
		}
		else if (food_val.equals("Sheetcake;W/ Whfrstng;Homercip1 Piece")){
			cal =445;
			group = "s";
		}
		else if (food_val.equals("Sheetcake;W/O Frstng;Homerecip1 Piece")){
			cal =315;
			group = "s";
		}
		else if (food_val.equals("Sherbet; 2% Fat 1 Cup")){
			cal =270;
			group = "s";
		}
		else if (food_val.equals("Sherbet; 2% Fat 1/2 Gal")){
			cal =2160;
			group = "s";
		}
		else if (food_val.equals("Shortbread Cookie; Commercial 4 Cookie")){
			cal =155;
			group = "s";
		}
		else if (food_val.equals("Shortbread Cookie; Home Recipe2 Cookie")){
			cal =145;
			group = "s";
		}
		else if (food_val.equals("Shredded Wheat Cereal 1 Oz")){
			cal =100;
			group = "g";
		}
		else if (food_val.equals("Shrimp; Canned; Drained 3 Oz")){
			cal =100;
			group = "m";
		}
		else if (food_val.equals("Shrimp; French Fried 3 Oz")){
			cal =200;
			group = "m";
		}
		else if (food_val.equals("Snack Cakes;Devils Food;Cremflsm Cake")){
			cal =105;
			group = "s";
		}
		else if (food_val.equals("Snack Cakes;Sponge Creme Fllngsm Cake")){
			cal =155;
			group = "s";
		}
		else if (food_val.equals("Snack Type Crackers 1 Crackr")){
			cal =15;
			group = "g";
		}
		else if (food_val.equals("Snap Bean;Cnnd;Drnd;Green;Salt1 Cup")){
			cal =25;
			group = "v";
		}
		else if (food_val.equals("Snap Bean;Cnnd;Drnd;Grn;Nosalt1 Cup")){
			cal =25;
			group = "v";
		}
		else if (food_val.equals("Snap Bean;Cnnd;Drnd;Yllw; Salt1 Cup")){
			cal =25;
			group = "v";
		}
		else if (food_val.equals("Snap Bean;Cnnd;Drnd;Yllw;Nosal1 Cup")){
			cal =25;
			group = "v";
		}
		else if (food_val.equals("Snap Bean;Frz;Ckd;Drnd;Green 1 Cup")){
			cal =35;
			group = "v";
		}
		else if (food_val.equals("Snap Bean;Frz;Ckd;Drnd;Yellow 1 Cup")){
			cal =35;
			group = "v";
		}
		else if (food_val.equals("Snap Bean;Raw;Ckd;Drnd;Green 1 Cup")){
			cal =45;
			group = "v";
		}
		else if (food_val.equals("Snap Bean;Raw;Ckd;Drnd;Yellow 1 Cup")){
			cal =45;
			group = "v";
		}
		else if (food_val.equals("Sour Cream 1 Cup")){
			cal =495;
			group = "d";
		}
		else if (food_val.equals("Sour Cream 1 Tbsp")){
			cal =25;
			group = "d";
		}
		else if (food_val.equals("Soybeans; Dry; Cooked; Drained1 Cup")){
			cal =235;
			group = "g";
		}
		else if (food_val.equals("Spaghetti; Cooked; Firm 1 Cup")){
			cal =190;
			group = "g";
		}
		else if (food_val.equals("Spaghetti; Cooked; Tender 1 Cup")){
			cal =155;
			group = "g";
		}
		else if (food_val.equals("Spaghetti; Tom Sauce Chee;Hmrp1 Cup")){
			cal =260;
			group = "c";
		}
		else if (food_val.equals("Spaghetti; Tom Sauce Chees;Cnd1 Cup")){
			cal =190;
			group = "c";
		}
		else if (food_val.equals("Spaghetti;Meatballs;Tomsa;Hmrp1 Cup")){
			cal =330;
			group = "c";
		}
		else if (food_val.equals("Spaghetti;Meatballs;Tomsac;Cnd1 Cup")){
			cal =260;
			group = "c";
		}
		else if (food_val.equals("Special K Cereal 1 Oz")){
			cal =110;
			group = "g";
		}
		else if (food_val.equals("Spinach Souffle 1 Cup")){
			cal =220;
			group = "v";
		}
		else if (food_val.equals("Spinach; Canned; Drnd;W/ Salt 1 Cup")){
			cal =50;
			group = "v";
		}
		else if (food_val.equals("Spinach; Canned; Drnd;W/O Salt1 Cup")){
			cal =50;
			group = "v";
		}
		else if (food_val.equals("Spinach; Cooked Fr Frzen; Drnd1 Cup")){
			cal =55;
			group = "v";
		}
		else if (food_val.equals("Spinach; Cooked From Raw; Drnd1 Cup")){
			cal =40;
			group = "v";
		}
		else if (food_val.equals("Spinach; Raw 1 Cup")){
			cal =10;
			group = "v";
		}
		else if (food_val.equals("Squash; Summer; Cooked; Draind1 Cup")){
			cal =35;
			group = "v";
		}
		else if (food_val.equals("Squash; Winter; Baked 1 Cup")){
			cal =80;
			group = "v";
		}
		else if (food_val.equals("Strawberries; Frozen; Sweetend1 Cup")){
			cal =245;
			group = "f";
		}
		else if (food_val.equals("Strawberries; Frozen; Sweetend10 Oz")){
			cal =275;
			group = "f";
		}
		else if (food_val.equals("Strawberries; Raw 1 Cup")){
			cal =45;
			group = "f";
		}
		else if (food_val.equals("Sugar Cookie; From Refrig Dogh4 Cookie")){
			cal =235;
			group = "s";
		}
		else if (food_val.equals("Sugar Frosted Flakes; Kellogg 1 Oz")){
			cal =110;
			group = "g";
		}
		else if (food_val.equals("Sugar Smacks Cereal 1 Oz")){
			cal =105;
			group = "g";
		}
		else if (food_val.equals("Sugar; Brown; Pressed Down 1 Cup")){
			cal =820;
			group = "s";
		}
		else if (food_val.equals("Sugar; Powdered; Sifted 1 Cup")){
			cal =385;
			group = "s";
		}
		else if (food_val.equals("Sugar; White; Granulated 1 Cup")){
			cal =770;
			group = "s";
		}
		else if (food_val.equals("Sugar; White; Granulated 1 Pkt")){
			cal =25;
			group = "s";
		}
		else if (food_val.equals("Sugar; White; Granulated 1 Tbsp")){
			cal =45;
			group = "s";
		}
		else if (food_val.equals("Sunflower Seeds 1 Oz")){
			cal =160;
			group = "g";
		}
		else if (food_val.equals("Super Sugar Crisp Cereal 1 Oz")){
			cal =105;
			group = "g";
		}
		else if (food_val.equals("Sweet (Dark) Chocolate 1 Oz")){
			cal =150;
			group = "s";
		}
		else if (food_val.equals("Sweetened Condensed Milk Cnnd 1 Cup")){
			cal =980;
			group = "d";
		}
		else if (food_val.equals("Sweetpotatoes; Baked; Peeled 1 Potato")){
			cal =115;
			group = "g";
		}
		else if (food_val.equals("Sweetpotatoes; Boiled W/O Peel1 Potato")){
			cal =160;
			group = "g";
		}
		else if (food_val.equals("Sweetpotatoes; Candied 1 Piece")){
			cal =145;
			group = "g";
		}
		else if (food_val.equals("Sweetpotatoes; Canned; Mashed 1 Cup")){
			cal =260;
			group = "g";
		}
		else if (food_val.equals("Sweetpotatoes; Cnned; Vac Pack1 Piece")){
			cal =35;
			group = "g";
		}
		else if (food_val.equals("Swiss Cheese 1 Oz")){
			cal =105;
			group = "d";
		}
		else if (food_val.equals("Syrup; Chocolate Flavored Thin2 Tbsp")){
			cal =85;
			group = "s";
		}
		else if (food_val.equals("Syrup; Chocolate Flvred; Fudge2 Tbsp")){
			cal =125;
			group = "s";
		}
		else if (food_val.equals("Table Syrup (Corn And Maple) 2 Tbsp")){
			cal =122;
			group = "s";
		}
		else if (food_val.equals("Taco 1 Taco")){
			cal =195;
			group = "c";
		}
		else if (food_val.equals("Tangerine Juice; Canned;Swtned1 Cup")){
			cal =125;
			group = "b";
		}
		else if (food_val.equals("Tangerines; Canned; Light Syrp1 Cup")){
			cal =155;
			group = "f";
		}
		else if (food_val.equals("Tangerines; Raw 1 Tangrn")){
			cal =35;
			group = "f";
		}
		else if (food_val.equals("Tea; Brewed 8 Fl Oz")){
			cal =0;
			group = "b";
		}
		else if (food_val.equals("Tea; Instant;Preprd;Unsweetend8 Fl Oz")){
			cal =0;
			group = "b";
		}
		else if (food_val.equals("Tea;Instant;Prepard;Sweetened 8 Fl Oz")){
			cal =85;
			group = "b";
		}
		else if (food_val.equals("Toaster Pastries 1 Pastry")){
			cal =210;
			group = "s";
		}
		else if (food_val.equals("Tofu 1 Piece")){
			cal =85;
			group = "g";
		}
		else if (food_val.equals("Tomato Juice; Canned W/O Salt 1 Cup")){
			cal =40;
			group = "b";
		}
		else if (food_val.equals("Tomato Juice; Canned With Salt1 Cup")){
			cal =40;
			group = "b";
		}
		else if (food_val.equals("Tomato Paste; Canned W/O Salt 1 Cup")){
			cal =220;
			group = "v";
		}
		else if (food_val.equals("Tomato Paste; Canned With Salt1 Cup")){
			cal =220;
			group = "v";
		}
		else if (food_val.equals("Tomato Puree; Canned W/O Salt 1 Cup")){
			cal =105;
			group = "v";
		}
		else if (food_val.equals("Tomato Puree; Canned With Salt1 Cup")){
			cal =105;
			group = "v";
		}
		else if (food_val.equals("Tomato Sauce; Canned With Salt1 Cup")){
			cal =75;
			group = "v";
		}
		else if (food_val.equals("Tomato Soup W/ Water; Canned 1 Cup")){
			cal =85;
			group = "c";
		}
		else if (food_val.equals("Tomato Soup With Milk; Canned 1 Cup")){
			cal =160;
			group = "c";
		}
		else if (food_val.equals("Tomato Veg Soup; Dehyd;Prepred1 Pkt")){
			cal =40;
			group = "c";
		}
		else if (food_val.equals("Tomatoes; Canned; S+L; W/ Salt1 Cup")){
			cal =50;
			group = "v";
		}
		else if (food_val.equals("Tomatoes; Canned; S+L;W/O Salt1 Cup")){
			cal =50;
			group = "v";
		}
		else if (food_val.equals("Tomatoes; Raw 1 Tomato")){
			cal =25;
			group = "v";
		}
		else if (food_val.equals("Tortillas; Corn 1 Tortla")){
			cal =65;
			group = "g";
		}
		else if (food_val.equals("Total Cereal 1 Oz")){
			cal =100;
			group = "g";
		}
		else if (food_val.equals("Trix Cereal 1 Oz")){
			cal =110;
			group = "g";
		}
		else if (food_val.equals("Trout; Broiled; W/ Buttr;Lemju3 Oz")){
			cal =175;
			group = "m";
		}
		else if (food_val.equals("Tuna Salad 1 Cup")){
			cal =375;
			group = "m";
		}
		else if (food_val.equals("Tuna; Cannd; Drnd;Oil;Chk;Lght3 Oz")){
			cal =165;
			group = "m";
		}
		else if (food_val.equals("Tuna; Cannd; Drnd;Watr; White 3 Oz")){
			cal =135;
			group = "m";
		}
		else if (food_val.equals("Turkey Ham; Cured Turkey Thigh2 Slices")){
			cal =75;
			group = "m";
		}
		else if (food_val.equals("Turkey Loaf; Breast Meat W/O C2 Slices")){
			cal =45;
			group = "m";
		}
		else if (food_val.equals("Turkey Loaf; Breast Meat; W/ C2 Slices")){
			cal =45;
			group = "m";
		}
		else if (food_val.equals("Turkey Patties; Brd;Battd;Frid1 Patty")){
			cal =180;
			group = "m";
		}
		else if (food_val.equals("Turkey Roast; Frzn;Lght+Drk;Ck3 Oz")){
			cal =130;
			group = "m";
		}
		else if (food_val.equals("Turkey; Roasted; Dark Meat 4 Pieces")){
			cal =160;
			group = "m";
		}
		else if (food_val.equals("Turkey; Roasted; Light + Dark 1 Cup")){
			cal =240;
			group = "m";
		}
		else if (food_val.equals("Turkey; Roasted; Light + Dark 3 Pieces")){
			cal =145;
			group = "m";
		}
		else if (food_val.equals("Turkey; Roasted; Light Meat 2 Pieces")){
			cal =135;
			group = "m";
		}
		else if (food_val.equals("Turnip Greens; Cked Frm Frozen1 Cup")){
			cal =50;
			group = "v";
		}
		else if (food_val.equals("Turnip Greens; Cooked From Raw1 Cup")){
			cal =30;
			group = "v";
		}
		else if (food_val.equals("Turnips; Cooked; Diced 1 Cup")){
			cal =30;
			group = "v";
		}
		else if (food_val.equals("Vanilla Wafers 10 Cooke")){
			cal =185;
			group = "s";
		}
		else if (food_val.equals("Veal Cutlet; Med Fat;Brsd;Brld3 Oz")){
			cal =185;
			group = "m";
		}
		else if (food_val.equals("Veal Rib; Med Fat; Roasted 3 Oz")){
			cal =230;
			group = "m";
		}
		else if (food_val.equals("Vegetable Beef Soup; Canned 1 Cup")){
			cal =80;
			group = "c";
		}
		else if (food_val.equals("Vegetable Juice Cocktail; Cnnd1 Cup")){
			cal =45;
			group = "b";
		}
		else if (food_val.equals("Vegetables; Mixed; Canned 1 Cup")){
			cal =75;
			group = "v";
		}
		else if (food_val.equals("Vegetables; Mixed; Cked Fr Frz1 Cup")){
			cal =105;
			group = "v";
		}
		else if (food_val.equals("Vegetarian Soup; Canned 1 Cup")){
			cal =70;
			group = "c";
		}
		else if (food_val.equals("Vienna Bread 1 Slice")){
			cal =70;
			group = "g";
		}
		else if (food_val.equals("Vienna Sausage 1 Sausag")){
			cal =45;
			group = "m";
		}
		else if (food_val.equals("Waffles; From Home Recipe 1 Waffle")){
			cal =245;
			group = "g";
		}
		else if (food_val.equals("Waffles; From Mix 1 Waffle")){
			cal =205;
			group = "g";
		}
		else if (food_val.equals("Walnuts; Black; Chopped 1 Cup")){
			cal =760;
			group = "m";
		}
		else if (food_val.equals("Walnuts; Black; Chopped 1 Oz")){
			cal =170;
			group = "m";
		}
		else if (food_val.equals("Walnuts; English; Pieces 1 Cup")){
			cal =770;
			group = "m";
		}
		else if (food_val.equals("Walnuts; English; Pieces 1 Oz")){
			cal =180;
			group = "m";
		}
		else if (food_val.equals("Water Chestnuts; Canned 1 Cup")){
			cal =70;
			group = "v";
		}
		else if (food_val.equals("Watermelon; Raw 1 Piece")){
			cal =155;
			group = "f";
		}
		else if (food_val.equals("Watermelon; Raw; Diced 1 Cup")){
			cal =50;
			group = "f";
		}
		else if (food_val.equals("Wheat Bread 1 Loaf")){
			cal =1160;
			group = "g";
		}
		else if (food_val.equals("Wheat Bread 1 Slice")){
			cal =65;
			group = "g";
		}
		else if (food_val.equals("Wheat Bread; Toasted 1 Slice")){
			cal =65;
			group = "g";
		}
		else if (food_val.equals("Wheat Flour; All-Purpose;Siftd1 Cup")){
			cal =420;
			group = "g";
		}
		else if (food_val.equals("Wheat Flour; All-Purpose;Unsif1 Cup")){
			cal =455;
			group = "g";
		}
		else if (food_val.equals("Wheat; Thin Crackers 4 Crackr")){
			cal =35;
			group = "g";
		}
		else if (food_val.equals("Wheaties Cereal 1 Oz")){
			cal =100;
			group = "g";
		}
		else if (food_val.equals("Whipped Topping; Pressurized 1 Cup")){
			cal =155;
			group = "d";
		}
		else if (food_val.equals("Whipped Topping; Pressurized 1 Tbsp")){
			cal =10;
			group = "d";
		}
		else if (food_val.equals("Whipping Cream; Unwhiped;Heavy1 Cup")){
			cal =820;
			group = "d";
		}
		else if (food_val.equals("Whipping Cream; Unwhiped;Heavy1 Tbsp")){
			cal =50;
			group = "d";
		}
		else if (food_val.equals("Whipping Cream; Unwhiped;Light1 Cup")){
			cal =700;
			group = "d";
		}
		else if (food_val.equals("Whipping Cream; Unwhiped;Light1 Tbsp")){
			cal =45;
			group = "d";
		}
		else if (food_val.equals("White Bread 1 Loaf")){
			cal =1210;
			group = "g";
		}
		else if (food_val.equals("White Bread Crumbs; Soft 1 Cup")){
			cal =120;
			group = "g";
		}
		else if (food_val.equals("White Bread Cubes 1 Cup")){
			cal =80;
			group = "g";
		}
		else if (food_val.equals("White Bread; Slice 18 Per Loaf1 Slice")){
			cal =65;
			group = "g";
		}
		else if (food_val.equals("White Bread; Slice 22 Per Loaf1 Slice")){
			cal =55;
			group = "g";
		}
		else if (food_val.equals("White Bread; Toasted 18 Per 1 Slice")){
			cal =65;
			group = "g";
		}
		else if (food_val.equals("White Bread; Toasted 22 Per 1 Slice")){
			cal =55;
			group = "g";
		}
		else if (food_val.equals("White Cake W/ Wht Frstng;Comml1 Cake")){
			cal =4170;
			group = "s";
		}
		else if (food_val.equals("White Cake W/ Wht Frstng;Comml1 Piece")){
			cal =260;
			group = "s";
		}
		else if (food_val.equals("White Sauce W/ Milk From Mix 1 Cup")){
			cal =240;
			group = "d";
		}
		else if (food_val.equals("White Sauce; Medium; Home Recp1 Cup")){
			cal =395;
			group = "d";
		}
		else if (food_val.equals("Whole-Wheat Bread 1 Loaf")){
			cal =1110;
			group = "g";
		}
		else if (food_val.equals("Whole-Wheat Bread 1 Slice")){
			cal =70;
			group = "g";
		}
		else if (food_val.equals("Whole-Wheat Bread; Toasted 1 Slice")){
			cal =70;
			group = "g";
		}
		calTot = calTot + cal;
		TextView total = (TextView)findViewById(R.id.total);
		total.setText("Total Calories: " + calTot);
		if (group.equals("s")){
			sweetsTot = sweetsTot + cal;
		}
		else if (group.equals("b")){
			beveragesTot = beveragesTot + cal;
		}
		else if (group.equals("m")){
			meatsTot = meatsTot + cal;
		}
		else if (group.equals("d")){
			dairyTot = dairyTot + cal;
		}
		else if (group.equals("v")){
			veggieTot = veggieTot + cal;
		}
		else if (group.equals("f")){
			fruitTot = fruitTot + cal;
		}
		else if (group.equals("g")){
			grainTot = grainTot + cal;
		}
		else if (group.equals("c")){
			combinedTot = combinedTot + cal;
		}

        //calcs the percent of the total cals that each category takes up
        sweetPer= (100.0 / calTot) * sweetsTot;
        bevPer= (100.0 / calTot) * beveragesTot;
        meatPer= (100.0 / calTot) * meatsTot;
        dairyPer= (100.0 / calTot) * dairyTot;
        fruitPer= (100.0 / calTot) * veggieTot;
        veggiePer= (100.0 / calTot) * fruitTot;
        grainPer= (100.0 / calTot) * grainTot;
        combPer= (100.0 / calTot) * combinedTot;

        //adds to arraylist to calc the max
        double max1 = Math.max(sweetPer,bevPer);
        double max2 = Math.max(meatPer,dairyPer);
        double max3 = Math.max(fruitPer,veggiePer);
        double max4 = Math.max(grainPer,combPer);
        double max5 = Math.max(max1,max2);
        double max6 = Math.max(max3,max4);
        MaxPercent = Math.max(max5,max6);

        if (MaxPercent == sweetPer){
            maxPercentType = "Sweets";
        }
        else if (MaxPercent == bevPer){
            maxPercentType = "Beverages";
        }
        else if (MaxPercent == meatPer){
            maxPercentType = "Meat";
        }
        else if (MaxPercent == dairyPer){
            maxPercentType = "Dairy";
        }
        else if (MaxPercent == fruitPer){
            maxPercentType = "Fruits";
        }
        else if (MaxPercent == veggiePer){
            maxPercentType = "Vegetables";
        }
        else if (MaxPercent == grainPer){
            maxPercentType = "Grains";
        }
        else if (MaxPercent == combPer){
            maxPercentType = "Combined Dishes";
        }

        if (cal > highCal){
            highCal = cal;
            highCalId = food_val;
        }
        highCalPerc = (100.0 / calTot) * highCal;

        messagePercentHigh =
                String.format(maxPercentType + " accounted for the highest percent of your calories, with %2.1f of all calories resulting from these dishes", MaxPercent);
        messageCalorieHigh = String.format("Your highest calorie dish was " + highCalId + ", which is " + highCal + " calories, or %2.1f of all of your calories consumed", highCalPerc);

	}

}