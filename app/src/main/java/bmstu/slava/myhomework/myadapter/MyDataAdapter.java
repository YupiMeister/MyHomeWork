package bmstu.slava.myhomework.myadapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import bmstu.slava.myhomework.R;
import bmstu.slava.myhomework.clicklestener.MyClickListener;
import bmstu.slava.myhomework.datasouce.DataSource;

import java.util.List;

public class MyDataAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private MyClickListener listener;
    private final List<DataSource> mData;

    public MyDataAdapter(List<DataSource> mData, MyClickListener listener) {
        this.mData = mData;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_number, parent, false);
        return new MyViewHolder(v, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DataSource data = mData.get(position);

        holder.getTextNumber().setText(data.getNumber().toString());
        holder.getTextNumber().setTextColor(data.getColor());
        holder.getTextNumber().setBackgroundColor(Color.GRAY);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
