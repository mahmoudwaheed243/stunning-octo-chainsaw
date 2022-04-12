package com.example.collegeapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Gpatable extends AppCompatActivity   {
    int number_of_rows;
    List<Spinner> grades;
    List<String> credites;
    double semesterGPA, cumulativeGPA , sumOfCredites , yourgpa, totalcreiteshourse, sumCredites_hourse;
    Button evaluate;
    EditText editText2 , editText3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpatable);
        grades=new ArrayList<>();
        credites=new ArrayList<>();
        editText2= findViewById(R.id.edittext2);
        totalcreiteshourse=Double.parseDouble(editText2.getText().toString());// to get the total hourse
        editText3 = findViewById(R.id.edittext3);
        yourgpa = Double.parseDouble(editText3.getText().toString());
        Intent intent = getIntent();
        number_of_rows = intent.getIntExtra("no",5);
        init();
        evaluate = findViewById(R.id.evaluatebutton);

    }
    public void init() {
        TableLayout stk = (TableLayout) findViewById(R.id.table_main);
        TableRow tbrow0 = new TableRow(this);
        TextView tv0 = new TextView(this);
        tv0.setText(" course.No   ");
        tv0.setTextColor(Color.WHITE);
        tbrow0.addView(tv0);
        TextView tv1 = new TextView(this);
        tv1.setText(" Grade ");
        tv1.setTextColor(Color.WHITE);
        tbrow0.addView(tv1);
        TextView tv2 = new TextView(this);
        tv2.setText(" Credits ");
        tv2.setTextColor(Color.WHITE);
        tbrow0.addView(tv2);
        stk.addView(tbrow0);
        for (int i = 1; i <= number_of_rows; i++) {
            TableRow tbrow = new TableRow(this);
            TextView t1v = new TextView(this);
            t1v.setText("" + i);
            t1v.setTextColor(Color.WHITE);
            t1v.setGravity(Gravity.CENTER);
            tbrow.addView(t1v);
            Spinner spinner = new Spinner(this);
            spinner.setId(i); // this line to add id for each spinnner dynamicaly
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.CourseGrade, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
            spinner.setOnItemClickListener((AdapterView.OnItemClickListener) this);
            tbrow.addView(spinner);
            grades.add(spinner);
            EditText editText1= new EditText(this);
            editText1.setHint("Enter Credits");
            editText1.setTextColor(Color.WHITE);
            editText1.setGravity(Gravity.CENTER);
            tbrow.addView(editText1);
            credites.add(editText1.getText().toString());
            stk.addView(tbrow);
        }

    }

    public void calculateSemesterGPA(){
        for(int i=0; i<credites.size(); i++){
            double current_credit=0;
            current_credit=Double.parseDouble(credites.get(i));
            sumOfCredites+=current_credit; // number of hourse for the current term
            sumCredites_hourse=0;
            Spinner sp=(Spinner)findViewById(i);
            String selected_grade = sp.getSelectedItem().toString();
            if(selected_grade.equals("A")){
                sumCredites_hourse+=(4.00)*current_credit;
            }
            else if (selected_grade.equals("A-")){
                sumCredites_hourse+=(3.67)*current_credit;
            }
            else if (selected_grade.equals("B+")){
                sumCredites_hourse+=(3.33)*current_credit;
            }
            else if (selected_grade.equals("B")){
                sumCredites_hourse+=(3.00)*current_credit;
            }
            else if (selected_grade.equals("C+")){
                sumCredites_hourse+=(2.67)*current_credit;
            }
            else if (selected_grade.equals("C")){
                sumCredites_hourse+=(2.33)*current_credit;
            }
            else if (selected_grade.equals("D")){
                sumCredites_hourse+=(2.00)*current_credit;
            }
            else if (selected_grade.equals("F")){
                sumCredites_hourse+=(0.00)*current_credit;
            }
            else {
                sumCredites_hourse+=0.0;
            }
        } // end of for loop
        semesterGPA=(sumCredites_hourse)/(sumOfCredites);
    }
    public void calculateCumulativeGPA(){
        cumulativeGPA=((sumOfCredites*semesterGPA)+(totalcreiteshourse*yourgpa))/(sumOfCredites+totalcreiteshourse);
    }
}