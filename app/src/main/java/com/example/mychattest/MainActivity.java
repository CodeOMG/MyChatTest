package com.example.mychattest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Msg> msgList = new ArrayList<>();
    private EditText input_msg;
    private Button send;
    private MsgAdapter msgAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMsg();
        recyclerView = findViewById(R.id.recycler_view);
        input_msg = findViewById(R.id.input_msg);
        send = findViewById(R.id.send);
        msgAdapter = new MsgAdapter(msgList);
        recyclerView.setAdapter(msgAdapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = input_msg.getText().toString();
                if (!"".equals(content)) {
                    Msg msg = new Msg(content, Msg.SENT);
                    msgList.add(msg);
                    msgAdapter.notifyItemInserted(msgList.size() - 1);
                    recyclerView.scrollToPosition(msgList.size() - 1);
                    input_msg.setText("");
                }
            }
        });
    }

    public void initMsg() {
        Msg msg1 = new Msg("Hello,I am Tom,Who are you?", Msg.RECEIVE);
        msgList.add(msg1);
        Msg msg2 = new Msg("I am Peter,Nice to meet you.", Msg.SENT);
        msgList.add(msg2);
        Msg msg3 = new Msg("Nice to meet you,too.", Msg.RECEIVE);
        msgList.add(msg3);
    }
}
