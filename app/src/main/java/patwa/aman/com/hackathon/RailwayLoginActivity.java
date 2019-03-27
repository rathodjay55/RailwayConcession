package patwa.aman.com.hackathon;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RailwayLoginActivity extends AppCompatActivity {


    TextInputLayout adminName,uniqueId,email;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_railway_login);

        adminName=findViewById(R.id.railway_name);
        uniqueId=findViewById(R.id.railway_uniquekey);
        email=findViewById(R.id.railway_email);
        login=findViewById(R.id.railway_login);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String admin=adminName.getEditText().getText().toString();
                String key=uniqueId.getEditText().getText().toString();
                String gmail=email.getEditText().getText().toString();

                if(admin.isEmpty() && key.isEmpty() && gmail.isEmpty()){
                    Toast.makeText(RailwayLoginActivity.this, "Please Enter Valid Details!!", Toast.LENGTH_SHORT).show();
                }
                else if(admin.equals("admin") && key.equals("1234") && gmail.equals("admin@gmail.com")){
                    Intent mainRailwayIntent=new Intent(RailwayLoginActivity.this,RailwayMainActivity.class);
                    startActivity(mainRailwayIntent);
                }
            }
        });
    }
}
