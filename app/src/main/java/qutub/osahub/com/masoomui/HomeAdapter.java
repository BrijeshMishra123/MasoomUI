package qutub.osahub.com.masoomui;

/**
 * Created by Qutub on 7/27/2015.
 */

import android.app.Activity;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;

        import java.util.ArrayList;
        import java.util.List;

/**
 * Created by ankit on 7/17/2015.
 */
public class HomeAdapter extends ArrayAdapter<HomePojo> {
    LayoutInflater inflater;
    List<HomePojo> photos=new ArrayList<>();
    public HomeAdapter(Activity activity,List<HomePojo> objects) {
        super(activity,R.layout.photolist,objects);
        photos=objects;
        inflater=activity.getWindow().getLayoutInflater();

    }
    public View getView(int position,View view,ViewGroup parent)
    {
        View rootView=inflater.inflate(R.layout.photolist,parent,false);

        TextView name=(TextView) rootView.findViewById(R.id.username);
        name.setText(photos.get(position).getName());
        TextView date=(TextView) rootView.findViewById(R.id.date);
        date.setText(photos.get(position).getDate());
        TextView place=(TextView) rootView.findViewById(R.id.place);
        place.setText(photos.get(position).getPlace());
        ImageView imageview=(ImageView)rootView.findViewById(R.id.imageView);
        imageview.setImageBitmap(photos.get(position).getImage());

        return rootView;

    }

}
