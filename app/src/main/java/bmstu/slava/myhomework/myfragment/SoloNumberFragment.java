package bmstu.slava.myhomework.myfragment;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bmstu.slava.myhomework.R;
import bmstu.slava.myhomework.datasouce.DataSource;

/**
 * A simple {@link Fragment} subclass.
 */
public class SoloNumberFragment extends BaseFragment {
    public static final String TAG = "SoloNumberFragment";

    private Integer number;
    private int color;
    private TextView numberView;

    public void setNumber(DataSource source) {
        Bundle bundle = new Bundle();
        bundle.putInt("number", source.getNumber());
        bundle.putInt("color", source.getColor());
        setArguments(bundle);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle == null) {
            return;
        }

        number = bundle.getInt("number");
        color = bundle.getInt("color");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_solo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        numberView = view.findViewById(R.id.numberView);
        numberView.setText(number.toString());
        numberView.setTextColor(color);
    }
}
