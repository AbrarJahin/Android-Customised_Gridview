package com.app_gallery.customisedgridview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;
import java.util.Random;

public class Activity_Main extends Activity
{
    private GridView gridView;
    private ArrayList<Model_GridView> gridViewValueArrray = new ArrayList<Model_GridView>();

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.gridViewMain);

        getValuesToShowInGrid();

        gridView.setAdapter(new Adapter_GridView(this, gridViewValueArrray));

        //Setting on click listener for clicking each item of gridview..............................
        gridView.setOnItemClickListener(new OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                //getting value -> ((TextView) v.findViewById(R.id.tv_label)).getText()
                Toast.makeText(
                        getApplicationContext(),gridViewValueArrray.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getValuesToShowInGrid()
    {
        //Generate 4 random data
        String[] MOBILE_OS = new String[] { "Android", "iOS",
                "Windows", "Blackberry", "Boss Phone", "My OS" };
        int[] image={R.drawable.abc_ic_menu_paste_mtrl_am_alpha,R.drawable.abc_ic_ab_back_mtrl_am_alpha
                    ,R.drawable.abc_ic_menu_selectall_mtrl_alpha,R.drawable.abc_ic_clear_mtrl_alpha
                    ,R.drawable.arow_down,R.drawable.abc_ic_menu_share_mtrl_alpha};

        //Storing those data
        for (int i = 0; i < MOBILE_OS.length && i < image.length; i++)
        {
            final Model_GridView all_current_data = new Model_GridView();

            /******* Firstly take data in model object ******/  //Same as in the model                                  //Update here////////////////////
            all_current_data.setName(MOBILE_OS[i]);
            all_current_data.setImage(image[i]);
            all_current_data.setPrice(randInt(i*1000,(i+1)*10000));
            /******** Take Model Object in ArrayList **********/
            gridViewValueArrray.add(all_current_data);
        }
    }

    //generating a random integer
    private int randInt(int min, int max)
    {
    // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}
