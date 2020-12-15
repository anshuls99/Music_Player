package com.example.musicplayer

import android.content.Context
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.SeekBar
import kotlinx.android.synthetic.main.song_ticket.view.*

class SongAdapter(private val songList:ArrayList<SongInfo>, private val context: Context, private val sbProgress:SeekBar, private var mp:MediaPlayer?): BaseAdapter() {

    override fun getCount(): Int {
        return songList.size
    }

    override fun getItem(position: Int): Any {
        return songList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = LayoutInflater.from(context)
        val myView = inflater.inflate(R.layout.song_ticket,null)
        val song = songList[position]
        myView.tvSongName.text = song.title
        myView.tvSinger.text = song.singerName

        myView.buPlay.setOnClickListener{
            //TODO: play song

            if(myView.buPlay.text == "Stop"){
                mp!!.stop()
                myView.buPlay.text = "Start"
            }else {

                mp = MediaPlayer()
                try {
                    mp!!.setDataSource(song.songUrl)
                    mp!!.prepare()
                    mp!!.start()
                    myView.buPlay.text = "Stop"
                    sbProgress.max=mp!!.duration
                } catch (ex: Exception) {
                }
            }
        }

        return myView
    }
}