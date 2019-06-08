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

    // tag, database helper, edit text
    private static final String TAG = "MainActivity";

    DatabaseHelper mDatabaseHelper;
    private Button Thankyou_Button;
    private EditText editText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Date Code
        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        TextView textViewDate = findViewById(R.id.dateText);
        textViewDate.setText(currentDate);

            // Button Code
        Button Thankyoubutton = findViewById(R.id.Thankyou_Button);

        Thankyoubutton.setOnClickListener(this);


        // editText Code
        EditText editText = findViewById(R.id.editText);

        // Database Code
        mDatabaseHelper = new DatabaseHelper(this);


    }

    public void AddData(String newEntry) {
        // this is a boolean, because a bool was returned in the addData method
        boolean insertData = mDatabaseHelper.addData(newEntry);

        if (insertData) {
            toastMessage("Data Successfully Inserted!");
        } else {
            toastMessage("Something went wrong");
        }
    }

    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        Toast toasty = Toast.makeText(this, "The Lord Has Received Your Message", Toast.LENGTH_LONG);
        toasty.show();
    }
}
