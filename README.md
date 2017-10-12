# ViewPager

- 어댑터는 데이터(모델)를 받아서 뷰를 만들어 그 안에 데이터를 담아주고,
 그 데이터가 세팅이 된 뷰를 뷰그룹(리스뷰, 뷰페이저)에 addView 해 준다
 모든 어댑터 뷰가 데이터(Model) - 어댑터(Presenter) - 뷰(View) 구조로 동작한다
- 이 과정에서 시스템(안드로이드)가 가 해 주는 일은 사용자 요청에 따라 getItem(getView)를 해주고, addView()도 자동으로 해 준다.
- 개발자의 역할은 그 안에서 뷰와 일부 디자인을 커스터마이징 하는 것이다.( 뷰페이저는 해 줘야 함(프래그먼트는 자동으로 해 줌))

## Fragment Pager

#### 어댑터
```java
public class FragmentPagerAdapter extends FragmentStatePagerAdapter {

    List<Fragment> datas;

    public FragmentPagerAdapter(FragmentManager fm, List<Fragment> datas) {
        super(fm);
        this.datas = datas;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                break;
        }
        return datas.get(position);
    }

    @Override
    public int getCount() {
        return datas.size();
    }
}
```

#### 탭레이아웃과 연결
```java
FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager(), datas); // 어댑터
pager.setAdapter(adapter);

// 페이저가 변경되었을 때 탭을 변경해주는 리스너
pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));

// 탭이 변경되었을 때 페이저를 변경해주는 리스너
tab.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(pager));
```


## ViewPager

#### 어댑터
```java
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
```

