package me.josmi.thankyou;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.text.DateFormat;
import java.util.Calendar;

// TODO: 6/8/2019 Add date to database, after history feature is implemented. 

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    // tag, database helper, edit text
    private static final String TAG = "MainActivity";

    DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Date Code
        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        TextView textViewDate = findViewById(R.id.dateText);
        textViewDate.setText(currentDate);

        // editText Code
        final EditText editText = findViewById(R.id.editText);

        // Button Code
        Button Thank_You_Button = findViewById(R.id.Thankyou_Button);

        Thank_You_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // newEntry represents the data that the user typed in
                String newEntry = editText.getText().toString();
                if (editText.length() != 0) {
                    // Adds data, then resets text for user
                    AddData(newEntry);
                    editText.setText("");
                } else {
                    toastMessage("You must put something in the text field!");
                }
            }
        });

        //HISTORY CODE FOR VERSION 2

//        History_Button.SetOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, ListDataActivity.class);
//                startActivity(intent);
//            }
//        });

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