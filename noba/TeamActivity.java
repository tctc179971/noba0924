package com.example.noba;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class TeamActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private TextView tv_roomname;
    private TextView tv_roomtype;
    private TextView tv_roomplace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        mRecyclerView = findViewById(R.id.rv_teammate);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        tv_roomname = (TextView) findViewById(R.id.tv_roomname);
        tv_roomtype = (TextView) findViewById(R.id.tv_roomtype);
        tv_roomplace = (TextView) findViewById(R.id.tv_roomplace);
        new Thread(() -> {
            sqlcon con = new sqlcon();
            con.run();
            String data_name = con.getinfo("roomid","select room.roomid from room where roomid=7");
            Log.v("OK", data_name);
            tv_roomname.post(() -> tv_roomname.setText("隊名:"+data_name));

            String data_type = con.getinfo("start_time","select room.start_time from room where roomid=7");
            Log.v("OK", data_type);
            tv_roomtype.post(() -> tv_roomtype.setText("項目:"+data_type));

            String data_place = con.getinfo("location","select room.location from room where roomid=7");
            Log.v("OK", data_place);
            tv_roomplace.post(() -> tv_roomplace.setText("地點:"+data_place));
        }).start();

    }

    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

        class MyViewHolder extends RecyclerView.ViewHolder{

            public View itemView;
            public ImageView mRecyclerViewImage;
            public TextView mRecyclerViewInfo;

            public MyViewHolder(@NonNull View v) {
                super(v);
                itemView = v;
                mRecyclerViewImage = findViewById(R.id.iv_mate);
                mRecyclerViewInfo = findViewById(R.id.tv_mate_info);
            }
        }

        @NonNull
        @Override
        public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_item,viewGroup,false);
            MyViewHolder vh = new MyViewHolder(itemView);
            return vh;
        }

        @Override
        public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder myViewHolder, int i) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }

}