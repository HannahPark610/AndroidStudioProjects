package com.example.hyunyoungpark.addressbookdemo;

import android.content.Context;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hyunyoungpark.addressbookdemo.Data.DatabaseDescription;


public class ContactsFragment extends Fragment
        implements  LoaderManager.LoaderCallbacks<Cursor>
{

//from here you should goto MainActivity and load
    //detailFragment with selected ID
//    @Override
//    public void onClick(Uri uri) {
//        contactFragmentInterface.onContactSelected(uri);
//    }

    //interface .: have only methods no implementation
    //Class implementing interface will have code
    public interface ContactFragmentInterface
    {
        void onAddContact();
        void onContactSelected(Uri uri);
    }
    private ContactAdapter contactAdapter;
    private int contact_loader =0;
    //declaration not intialization
    public ContactFragmentInterface contactFragmentInterface;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view =inflater.inflate(
                R.layout.fragment_contacts,
                container,
                false
        );
        RecyclerView recyclerView = (RecyclerView)
                view.findViewById(R.id.recyclerView);
        //set layoutManger
        recyclerView.setLayoutManager(
                new LinearLayoutManager(
                        getActivity().getBaseContext()
                ));
        //set Adapter
        contactAdapter =  new ContactAdapter(new ContactAdapter.ContactAdapterInterface() {
            @Override
            public void onClick(Uri uri) {
                contactFragmentInterface.onContactSelected(uri);
            }
        });
        recyclerView.setAdapter(contactAdapter);
        recyclerView.addItemDecoration(new
                ItemDivider(getContext()));
        //Improving the performance
        recyclerView.setHasFixedSize(true);

        FloatingActionButton addButton = (FloatingActionButton)
                view.findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contactFragmentInterface.onAddContact();
            }
        });
        return  view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        contactFragmentInterface = (ContactFragmentInterface) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        contactFragmentInterface = null;
    }

    //Intialize the loader whenever the fragment
    // activity is created

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getLoaderManager().initLoader(contact_loader,
                null,this);
    }

    //create a loader object and start loading
    // the data into cursor
    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        CursorLoader c = new CursorLoader(
                getActivity(),
                DatabaseDescription.Contact.CONTENT_URI,
                null,
                null,
                null,
                null
        );
        return c;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        contactAdapter.notifyChange(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        contactAdapter.notifyChange(null);
    }
}