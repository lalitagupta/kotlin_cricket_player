package com.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.demo.match.R
import com.demo.match.adapter.PlayerAdapter
import com.demo.match.datamodel.Players
import kotlinx.android.synthetic.main.players.*
import java.util.ArrayList

class PlayerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity
        return inflater.inflate(R.layout.players,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecyclerView()

    }

    private fun initRecyclerView() {
        val llm = LinearLayoutManager(activity)
        llm.orientation = LinearLayoutManager.VERTICAL
        rv_users.layoutManager = llm
        val adapter = arguments?.getParcelableArrayList<Players>("list")?.let { PlayerAdapter(it) }
        rv_users.adapter=adapter
    }

    companion object {

        fun newInstance(playerList: ArrayList<Players>?)=
            PlayerFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList("list",playerList)
                }
            }
    }

}