package fragments.android.example.com.test1;

import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class DetailActivity extends ActionBarActivity {

    public static String EXTRA_URL = "id:";
    public int id;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Check", "onDestroy DetailActivity"+this.id);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Check", "onStop DetailActivity"+this.id);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Check", "onCreate DetailActivity"+this.id);


        // ขณะนี้หน้าจอเป็นอยู่ Landscape หรือป่าว ไม่เช่นนั้นจะใช้ detail_fragment ใน Main Activity แทน
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            //return;
        } else {
            setContentView(R.layout.activity_detail);

            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                Integer id = extras.getInt(EXTRA_URL);
                this.id = id;
                DetailFragment detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.detailFragment);
                detailFragment.setText(id);
            }
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Check","onResume DetailActivity"+this.id);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
