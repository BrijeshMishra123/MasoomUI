package qutub.osahub.com.masoomui;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;


public class FirstActivity extends ActionBarActivity {

    ImageButton login1,signup1;
    EditText email1,pass1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ImageView iv = (ImageView) findViewById(R.id.imageLogo);
         login1=(ImageButton)findViewById(R.id.login);
        signup1=(ImageButton)findViewById(R.id.signup);
        email1=(EditText)findViewById(R.id.email);
        pass1=(EditText)findViewById(R.id.pass);
        login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email1.getText().toString().length()==0)
                {
                    email1.setHint("enter email");
                    email1.setHintTextColor(getResources().getColor(R.color.red));
                }
                if(pass1.getText().toString().length()==0)
                {
                    pass1.setHint("enter password");
                    pass1.setHintTextColor(getResources().getColor(R.color.red));
                }
                Database obj = new Database(getApplicationContext());
                List< UserDatabasePOJO> contacts=obj.getLoginInfo(obj, email1.getText().toString());
                String pass=pass1.getText().toString();
                String email=email1.getText().toString();
                int flag=1;

                    for (int i = 0; i < contacts.size(); i++) {

                        //  contacts.get(i).getName());
                        if (pass.equals(contacts.get(i).getPassword()) && email.equals(contacts.get(i).getEmail())) {
                            //  contacts.get(i).getEmail());


                            //if passward and email match then go to home page using intent
                            Intent objmain = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(objmain);
                        }
                    }






                      /*  Toast toast = Toast.makeText(getApplicationContext(), "wrong email and password",
                                Toast.LENGTH_SHORT);
                        toast.show();
                        Intent objmain = new Intent(getApplicationContext(), FirstActivity.class);
                        startActivity(objmain);*/





            }
        });
        signup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent objmain= new Intent(getApplicationContext(),Signup.class);
                startActivity(objmain);

            }
        });




    }


}