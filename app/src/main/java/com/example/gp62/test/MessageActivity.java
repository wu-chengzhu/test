package com.example.gp62.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gp62.test.Adapter.MsgAdapter;

import java.util.ArrayList;
import java.util.List;

public class MessageActivity extends AppCompatActivity {
        private List<Msg> msgList=new ArrayList<>();
        private EditText inputText;
        private Button send;
        private RecyclerView msgRecyclerView;
        private MsgAdapter adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);
        initMsgs();//初始化消息数据
        inputText=findViewById(R.id.input_text);
        send=findViewById(R.id.send);
        msgRecyclerView=(RecyclerView)findViewById(R.id.msg_recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(layoutManager);
        adapter=new MsgAdapter(msgList);//new 一个adapter 并给它数据
        msgRecyclerView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content=inputText.getText().toString();//从输入框得到内容
                if(!"".equals(content))//不为空消息
                {
                    Msg msg=new Msg(content,Msg.TYPE_SENT);
                    msgList.add(msg);
                    adapter.notifyItemInserted(msgList.size()-1);//当有新消息时，刷新ListView中的显示
                    msgRecyclerView.scrollToPosition(msgList.size()-1);//将ListView定位到最后一行
                    inputText.setText("");//清空输入框中的内容

                }
            }
        });
    }

    private void initMsgs()
    {
        Msg msg1=new Msg("Hello guy",Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2=new Msg("Hello what's up?",Msg.TYPE_SENT);
        msgList.add(msg2);
        Msg msg3=new Msg("This is Tom.",Msg.TYPE_RECEIVED);
        msgList.add(msg3);

    }
}
