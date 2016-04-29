package jp.ac.titech.itpro.sdl.hilbert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView levelView;
    private HilbertView hilbertView;
    private final static int MAX_N = 9;
    private int n = 1;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        levelView = (TextView)findViewById(R.id.level_view);
        hilbertView = (HilbertView)findViewById(R.id.hilbert_view);
        Log.d(TAG, "onCreate");
    }

    @Override
    protected void onResume() {
        super.onResume();
        display();
        Log.d(TAG, "onResume");
    }

    public void onClickDec(View v) {
        if (n > 1) n--;
        display();
    }

    public void onClickInc(View v) {
        if (n < MAX_N) n++;
        display();

    }

    private void display() {
        levelView.setText(getString(R.string.level_format, n));
        hilbertView.setLevel(n);
    }

    @Override
    protected void onStart() { // 同様にして onResume, onRestart, onPause, onStop,
        super.onStart(); // onDestroy も実装すること.全て protected で,返値は
        Log.d(TAG, "onStart"); // void,引数はなしである.
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        display();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        display();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        display();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        display();
        Log.d(TAG, "onDestroy");
    }
}
