package patwa.aman.com.hackathon;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class StudentDetailsActivity extends AppCompatActivity {

    TextInputLayout studentname;
    TextInputLayout passnumber;
    TextInputLayout sapid;
    TextInputLayout phoneNumber;
    TextInputLayout address;
    TextInputLayout stationfrom;
    TextInputLayout collegename,duration,railwayClass;
    Button senddetails;
    private DatabaseReference studentDetail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        senddetails=(Button)findViewById(R.id.send_details);
        studentname=(TextInputLayout)findViewById(R.id.student_name);
        passnumber=(TextInputLayout)findViewById(R.id.student_pass_number);
        sapid=(TextInputLayout)findViewById(R.id.student_sapid);
        phoneNumber=(TextInputLayout)findViewById(R.id.student_phonenumber);
        address=(TextInputLayout)findViewById(R.id.student_address);
        stationfrom=(TextInputLayout)findViewById(R.id.student_fromstation);
        collegename=(TextInputLayout)findViewById(R.id.student_college);
        studentDetail= FirebaseDatabase.getInstance().getReference();
        duration=(TextInputLayout)findViewById(R.id.student_duration);
        railwayClass=(TextInputLayout)findViewById(R.id.student_railwayclass);


        senddetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(StudentDetailsActivity.this,"Details Sent",Toast.LENGTH_SHORT).show();

                String mstudentname=studentname.getEditText().getText().toString();
                String mpassnumber=passnumber.getEditText().getText().toString();
                String msapid = sapid.getEditText().getText().toString();
                String mPhoneNumber=phoneNumber.getEditText().getText().toString();
                String maddress=address.getEditText().getText().toString();
                String mstationfrom=stationfrom.getEditText().getText().toString();
                String mcollegename=collegename.getEditText().getText().toString();
                String mduration=duration.getEditText().getText().toString();
                String mrailwayClass=railwayClass.getEditText().getText().toString();


                if (mstudentname.isEmpty() || mpassnumber.isEmpty() || msapid.isEmpty() || mPhoneNumber.isEmpty() || maddress.isEmpty() ||
                        mstationfrom.isEmpty() || mcollegename.isEmpty() ){

                    Toast.makeText(StudentDetailsActivity.this,"Please Enter Valid Details",Toast.LENGTH_SHORT).show();

                }
                else{

                    HashMap<String,String> studentMap=new HashMap<String, String>();
                    studentMap.put("name",mstudentname);
                    studentMap.put("college",mcollegename);
                    studentMap.put("sap_id",msapid);
                    studentMap.put("address",maddress);
                    studentMap.put("contact",mPhoneNumber);
                    studentMap.put("from",mstationfrom);
                    studentMap.put("pass_no",mpassnumber);
                    studentMap.put("duration",mduration);
                    studentMap.put("railwayClass",mrailwayClass);
                    studentMap.put("status","not verify");

                    if(mcollegename.equals("Dj sanghvi")){
                        studentDetail.child("college").child("Dj sanghvi").child("student_details").child(msapid).setValue(studentMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(StudentDetailsActivity.this, "Data Sent", Toast.LENGTH_SHORT).show();
                                Intent studentIntent=new Intent(StudentDetailsActivity.this,StudentPassActivity.class);
                                startActivity(studentIntent);
                                finish();
                            }
                        });
                    }

                    else if(mcollegename.equals("Kj somaiya")){

                        studentDetail.child("college").child("Kj somaiya").child("student_details").child(msapid).setValue(studentMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(StudentDetailsActivity.this, "Data Sent", Toast.LENGTH_SHORT).show();
                                Intent studentIntent=new Intent(StudentDetailsActivity.this,StudentPassActivity.class);
                                startActivity(studentIntent);
                                finish();
                            }
                        });
                    }

                    else if(mcollegename.equals("Spit")){
                        studentDetail.child("college").child("Kj somaiya").child("student_details").child(msapid).setValue(studentMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(StudentDetailsActivity.this, "Data Sent", Toast.LENGTH_SHORT).show();

                                Intent studentIntent=new Intent(StudentDetailsActivity.this,StudentPassActivity.class);
                                startActivity(studentIntent);
                                finish();
                            }
                        });
                    }




                }

            }
        });


    }
}
