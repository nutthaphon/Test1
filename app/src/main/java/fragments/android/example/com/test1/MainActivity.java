package fragments.android.example.com.test1;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity implements HeaderFragment.OnItemSelectedListener{

    public int id=0;
    public static String SAVE_ID="id";
    public boolean intentToDetailActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Log.i("Check", "onCreate MAINACTIVITY"+this.id);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Check:","onDestroy MAINACTIVITY"+this.id);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Check:","onStop MAINACTIVITY"+this.id);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Not first time created and rotate to Land show current Items
        if (this.id>0) {
            if ((getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) || (!intentToDetailActivity)) {
                onItemSelected(this.id);
            }
        }
        Log.i("Check:","onResume MAINACTIVITY"+this.id);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(SAVE_ID,this.id);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        this.id = savedInstanceState.getInt(SAVE_ID);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1) {
            intentToDetailActivity=true;
            Log.i("Check","Intent to Detail Activity with "+resultCode);
        }
    }

    @Override
    public void onItemSelected(int id) {

        DetailFragment fragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.detailFragment);

        this.id = id;
        if (fragment != null && fragment.isInLayout()) {

            // ถ้าหน้าจอเป็น Landscape เรียกไปยัง Detail Fragment
            fragment.setText(id);
        } else {

            intentToDetailActivity=false;
            // ถ้าหน้าจอเป็น Portrait สร้าง Intent ไป Detail Activity
            // Layout activity_main.xml จะไม่มี Detail Fragment อยู่
            Intent intent = new Intent(getApplicationContext(),DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_URL, id);
            //startActivity(intent);
            startActivityForResult(intent,1);

        }
    }
}
