package com.theekshana.codefestexam;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;
import com.theekshana.codefestexam.Holder.orderHolder;
import com.theekshana.codefestexam.Model.Tickect;


public class showorder extends Fragment {


    FirebaseFirestore db = FirebaseFirestore.getInstance();
    RecyclerView productlistvie;
    StorageReference storageRef;
    ;
    FirebaseStorage storage;
    private StorageReference mStorageRef;
    private FirestoreRecyclerAdapter<Tickect, orderHolder> fsFirestoreRecyclerAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_showorder, container, false);
        storage = FirebaseStorage.getInstance();
        storageRef = storage.getReference();
        Query query = db.collection("Tickets");
        FirestoreRecyclerOptions<Tickect> options = new FirestoreRecyclerOptions.Builder<Tickect>().setQuery(query,Tickect.class).build();
        //create adapter
        productlistvie = (RecyclerView)view.findViewById(R.id.listRecycle);
        productlistvie.setLayoutManager(new LinearLayoutManager(getContext()));
        fsFirestoreRecyclerAdapter = new FirestoreRecyclerAdapter<Tickect, orderHolder>(options) {

            @NonNull
            @Override
            public orderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_list,parent,false);

                return new orderHolder(view);

            }

            @Override
            protected void onBindViewHolder(@NonNull orderHolder holder, int position, @NonNull Tickect model) {
                holder.title.setText(model.getNAme());
                holder.dis.setText(model.getBody());
                holder.loc.setText(model.getComplain()+"");
                holder.time.setText(model.getDocID()+"");

            }
        };

        //set adapter to reyclciew
        productlistvie.setAdapter(fsFirestoreRecyclerAdapter);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        fsFirestoreRecyclerAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        fsFirestoreRecyclerAdapter.stopListening();
    }
}