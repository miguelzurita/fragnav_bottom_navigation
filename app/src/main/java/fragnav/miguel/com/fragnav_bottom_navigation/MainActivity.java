package fragnav.miguel.com.fragnav_bottom_navigation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {

    BottomNavigationBar bottomNavigationBar;
    private int lastSelectedPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupBottomNavigation();
    }

    private void setupBottomNavigation() {

        showSection(lastSelectedPosition);

        bottomNavigationBar = findViewById(R.id.bottom_navigation_bar);

        bottomNavigationBar.setTabSelectedListener(this);

        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);


        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_home_white_24dp, "Home").setActiveColorResource(R.color.orange))
                .addItem(new BottomNavigationItem(R.drawable.ic_book_white_24dp, "Books").setActiveColorResource(R.color.teal))
                .addItem(new BottomNavigationItem(R.drawable.ic_music_note_white_24dp, "Music").setActiveColorResource(R.color.blue))
                .addItem(new BottomNavigationItem(R.drawable.ic_tv_white_24dp, "Movies & TV").setActiveColorResource(R.color.brown))
                .addItem(new BottomNavigationItem(R.drawable.ic_videogame_asset_white_24dp, "Games").setActiveColorResource(R.color.grey))
                .setFirstSelectedPosition(lastSelectedPosition)
                .initialise();
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

    private void showSection(int position) {
        Bundle bundle = new Bundle();


        HomeFragment homeFragment = new HomeFragment();
        switch (position) {
            case 0:
                bundle.putString("label", "11");
                homeFragment.setArguments(bundle);

                getSupportFragmentManager().beginTransaction().replace(R.id.home_activity_frag_container, homeFragment).commitAllowingStateLoss();
                break;
            case 1:
                bundle.putString("label", "22");
                homeFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.home_activity_frag_container, homeFragment).commitAllowingStateLoss();
                break;
            case 2:
                bundle.putString("label", "33");
                homeFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.home_activity_frag_container, homeFragment).commitAllowingStateLoss();
                break;
            case 3:
                getSupportFragmentManager().beginTransaction().replace(R.id.home_activity_frag_container, homeFragment).commitAllowingStateLoss();
                break;
            case 4:
                getSupportFragmentManager().beginTransaction().replace(R.id.home_activity_frag_container, homeFragment).commitAllowingStateLoss();
                break;
            default:
                getSupportFragmentManager().beginTransaction().replace(R.id.home_activity_frag_container, homeFragment).commitAllowingStateLoss();
                break;
        }
    }
}
