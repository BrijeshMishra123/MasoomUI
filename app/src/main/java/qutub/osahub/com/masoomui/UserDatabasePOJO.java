package qutub.osahub.com.masoomui;

/**
 * Created by Qutub on 7/27/2015.
 */
public class UserDatabasePOJO {

        String name;
        String password;
        String mobile;
        String email;

        public UserDatabasePOJO()
        {
           // name="";
           // password="";

         //   mobile="";
          //  email="";

        }
        public UserDatabasePOJO(String name1,String email1,String mobile1,String password1)
        {
            this.name=name1;
            this.password=password1;
            this.email=email1;
            this.mobile=mobile1;
        }
        public UserDatabasePOJO(String name1,String email1,String password1)
        {
            this.name=name1;
            this.password=password1;
            this.email=email1;

         }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
