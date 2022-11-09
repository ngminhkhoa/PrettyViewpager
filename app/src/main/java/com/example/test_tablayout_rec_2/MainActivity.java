package com.example.test_tablayout_rec_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        models = new ArrayList<>();
        models.add(new Model(R.drawable.avatar1, "Như Phương",
                "School was a totally positive experience for me. The positive aspects of parenthood are rarely written about."));
        models.add(new Model(R.drawable.avatar_2, "Minh Khoa",
                "The experiment is working well and feedback is very positive. We couldn’t be sure if her reaction would be positive."));
        models.add(new Model(R.drawable.avatar_3, "Tên Gì Đó",
                "When you’re writing, you might find that you rely on the same familiar adjectives. Or perhaps you’ve noticed that you tend to overuse certain words?"));
        models.add(new Model(R.drawable.avatar_4, "Ai Biết Đâu",
                "She loves making the complex seem simple through blogs, articles, and curriculum content. You can check out her work at hellydouglas.com or connect on Twitter"));

        adapter = new Adapter(models, this);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),
        };

        colors = colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position,
                                       float positionOffset,
                                       int positionOffsetPixels) {

                if (position < (adapter.getCount() -1) && position <(colors.length - 1)) {
                    viewPager.setBackgroundColor((Integer) argbEvaluator.evaluate(
                            positionOffset,
                            colors[position], colors[position + 1]
                            )
                    );
                } else {
                    viewPager.setBackgroundColor(colors[colors.length -1 ]);
                }
            }

            @Override
            public void onPageSelected(int position) {
                Toast.makeText(MainActivity.this, " " +position, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }
}