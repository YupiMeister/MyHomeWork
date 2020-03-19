package bmstu.slava.myhomework.datasouce;

import android.util.Log;
import bmstu.slava.myhomework.myfragment.RecyclerFragment;

import java.util.ArrayList;
import java.util.List;

public class DataList {
    private static DataList dataList;
    private final List<DataSource> sData;
    private int counterNumbers;

    public List<DataSource> getData() {
        return sData;
    }

    public void addList() {
        counterNumbers++;
        sData.add(new DataSource(counterNumbers));
    }

    public synchronized static DataList getInstance(int counterNumbers) {
        if (dataList == null) {
            dataList = new DataList(counterNumbers);

            Log.d("getInstance", "GetINSTANCE");
        }

        return dataList;
    }

    private DataList(int counterNumbers) {
        sData = new ArrayList<DataSource>(counterNumbers + counterNumbers / 2);
        this.counterNumbers = counterNumbers;

        for (int i = 1; i <= counterNumbers; i++) {
            sData.add(new DataSource(i));
        }
    }
}
