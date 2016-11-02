package com.insequence.simpletodo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by paulyang on 9/20/16.
 */

// http://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView

public class TodoItemAdapter extends ArrayAdapter<TodoItem> {
    // View lookup cache
    public static final String ITEMS_CHILD = "items";
    private DatabaseReference mFirebaseDatabaseReference;
    Context context;

    private static class ViewHolder {
        TextView itemPersonName;
        TextView itemText;
        ImageView imageView;
        CheckBox checkBox;
    }

    public TodoItemAdapter(Context context, ArrayList<TodoItem> users) {
        super(context, R.layout.todo_item, users);
        this.context = context;
        mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final TodoItem todoItem = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        final ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            // If there's no view to re-use, inflate a brand new view for row
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.todo_item, parent, false);
            viewHolder.itemPersonName = (TextView) convertView.findViewById(R.id.itemPersonName);
            viewHolder.itemText = (TextView) convertView.findViewById(R.id.itemText);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.imageView3);
            viewHolder.checkBox = (CheckBox) convertView.findViewById(R.id.chkBox);
            // Cache the viewHolder object inside the fresh view
            convertView.setTag(viewHolder);
        } else {
            // View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // Populate the data into the template view using the data object
        viewHolder.itemPersonName.setText(todoItem.getName());
        viewHolder.itemText.setText(todoItem.getText());

        // http://stackoverflow.com/questions/15941635/how-to-add-a-listener-for-checkboxes-in-an-adapter-view-android-arrayadapter
        viewHolder.checkBox.setChecked(todoItem.getChecked());
        viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                final boolean checked = viewHolder.checkBox.isChecked();
                // update on firebase.
                System.out.println("checked: " + checked);
                mFirebaseDatabaseReference.child(ITEMS_CHILD).child(todoItem.getKey()).child("checked").setValue(checked);
            }
        });

        // get the profile picture from url

        String imageUri = todoItem.getPhotoUrl();
        ImageView ivBasicImage = (ImageView) viewHolder.imageView;
        Picasso.with(context).load(imageUri).into(ivBasicImage);

//      Return the completed view to render on screen
        return convertView;
    }


}