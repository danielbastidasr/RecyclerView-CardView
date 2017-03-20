package com.example.dabasra.examplerecicleview;

/**
 * Created by dabasra .
 */
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.dabasra.examplerecicleview.adapters.TicketsAdapter;
import com.example.dabasra.examplerecicleview.model.Ticket;

import java.util.ArrayList;


public class MainFragment extends Fragment {


    public MainFragment() {
    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);


        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.reciclerView);
        recyclerView.setHasFixedSize(true);

        ArrayList<Ticket> tickets  = new ArrayList<Ticket>();
        // This tickets we create should come from your data base.
        Ticket ticket = new Ticket("Open Bar","06-01-2014","http://www.pubyfiesta.com/ec2/?src=/img/events/002687/0000359508/full/10fed003-a2aa-c2b4-7171-a39adc8cb6fb.jpg&w=1000&h=800&signature=KlL7mDuJXJCU2GZTBTMY5xZaQUY%3D");
        tickets.add(ticket);
        ticket = new Ticket("This Is Amazing","20-10-2014","http://www.pubyfiesta.com/ec2/?src=/img/events/002687/0000359508/full/10fed003-a2aa-c2b4-7171-a39adc8cb6fb.jpg&w=1000&h=800&signature=KlL7mDuJXJCU2GZTBTMY5xZaQUY%3D");
        tickets.add(ticket);
        ticket = new Ticket("Lora Is My Dog","05-01-2016","http://www.pubyfiesta.com/ec2/?src=/img/events/002687/0000359508/full/10fed003-a2aa-c2b4-7171-a39adc8cb6fb.jpg&w=1000&h=800&signature=KlL7mDuJXJCU2GZTBTMY5xZaQUY%3D");
        tickets.add(ticket);
        ticket = new Ticket("Good Luck With That","20-11-2014","http://www.pubyfiesta.com/ec2/?src=/img/events/002687/0000359508/full/10fed003-a2aa-c2b4-7171-a39adc8cb6fb.jpg&w=1000&h=800&signature=KlL7mDuJXJCU2GZTBTMY5xZaQUY%3D");
        tickets.add(ticket);

        TicketsAdapter ticketsAdapter = new TicketsAdapter(tickets);

        recyclerView.addItemDecoration(new SpaceItems(20));
        recyclerView.setAdapter(ticketsAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayout.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }


    class SpaceItems extends RecyclerView.ItemDecoration{

        private final int spacer;

        SpaceItems(int spacer) {
            this.spacer = spacer;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.bottom = spacer;
        }
    }

}
