package com.joietribianni.RVExoplayer;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import java.util.ArrayList;

public class FirstFragment extends Fragment {

    ExoPlayerRecyclerView mRecyclerView;
    private ArrayList<MediaObject> mediaObjectList = new ArrayList<>();
    private MediaRecyclerAdapter mAdapter;
    private boolean firstTime = true;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_first, container, false);
        mRecyclerView = rootView.findViewById(R.id.exoPlayerRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
//        Drawable dividerDrawable = ContextCompat.getDrawable(getActivity(), R.drawable.divider_drawable);
//        assert dividerDrawable != null;
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(dividerDrawable));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        prepareVideoList();

        //set data object
        mRecyclerView.setMediaObjects(mediaObjectList);
        mAdapter = new MediaRecyclerAdapter(mediaObjectList, initGlide());
        //Set Adapter
        mRecyclerView.setAdapter(mAdapter);

        if (firstTime) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    mRecyclerView.playVideo(false);
                }
            });
            firstTime = false;
        }

        return rootView;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

//    private void initView() {
//        mRecyclerView = getView().findViewById(R.id.exoPlayerRecyclerView);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
//        Drawable dividerDrawable = ContextCompat.getDrawable(this, R.drawable.divider_drawable);
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(dividerDrawable));
//        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
//    }

    private RequestManager initGlide() {
        RequestOptions options = new RequestOptions();
        return Glide.with(this)
                .setDefaultRequestOptions(options);
    }

    private void prepareVideoList() {
        MediaObject mediaObject = new MediaObject();
        mediaObject.setId(1);
        mediaObject.setUserHandle("@h.pandya");
        mediaObject.setTitle(
                "Do you think the concept of marriage will no longer exist in the future?");
        mediaObject.setCoverUrl(
                "https://i.redd.it/tpsnoz5bzo501.jpg");
        mediaObject.setUrl("https://glimps-video-bucket.s3.ap-south-1.amazonaws.com/1.mp4");
        MediaObject mediaObject2 = new MediaObject();
        mediaObject2.setId(2);
        mediaObject2.setUserHandle("@hardik.patel");
        mediaObject2.setTitle(
                "If my future husband doesn't cook food as good as my mother should I scold him?");
        mediaObject2.setCoverUrl(
                "https://i.redd.it/j6myfqglup501.jpg");
        mediaObject2.setUrl("https://glimps-video-bucket.s3.ap-south-1.amazonaws.com/2.mp4");
        MediaObject mediaObject3 = new MediaObject();
        mediaObject3.setId(3);
        mediaObject3.setUserHandle("@arun.gandhi");
        mediaObject3.setTitle("Give your opinion about the Ayodhya temple controversy.");
        mediaObject3.setCoverUrl(
                "https://i.redd.it/0h2gm1ix6p501.jpg");
        mediaObject3.setUrl("https://glimps-video-bucket.s3.ap-south-1.amazonaws.com/3.mp4");
        MediaObject mediaObject4 = new MediaObject();
        mediaObject4.setId(4);
        mediaObject4.setUserHandle("@sachin.patel");
        mediaObject4.setTitle("When did kama founders find sex offensive to Indian traditions");
        mediaObject4.setCoverUrl(
                "https://i.redd.it/k98uzl68eh501.jpg");
        mediaObject4.setUrl("https://glimps-video-bucket.s3.ap-south-1.amazonaws.com/4.mp4");
        MediaObject mediaObject5 = new MediaObject();
        mediaObject5.setId(5);
        mediaObject5.setUserHandle("@monika.sharma");
        mediaObject5.setTitle("When did you last cry in front of someone?");
        mediaObject5.setCoverUrl(
                "https://i.redd.it/glin0nwndo501.jpg");
        mediaObject5.setUrl("https://glimps-video-bucket.s3.ap-south-1.amazonaws.com/5.mp4");
        mediaObjectList.add(mediaObject);
        mediaObjectList.add(mediaObject2);
        mediaObjectList.add(mediaObject3);
        mediaObjectList.add(mediaObject4);
        mediaObjectList.add(mediaObject5);
        mediaObjectList.add(mediaObject);
        mediaObjectList.add(mediaObject2);
        mediaObjectList.add(mediaObject3);
        mediaObjectList.add(mediaObject4);
        mediaObjectList.add(mediaObject5);
    }
}
