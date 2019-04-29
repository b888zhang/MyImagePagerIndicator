package com.example.zb.myimagepagerindicator;

import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.zb.myimagepagerindicator.fragment.OneFragment;
import com.example.zb.myimagepagerindicator.fragment.TestFragment;
import com.example.zb.myimagepagerindicator.fragment.TwoFragment;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ModifyTabLayout tabLayout=findViewById(R.id.modiftTabLayout);
        ViewPager vp=findViewById(R.id.vp);
        tabLayout.setViewHeight(dp2px(50));
        //tab底部线宽度
        tabLayout.setBottomLineWidth(dp2px(30));
        //tab底部线高度
        tabLayout.setBottomLineHeight(dp2px(4));
        //tab底部线颜色
        tabLayout.setBottomLineHeightBgResId(R.color.colorAccent);

        tabLayout.setItemInnerPaddingLeft(dp2px(6));
        tabLayout.setItemInnerPaddingRight(dp2px(6));
        //tab选中的字体颜色
        tabLayout.setmTextColorSelect(ContextCompat.getColor(this,R.color.white));
        //tab默认的字体颜色
        tabLayout.setmTextColorUnSelect(ContextCompat.getColor(this,R.color.black));
        tabLayout.setTextSize(18);

        //以下两行是等分，如果注释了就不等分了
        int width=getResources().getDisplayMetrics().widthPixels;
        tabLayout.setNeedEqual(true,width);

        CustomFragmentPagerAdapter adapter = new CustomFragmentPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new TestFragment(), "新闻");
        adapter.addFrag(new OneFragment(), "音乐");
        adapter.addFrag(new TwoFragment(), "王者荣耀");
        vp.setAdapter(adapter);
        vp.setOffscreenPageLimit(adapter.getCount());
        tabLayout.setupWithViewPager(vp);
    }

    /**
     * dp转换成px
     */
    public int dp2px( float dpValue){
        float scale=getResources().getDisplayMetrics().density;
        return (int)(dpValue*scale+0.5f);
    }
}
