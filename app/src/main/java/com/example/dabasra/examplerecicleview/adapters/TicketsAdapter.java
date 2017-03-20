package com.example.dabasra.examplerecicleview.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dabasra.examplerecicleview.MainActivity;
import com.example.dabasra.examplerecicleview.R;
import com.example.dabasra.examplerecicleview.holders.TicketViewHolder;
import com.example.dabasra.examplerecicleview.model.Ticket;

import java.util.ArrayList;

/**
 * Created by dabasra .
 */
public class TicketsAdapter extends RecyclerView.Adapter<TicketViewHolder>{


    private ArrayList<Ticket> tickets;

    public TicketsAdapter(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public TicketViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View ticketCard = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_ticket,parent,false);
        return new TicketViewHolder(ticketCard);
    }

    @Override
    public void onBindViewHolder(TicketViewHolder holder, int position) {

        final Ticket ticket = tickets.get(position);
        holder.updateUI(ticket);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.getMainActivity().loadDetailActivity(ticket);
            }
        });

    }

    @Override
    public int getItemCount() {
        return tickets.size();
    }
}
