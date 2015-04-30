package fragments.android.example.com.test1;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity implements HeaderFragment.OnItemSelectedListener{

    private int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Check:","Before onSaveInstanceState()...");
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
    public void onItemSelected(int id) {

        DetailFragment fragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.detailFragment);


        if (fragment != null && fragment.isInLayout()) {

            // ถ้าหน้าจอเป็น Landscape เรียกไปยัง Detail Fragment
            fragment.setText(id);
        } else {

            // ถ้าหน้าจอเป็น Portrait สร้าง Intent ไป Detail Activity
            // Layout activity_main.xml จะไม่มี Detail Fragment อยู่
            Intent intent = new Intent(getApplicationContext(),DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_URL,id);
            startActivity(intent);
        }
    }
}
