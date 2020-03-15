package bmstu.slava.myhomework.datasouce;

import java.util.ArrayList;
import java.util.List;

public class DataList {
    private static DataList dataList;
    private final List<DataSource> sData;
    private int i;

    public List<DataSource> getData() {
        return sData;
    }

    public void addList() {
        sData.add(new DataSource(i));
        i++;
    }

    public synchronized static DataList getInstance() {
        if (dataList == null) {
            dataList = new DataList();
        }

        return dataList;
    }

    private DataList() {
        sData = new ArrayList<DataSource>();
        i = 1;

        for (; i <= 100; i++) {
            sData.add(new DataSource(i));
        }
    }
}
