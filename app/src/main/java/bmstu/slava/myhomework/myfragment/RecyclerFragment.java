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
    private final int COLUMNS_HORIZONTAL = 4;
    private final int COLUMNS_VERTICAL = 3;

    private MyDataAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_grid, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list);

        Button button = (Button) view.findViewById(R.id.button_add);
        button.setOnClickListener(v -> {
            DataList.getInstance().addList();
            mAdapter.notifyDataSetChanged();
        });

        mAdapter = new MyDataAdapter(DataList.getInstance().getData(), this);
        int horizontal = getResources().getBoolean(R.bool.is_horizontal) ?
                GridLayoutManager.HORIZONTAL : GridLayoutManager.VERTICAL;

        if (horizontal == GridLayoutManager.HORIZONTAL) {
            recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), COLUMNS_HORIZONTAL));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), COLUMNS_VERTICAL));
        }

        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onSoloClick(DataSource source) {
        if (getActivity() == null || !(getActivity() instanceof MyClickListener)) {
            return;
        }

        ((MyClickListener) getActivity()).onSoloClick(source);
    }
}
