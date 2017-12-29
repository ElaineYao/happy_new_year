package com.example.viewpager_prac;

import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<View> viewList;
    private ViewPager pager;
    private  List<String> titleList;
    private PagerTabStrip tab;
    private TextView text1;
    private TextView text2;
    private TextView text3;
    private TextView text4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewList=new ArrayList<View>();
        View view1=View.inflate(this,R.layout.page1,null);
        View view2=View.inflate(this,R.layout.page2,null);
        View view3=View.inflate(this,R.layout.page3,null);
        View view4=View.inflate(this,R.layout.page4,null);

        titleList=new ArrayList<String>();
        titleList.add("第一页");
        titleList.add("第二页");
        titleList.add("第三页");
        titleList.add("第四页");

        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        viewList.add(view4);

        tab=(PagerTabStrip)findViewById(R.id.tab);
        tab.setBackgroundColor(Color.GRAY);
        tab.setTextColor(Color.BLUE);
        tab.setDrawFullUnderline(false);
        tab.setTabIndicatorColor(Color.BLACK);


        MyPagerAdapter adapter=new MyPagerAdapter(viewList,titleList);
        pager=(ViewPager)findViewById(R.id.pager);
        pager.setAdapter(adapter);

    }
    class MyPagerAdapter extends PagerAdapter{

        private List<View> viewList;
        private List<String> titleList;

        public MyPagerAdapter(List<View> viewList,List<String> titleList){
            this.viewList=viewList;
            this.titleList=titleList;
        }

        @Override
        public int getCount() {
            return viewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewList.get(position));
            return viewList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(viewList.get(position));
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titleList.get(position);
        }
    }

}
