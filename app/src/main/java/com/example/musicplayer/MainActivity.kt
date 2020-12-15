package com.example.musicplayer

import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var listSongs = ArrayList<SongInfo>()
    private var mp: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadUrl()
        lsListSongs.adapter = SongAdapter(listSongs, this, sbProgress, mp)

        MySongTrack().start()
    }

    private fun loadUrl() {
        listSongs.add(SongInfo("S1", "Sonu", "https://server6.mp3quran.net/thubti/001.mp3"))
        listSongs.add(SongInfo("S2", "Sonu", "https://server6.mp3quran.net/thubti/002.mp3"))
        listSongs.add(SongInfo("S3", "Sonu", "https://server6.mp3quran.net/thubti/003.mp3"))
        listSongs.add(SongInfo("S4", "Sonu", "https://server6.mp3quran.net/thubti/004.mp3"))
        listSongs.add(SongInfo("S5", "Sonu", "https://server6.mp3quran.net/thubti/005.mp3"))
    }

    inner class MySongTrack : Thread() {

        override fun run() {
            while (true) {
                try {
                    sleep(1000)
                } catch (ex: Exception) {
                }

                runOnUiThread {

                    if (mp != null) {
                        sbProgress.progress = mp!!.currentPosition
                    }
                }
            }

        }
    }

}