package bmstu.slava.myhomework.datasouce;

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
        sData.add(new DataSource(counterNumbers));
        counterNumbers++;
    }

    public synchronized static DataList getInstance() {
        if (dataList == null) {
            dataList = new DataList();
        }

        return dataList;
    }

    private DataList() {
        sData = new ArrayList<DataSource>();
        counterNumbers = 1;

        for (; counterNumbers <= 100; counterNumbers++) {
            sData.add(new DataSource(counterNumbers));
        }
    }
}
