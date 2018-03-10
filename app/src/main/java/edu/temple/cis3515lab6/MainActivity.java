package edu.temple.cis3515lab6;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends Activity implements PaletteFragment.OnColorSelectedListener{

    PaletteFragment paletteFragment;
    CanvasFragment canvasFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // add fragments
        FragmentManager fragmentManager = getFragmentManager();

        paletteFragment = (PaletteFragment) fragmentManager.findFragmentById(R.id.paletteLayout);
        if (paletteFragment == null){
            paletteFragment = new PaletteFragment();
            fragmentManager.beginTransaction().add(R.id.mainLayout, paletteFragment).commit();
        }

        canvasFragment = (CanvasFragment) fragmentManager.findFragmentById(R.id.canvasLayout);
        if (canvasFragment == null){
            canvasFragment = new CanvasFragment();
            fragmentManager.beginTransaction().add(R.id.mainLayout, canvasFragment).commit();
        }
    }

    @Override
    public void onColorSelected(int position) {
        canvasFragment.updateBackgroundColor(position);
    }
}
