package patwa.aman.com.hackathon;

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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import static patwa.aman.com.hackathon.R.layout.railway_card;

public class RailwayMainActivity extends AppCompatActivity {

    RecyclerView railRecyclerView;
    FirebaseRecyclerOptions<RailwayModel> options;
    FirebaseRecyclerAdapter<RailwayModel,RailwayViewHolder> adapter;
    DatabaseReference getAdminData,student;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_railway_main);

        railRecyclerView=findViewById(R.id.railway_rv);
        getAdminData= FirebaseDatabase.getInstance().getReference("admin");

        railRecyclerView.setHasFixedSize(true);
        railRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        student=FirebaseDatabase.getInstance().getReference("student");

        options=new FirebaseRecyclerOptions.Builder<RailwayModel>()
                .setQuery(getAdminData,RailwayModel.class)
                .build();

        adapter=new FirebaseRecyclerAdapter<RailwayModel, RailwayViewHolder>(options) {
            @Override
            protected void onBindViewHolder(final RailwayViewHolder holder, int position, final RailwayModel model) {
                holder.to.setText("Station To: "+model.getTo());
                holder.add.setText("Address: "+model.getAddress());
                holder.station_from.setText("Station From: "+model.getFrom());
                holder.phone_no.setText("Contact: "+model.getContact());
                holder.sapid.setText("Sap Id: "+model.getSap_id());
                holder.pass_no.setText("Pass No: "+model.getPass_no());
                holder.coll_name.setText("College: "+model.getCollege());
                holder.name.setText("Name: "+model.getName());
                holder.railwayClass.setText("Class: "+model.getRailwayClass());
                holder.duration.setText("Duration: "+model.getDuration());
                holder.verify.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Map verified=new HashMap<>();
                        verified.put("status","verified by Railways");

                        getAdminData.child(model.getPass_no()).updateChildren(verified).addOnCompleteListener(new OnCompleteListener() {
                            @Override
                            public void onComplete(@NonNull Task task) {
                                HashMap<String,String> studentMap=new HashMap<String, String>();
                                studentMap.put("name",model.getName());
                                studentMap.put("college",model.getCollege());
                                studentMap.put("sap_id",model.getSap_id());
                                studentMap.put("address",model.getAddress());
                                studentMap.put("contact",model.getContact());
                                studentMap.put("from",model.getFrom());
                                studentMap.put("pass_no",model.getPass_no());
                                studentMap.put("railwayClass",model.getRailwayClass());
                                studentMap.put("duration",model.getDuration());
                                studentMap.put("status","Verified by Railway");
                                studentMap.put("to","Vile Parle");


                                student.child(model.getSap_id()).setValue(studentMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        holder.verify.setEnabled(false);
                                        Toast.makeText(RailwayMainActivity.this, "Process Completed", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        });
                    }
                });
            }

            @Override
            public RailwayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view= LayoutInflater.from(RailwayMainActivity.this).inflate(R.layout.railway_card,parent,false);
                RailwayViewHolder viewHolder=new RailwayViewHolder(view);
                return viewHolder;
            }
        };

        adapter.startListening();
        railRecyclerView.setAdapter(adapter);



    }
}
