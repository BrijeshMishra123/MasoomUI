package qutub.osahub.com.masoomui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class Signup extends ActionBarActivity {
    EditText name,emailid,number,password;
    ImageButton submit,image;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name=(EditText)findViewById(R.id.name);
        emailid=(EditText)findViewById(R.id.emailid);
        number=(EditText)findViewById(R.id.number);
        password=(EditText)findViewById(R.id.password);
        image=(ImageButton)findViewById(R.id.image);
        submit=(ImageButton)findViewById(R.id.submit);



        SharedPreferences prefs= getSharedPreferences("osahub",MODE_PRIVATE);
        if(prefs.contains("imagePath"))
        {
            String path=prefs.getString("imagePath", "");
            if(path!=null&& !path.equals("")){
                try{
                    File file= new File(path,"camera.jpg");
                    Bitmap b= BitmapFactory.decodeStream(new FileInputStream(file));
                    image.setImageBitmap(b);


                }catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        }

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 10);


            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Toast.makeText(getActivity(),"registered", Toast.LENGTH_LONG).show();
                if (name.getText().toString().length() == 0) {

                    name.setHint("Field should not be empty");
                    name.setHintTextColor(getResources().getColor(R.color.red));
                }
                if (emailid.getText().toString().length() == 0) {

                    emailid.setHint("Field should not be empty");
                    emailid.setHintTextColor(getResources().getColor(R.color.red));
                }
                if (password.getText().toString().length() == 0) {

                    password.setHint("Field should not be empty");
                    password.setHintTextColor(getResources().getColor(R.color.red));
                } else {
                    Toast.makeText(getApplicationContext(), "registered", Toast.LENGTH_LONG).show();
                    Database database= new Database(getApplicationContext());
                    database.saveLoginInfo(database,name.getText().toString(),password.getText().toString(),emailid.getText().toString(),number.getText().toString());
                    //store all the data  entered by user to database
                    //" "don't" send the user to home page
                    Intent objmain= new Intent(getApplicationContext(),FirstActivity.class);
                    startActivity(objmain);
                }


            }
        });
    }
    protected void onActivityResult(int requestCode,int responseCode,Intent data){

        super.onActivityResult(requestCode,responseCode,data);
        Bitmap bp=(Bitmap)data.getExtras().get("data");
        saveImage(bp);
        image.setImageBitmap(bp);
    }
    protected void saveImage(Bitmap bp)
    {
        File folder=getApplicationContext().getDir("images", Context.MODE_PRIVATE);
        File myImage=new File(folder,"camera.jpg");
        try{
            FileOutputStream obj=new FileOutputStream(myImage);
            bp.compress(Bitmap.CompressFormat.JPEG,100,obj);
            obj.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        SharedPreferences prefs=getSharedPreferences("osahub", MODE_PRIVATE);
        SharedPreferences.Editor edit=prefs.edit();
        edit.putString("imagePath",folder.getAbsolutePath());
        edit.apply();
    }
}