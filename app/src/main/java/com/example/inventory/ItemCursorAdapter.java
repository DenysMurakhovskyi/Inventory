package com.example.inventory;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.inventory.data.DbContract;

public class ItemCursorAdapter extends CursorAdapter {

    public ItemCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        // Inflate a list item view using the layout specified in list_item.xml
        return LayoutInflater.from(context).inflate(R.layout.items_list_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find individual views that we want to modify in the list item layout
        TextView nameTextView = (TextView) view.findViewById(R.id.name);
        TextView quantityTextView = (TextView) view.findViewById(R.id.quantity);
        TextView shelfTextView = (TextView) view.findViewById(R.id.shelf_name);

        // Find the columns of item attributes that we're interested in
        int nameColumnIndex = cursor.getColumnIndex(DbContract.ItemEntry.COLUMN_ITEM_NAME);
        int quantityColumnIndex = cursor.getColumnIndex(DbContract.ItemEntry.COLUMN_ITEM_QUANTITY);
        int shelfNameColumnIndex = cursor.getColumnIndex(DbContract.ItemEntry.COLUMN_ITEM_SHELF_NAME);

        // Read the item attributes from the Cursor for the current item
        String itemName = cursor.getString(nameColumnIndex);
        String itemQuantity = String.valueOf(cursor.getInt(quantityColumnIndex));
        String itemShelf = cursor.getString(shelfNameColumnIndex);

        // Update the TextViews with the attributes for the current pet
        nameTextView.setText(itemName);
        quantityTextView.setText(itemQuantity);
        shelfTextView.setText(itemShelf);
    }
}
