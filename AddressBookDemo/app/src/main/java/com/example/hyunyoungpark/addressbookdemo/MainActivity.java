package com.example.hyunyoungpark.addressbookdemo;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity
        implements ContactsFragment.ContactFragmentInterface,
        AddEditFragment.AddEditFragmentInterface
{
    private ContactsFragment contactsFragment;
    public static final String CONTACT_URI = "contact_uri";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        contactsFragment  = new ContactsFragment();
        //add the fragment into framelayout
        //use Fragment Transaction
        FragmentTransaction fragmentTransaction =
                getSupportFragmentManager()
                        .beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer,contactsFragment );
        fragmentTransaction.commit();
        //  displayAddEditFragment(R.id.fragmentContainer ,null );
    }
    // display fragment for adding a new or editing an existing contact
    // ViewID is layout id & it should be the container
    // contacturi is the path for contentProvider
    public void displayAddEditFragment(int ViewId ,  Uri contacturi)
    {
        AddEditFragment addEditFragment =
                new AddEditFragment();
        // Create the fragment using FragmentTransaction
        FragmentTransaction fragmentTransaction =
                getSupportFragmentManager()
                        .beginTransaction();
        fragmentTransaction.replace(ViewId, addEditFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onAddContact() {
        displayAddEditFragment(R.id.fragmentContainer,null);
    }
    //display DetailFragment for selected Contact
    @Override
    public void onContactSelected(Uri uri) {
        DetailFragment detailFragment = new DetailFragment();


        //use FragmentTranscation
        FragmentTransaction transaction =
                getSupportFragmentManager()
                        .beginTransaction();
        transaction.replace(R.id.fragmentContainer,
                detailFragment);
        transaction.addToBackStack(null);
        transaction.commit();

        //create a bundle object that will pass selected
        // row uri to detailFragment
        Bundle bundle = new Bundle();
        bundle.putParcelable(CONTACT_URI,uri);
        detailFragment.setArguments(bundle);
    }

    @Override
    public void onAddEditComplete(Uri uri) {
        getSupportFragmentManager()
                .popBackStack();
    }



}