package qutub.osahub.com.masoomui;

/**
 * Created by Qutub on 7/27/2015.
 */
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ankit on 7/17/2015.
 */
public class HomeFragment extends DialogFragment {
    ArrayAdapter<HomePojo> chatArrayAdapter;
    ImageView iv;
    Bitmap bp;
    ListView v;
    SharedPreferences prefs ; //= getActivity().getSharedPreferences("osahub", Context.MODE_PRIVATE);



    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_home, container, false);

        v = (ListView) rootView.findViewById(R.id.listView);
        prefs= getActivity().getSharedPreferences("osahub", Context.MODE_PRIVATE);
        File folder = getActivity().getApplicationContext().getDir("images", Context.MODE_PRIVATE);
        String p=  prefs.getString("mypath","");

        File myImage = new File(folder, p);
        Uri imageUri;
        imageUri = Uri.fromFile(myImage);
        try {
            bp = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), imageUri);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap icon= BitmapFactory.decodeResource(getActivity().getResources(),R.drawable.myimage);

        HomePojo home1 = new HomePojo("dwarka", "brijesh", "2/6/2015", icon);
        List<HomePojo> photos = new ArrayList<>();
        photos.add(home1);
        chatArrayAdapter = new HomeAdapter(getActivity(), photos);
        v.setAdapter(chatArrayAdapter);
        ImageButton b = (ImageButton) rootView.findViewById(R.id.button1);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i, 0);
            }

        });


        return rootView;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        Bitmap bp = (Bitmap) data.getExtras().get("data");
        saveImage(bp);

    }

    protected void saveImage(Bitmap bp) {
        File folder = getActivity().getApplicationContext().getDir("images", Context.MODE_PRIVATE);

        String path = new Date().toString();
        File myImage = new File(folder, path);
        try {
            FileOutputStream obj = new FileOutputStream(myImage);
            bp.compress(Bitmap.CompressFormat.JPEG, 100, obj);
            obj.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        SharedPreferences.Editor editor = getActivity().getPreferences(Context.MODE_PRIVATE).edit();
        editor.putString("mypath",path);
        editor.apply();
    }
}
