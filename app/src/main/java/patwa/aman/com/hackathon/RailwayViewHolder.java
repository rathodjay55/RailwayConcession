package patwa.aman.com.hackathon;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by dell on 10-02-2019.
 */

public class RailwayViewHolder extends RecyclerView.ViewHolder {

    TextView name,pass_no,coll_name,sapid,phone_no,station_from,add,to,duration,railwayClass;
    Button verify;

    public RailwayViewHolder(View itemView) {
        super(itemView);

        name=itemView.findViewById(R.id.railway_card_name);
        pass_no=itemView.findViewById(R.id.railway_card_passno);
        coll_name=itemView.findViewById(R.id.railway_collName);
        sapid=itemView.findViewById(R.id.railway_card_sapId);
        phone_no=itemView.findViewById(R.id.railway_card_phone);
        station_from=itemView.findViewById(R.id.railway_card_stationFrom);
        add=itemView.findViewById(R.id.railway_card_address);
        to=itemView.findViewById(R.id.railway_card_stationTo);
        verify=itemView.findViewById(R.id.railway_card_verify_btn);
        duration=itemView.findViewById(R.id.railway_card_duration);
        railwayClass=itemView.findViewById(R.id.railway_card_class);


    }
}
