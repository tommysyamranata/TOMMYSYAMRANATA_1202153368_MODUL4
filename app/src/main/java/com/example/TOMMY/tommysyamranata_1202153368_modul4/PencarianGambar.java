package com.example.TOMMY.tommysyamranata_1202153368_modul4;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.TOMMY.tommysyamranata_1202153368_modul4.R;

import java.io.InputStream;

public class PencarianGambar extends AppCompatActivity {
    EditText cariurl;
    Button btncarigambar ;
    ImageView gmbr;
    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pencarian_gambar);

        cariurl =(EditText)findViewById(R.id.edittextcari);

       gmbr = (ImageView)findViewById(R.id.gambar);
        btncarigambar = (Button) findViewById(R.id.btncari);

        btncarigambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String linkurl = cariurl.getText().toString();
                new DownloadImage().execute(linkurl);
            }
        });
    }
    private class DownloadImage extends AsyncTask<String,Void,Bitmap> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(PencarianGambar.this);
            // Set progressdialog title
            mProgressDialog.setTitle("Download Image Tutorial");
            // Set progressdialog message
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog.show();
        }

        @Override
        protected Bitmap doInBackground(String... URL) {

            String imageURL = URL[0];

            Bitmap bitmap = null;
            try {
                // Download Image from URL
                InputStream input = new java.net.URL(imageURL).openStream();
                // Decode Bitmap
                bitmap = BitmapFactory.decodeStream(input);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            // Set the bitmap into ImageView
            gmbr.setImageBitmap(result);
            // Close progressdialog
            mProgressDialog.dismiss();
        }
    }
}
