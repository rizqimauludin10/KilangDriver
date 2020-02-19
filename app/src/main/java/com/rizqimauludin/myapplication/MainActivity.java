package com.rizqimauludin.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.rizqimauludin.myapplication.Adapter.ViewPagerAdapter;
import com.rizqimauludin.myapplication.Fragment.Beranda_Fragment;
import com.rizqimauludin.myapplication.Fragment.History_Fragment;
import com.rizqimauludin.myapplication.Fragment.Profile_Fragment;
import com.rizqimauludin.myapplication.Fragment.Saldo_Fragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;

    private Beranda_Fragment beranda_fragment;
    private History_Fragment history_fragment;
    private Saldo_Fragment saldo_fragment;
    private Profile_Fragment profile_fragment;

    private MenuItem menuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        bottomNavigationView = findViewById(R.id.btmNav);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.menu_beranda:
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.menu_history:
                    viewPager.setCurrentItem(1);
                    break;
                case R.id.menu_saldo:
                    viewPager.setCurrentItem(2);
                    break;
                case R.id.menu_profil:
                    viewPager.setCurrentItem(3);
                    break;
            }

            return false;
        });


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null){
                    menuItem.setChecked(true);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }

                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                menuItem = bottomNavigationView.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        final View view = findViewById(R.id.viewPager);
        view.setOnTouchListener((v, event) -> true);

        setupViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        beranda_fragment = new Beranda_Fragment();
        history_fragment = new History_Fragment();
        saldo_fragment = new Saldo_Fragment();
        profile_fragment = new Profile_Fragment();
        adapter.addFragments(beranda_fragment);
        adapter.addFragments(history_fragment);
        adapter.addFragments(saldo_fragment);
        adapter.addFragments(profile_fragment);
        viewPager.setAdapter(adapter);
    }
}
