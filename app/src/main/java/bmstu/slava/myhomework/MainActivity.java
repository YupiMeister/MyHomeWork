package bmstu.slava.myhomework;

import android.util.Log;
import android.os.Bundle;
import bmstu.slava.myhomework.clicklestener.MyClickListener;
import bmstu.slava.myhomework.datasouce.DataSource;
import bmstu.slava.myhomework.myfragment.RecyclerFragment;
import bmstu.slava.myhomework.myfragment.SoloNumberFragment;

public class MainActivity extends BaseActivity implements MyClickListener {
    private RecyclerFragment recyclerFragment;
    private SoloNumberFragment soloNumberFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerFragment = (RecyclerFragment) getSupportFragmentManager().findFragmentByTag(RecyclerFragment.TAG);
        soloNumberFragment = (SoloNumberFragment) getSupportFragmentManager().findFragmentByTag(SoloNumberFragment.TAG);

        if (recyclerFragment == null) {
            recyclerFragment = new RecyclerFragment();
        }

        if (soloNumberFragment == null) {
            soloNumberFragment = new SoloNumberFragment();
        }

        showRecyclerFragment();
    }

    @Override
    public void onSoloClick(DataSource source) {
        showSoloNumberFragment(source);
    }

    private void showSoloNumberFragment(DataSource source) {
        soloNumberFragment.setNumber(source);

        if (getSupportFragmentManager().findFragmentByTag(SoloNumberFragment.TAG) != null) {
            Log.wtf(MainActivity.class.toString(), "SoloNumberFragment execute twice");
            return;
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, soloNumberFragment, SoloNumberFragment.TAG)
                .addToBackStack(SoloNumberFragment.TAG)
                .commit();
    }

    private void showRecyclerFragment() {
        if(getSupportFragmentManager().findFragmentByTag(RecyclerFragment.TAG) != null) {
            return;
        }

        getSupportFragmentManager().beginTransaction()
                .add(R.id.content, recyclerFragment, RecyclerFragment.TAG)
                .commit();
    }
}
