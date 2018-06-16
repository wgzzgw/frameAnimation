package com.example.frameanimationtest;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Button btn_startFrame,btn_stopFrame;//k开启动画，停止动画
    private ImageView iv;//gif图
    private AnimationDrawable animationDrawable;//帧动画 对象AnimationDrawable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.image);
        btn_startFrame = (Button) findViewById(R.id.start);
        btn_stopFrame = (Button) findViewById(R.id.stop);
        animationDrawable = new AnimationDrawable();
        for (int i = 0; i <= 30; i++) {
            int id = getResources().getIdentifier("i" + i, "drawable", getPackageName());
            Drawable drawable = getResources().getDrawable(id);
            animationDrawable.addFrame(drawable, 100);
        }
        btn_startFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            /*    iv.setImageResource(R.drawable.knight_attack1);
                // 1. 设置动画
                animationDrawable = (AnimationDrawable) iv.getDrawable();
                // 2. 获取动画对象
                animationDrawable.start();
                // 3. 启动动画*/
                animationDrawable.setOneShot(false);
                iv.setImageDrawable(animationDrawable);
                // 获取资源对象
                animationDrawable.stop();
                // 特别注意：在动画start()之前要先stop()，不然在第一次动画之后会停在最后一帧，这样动画就只会触发一次
                animationDrawable.start();
                // 启动动画
            }
        });
        //停止动画
        btn_stopFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             /*   iv.setImageResource(R.drawable.knight_attack1);
                // 1. 设置动画
                animationDrawable = (AnimationDrawable) iv.getDrawable();
                // 2. 获取动画对象
                animationDrawable.stop();
                // 3. 暂停动画*/
                animationDrawable.setOneShot(false);
                iv.setImageDrawable(animationDrawable);
                animationDrawable.stop();
            }
        });
    }
}
