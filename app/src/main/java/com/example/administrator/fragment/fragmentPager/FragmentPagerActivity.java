package com.example.administrator.fragment.fragmentPager;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.fragment.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentPagerActivity extends AppCompatActivity {

    private ViewPager pager;
    private TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);
        initView();
        initPager();
    }

    private void initView() {
        pager = (ViewPager) findViewById(R.id.pager);
        tab = (TabLayout) findViewById(R.id.tabLayout);
    }

    private void initPager(){
        // 1. ViewPager 위젯 연결
        pager = (ViewPager) findViewById(R.id.pager); // 1. 이게 리스트뷰라고 보면 됨
        tab = (TabLayout) findViewById(R.id.tabLayout);
        tab.addTab(tab.newTab().setText("one"));
        tab.addTab(tab.newTab().setText("two"));
        tab.addTab(tab.newTab().setText("three"));

        // 2. 프래그먼트 리스트 데이터 세팅
        OneFragment one = new OneFragment(); //2. 이것들이 데이터
        TwoFragment two = new TwoFragment();
        ThreeFragment three = new ThreeFragment();
        List<Fragment> datas = new ArrayList<>();
        datas.add(one);
        datas.add(two);
        datas.add(three);

        // 4.
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager(), datas); // 어댑터
        pager.setAdapter(adapter);

        // 6. 페이저가 변경되었을 때 탭을 변경해주는 리스너
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));

        // 7. 탭이 변경되었을 때 페이저를 변경해주는 리스너
        tab.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(pager));
    }
}
