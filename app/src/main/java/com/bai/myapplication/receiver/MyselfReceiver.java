package com.bai.myapplication.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.bai.myapplication.Main2Activity;

/**
 * Created by  林师金 on 2019/4/27 0027.
 */

public class MyselfReceiver extends BroadcastReceiver {
    /**
     * 广播接收器收到相应的广播后会自动调用这个方法，不能执行耗时操作，不然会容易出现ANR
     *
     * @param context
     * @param intent
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = intent.getStringExtra("Msg");
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(context, Main2Activity.class);
        context.startActivity(intent1);
    }
}
