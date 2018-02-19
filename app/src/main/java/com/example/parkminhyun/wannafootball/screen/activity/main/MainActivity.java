package com.example.parkminhyun.wannafootball.screen.activity.main;

import android.app.Activity;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.Toast;

import com.example.parkminhyun.wannafootball.BaseActivity;
import com.example.parkminhyun.wannafootball.R;
import com.example.parkminhyun.wannafootball.common.customview.RiceCakeView;
import com.example.parkminhyun.wannafootball.screen.fragment.CreateTeamFragment;
import com.example.parkminhyun.wannafootball.screen.fragment.EnrollMatchingFragment;
import com.example.parkminhyun.wannafootball.screen.fragment.HomeFragment;
import com.example.parkminhyun.wannafootball.screen.fragment.MyInfoFragment;
import com.example.parkminhyun.wannafootball.screen.fragment.SearchMatchingFragment;
import com.example.parkminhyun.wannafootball.screen.fragment.SearchTeamFragment;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainPage.View{

    @BindView(R.id.mainFragmentContainer)
    View mainFragmentContainer;

    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;

    @BindView(R.id.navigationView)
    NavigationView navigationView;

    @BindView(R.id.mainMenuButton)
    RiceCakeView mainMenuButton;

    private MainPage.Presenter mainPresenter;
    private int currentFragmentID;
    private boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void init(BaseActivity context) {
        initFragment();
        initView();
    }

    private void initFragment() {
        currentFragmentID = R.id.navigation_item_home;
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.mainFragmentContainer, new HomeFragment()).commit();
    }

    private void initView() {

        navigationView.setNavigationItemSelectedListener(menuItem -> {
            menuItem.setChecked(true);
            drawerLayout.closeDrawers();

            int id = menuItem.getItemId();
            if(id == currentFragmentID)
                return true;

            switch (id) {
                case R.id.navigation_item_home:
                    replaceFragment(new HomeFragment());
                    Toast.makeText(MainActivity.this, menuItem.getTitle(), Toast.LENGTH_LONG).show();
                    break;

                case R.id.navigation_item_my_info:
                    replaceFragment(new MyInfoFragment());
                    Toast.makeText(MainActivity.this, menuItem.getTitle(), Toast.LENGTH_LONG).show();
                    break;

                case R.id.navigation_item_create_team:
                    replaceFragment(new CreateTeamFragment());
                    Toast.makeText(MainActivity.this, menuItem.getTitle(), Toast.LENGTH_LONG).show();
                    break;

                case R.id.navigation_item_search_team:
                    replaceFragment(new SearchTeamFragment());
                    Toast.makeText(MainActivity.this, menuItem.getTitle(), Toast.LENGTH_LONG).show();
                    break;

                case R.id.navigation_item_search_matching:
                    replaceFragment(new SearchMatchingFragment());
                    Toast.makeText(MainActivity.this, menuItem.getTitle(), Toast.LENGTH_LONG).show();
                    break;

                case R.id.navigation_item_enroll_matching:
                    replaceFragment(new EnrollMatchingFragment());
                    Toast.makeText(MainActivity.this, menuItem.getTitle(), Toast.LENGTH_LONG).show();
                    break;
            }
            return true;
        });
    }


    @OnClick({R.id.mainMenuButton})
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.mainMenuButton) {
            drawerLayout.openDrawer(GravityCompat.START);
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mainFragmentContainer, fragment).commit();
    }

    @Override
    public void finish() {
        super.finish();
        this.finishAffinity();
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        doubleBackToExitPressedOnce = true;
        Toast.makeText(this, getResources().getString(R.string.double_exit_button_click), Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(() -> doubleBackToExitPressedOnce=false, 2000);
    }

    @Override
    protected void createPresenter() { mainPresenter = new MainPagePresenter(this); }

    @Override
    protected Activity getViews() { return this; }

    @Override
    protected int getLayout() { return R.layout.activity_main; }

}
