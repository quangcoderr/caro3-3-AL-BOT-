package com.example.caro33.Fragment;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.caro33.MainActivity;
import com.example.caro33.R;

public class StartFragment extends Fragment {


    private Button btn_start;
private RadioButton r_2Player,r_Play_With_Computer;
private MediaPlayer mediaPlayer;
    private boolean isMusicPlaying = false;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start, container, false);
        btn_start=view.findViewById(R.id.btn_start);
        r_2Player=view.findViewById(R.id.r_2player);
        r_Play_With_Computer=view.findViewById(R.id.r_with_computer);
        mediaPlayer=MediaPlayer.create(requireContext(),R.raw.start);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

        r_Play_With_Computer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.mutilPlayer=false;
            }
        });
        r_2Player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.mutilPlayer=true;
            }
        });
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction=getActivity().getSupportFragmentManager().beginTransaction();
                MainActivity.scoreO =0;
                MainActivity.scoreX =0;
                transaction.addToBackStack(GameFragment.TAG);
                transaction.replace(R.id.main_frame,new GameFragment());
                transaction.commit();
                mediaPlayer.stop();
            }
        });
        return view;
    }
    public void stopMusic() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
            isMusicPlaying=false;

        }
    }

}