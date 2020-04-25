package com.example.dscrecyclerviewandalertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final static String[] pictureNames = {
            "Rocket in the universe",
            "A scene in London",
            "Moon over mountains",
            "A simple moon",
            "Sun and volcano",
            "A collection of mountains",
            "River between mountains",
            "Some pine trees",
            "On Small Town",
            "Volcanoes reflection"
    };

    private final static Integer pictureImages[] = {
            R.drawable.cohete_flat,
            R.drawable.london_flat,
            R.drawable.material_flat,
            R.drawable.moon_flat,
            R.drawable.mountain_flat,
            R.drawable.mountain_mo_flat,
            R.drawable.moutain_go_flat,
            R.drawable.pine_flat,
            R.drawable.towers_flat,
            R.drawable.vulcan_flat
    };

    RecyclerView rv;
    OurRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv);
        adapter = new OurRecyclerViewAdapter(createImagesList(), new OurRecyclerViewAdapter.SelectionPropagator() {
            @Override
            public void propagateSelection(ImageModel image) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(R.string.dialog_title);
                builder.setMessage(getString(R.string.dialog_message_p1) +image.getName());
                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();

                Button btnPositive = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                btnPositive.setTextColor(getColor(R.color.colorPrimary));
                btnPositive.setBackgroundColor(Color.parseColor("#FFFFFF"));

            }
        });
        rv.setAdapter(adapter);


/*
        rv.setLayoutManager(new GridLayoutManager(
                this,
                3,
                RecyclerView.HORIZONTAL,
                false));
*/
        rv.setLayoutManager(new LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false));
    }

    private ArrayList<ImageModel> createImagesList(){
        ArrayList<ImageModel> pictures = new ArrayList<>();

        ArrayList<String> pictureNamesList = new ArrayList<>(Arrays.asList(pictureNames));
        List picturesImagesList =  new ArrayList<>(Arrays.asList(pictureImages));

        for(int i = 0; i < 10; i++){
            ImageModel pictureToAdd = new ImageModel((Integer) picturesImagesList.get(i), pictureNamesList.get(i));
            pictures.add(pictureToAdd);
        }
        return pictures;
    }
}
