package com.example.cjiao.listviewtest;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    //private String[] data = {"路飞","柯南","蜡笔小新","哆啦A梦","怪盗基德","小丸子","樱木花道","鸣人","圣斗士星矢","奥特曼","皮卡丘","龟仙人"};
    private List<Cartoon> cartoonList = new ArrayList<Cartoon>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initCartoons();
        CartoonAdapter adapter = new CartoonAdapter(MainActivity.this,R.layout.cartoon_item,cartoonList);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,data);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }

    //{"路飞","柯南","蜡笔小新","哆啦A梦","怪盗基德","小丸子","樱木花道","鸣人","圣斗士星矢","奥特曼","皮卡丘","龟仙人"}
    private void initCartoons(){
        Cartoon lufei = new Cartoon("路飞",R.drawable.lufei);
        cartoonList.add(lufei);
        Cartoon kenan = new Cartoon("柯南",R.drawable.kenan);
        cartoonList.add(kenan);
        Cartoon xiaoxin = new Cartoon("蜡笔小新",R.drawable.xiaoxin);
        cartoonList.add(xiaoxin);
        Cartoon ameng = new Cartoon("哆啦A梦",R.drawable.ameng);
        cartoonList.add(ameng);
        Cartoon jide = new Cartoon("怪盗基德",R.drawable.jide);
        cartoonList.add(jide);
        Cartoon xwanzi = new Cartoon("小丸子",R.drawable.xwanzi);
        cartoonList.add(xwanzi);
        Cartoon yinmu = new Cartoon("樱木花道",R.drawable.yinmu);
        cartoonList.add(yinmu);
        Cartoon mingren = new Cartoon("鸣人",R.drawable.mingren);
        cartoonList.add(mingren);
        Cartoon xingshi = new Cartoon("圣斗士星矢",R.drawable.xingshi);
        cartoonList.add(xingshi);
        Cartoon aote = new Cartoon("奥特曼",R.drawable.aote);
        cartoonList.add(aote);
        Cartoon pikaqiu = new Cartoon("皮卡丘",R.drawable.pikaqiu);
        cartoonList.add(pikaqiu);
        Cartoon guixianr = new Cartoon("龟仙人",R.drawable.guixianr);
        cartoonList.add(guixianr);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
