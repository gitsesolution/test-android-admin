package com.theekshana.codefestexam;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;
import com.theekshana.codefestexam.Model.NewsModel;


public class NewsDash extends Fragment {
    Fragment fragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    private static final int FILE_CHOOSE_ACTIVITY_RESULT_CODE = 7;
    Button uploadImage, addnews;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private Uri selectProductImageUri;
    ImageView imageProduct;
    EditText name,des,loc,time;
    private StorageReference mStorageRef;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        uploadImage = view.findViewById(R.id.proImgebtn);
        addnews = view.findViewById(R.id.proAdd);
        name = view.findViewById(R.id.proName);
        des = view.findViewById(R.id.proDisc);
        loc = view.findViewById(R.id.proPrice);
        time = view.findViewById(R.id.newtimes);
        imageProduct = view.findViewById(R.id.newImage);


        mStorageRef = FirebaseStorage.getInstance().getReference();
        uploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent filechooser = new Intent();
                filechooser.setAction(Intent.ACTION_GET_CONTENT);
                filechooser.setType("image/*");
                startActivityForResult(Intent.createChooser(filechooser,"Select File"),FILE_CHOOSE_ACTIVITY_RESULT_CODE);

            }
        });

        addnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNews();
            }
        });

        return view;


    }

    private void saveNews() {

        String newsName = name.getText().toString();
        String newdes = des.getText().toString();
        String newsloc = loc.getText().toString();
        String newstime = time.getText().toString();


        String path ="ProdcutImages/"+newsName+"_"+System.currentTimeMillis()+".png";
        StorageReference riversRef =  mStorageRef.child(path);
        riversRef.putFile(selectProductImageUri);

        NewsModel newsModel = new NewsModel(newsName,newdes,newsloc,newstime,path);
        CollectionReference PCollectionReference = db.collection("News");
        PCollectionReference.add(newsModel).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(getContext(),"News Add Succefuuly",Toast.LENGTH_LONG).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getContext(),"Error :"+e.getMessage(),Toast.LENGTH_LONG).show();

            }
        });

    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(FILE_CHOOSE_ACTIVITY_RESULT_CODE == requestCode){
            if(resultCode== Activity.RESULT_OK){
                selectProductImageUri = data.getData();
//                Toast.makeText(this, selectProductImageUri.toString(), Toast.LENGTH_LONG).show();


                    selectProductImageUri = data.getData();
                    Picasso.with(getContext()).load(selectProductImageUri).into(imageProduct);


            }else {
                Toast.makeText(getContext(), "File Not Selected :"+ resultCode, Toast.LENGTH_LONG).show();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}