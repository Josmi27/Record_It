package me.josmi.thankyou;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        TextView textViewDate = findViewById(R.id.dateText);
        textViewDate.setText(currentDate);

        Button Thankyoubutton = findViewById(R.id.Thankyou_Button);

//        Thankyoubutton.setOnClickListener();
        Thankyoubutton.setOnClickListener(this);
//        Thankyoubutton.setEnabled(false);


    }

    @Override
    public void onClick(View v) {
        Toast toasty = Toast.makeText(this, "The Lord Has Received Your Message", Toast.LENGTH_LONG);
//        toasty.setMargin(0,0);
        toasty.show();




    }


//    Date c = Calendar.getInstance().getTime();
//    System.out.println("Current time =>" + c);
//
//    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//    String formattedDate = df.format(c);
//
//    TextView dateTextView = (TextView)findViewById(R.id.dateText);
//    dateTextView.setText(formattedDate);\\


}
