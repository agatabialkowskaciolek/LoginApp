package com.example.agata.loginapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by aciolekwaw on 2015-09-15.
 */
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private List<ContactInfo> contactList;
    private int rowLayout;
    private Context mContext;


    public ContactAdapter(List<ContactInfo> contactList, int rowLayout, Context context) {
        this.contactList = contactList;
        this.rowLayout = rowLayout;
        this.mContext = context;
    }


    @Override
    public int getItemCount() {
        return contactList.size();
    }

/*    @Override
       public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ContactInfo ci = contactList.get(i);
        viewHolder.vName.setText(ci.name);
        viewHolder.vSurname.setText(ci.surname);
        contactViewHolder.vEmail.setText(ci.email);
        contactViewHolder.vTitle.setText(ci.name + " " + ci.surname);
    }*/

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.card_layout, viewGroup, false);

        return new ContactViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int i) {
        ContactInfo ci = contactList.get(i);
        holder.vName.setText(ci.name);
        holder.vSurname.setText(ci.surname);
        holder.vEmail.setText(ci.email);
        holder.vTitle.setText(ci.name + " " + ci.surname);
    }



/*    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }*/

    public static class ContactViewHolder extends RecyclerView.ViewHolder {

        protected TextView vName;
        protected TextView vSurname;
        protected TextView vEmail;
        protected TextView vTitle;

        public ContactViewHolder(View v) {
            super(v);
            vName =  (TextView) v.findViewById(R.id.txtName);
            vSurname = (TextView)  v.findViewById(R.id.txtSurname);
            vEmail = (TextView)  v.findViewById(R.id.txtEmail);
            vTitle = (TextView) v.findViewById(R.id.title);
        }
    }
}
