package qutub.osahub.com.masoomui;

/**
 * Created by Qutub on 7/27/2015.
 */
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class InformationFragment extends DialogFragment {

    Bitmap bp;
    SharedPreferences prefs ;//= getActivity().getSharedPreferences("osahub", Context.MODE_PRIVATE);


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.information, container, false);
        TextView t = (TextView) rootView.findViewById(R.id.info);
        t.setText("Rakshak");
        ListView list = (ListView) rootView.findViewById(R.id.listview4);
        prefs = getActivity().getSharedPreferences("osahub", Context.MODE_PRIVATE);
        File folder = getActivity().getApplicationContext().getDir("images", Context.MODE_PRIVATE);
        String p=     prefs.getString("mypath","");

        File myImage = new File(folder, p);
        Uri imageUri;
        imageUri = Uri.fromFile(myImage);

        try {
            bp = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), imageUri);
        } catch (IOException e) {
            e.printStackTrace();
        }


        HomePojo home1 = new HomePojo("dwarka", "brijesh", "2/6/2015", bp);
        HomePojo home2 = new HomePojo("dwarka", "brijesh", "2/6/2015", bp);
        List<HomePojo> photos = new ArrayList<HomePojo>();
        photos.add(home1);
        photos.add(home2);
        ArrayAdapter<HomePojo> chatArrayAdapter = new HomeAdapter(getActivity(), photos);
        list.setAdapter(chatArrayAdapter);
        return rootView;


    }
}
