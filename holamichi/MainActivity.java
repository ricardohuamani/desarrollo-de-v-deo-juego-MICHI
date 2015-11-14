package com.example.holamichi;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.Toast;
import android.view.View.OnClickListener;




@SuppressWarnings("unused")
public class MainActivity extends Activity implements OnClickListener {
	
	boolean turn =true; //true =X & false=O
	int turn_count =0;
	Button[]bArray=null;
	Button a1,a2,a3,b1,b2,b3,c1,c2,c3;
	
	
	
	//Ahora tenemos nuestro diseño listo 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //deja para ejecutar este
        
        a1=(Button)findViewById(R.id.A1);
        b1=(Button)findViewById(R.id.B1);
        c1=(Button)findViewById(R.id.C1);
        a2=(Button)findViewById(R.id.A2);
        b2=(Button)findViewById(R.id.B2);
        c2=(Button)findViewById(R.id.C2);
        a3=(Button)findViewById(R.id.A3);
        b3=(Button)findViewById(R.id.B3);
        c3=(Button)findViewById(R.id.C3);
        bArray=new Button[]{a1,a2,a3,b1,b2,b3,c1,c2,c3};
        
        for(Button b:bArray){
        	b.setOnClickListener(this);
        }
           
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public void onClick(View v){
    	Button b= (Button) v;
    	buttonClicked(b);
    }


public void buttonClicked(Button b){
	
	
	if(turn){
		
		b.setText("X");
		
	}else{
		
		b.setText("O");
	}
	
	turn_count++;
	
	b.setBackgroundColor(Color.LTGRAY);
	b.setClickable(false);
	turn =!turn;
	checkForWinner();
	
}


private void checkForWinner() {
	// TODO Auto-generated method stub
	boolean there_is_a_winner =false;
	
	//Horizontal 
	if(a1.getText()==a2.getText()&& a2.getText()==a3.getText()
			&& !a1.isClickable())
		there_is_a_winner=true;
	else if(b1.getText()==b2.getText() && b2.getText()== b3.getText()
			  && !a1.isClickable())
		there_is_a_winner=true;
	else if(c1.getText()==c2.getText() && c2.getText()== c3.getText()
			  && !c1.isClickable())
		there_is_a_winner=true;
	
	//vertical
	else if(a1.getText()==b1.getText()&& b1.getText()==c1.getText()
			&& !a1.isClickable())
		there_is_a_winner=true;
	else if(a2.getText()==b2.getText()&& b2.getText()==c2.getText()
			&& !b2.isClickable())
		there_is_a_winner=true;
	
	
	
	
	
	
	
	
}



	
}