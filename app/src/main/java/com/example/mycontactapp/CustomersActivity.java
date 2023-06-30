package com.example.mycontactapp;



import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mycontactapp.databinding.ActivityCustomersBinding;

public class CustomersActivity extends DrawerBaseActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private ImageView imageView;

    ActivityCustomersBinding activityCustomersBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCustomersBinding = ActivityCustomersBinding.inflate(getLayoutInflater());
        setContentView(activityCustomersBinding.getRoot());
        allocateActivityTitle("Customers");
        imageView = findViewById(R.id.imageView);
    }

    public void openCamera(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        } else {
            Toast.makeText(this, "Camera app not found", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            // Process the image taken here
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            // Use the image captured next
            imageView.setImageBitmap(imageBitmap);
        }
    }


}