package com.example.administrator.fragment.viewPager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.fragment.R;

import java.util.ArrayList;
import java.util.List;
/**
 * ViewPager
 *
 * 어댑터는 데이터(모델)를 받아서 뷰를 만들어 그 안에 데이터를 담아주고,
 * 그 데이터가 세팅이 된 뷰를 뷰그룹(리스뷰, 뷰페이저)에 addView 해 주는 것이다
 * 모든 어댑터 뷰가 이렇게 동작한다.
 * 즉, 데이터(Model) - 어댑터(Presenter) - 뷰(View) 구조로 되어있다
 *
 * 몇가지 생각할 것은 이 과정에서 시스템(안드로이드)가 가 해 주는 일이다
 * 안드로이드가 사용자 요청에 따라 getItem(getView)를 해주고, addView()도 자동으로 해 준다.
 * 즉 우리는 그 안에서 뷰 사용만 커스터마이징 하는 것이었군. 부르고 더해주는 일을 어댑터가 해 주는 것이다.
 * 다만 뷰페이저는 해 줘야 함.(프래그먼트는 자동으로 해 줌)
 */
public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        initView();
        initViewPager();
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
    }

    private void initViewPager(){
        // 가.데이터 로드
        List<String> data = new ArrayList<>();
        for(int i=0 ; i<100 ; i++){
            data.add("Temp Data="+i);
        }

        // 나.아답터 생성
        ViewPagerAdapter adapter = new ViewPagerAdapter(this, data);

        // 다.아답터 연결
        viewPager.setAdapter(adapter);
    }

}
