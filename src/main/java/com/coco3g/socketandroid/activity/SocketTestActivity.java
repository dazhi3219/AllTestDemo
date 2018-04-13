package com.coco3g.socketandroid.activity;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.coco3g.socketandroid.R;

import org.java_websocket.WebSocket;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_17;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by lisen on 16/2/25 17:29.
 */
public class SocketTestActivity extends AppCompatActivity {
    private String ip = "";
    private EditText mEditContent;
    private View mTxt;
    private View mImageView;

    private WebSocketClient webSocketClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ImageView imageView = findViewById(R.id.image_bb);
        mEditContent = findViewById(R.id.edit_content);
        mTxt = findViewById(R.id.tv_send_msg_msg);
        mImageView = findViewById(R.id.image_bb);
        TextView textView = new TextView(this);
        textView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                TextView textView1 = null;


                return false;
            }
        });

//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(SocketTestActivity.this, WebActivity.Classs);
//                intent.putExtra("title", "测试");
//                intent.putExtra("url", DataUrl.IMAGE_URL);
//                startActivity(intent);
//
//            }
//        });


    }

    public void getIp() {
        //获取wifi服务
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        //判断wifi是否开启
        if (!wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(true);
        }
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        int ipAddress = wifiInfo.getIpAddress();
        ip = intToIp(ipAddress);
        Log.e("获取的ip地址：", ipAddress + "   ip =" + ip);
    }

    private String intToIp(int i) {
        return (i & 0xFF) + "." +
                ((i >> 8) & 0xFF) + "." +
                ((i >> 16) & 0xFF) + "." +
                (i >> 24 & 0xFF);
    }


    public void getChangeTime() {
        int time = getIntent().getIntExtra("kjdk", 10);

    }


    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.tv_get_localhost:
                intent = getIntent();
                intent.putExtra("jdk", true);
                startActivity(intent);

//                getIp();
                break;

            case R.id.tv_connect:
//                startServiceSocket();

                Intent intent1 = new Intent(this, ToolbarActivity.class);
                startActivity(intent1);

                break;

            case R.id.tv_send_msg:
                connectToService();

                break;

            case R.id.tv_send_msg_msg:

//                Intent intent1 = new Intent(this, Main2Activity.class);
//                startActivity(intent1);

//                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeCustomAnimation(this, android.R.anim.slide_in_left, android.R.anim.slide_out_right);
//                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeScaleUpAnimation(mTxt, 0, 0, mTxt.getWidth(), mTxt.getHeight());
//                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeClipRevealAnimation(mTxt, 0, 0, 100, 100);


                Pair<View, String> pair1 = Pair.create(mImageView, getResources().getString(R.string.app_name));
                Pair<View, String> pair2 = Pair.create(mTxt, getResources().getString(R.string.action_settings));

                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(SocketTestActivity.this, pair1, pair2);

                ActivityCompat.startActivity(this, new Intent(this, Main2Activity.class), optionsCompat.toBundle());


                break;

        }
    }

    private void startServiceSocket() {
        WebSocketServer webSocketServer = new WebSocketServer(new InetSocketAddress(8081)) {
            @Override
            public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {
                Log.e("服务端", "open--开启");

            }

            @Override
            public void onClose(WebSocket webSocket, int i, String s, boolean b) {
                Log.e("服务端", "close--关闭");
            }

            @Override
            public void onMessage(WebSocket webSocket, String s) {
                Log.e("服务端", "message--" + s);
            }

            @Override
            public void onError(WebSocket webSocket, Exception e) {
                Log.e("服务端", "error--" + e);
            }
        };
        webSocketServer.start();

    }


    private void connectToService() {
        try {
            webSocketClient = new WebSocketClient(new URI("ws://" + ip + ":8081"), new Draft_17()) {
                @Override
                public void onOpen(ServerHandshake serverHandshake) {
                    Log.e("!!客户端", "Open");

                }

                @Override
                public void onMessage(String s) {

                }

                @Override
                public void onClose(int i, String s, boolean b) {
                    Log.e("客户端", "close");
                }

                @Override
                public void onError(Exception e) {
                    Log.e("!!客户端", "Error" + e.toString());
                }
            };
            webSocketClient.connect();


        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

}
