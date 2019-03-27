package patwa.aman.com.hackathon;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class college_login extends AppCompatActivity {


    TextInputLayout collegename;
    TextInputLayout email;
    TextInputLayout uniquekey;
    Button register;
    DatabaseReference colleges;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_login);

        colleges= FirebaseDatabase.getInstance().getReference("colleges");
        collegename=(TextInputLayout) findViewById(R.id.college_name);
        email=(TextInputLayout) findViewById(R.id.college_email);
        uniquekey=(TextInputLayout) findViewById(R.id.college_uniquekey);
        register=(Button)findViewById(R.id.college_login);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(college_login.this,"Successfully Registered",Toast.LENGTH_SHORT).show();

                String name=collegename.getEditText().getText().toString();
                String emailname=email.getEditText().getText().toString();
                String unique=uniquekey.getEditText().getText().toString();

                if(name.isEmpty() && emailname.isEmpty() && unique.isEmpty()){

                    Toast.makeText(college_login.this,"Please Enter Valid Details",Toast.LENGTH_SHORT).show();
                }
                else{
                    HashMap<String ,String > collegHack=new HashMap<>();
                    collegHack.put("email",emailname);
                    collegHack.put("key",unique);
                    colleges.child(name).setValue(collegHack).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Log.d("","Login");
                        }
                    });
                    Intent mainCollegeIntent=new Intent(college_login.this,CollegeMainActivity.class);
                    mainCollegeIntent.putExtra("college_name",name);
                    startActivity(mainCollegeIntent);
                }
            }






        });




    }


}
