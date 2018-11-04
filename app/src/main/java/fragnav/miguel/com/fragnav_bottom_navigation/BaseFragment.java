package fragnav.miguel.com.fragnav_bottom_navigation;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BaseFragment extends Fragment {

    public static final String ARGS_INSTANCE = "com.ncapdevi.sample.argsInstance";

    FragmentNavigation mFragmentNavigation;

    private TextView textview;

    public BaseFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentNavigation) {
            mFragmentNavigation = (FragmentNavigation) context;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        /*mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mFragmentNavigation != null) {
                    mFragmentNavigation.pushFragment(RecentsFragment.newInstance(mInt + 1));
                }
            }
        });
        mButton.setText(getClass().getSimpleName() + " " + mInt);*/
    }


    public interface FragmentNavigation {
        public void pushFragment(Fragment fragment);
    }

}
