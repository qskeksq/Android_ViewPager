package com.example.administrator.fragment.viewPager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.fragment.R;

import java.util.List;

/**
 * Created by Administrator on 2017-10-12.
 */

public class ViewPagerAdapter  extends PagerAdapter {
    Context context;
    List<String> data;

    public ViewPagerAdapter(Context context, List<String> data){
        this.context = context;
        this.data = data;
    }

    /**
     * 이렇게 함으로써 완벽한 MVP 를 구현할 수있다
     * @param view
     */
    public void setView(ViewPager view){
        view.setAdapter(this);
    }

    // 전체 개수
    @Override
    public int getCount() {
        return data.size();
    }

    /**
     * 리스트뷰의 getView()
     * @param container : 뷰페이저
     * @param position
     * @return
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // 1. 여기서 레이아웃 파일을 inflate해서 view로 만든다
        View view = LayoutInflater.from(context).inflate(R.layout.item_viewpager, null);

        // 2. 데이터를 화면에 세팅
        String value = data.get(position);
        TextView textView = (TextView) view.findViewById(R.id.textView);
        textView.setText(value);

        // 3. 뷰 그룹에 만들어진 view를 add 한다.
        container.addView(view);
        return view;
    }

    /**
     * instantiateItem 에서 리턴된 object가 View가 맞는지 확인
     */
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    /**
     * 현재 사용하지 않은 View 제거
     * @param container : 뷰페이저
     * @param position
     * @param object : 뷰페이저 안에 있는 뷰아이템
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView( (View)object  );
        //super.destroyItem(container, position, object);
    }
}
