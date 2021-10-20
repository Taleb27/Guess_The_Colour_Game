package y2020.aoc.bayan.taleb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Picture;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.FileNotFoundException;

public class profileActivity extends AppCompatActivity implements View.OnClickListener {


    private static final int CAMERA_REQUEST = 0;
    private static final int GALLERY_REQUEST = 1;
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonCamera){
            Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(i , CAMERA_REQUEST);
        }else{
            Intent i = new Intent(Intent.ACTION_PICK , MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(i, GALLERY_REQUEST);

        }
    }

    @Override
    protected void onActivityResult(int requestCode , int resultCode , @NonNull Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (resultCode == CAMERA_REQUEST) {
            if (resultCode == RESULT_OK) {
                picture = (Bitmap) data.getExtras().get("data");
                imageViewProfile.setImageBitmap(Picture);
            } else{if(resultCode == RESULT_OK){
                uri targeturi = data.getData();
                try{
                    Picture = BitmapFactory.decodeStream(getContetResolver().openInputStream(targeturi));
                    imageViewProfile.setImageBitmap
                }
            }

            } (FileNotFoundException e){
                e.PrintStackTrace();
            }
        }
    }

    public class ProfileActivity extends AppCompatActivity {
        private Button buttonCamera, buttonGallery;
        private ImageView imageViewProfile;
        private Bitmap picture;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_profile);

            buttonCamera = findViewById(R.id.buttonCamera);
            buttonCamera.setOnClickListener(this);
            buttonGallery = findViewById(R.id.buttonGallery);
            buttonGallery.setOnClickListener(this);
            imageViewProfile = findViewById(R.id.imageViewProfile);

        }


    }
}