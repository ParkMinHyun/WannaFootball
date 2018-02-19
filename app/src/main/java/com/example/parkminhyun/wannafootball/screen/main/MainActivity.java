package com.example.parkminhyun.wannafootball.screen.main;

import android.app.Activity;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.Toast;

import com.example.parkminhyun.wannafootball.BaseActivity;
import com.example.parkminhyun.wannafootball.R;
import com.example.parkminhyun.wannafootball.common.customview.RiceCakeView;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainPage.View{

    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;

    @BindView(R.id.navigationView)
    NavigationView navigationView;

    @BindView(R.id.mainMenuButton)
    RiceCakeView mainMenuButton;

    private MainPage.Presenter mainPresenter;

    private boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void init(BaseActivity context) {
        initView();
    }

    private void initView() {
        navigationView.setNavigationItemSelectedListener(menuItem -> {
            menuItem.setChecked(true);
            drawerLayout.closeDrawers();

            int id = menuItem.getItemId();
            switch (id) {
//                case R.id.navigation_item_attachment:
//                    Toast.makeText(MainActivity.this, menuItem.getTitle(), Toast.LENGTH_LONG).show();
//                    break;
//
//                case R.id.navigation_item_images:
//                    Toast.makeText(MainActivity.this, menuItem.getTitle(), Toast.LENGTH_LONG).show();
//                    break;
//
//                case R.id.navigation_item_location:
//                    Toast.makeText(MainActivity.this, menuItem.getTitle(), Toast.LENGTH_LONG).show();
//                    break;
//
//                case R.id.nav_sub_menu_item01:
//                    Toast.makeText(MainActivity.this, menuItem.getTitle(), Toast.LENGTH_LONG).show();
//                    break;
//
//                case R.id.nav_sub_menu_item02:
//                    Toast.makeText(MainActivity.this, menuItem.getTitle(), Toast.LENGTH_LONG).show();
//                    break;
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
