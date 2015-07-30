package qutub.osahub.com.masoomui;

/**
 * Created by Qutub on 7/27/2015.
 */
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by ankit on 7/19/2015.
 */
public class Ngo extends DialogFragment {
    Button button1,button2,button3,button4,button5,button6,button7;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.ngo, container, false);
        button1=(Button)rootView.findViewById(R.id.button1);
        button2=(Button)rootView.findViewById(R.id.button2);
        button3=(Button)rootView.findViewById(R.id.button3);
        button4=(Button)rootView.findViewById(R.id.button4);
        button5=(Button)rootView.findViewById(R.id.button5);
        button6=(Button)rootView.findViewById(R.id.button6);
        button7=(Button)rootView.findViewById(R.id.button7);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder obj1 = new AlertDialog.Builder(getActivity());
                obj1.setTitle("M.Venkatarangaiya Foundation");
                obj1.setMessage("Address:\n" +
                        "201, Narayan Apartments,\n" +
                        "West Marredpally, \n" +
                        "Secunderabad - 500026, AP India. \n" +
                        "Phone: +91 (40) 2780-1320\n" +
                        "Fax: +91 (40) 2780-8808");
                obj1.setPositiveButton("Website link", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        String url = "http://www.mvfindia.in";
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);

                    }
                });

                obj1.setNegativeButton("Back", null);
                obj1.show();

            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder obj1 = new AlertDialog.Builder(getActivity());
                obj1.setTitle("Ahwaan Foundation");
                obj1.setMessage("Address :\n" +
                        "1820/2 1st Floor,\n" +
                        "Gurudwara Road,\n" +
                        "Kotla Mubarakpur,\n" +
                        "New Delhi -110049 \n" +
                        "India \n" +
                        "Tel: 01124508967");
                obj1.setPositiveButton("Website link", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        String url = "http://www.ahwaanfoundation.com";
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);

                    }
                });

                obj1.setNegativeButton("Back", null);
                obj1.show();

            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder obj1 = new AlertDialog.Builder(getActivity());
                obj1.setTitle(" AVANI");
                obj1.setMessage("Contact details :\n" +
                        "Sangli Office :  14/51, Gokak Sadan\n" +
                        "Kala Nagar,P. Box : 49,\n" +
                        "Sangli 416 416\n" +
                        "Maharashtra State\n" +
                        "INDIA\n" +
                        "Ph : +91-233-2310 288\n" +
                        "Fax : + 91-233-2310 288");
                obj1.setPositiveButton("Website link", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        String url = "http://www.verala.org";
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);

                    }
                });

                obj1.setNegativeButton("Back", null);
                obj1.show();

            }
        });


        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder obj1 = new AlertDialog.Builder(getActivity());
                obj1.setTitle("Prayas, New Delhi");
                obj1.setMessage("Prayas Institute of Juvenile Justice\n" +
                        "Address:\n" +
                        "59, Tughlakabad institutional Area,\n" +
                        "New Delhi- 110062\n" +
                        "Telefax: 29956244, 29955505");
                obj1.setPositiveButton("Website link", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        String url = "http://www.prayasonline.org";
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);

                    }
                });

                obj1.setNegativeButton("Back", null);
                obj1.show();

            }
        });


        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder obj1 = new AlertDialog.Builder(getActivity());
                obj1.setTitle("Sneh Prayas");
                obj1.setMessage("Address:\n" +
                        "3-4, Manmohan Complex\n" +
                        "B/h Navrangpura Police Station\n" +
                        "Navrangpura Village\n" +
                        "Navrangpura,\n" +
                        "Ahmedabad-380009.\n" +
                        "Telefax: 0091-79-26461777");
                obj1.setPositiveButton("Website link", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        String url = "http:// www.snehprayas.org";
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);

                    }
                });

                obj1.setNegativeButton("Back", null);
                obj1.show();

            }
        });


        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder obj1 = new AlertDialog.Builder(getActivity());
                obj1.setTitle("CRY - Child Rights and You");
                obj1.setMessage("Address\n"+
                        "632, Lane No.3, Westend Marg,\n" +
                        "Near Saket Metro Station, Saiyad-ul-Ajaib\n" +
                        "New Delhi - 110 030.\n" +
                        "Tel - 91-11-29533451/52/53\n" +
                        "Tel – 91-11-29531835\n" +
                        "Fax - 91-11-29533732\n" +
                        "e-mail: cryinfo.del@crymail.org");
                obj1.setPositiveButton("Website link", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        String url = "http://www.cry.org";
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);

                    }
                });

                obj1.setNegativeButton("Back", null);
                obj1.show();

            }
        });



        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder obj1 = new AlertDialog.Builder(getActivity());
                obj1.setTitle("Bachapan Bachao Andolan");
                obj1.setMessage("Central Office:\n" +
                        "L- 6, Kalkaji, \n" +
                        "New Delhi- 110019, India \n" +
                        "Phone: 91 11 2647 5481, 2622 4899\n" +
                        "Mobile: 9212089894, 9212023778\n" +
                        "Fax: 91 11 2623 6818");
                obj1.setPositiveButton("Website link", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        String url = "http://www.bba.org.in";
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);

                    }
                });

                obj1.setNegativeButton("Back", null);
                obj1.show();

            }
        });

        return rootView;
    }
}
