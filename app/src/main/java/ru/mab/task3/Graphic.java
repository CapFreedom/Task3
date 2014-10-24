package ru.mab.task3;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;



public class Graphic extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphic);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.graphic, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.activity_graphic, container, false);
            GraphView graphView = new LineGraphView(
                    this // context
                    , new GraphViewData[] {
                    new GraphViewData(1, 2.0d)
                    , new GraphViewData(2, 1.5d)
                    , new GraphViewData(2.5, 3.0d) // another frequency
                    , new GraphViewData(3, 2.5d)
                    , new GraphViewData(4, 1.0d)
                    , new GraphViewData(5, 3.0d)
            } // data
                    , "GraphViewDemo" // heading
                    , null // dynamic labels
                    , null // dynamic labels
            );
            LinearLayout layout = (LinearLayout) findViewById(R.id.graph1);
            layout.addView(graphView);
            return rootView;
        }
    }
}
