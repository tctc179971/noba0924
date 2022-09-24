package com.example.noba;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.time.LocalDate;

public class CreateTeamActivity extends AppCompatActivity {

    private View creatTeam;

    private RadioButton btnCasual;
    private RadioButton btnCompete;
    private Button btnCamera;
    private Button btnPicture;
    private Button btnSend;
    private Spinner sportType;
    private Spinner people;
    private Spinner place;
    private EditText et_roomname;
    private EditText et_context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_team);
        creatTeam = findViewById(R.id.create_team);
        btnCasual = findViewById(R.id.btn_casual);
        btnCompete = findViewById(R.id.btn_competition);
        btnCamera = findViewById(R.id.btn_camera);
        btnPicture = findViewById(R.id.btn_picture);
        btnSend = findViewById(R.id.btn_send);
        sportType = findViewById(R.id.sp_type);
        sportType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String result = adapterView.getItemAtPosition(i).toString();
                System.out.println(result);
                if(result.equals("籃球")){
                    System.out.println("true");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        people = findViewById(R.id.sp_people);
        people.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String result = adapterView.getItemAtPosition(i).toString();
                System.out.println(result);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        place = findViewById(R.id.sp_place);
        place.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String result = adapterView.getItemAtPosition(i).toString();
                System.out.println(result);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        setListeners();
    }
    private void setListeners(){
        Onclick onclick = new Onclick();

        btnCasual.setOnClickListener(onclick);
        btnCompete.setOnClickListener(onclick);
        btnCamera.setOnClickListener(onclick);
        btnPicture.setOnClickListener(onclick);
        btnSend.setOnClickListener(onclick);


    }

    private class Onclick implements View.OnClickListener{
        EditText et_roomname = (EditText) findViewById(R.id.et_roomname);
        EditText et_context = (EditText) findViewById(R.id.et_context);

        @Override
        public void onClick(View view) {
            new Thread(() -> {
                LocalDate todaysDate;
                todaysDate = LocalDate.now();
                sqlcon con = new sqlcon();
                con.run();
                String addroomsql="INSERT INTO room (location, start_time,dead_time,room_state,creater_id,type_id, descript) VALUES  ('高大','2017-01-01 12:00:00','2017-01-01 12:00:00','1','1','1','"+et_context.getText().toString()+"')";
                con.sql(addroomsql);
            }).start();

            switch(view.getId()){
                case R.id.btn_casual:
                    Toast.makeText(CreateTeamActivity.this,btnCasual.getText() , Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_competition:
                    Toast.makeText(CreateTeamActivity.this,btnCompete.getText() , Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_camera:

                    break;
                case R.id.btn_picture:

                    break;
                case R.id.btn_send:
                    Intent intent = new Intent(CreateTeamActivity.this,TeamActivity.class);
                    startActivity(intent);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + view.getId());
            }
        }

    }

}