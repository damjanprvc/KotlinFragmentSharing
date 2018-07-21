package com.damjan.kotlinfragmentsharing


import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.net.Uri
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_video_view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val VID_URI = "videoUri"

class VideoViewFragment : Fragment() {

    private var videoUri: Uri? = null
    private val videoUriViewModel by lazy {
        ViewModelProviders.of(activity!!).get(VideoUriViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()

        if(videoUriViewModel.videoUri != null) {
            videoView.setVideoURI(videoUriViewModel.videoUri)
            videoView.start()
        }
    }

    override fun onPause() {
        super.onPause()
        videoView.pause()
    }

    override fun onStop() {
        super.onStop()
        videoView.stopPlayback()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_video_view, container, false)
    }

    companion object {
        private val TAG = VideoIntentFragment::class.qualifiedName

        @JvmStatic fun newInstance() = VideoViewFragment()
    }
}
