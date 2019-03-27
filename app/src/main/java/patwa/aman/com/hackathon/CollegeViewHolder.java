package patwa.aman.com.hackathon;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;

/**
 * Created by dell on 10-02-2019.
 */

public class CollegeViewHolder extends RecyclerView.ViewHolder {

    TextView name,pass_no,coll_name,sapid,phone_no,station_from,add,to,duration,railwayClass;
    CollegeMainActivity collegeMainActivity;
    String mCollegeName;
    Button verify,dontVerify;

    public CollegeViewHolder(View itemView, CollegeMainActivity collegeMainActivity, String mCollegeName) {
        super(itemView);
        this.collegeMainActivity = collegeMainActivity;
        this.mCollegeName = mCollegeName;

        name=itemView.findViewById(R.id.college_card_name);
        pass_no=itemView.findViewById(R.id.college_card_passno);
        coll_name=itemView.findViewById(R.id.college_collName);
        sapid=itemView.findViewById(R.id.college_card_sapId);
        phone_no=itemView.findViewById(R.id.college_card_phone);
        station_from=itemView.findViewById(R.id.college_card_stationFrom);
        add=itemView.findViewById(R.id.college_card_address);
        to=itemView.findViewById(R.id.college_card_stationTo);
        verify=itemView.findViewById(R.id.college_card_verify_btn);
        dontVerify=itemView.findViewById(R.id.college_card_noverify_btn);
        duration=itemView.findViewById(R.id.college_card_duration);
        railwayClass =itemView.findViewById(R.id.college_card_railwayclass);
    }


}
