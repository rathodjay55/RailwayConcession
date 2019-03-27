package patwa.aman.com.hackathon;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class CollegeMainActivity extends AppCompatActivity {

    RecyclerView collegerv;
    DatabaseReference DjData,KjData,SpData,admin;
    FirebaseRecyclerOptions<CollegeModel> options;
    FirebaseRecyclerAdapter<CollegeModel,CollegeViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_main);

        collegerv=(RecyclerView)findViewById(R.id.college_main_rv);
        DjData= FirebaseDatabase.getInstance().getReference("college").child("Dj sanghvi").child("student_details");
        KjData=FirebaseDatabase.getInstance().getReference("college").child("Kj somaiya").child("student_details");
        SpData=FirebaseDatabase.getInstance().getReference("college").child("Spit").child("student_details");
        admin=FirebaseDatabase.getInstance().getReference("admin");

        Intent intent=getIntent();
        final String collegeName=intent.getStringExtra("college_name");
        Toast.makeText(this, ""+collegeName, Toast.LENGTH_SHORT).show();

        collegerv.setHasFixedSize(true);
        collegerv.setLayoutManager(new LinearLayoutManager(this));


        if(collegeName.equals("Dj sanghvi")){

            options=new FirebaseRecyclerOptions.Builder<CollegeModel>()
                    .setQuery(DjData,CollegeModel.class)
                    .build();

            adapter=new FirebaseRecyclerAdapter<CollegeModel, CollegeViewHolder>(options) {
                @Override
                protected void onBindViewHolder(final CollegeViewHolder holder, int position, final CollegeModel model) {
                    holder.to.setText("Station To: Vile Parle");
                    holder.add.setText("Address: "+model.getAddress());
                    holder.station_from.setText("Station From: "+model.getFrom());
                    holder.phone_no.setText("Contact: "+model.getContact());
                    holder.sapid.setText("Sap Id: "+model.getSap_id());
                    holder.railwayClass.setText("Class:"+model.getRailwayClass());
                    holder.duration.setText("Duration:"+model.getDuration());
                    holder.pass_no.setText("Pass No: "+model.getPass_no());
                    holder.coll_name.setText("College: "+model.getCollege());
                    holder.name.setText("Name: "+model.getName());

                    holder.verify.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Map verified=new HashMap<>();
                            verified.put("status","verified by college");

                            DjData.child(model.getSap_id()).updateChildren(verified).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    HashMap<String,String> studentMap=new HashMap<String, String>();
                                    studentMap.put("name",model.getName());
                                    studentMap.put("college",model.getCollege());
                                    studentMap.put("sap_id",model.getSap_id());
                                    studentMap.put("address",model.getAddress());
                                    studentMap.put("contact",model.getContact());
                                    studentMap.put("from",model.getFrom());
                                    studentMap.put("duration",model.getDuration());
                                    studentMap.put("railwayClass",model.getRailwayClass());
                                    studentMap.put("pass_no",model.getPass_no());
                                    studentMap.put("status","Verified by college");
                                    studentMap.put("to","Vile Parle");

                                    admin.child(model.getPass_no()).setValue(studentMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            DjData.child(model.getSap_id()).removeValue();
                                        }
                                    });
                                }
                            });
                        }
                    });

                    holder.dontVerify.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            DjData.child(model.getSap_id()).removeValue();
                        }
                    });
                }

                @Override
                public CollegeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                    View view=LayoutInflater.from(CollegeMainActivity.this).inflate(R.layout.college_student_card,parent,false);
                    CollegeViewHolder viewHolder=new CollegeViewHolder(view,CollegeMainActivity.this,collegeName);
                    return viewHolder;
                }
            };

            adapter.startListening();
            collegerv.setAdapter(adapter);

        }
        else if(collegeName.equals("Kj somaiya")){

            options=new FirebaseRecyclerOptions.Builder<CollegeModel>()
                    .setQuery(KjData,CollegeModel.class)
                    .build();

            adapter=new FirebaseRecyclerAdapter<CollegeModel, CollegeViewHolder>(options) {
                @Override
                protected void onBindViewHolder(CollegeViewHolder holder, int position, final CollegeModel model) {
                    holder.to.setText("Station To: VidyaVihar");
                    holder.add.setText("Address: "+model.getAddress());
                    holder.station_from.setText("Station From: "+model.getFrom());
                    holder.phone_no.setText("Contact: "+model.getContact());
                    holder.sapid.setText("Sap Id: "+model.getSap_id());
                    holder.railwayClass.setText("Class: "+model.getRailwayClass());
                    holder.duration.setText("Duration: "+model.getDuration());
                    holder.pass_no.setText("Pass No: "+model.getPass_no());
                    holder.coll_name.setText("College: "+model.getCollege());
                    holder.name.setText("Name: "+model.getName());

                    holder.verify.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Map verified=new HashMap<>();
                            verified.put("status","verified by college");

                            KjData.child(model.getSap_id()).updateChildren(verified).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    HashMap<String,String> studentMap=new HashMap<String, String>();
                                    studentMap.put("name",model.getName());
                                    studentMap.put("college",model.getCollege());
                                    studentMap.put("sap_id",model.getSap_id());
                                    studentMap.put("address",model.getAddress());
                                    studentMap.put("contact",model.getContact());
                                    studentMap.put("from",model.getFrom());
                                    studentMap.put("duration",model.getDuration());
                                    studentMap.put("railwayClass",model.getRailwayClass());
                                    studentMap.put("pass_no",model.getPass_no());
                                    studentMap.put("status","Verified by college");
                                    studentMap.put("to","VidyaVihar");

                                    admin.child(model.getPass_no()).setValue(studentMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            KjData.child(model.getSap_id()).removeValue();
                                        }
                                    });
                                }
                            });
                        }
                    });

                    holder.dontVerify.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            KjData.child(model.getSap_id()).removeValue();
                        }
                    });


                }

                @Override
                public CollegeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                    View view=LayoutInflater.from(CollegeMainActivity.this).inflate(R.layout.college_student_card,parent,false);
                    CollegeViewHolder viewHolder=new CollegeViewHolder(view,CollegeMainActivity.this,collegeName);
                    return viewHolder;
                }
            };

            adapter.startListening();
            collegerv.setAdapter(adapter);


        }
        else if(collegeName.equals("Spit")){

            options=new FirebaseRecyclerOptions.Builder<CollegeModel>()
                    .setQuery(SpData,CollegeModel.class)
                    .build();

            adapter=new FirebaseRecyclerAdapter<CollegeModel, CollegeViewHolder>(options) {
                @Override
                protected void onBindViewHolder(CollegeViewHolder holder, int position, final CollegeModel model) {
                    holder.to.setText("Station To: Andheri");
                    holder.add.setText("Address: "+model.getAddress());
                    holder.station_from.setText("Station From: "+model.getFrom());
                    holder.phone_no.setText("Contact: "+model.getContact());
                    holder.sapid.setText("Sap Id: "+model.getSap_id());
                    holder.railwayClass.setText("Class: "+model.getRailwayClass());
                    holder.duration.setText("Duration: "+model.getDuration());
                    holder.pass_no.setText("Pass No: "+model.getPass_no());
                    holder.coll_name.setText("College: "+model.getCollege());
                    holder.name.setText("Name: "+model.getName());

                    holder.verify.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Map verified=new HashMap<>();
                            verified.put("status","verified by college");

                            SpData.child(model.getSap_id()).updateChildren(verified).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    HashMap<String,String> studentMap=new HashMap<String, String>();
                                    studentMap.put("name",model.getName());
                                    studentMap.put("college",model.getCollege());
                                    studentMap.put("sap_id",model.getSap_id());
                                    studentMap.put("address",model.getAddress());
                                    studentMap.put("contact",model.getContact());
                                    studentMap.put("duration",model.getDuration());
                                    studentMap.put("railwayClass",model.getRailwayClass());
                                    studentMap.put("from",model.getFrom());
                                    studentMap.put("pass_no",model.getPass_no());
                                    studentMap.put("status","Verified by college");
                                    studentMap.put("to","Andheri");

                                    admin.child(model.getPass_no()).setValue(studentMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {

                                            SpData.child(model.getSap_id()).removeValue();
                                        }
                                    });
                                }
                            });
                        }
                    });

                    holder.dontVerify.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            SpData.child(model.getSap_id()).removeValue();
                        }
                    });
                }

                @Override
                public CollegeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                    View view=LayoutInflater.from(CollegeMainActivity.this).inflate(R.layout.college_student_card,parent,false);
                    CollegeViewHolder viewHolder=new CollegeViewHolder(view,CollegeMainActivity.this,collegeName);
                    return viewHolder;
                }
            };

            adapter.startListening();
            collegerv.setAdapter(adapter);



        }




    }
}
