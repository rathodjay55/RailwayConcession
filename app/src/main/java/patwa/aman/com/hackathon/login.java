package patwa.aman.com.hackathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class login extends AppCompatActivity {

    private Button student_login,college_login,railway_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        student_login=(Button)findViewById(R.id.login_student);
        college_login=(Button)findViewById(R.id.login_college);
        railway_login=(Button)findViewById(R.id.login_railway);

        student_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent studentIntent=new Intent(login.this,StudentDetailsActivity.class);
                startActivity(studentIntent);
            }
        });

        college_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent collegeIntent=new Intent(login.this,college_login.class);
                startActivity(collegeIntent);            }
        });

        railway_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent railwayIntent=new Intent(login.this,RailwayLoginActivity.class);
               startActivity(railwayIntent);
            }
        });
    }
}
