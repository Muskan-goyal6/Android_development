package com.example.muskangoyal.firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.crashlytics.android.Crashlytics;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.internal.zzl;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText et;
    ArrayList<String> notes;
    ListView lv;
    ArrayAdapter<String> arrAdapter;
    FirebaseUser firebaseUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       final int RC_SIGN_IN = 1000;

        btn = findViewById(R.id.btn);
        et = findViewById(R.id.et);
        lv = findViewById(R.id.lv);
        notes = new ArrayList<>();
        Crashlytics.getInstance().crash(); // Force a crash

        final ArrayAdapter<String> arrAdapter = new ArrayAdapter<String>(
              this,
              R.layout.item_row,
              R.id.tvrow,
              notes
        );
        lv.setAdapter(arrAdapter);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        if (firebaseUser != null) {
            //Logged in
            addListeners();
        } else {
            //Logged out
            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setIsSmartLockEnabled(false)  //disable google smart lock
                            .setAvailableProviders(Arrays.asList(
                                    new AuthUI.IdpConfig.EmailBuilder().build(),
                                    new AuthUI.IdpConfig.PhoneBuilder().build(),
                                    new AuthUI.IdpConfig.GoogleBuilder().build()))
                            .build(),
                    RC_SIGN_IN);
        }
    }



//        final DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference();
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String note = et.getText().toString();
//
//                //upload note to firebase
//               // FirebaseDatabase.getInstance().getReference().push().setValue(note); //this gives us the root node or root database
//               // dbRef.child("note").push().setValue(note);
//                //dbRef.child("todo").push().setValue(note);
//
//               // Note n =new Note("hello","world");
//                dbRef.child("note").push().setValue(note);
//
//            }
//        });

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
         final int RC_SIGN_IN = 1000;
        super.onActivityResult(requestCode, resultCode, data);
        // RC_SIGN_IN is the request code you passed into startActivityForResult(...) when starting the sign in flow.
        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            // Successfully signed in
            if (resultCode == RESULT_OK) {
                firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
                addListeners();
                Log.e("TAG", "onActivityResult: " + firebaseUser.getDisplayName());
                Log.e("TAG", "onActivityResult: " + firebaseUser.getUid());
            } else {
                // Sign in failed
                if (response == null) {
                    // User pressed back button
                    return;
                }

                if (response.getError().getErrorCode() == ErrorCodes.NO_NETWORK) {
                    return;
                }
            }
        }
    }

    public void addListeners(){
        final DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String note = et.getText().toString();
                //Upload the note to Firebase
                dbRef.child("note").child(firebaseUser.getUid()).push().setValue(note);
            }
        });


        dbRef.child("note").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                //called when a new node is inserted to the 'note' node
                //Note data = dataSnapshot.getValue(Note.class);

                String data = dataSnapshot.getValue(String.class);
                notes.add(data);
                arrAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
               //an existing data node is updated

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
               //when a data at a subnode is removed
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                 //when the position of a subnode changes
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //when the read operation failed
            }
        });

        dbRef.child("note").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //gets the entire database regardless of the operation
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
