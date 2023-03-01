package com.xaoyv.magicbox.ui.home;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.xaoyv.magicbox.R;
import com.xaoyv.magicbox.base.BaseActivity;
import com.xaoyv.magicbox.view.CustomViewPager;

public class HomeActivity extends BaseActivity {

    private CustomViewPager viewPager;
    private RelativeLayout rlHome;
    private RelativeLayout rlMine;

    private TextView tvHome;
    private TextView tvMine;
    private ImageView ivHome;
    private ImageView ivMine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initView();
        initListener();
    }

    private void initListener() {
        HomeFragment homeFragment = new HomeFragment();
        MineFragment mineFragment = new MineFragment();
        viewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return position == 0 ? homeFragment : mineFragment;
            }

            @Override
            public int getCount() {
                return 2;
            }
        });
        rlHome.setOnClickListener(v -> {
            tvHome.setTextColor(getResources().getColor(R.color.box_33));
            tvMine.setTextColor(getResources().getColor(R.color.box_30_33));
            viewPager.setCurrentItem(0);
        });
        rlMine.setOnClickListener(v -> {
            tvHome.setTextColor(getResources().getColor(R.color.box_30_33));
            tvMine.setTextColor(getResources().getColor(R.color.box_33));
            viewPager.setCurrentItem(1);
        });
    }

    private void initView() {
        viewPager = findViewById(R.id.viewpager);
        rlHome = findViewById(R.id.rl_home);
        rlMine = findViewById(R.id.rl_mine);
        tvHome = findViewById(R.id.tv_home);
        tvMine = findViewById(R.id.tv_mine);
        ivHome = findViewById(R.id.iv_home);
        ivMine = findViewById(R.id.iv_mine);

        tvHome.setText("首页");
        tvMine.setText("我的");
    }
}