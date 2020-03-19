package bmstu.slava.myhomework.myadapter;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import bmstu.slava.myhomework.R;
import bmstu.slava.myhomework.clicklestener.MyClickListener;
import bmstu.slava.myhomework.datasouce.DataList;
import bmstu.slava.myhomework.datasouce.DataSource;
import bmstu.slava.myhomework.myfragment.RecyclerFragment;

public class MyViewHolder extends RecyclerView.ViewHolder {
    private final TextView textNumber;

    public MyViewHolder(@NonNull View itemView, final MyClickListener myClickListener) {
        super(itemView);

        textNumber = itemView.findViewById(R.id.number);

        textNumber.setOnClickListener(v -> {
            int pos = getAdapterPosition();
            DataSource source = DataList.getInstance(RecyclerFragment.DEFAULT_VALUE).getData().get(pos);

            myClickListener.onSoloClick(source);
        });
    }

    public TextView getTextNumber() {
        return textNumber;
    }
}
