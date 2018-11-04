package fragnav.miguel.com.fragnav_bottom_navigation;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {

    public static final String ARGS_INSTANCE = "com.ncapdevi.sample.argsInstance";


    private TextView textview;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(int instance, String label) {
        Bundle args = new Bundle();
        args.putInt(ARGS_INSTANCE, instance);
        args.putString("label", label);
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        textview = view.findViewById(R.id.tv_number);


        if (getArguments() != null) {
            textview.setText(getArguments().getString("label"));
        } else {
            textview.setText("label");
        }

        return view;
    }

}
