package sg.edu.rp.c346.id20013327.demodialogl12;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button btnDemo1,btnDemo2,btnDemo3,btnExercise3,btnDemo4,btnDemo5;
    TextView tvDemo2,tvDemo3,tvExercise3,tvDemo4,tvDemo5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDemo1 = findViewById(R.id.btnDemo1);
        btnDemo2 = findViewById(R.id.btnDemo2);
        tvDemo2 = findViewById(R.id.tvDemo2);
        btnDemo3 = findViewById(R.id.btnDemo3);
        tvDemo3 = findViewById(R.id.tvDemo3);
        btnExercise3 = findViewById(R.id.btnExercise3);
        tvExercise3 = findViewById(R.id.tvExercise3);
        btnDemo4 = findViewById(R.id.btnDemo4);
        tvDemo4 = findViewById(R.id.tvDemo4);
        btnDemo5 = findViewById(R.id.btnDemo5);
        tvDemo5 = findViewById(R.id.tvDemo5);

        btnDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Create the Dialog Builder
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                //Set the Dialog details
                myBuilder.setTitle("Congratulations");
                myBuilder.setMessage("you have completed a simple dialog box");
                myBuilder.setCancelable(true);
                myBuilder.setPositiveButton("Dismiss", null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

//                //Set the Dialog details
//                myBuilder.setTitle("Congratulations");
//                myBuilder.setMessage("you have completed a simple dialog box");
//                myBuilder.setCancelable(false);
//                myBuilder.setPositiveButton("Dismiss",null);
//
//                AlertDialog myDialog = myBuilder.create();
//                myDialog.show();

//                //Set the Diaglog details
//                myBuilder.setTitle("Demo 1 - Simple Dialog");
//                myBuilder.setMessage("I can develop Android App");
//                myBuilder.setCancelable(false);
//                myBuilder.setPositiveButton("Close", null);
//
//                AlertDialog myDialog = myBuilder.create();
//                myDialog.show();

            }
        });

        btnDemo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setTitle("Demo 2 - Buttons Dialog");
                myBuilder.setMessage("Select one of the buttons below");
                myBuilder.setCancelable(false);

                //To Configure the Positive button (Outermost right)
//                myBuilder.setPositiveButton("Positive", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        tvDemo2.setText("You have selected Positive");
//                    }
//                });

                myBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You have selected Yes");
                    }
                });

//                //To configure the Negative button (left to the positive button/center)
//                myBuilder.setNegativeButton("Negative", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        tvDemo2.setText("You have selected Negative");
//                    }
//                });

                //To configure the Negative button
                myBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You have selected No");
                    }
                });

                //To Configure Neutral button (Outermost left)
                myBuilder.setNeutralButton("Cancel", null);


                //This two must be the last or else if the Negative button code is below then it won't be shown
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnDemo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
//                myBuilder.setTitle("Demo 3 - Text input Dialog");

                //Inflate the input.xml layout file
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input, null);

                //Obtain the UI component in the input.xml layout
                //It needs to be defined as "final", so that it can used in the onClick() method later
                final EditText etInput = viewDialog.findViewById(R.id.etDemo3);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Demo 3 - Text Input Dialog");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Extract the text entered by the user
                        String message = etInput.getText().toString();
                        //Set the text to the textView
                        tvDemo3.setText(message);
                    }
                });

                myBuilder.setNegativeButton("Cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnExercise3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input2, null);

                final EditText etInputNo1 = viewDialog.findViewById(R.id.etExercise3_1);
                final EditText etInputNo2 = viewDialog.findViewById(R.id.etExercise3_2);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Exercise 3");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //To extract the two text entered by the user
                        int firstNumber = Integer.parseInt(etInputNo1.getText().toString());
                        int secondNumber = Integer.parseInt(etInputNo2.getText().toString());
                        int total = firstNumber + secondNumber;
                        //To set both the text into one
                        tvExercise3.setText("The sum is " + total);
                    }
                });

                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnDemo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create the Listener to set the date
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        tvDemo4.setText("Date: " + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                };

            //Create the Date Picker Dialog
//            DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this,myDateListener, 2014, 11, 31);
//            myDateDialog.show();
                Calendar now = Calendar.getInstance();
                int year = now.get(Calendar.YEAR);
                int month = now.get(Calendar.MONTH);
                int day = now.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog myDateDialog = new DatePickerDialog (MainActivity.this, myDateListener, year, month, day);
                myDateDialog.show();
            }
        });

        btnDemo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create the Listener to set the time
                TimePickerDialog.OnTimeSetListener myTimeListener= new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet (TimePicker view, int hourOfDay, int minute) {
                        tvDemo5.setText("Time: " + hourOfDay + ":" + minute);
                    }
                };

                //Create the Time Picker Dialog
//                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this, myTimeListener, 20, 00, false);
//                myTimeDialog.show();

                Calendar now = Calendar.getInstance();
                int hourOfDay = now.get(Calendar.HOUR_OF_DAY);
                int minute = now.get(Calendar.MINUTE);
                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this, myTimeListener, hourOfDay, minute, true);
                myTimeDialog.show();
            }
        });
    }
}