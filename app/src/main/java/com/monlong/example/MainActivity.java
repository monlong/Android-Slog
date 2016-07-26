package com.monlong.example;

import android.app.Activity;
import android.os.Bundle;

import com.monlong.slog.Slog;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String json = "[{\"a\":\"b\", \"c\":\"d\"}, {\"a\":\"b\", \"c\":\"d\"}]";
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><recipe \n\t\n\t><recipename><recipename>Ice Cream Sundae</recipename><preptime>5 minutes</preptime></recipename></recipe>";

        boolean flag = false;
        char c = 'c';
        char[] cs = {'c','b','d'};
        double d = 434.88D;
        float f = 43.44F;
        long l = 33432;
        int i = 43;
        Object o = new Object();
        String str = "hello";

        Slog.e(flag);
        Slog.e(c);
        Slog.e(cs);
        Slog.e(d);
        Slog.e(f);
        Slog.e(l);
        Slog.e(i);
        Slog.e(o);
        Slog.e(str);

        Slog.e(json);
        Slog.e(xml);
    }
}
