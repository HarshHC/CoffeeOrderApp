package com.hc.orderapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.name);
    }


    int count=1;

    public void increment(View view){       //called when + button clicked
        count=count+1;
        displaycount(count);
    }

    public void decrement(View view){       //called when - button clicked
        if(count>0){
            count=count-1;
        }
        else
        {
            Toast toast=Toast.makeText(this,"Quantity cannot be negative",1000);
            toast.show();
        }
        displaycount(count);
    }

    public void submitOrder(View view){       //called when order button clicked
        displaybill(createOrderSummary("Coffee",count));
    }

    private void displaycount(int num){
        TextView itemcount= (TextView) findViewById(R.id.itemcount);
        itemcount.setText(""+num);
    }

    private void displaybill(String text){
        TextView bill= (TextView) findViewById(R.id.bill);
        bill.setText(""+text);
    }

    private String createOrderSummary(String item,int quantity){
        return "Name:"+name.getText().toString()+"\nItem: "+item+"\nQuantity: "+quantity+"\nTotal amount: $"+(quantity*2)+"\nThank You!";
    }

}
