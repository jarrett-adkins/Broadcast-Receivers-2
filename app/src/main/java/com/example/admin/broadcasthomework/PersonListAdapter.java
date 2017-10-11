package com.example.admin.broadcasthomework;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 10/2/2017.
 */

public class PersonListAdapter extends ArrayAdapter<Person> {

    public PersonListAdapter(@NonNull Context context, @LayoutRes int resource, ArrayList<Person> personList) {
        super(context, resource, personList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder holder;

        if( convertView == null ) {
            //inflate the view with custom layout xml
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_item, null);

            //bind the views
            holder = new ViewHolder( convertView );
            holder.nameTextView = convertView.findViewById( R.id.tvPersonFirstName );
            holder.surnameTextView = convertView.findViewById( R.id.tvPersonSecondName );
            holder.ageTextView = convertView.findViewById( R.id.tvPersonAge );
            holder.weightTextView = convertView.findViewById( R.id.tvPersonWeight );

            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        //set the values
        Person person = getItem( position );

        holder.nameTextView.setText( person.getFirstName() );
        holder.surnameTextView.setText( person.getLastName() );
        holder.ageTextView.setText( String.valueOf( person.getAge() ));
        holder.weightTextView.setText( String.valueOf( person.getWeight() ));

        return convertView;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private TextView surnameTextView;
        private TextView ageTextView;
        private TextView weightTextView;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
