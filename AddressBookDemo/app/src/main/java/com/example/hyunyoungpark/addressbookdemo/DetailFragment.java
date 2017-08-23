package com.example.hyunyoungpark.addressbookdemo;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hyunyoungpark.addressbookdemo.Data.DatabaseDescription;


public class DetailFragment extends Fragment
        implements LoaderManager.LoaderCallbacks<Cursor>
{
    //create an ID for loader
    private static  final int CONTACT_LOADER =0;
    //uri of selected contact
    private Uri contactUri;
    private TextView nameTextView; // displays contact's name
    private TextView phoneTextView; // displays contact's phone
    private TextView emailTextView; // displays contact's email
    private TextView streetTextView; // displays contact's street
    private TextView cityTextView; // displays contact's city
    private TextView stateTextView; // displays contact's state
    private TextView zipTextView; // displays contact's zip

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        //only this fragment is having optionMenu
        //in others it set to false
        setHasOptionsMenu(true);
        //create view from fragment_deatil.xml
        View view = inflater.inflate(
                R.layout.fragment_detail,
                container,
                false
        );
        //get the reference of Textview
        nameTextView  =(TextView)view.findViewById(R.id.nameTextView);
        phoneTextView = (TextView)view.findViewById(R.id.phoneTextView);
        emailTextView = (TextView) view.findViewById(R.id.emailTextView);
        streetTextView = (TextView) view.findViewById(R.id.streetTextView);
        cityTextView = (TextView) view.findViewById(R.id.cityTextView);
        stateTextView = (TextView) view.findViewById(R.id.stateTextView);
        zipTextView = (TextView) view.findViewById(R.id.zipTextView);
        //get the bundle value for selected contact URI
        Bundle arg = getArguments();
        contactUri = arg.getParcelable(
                MainActivity.CONTACT_URI);
        return view;

    }


    //this method is called by Lodermanager to create a loader
    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        CursorLoader cursorLoader = new CursorLoader(
                getActivity(),
                contactUri, //Uri value which
                // display a specific contact
                null, // null projection returns all column
                null, //null selection return all rows
                null, // null selection selection value
                null  //sorting order
        );
        return cursorLoader;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
//we should pass the data to UI
        //if your contact details in database exist
        if(data!=null && data.moveToFirst()){
            int nameIndex = data.getColumnIndex
                    (DatabaseDescription.Contact.COLUMN_NAME);
            int phoneIndex = data.getColumnIndex(
                    DatabaseDescription.Contact.COLUMN_PHONE);
            int emailIndex = data.getColumnIndex(DatabaseDescription.Contact.COLUMN_EMAIL);
            int streetIndex = data.getColumnIndex(DatabaseDescription.Contact.COLUMN_STREET);
            int cityIndex = data.getColumnIndex(DatabaseDescription.Contact.COLUMN_CITY);
            int stateIndex = data.getColumnIndex(DatabaseDescription.Contact.COLUMN_STATE);
            int zipIndex = data.getColumnIndex(DatabaseDescription.Contact.COLUMN_ZIP);

            //fill textview with retrieved data
            nameTextView.setText(data.getString(nameIndex));
            phoneTextView.setText(data.getString(phoneIndex));
            emailTextView.setText(data.getString(emailIndex));
            streetTextView.setText(data.getString(streetIndex));
            cityTextView.setText(data.getString(cityIndex));
            stateTextView.setText(data.getString(stateIndex));
            zipTextView.setText(data.getString(zipIndex));
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

}