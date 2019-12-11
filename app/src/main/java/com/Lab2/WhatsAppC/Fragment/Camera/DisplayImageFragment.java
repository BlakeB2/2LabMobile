package com.Lab2.WhatsAppC.Fragment.Camera;

import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.Lab2.WhatsAppC.Activity.MainActivity;
import com.Lab2.WhatsAppC.R;

public class DisplayImageFragment extends Fragment implements View.OnClickListener{

    View view;

    ImageView mImage;

    ImageButton mSend;

    public static DisplayImageFragment newInstance(){
        DisplayImageFragment fragment = new DisplayImageFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_display_capture , container, false);

        initializeObjects();

        return view;
    }

    void initializeObjects(){
        mImage = view.findViewById(R.id.image);
        mSend = view.findViewById(R.id.send);

        mSend.setOnClickListener(this);

        Bitmap bitmap = ((MainActivity)getActivity()).getBitmapToSend();
        mImage.setImageBitmap(bitmap);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.send:
                ((MainActivity)getActivity()).openChooseReceiverFragment();
                break;
        }
    }
}
