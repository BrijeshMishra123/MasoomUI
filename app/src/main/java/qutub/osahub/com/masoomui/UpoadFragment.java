package qutub.osahub.com.masoomui;

/**
 * Created by Qutub on 7/27/2015.
 */

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;

import android.provider.MediaStore;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class UpoadFragment extends DialogFragment {
    ArrayAdapter<HomePojo> chatArrayAdapter;
    Bitmap bp;
    SharedPreferences prefs;// = getActivity().getSharedPreferences("osahub", Context.MODE_PRIVATE);

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_upoad, container, false);
        ListView v = (ListView) rootView.findViewById(R.id.listView2);
        ListView v1 = (ListView) rootView.findViewById(R.id.listView3);
        prefs = getActivity().getSharedPreferences("osahub", Context.MODE_PRIVATE);
        File folder = getActivity().getApplicationContext().getDir("images", Context.MODE_PRIVATE);
        String p = prefs.getString("mypath", "");
        File myImage = new File(folder, p);
        Uri imageUri;
        imageUri = Uri.fromFile(myImage);
        try {
            bp = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), imageUri);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HomePojo home1 = new HomePojo("dwarka", "brijesh", "2/6/2015", bp);
        List<HomePojo> photos = new ArrayList<HomePojo>();
        // photos.add(home);
        photos.add(home1);
        chatArrayAdapter = new HomeAdapter(getActivity(), photos);
        v.setAdapter(chatArrayAdapter);
        v1.setAdapter(chatArrayAdapter);

        //
        //
        return rootView;
    }
}