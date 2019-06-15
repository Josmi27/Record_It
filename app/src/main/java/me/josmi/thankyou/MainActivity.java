package me.josmi.thankyou;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    DatabaseHelper mDatabaseHelper;
    boolean status;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatabaseHelper = new DatabaseHelper(this);

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        TextView textViewDate = findViewById(R.id.dateText);
        textViewDate.setText(currentDate);

        Button Thankyoubutton = findViewById(R.id.Thankyou_Button);

//        Thankyoubutton.setOnClickListener();
        Thankyoubutton.setOnClickListener(this);
//        Thankyoubutton.setEnabled(false);

    }

    public boolean AddData(String newEntry){
        boolean insertData = mDatabaseHelper.addData(newEntry);
        return insertData;
    }

    @Override
    public void onClick(View v) {
        String newEntry = editText.getText().toString();
        if (editText.length()!=0){
            status = AddData(newEntry);
            if (status){
                Toast.makeText(this, "The Lord Has Received Your Message", Toast.LENGTH_LONG).show();
                editText.setText("");
            }else{ Toast.makeText(this, "Data was not saved!", Toast.LENGTH_LONG).show();}

        }else{ Toast.makeText(this,"You must enter something",Toast.LENGTH_LONG).show();}
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
