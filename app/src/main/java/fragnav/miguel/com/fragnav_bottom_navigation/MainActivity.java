package fragnav.miguel.com.fragnav_bottom_navigation;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ncapdevi.fragnav.FragNavController;
import com.ncapdevi.fragnav.FragNavSwitchController;
import com.ncapdevi.fragnav.FragNavTransactionOptions;
import com.ncapdevi.fragnav.tabhistory.FragNavTabHistoryController;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener, BaseFragment.FragmentNavigation, FragNavController.TransactionListener, FragNavController.RootFragmentListener {

    BottomNavigationBar bottomNavigationBar;
    private int lastSelectedPosition = 0;
    private FragNavController.Builder builder;
    private FragNavController mNavController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        fragNav
        builder = FragNavController.newBuilder(savedInstanceState, getSupportFragmentManager(), R.id.home_activity_frag_container);

        mNavController = builder
                .transactionListener(this)
                .rootFragmentListener(this, 5)
                .popStrategy(FragNavTabHistoryController.UNIQUE_TAB_HISTORY)
                .switchController(new FragNavSwitchController() {
                    @Override
                    public void switchTab(int index, FragNavTransactionOptions transactionOptions) {
                        bottomNavigationBar.selectTab(index);
//                        bottomBar.selectTabAtPosition(index);
                    }
                })
                .build();

        setupBottomNavigation();
    }

    private void setupBottomNavigation() {

        showSection(lastSelectedPosition);

        bottomNavigationBar = findViewById(R.id.bottom_navigation_bar);

        bottomNavigationBar.setTabSelectedListener(this);

//        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED_NO_TITLE);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);


        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_home_white_24dp, "Home").setActiveColorResource(R.color.orange))
                .addItem(new BottomNavigationItem(R.drawable.ic_book_white_24dp, "Books").setActiveColorResource(R.color.teal))
                .addItem(new BottomNavigationItem(R.drawable.ic_music_note_white_24dp, "Music").setActiveColorResource(R.color.blue))
                .addItem(new BottomNavigationItem(R.drawable.ic_tv_white_24dp, "Movies & TV").setActiveColorResource(R.color.brown))
                .addItem(new BottomNavigationItem(R.drawable.ic_videogame_asset_white_24dp, "Games").setActiveColorResource(R.color.grey))
                .setFirstSelectedPosition(lastSelectedPosition)
                .initialise();


        /*List<Fragment> fragments = new ArrayList<>(5);

        fragments.add(HomeFragment.newInstance(0));
        fragments.add(HomeFragment.newInstance(0));
        fragments.add(HomeFragment.newInstance(0));
        fragments.add(HomeFragment.newInstance(0));
        fragments.add(HomeFragment.newInstance(0));*/

//        mNavController.switchTab(INDEX_RECENTS);

//        builder.rootFragments(fragments);

//        mNavController = builder.build();
    }

    @Override
    public void onTabSelected(int position) {
        lastSelectedPosition = position;
//        setMessageText(position + " Tab Selected");
        /*if (numberBadgeItem != null) {
            numberBadgeItem.setText(Integer.toString(position));
        }*/
        showSection(position);
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    public void onBackPressed() {
        if (!mNavController.popFragment()) {
            super.onBackPressed();
        }
    }

    private void showSection(int position) {
        Bundle bundle = new Bundle();


        HomeFragment homeFragment = new HomeFragment();
        switch (position) {
            case 0:
                bundle.putString("label", "11");
                homeFragment.setArguments(bundle);
                replaceFragment(position, homeFragment);
                break;
            case 1:
                bundle.putString("label", "22");
                homeFragment.setArguments(bundle);
                replaceFragment(position, homeFragment);
                break;
            case 2:
                bundle.putString("label", "33");
                homeFragment.setArguments(bundle);
                replaceFragment(position, homeFragment);
                break;
            case 3:
                replaceFragment(position, homeFragment);
                break;
            case 4:
                replaceFragment(position, homeFragment);
                break;
            default:
                replaceFragment(position, homeFragment);
                break;
        }
    }

    private void replaceFragment(int position, HomeFragment homeFragment) {
        mNavController.switchTab(position);
//        getSupportFragmentManager().beginTransaction().replace(R.id.home_activity_frag_container, homeFragment).commitAllowingStateLoss();
    }

    @Override
    public Fragment getRootFragment(int index) {

        Log.d("MyAPP", "index:" + index);

//        return HomeFragment.newInstance(0);
        switch (index) {
            case 0:
                return HomeFragment.newInstance(0, "aaa");
            case 1:
                return HomeFragment.newInstance(0, "bbb");
            case 2:
                return HomeFragment.newInstance(0, "ccc");
            /*case INDEX_FRIENDS:
                return FriendsFragment.newInstance(0);
            case INDEX_FOOD:
                return FoodFragment.newInstance(0);*/
        }
        throw new IllegalStateException("Need to send an index that we know");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mNavController != null) {
            mNavController.onSaveInstanceState(outState);
        }
    }

    @Override
    public void onTabTransaction(@Nullable Fragment fragment, int index) {
        // If we have a backstack, show the back button
        if (getSupportActionBar() != null && mNavController != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(!mNavController.isRootFragment());
        }
    }


    @Override
    public void onFragmentTransaction(Fragment fragment, FragNavController.TransactionType transactionType) {
        //do fragmentty stuff. Maybe change title, I'm not going to tell you how to live your life
        // If we have a backstack, show the back button
        if (getSupportActionBar() != null && mNavController != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(!mNavController.isRootFragment());
        }
    }

    @Override
    public void pushFragment(Fragment fragment) {
        if (mNavController != null) {
            mNavController.pushFragment(fragment);
        }
    }
}
