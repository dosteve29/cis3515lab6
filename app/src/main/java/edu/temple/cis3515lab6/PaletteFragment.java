package edu.temple.cis3515lab6;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PaletteFragment extends Fragment {
    OnColorSelectedListener mCallback;

    public PaletteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //get the inflated view
        View view = inflater.inflate(R.layout.fragment_palette, container, false);

        //set the color adapter to the gridView
        ColorAdapter colorAdapter = new ColorAdapter(getContext(), getResources().getStringArray(R.array.Colors));
        GridView gridView = view.findViewById(R.id.gridView);
        gridView.setAdapter(colorAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                mCallback.onColorSelected(position);
            }
        });
       return view;
    }

    //Container Activity must implement this interface
    public interface OnColorSelectedListener{
        void onColorSelected(int position);
    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);

        //Check if the container activity has implemented the callback interface
        try{
            mCallback = (OnColorSelectedListener) activity;
        } catch(ClassCastException e){
            throw new ClassCastException(getActivity().toString() + " must implement OnItemClickListener");
        }
    }

    @Override
    public void onDetach(){
        super.onDetach();
        mCallback = null;
    }
}
