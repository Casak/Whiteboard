package ru.casak.whiteboard;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;

public class WhiteboardActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whiteboard);

        ImageView trash = (ImageView) findViewById(R.id.trash_button);
        trash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrawView.clear();
            }
        });

        Spinner colorSpinner = (Spinner) findViewById(R.id.color_spinner);
        colorSpinner.setAdapter(new IconAdapter(getApplicationContext(),
                new Integer[]{
                        R.drawable.black_icon,
                        R.drawable.blue_icon,
                        R.drawable.green_icon,
                        R.drawable.red_icon
                }));
        colorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        DrawView.setColor(DrawView.BLACK);
                        break;
                    case 1:
                        DrawView.setColor(DrawView.BLUE);
                        break;
                    case 2:
                        DrawView.setColor(DrawView.GREEN);
                        break;
                    case 3:
                        DrawView.setColor(DrawView.RED);
                        break;
                    default:
                        DrawView.setColor(DrawView.BLACK);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner widthSpinner = (Spinner) findViewById(R.id.width_spinner);;
        widthSpinner.setAdapter(new IconAdapter(getApplicationContext(),
                new Integer[]{
                        R.drawable.thin_icon,
                        R.drawable.medium_thin_icon,
                        R.drawable.medium_icon,
                        R.drawable.bold_icon
                }));
        widthSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        DrawView.setWidth(DrawView.THIN);
                        break;
                    case 1:
                        DrawView.setWidth(DrawView.MEDIUM_THIN);
                        break;
                    case 2:
                        DrawView.setWidth(DrawView.MEDIUM);
                        break;
                    case 3:
                        DrawView.setWidth(DrawView.BOLD);
                        break;
                    default:
                        DrawView.setWidth(DrawView.THIN);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}



