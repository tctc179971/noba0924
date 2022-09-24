package com.example.noba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnCreateTeam;
    private Button btnCreateTeam_2;
    private Button btnCreateTeam_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCreateTeam = (Button) findViewById(R.id.btn_team_create);
        btnCreateTeam_2 = (Button) findViewById(R.id.btn_team_2);
        btnCreateTeam_3 = (Button) findViewById(R.id.btn_team_3);
        btnCreateTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,CreateTeamActivity.class);
                startActivity(intent);
            }
        });
        btnCreateTeam_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,TeaminfoActivity.class);
                startActivity(intent);
            }
        });
        btnCreateTeam_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,TeamsearchActivity.class);
                startActivity(intent);
            }
        });
    }
}