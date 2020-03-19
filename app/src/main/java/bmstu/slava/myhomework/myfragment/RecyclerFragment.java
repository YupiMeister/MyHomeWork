package bmstu.slava.myhomework.myfragment;


import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bmstu.slava.myhomework.R;
import bmstu.slava.myhomework.clicklestener.MyClickListener;
import bmstu.slava.myhomework.datasouce.DataList;
import bmstu.slava.myhomework.datasouce.DataSource;
import bmstu.slava.myhomework.myadapter.MyDataAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerFragment extends BaseFragment implements MyClickListener {
    public static final String TAG = "RecyclerFragment";
    public static final int DEFAULT_VALUE = 100;

    private MyDataAdapter mAdapter;
    private int dataSize = DEFAULT_VALUE;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_grid, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (savedInstanceState != null) {
            dataSize = savedInstanceState.getInt("counterElements");
        }

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list);

        Button button = (Button) view.findViewById(R.id.button_add);
        button.setOnClickListener(v -> {
            DataList.getInstance(dataSize).addList();
            mAdapter.notifyDataSetChanged();
        });

        mAdapter = new MyDataAdapter(DataList.getInstance(dataSize).getData(), this);
        int counterColumns = getResources().getInteger(R.integer.counter_columns);

        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), counterColumns));
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("counterElements", mAdapter.getmData().size());
    }

    @Override
    public void onSoloClick(DataSource source) {
        if (getActivity() == null || !(getActivity() instanceof MyClickListener)) {
            return;
        }

        ((MyClickListener) getActivity()).onSoloClick(source);
    }
}
