package com.example.myportfolio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;

import com.example.myportfolio.cv.CVFragment;
import com.example.myportfolio.home.HomeFragment;
import com.example.myportfolio.portfolio.PortfolioFragment;
import com.example.myportfolio.sidemenu.Callback;
import com.example.myportfolio.sidemenu.MenuAdapter;
import com.example.myportfolio.sidemenu.MenuItem;
import com.example.myportfolio.sidemenu.MenuUtil;
import com.example.myportfolio.team.TeamFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Callback {

    RecyclerView menuRv;
    List<MenuItem> menuItems;
    MenuAdapter adapter;
    int selectedMenuPos = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

            // setup side menu
        setupSideMenu();

            // set the default fragment when activity launch
            setHomeFragment();



        }

        private void setupSideMenu() {

            menuRv = findViewById(R.id.rv_side_menu);

            // get menu list item  will get data from a static data class

            menuItems = MenuUtil.getMenuList();
            adapter = new MenuAdapter(menuItems,this);
            menuRv.setLayoutManager(new LinearLayoutManager(this));
            menuRv.setAdapter(adapter);

        }

        void setPortfoliofragment() {

            getSupportFragmentManager().beginTransaction().replace(R.id.container,new PortfolioFragment()).commit();

        }

        void setTeamFragment () {
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new TeamFragment()).commit();
        }

        void setCVFragment() {
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new CVFragment()).commit();
        }


        void setHomeFragment() {

            getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment()).commit();

        }


        @Override
        public void onSideMenuItemClick(int i) {

            switch (menuItems.get(i).getCode()) {

                case MenuUtil.HOME_FRAGMENT_CODE : setHomeFragment();
                    break;
                case MenuUtil.CV_FRAGMENT_CODE : setCVFragment();
                    break;
                case MenuUtil.TEAM_FRAGMENT_CODE: setTeamFragment();
                    break;
                case MenuUtil.PORTFOLIO_FRAGMENT_CODE:setPortfoliofragment();
                    break;
                default: setHomeFragment();
            }

            // hightligh the selected menu item

            menuItems.get(selectedMenuPos).setSelected(false);
            menuItems.get(i).setSelected(true);
            selectedMenuPos = i ;
            adapter.notifyDataSetChanged();

        }
}