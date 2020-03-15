package bmstu.slava.myhomework.datasouce;

import android.graphics.Color;

public class DataSource {
    Integer number;
    int color;

    public DataSource(Integer sNumber) {
        this.number = sNumber;

        if (sNumber % 2 == 0) {
            this.color = Color.RED;
        } else {
            this.color = Color.BLUE;
        }
    }

    public Integer getNumber() {
        return number;
    }

    public int getColor() {
        return color;
    }
}
