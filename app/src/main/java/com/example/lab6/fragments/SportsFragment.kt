package com.example.lab6.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.lab6.adapter.SportsRecyclerViewAdapter
import com.example.lab6.databinding.FragmentSportsBinding
import com.example.lab6.dialog.AddNewSportDialogFragment


class SportsFragment : Fragment() {

lateinit var binding: FragmentSportsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSportsBinding.inflate(inflater, container, false)
       val sportsRecyclerViewAdapter  =   SportsRecyclerViewAdapter(sports)
        binding.sportsRecyclerView.adapter = sportsRecyclerViewAdapter


        binding.sportsRecyclerView.layoutManager = GridLayoutManager(this.context, 2)
        binding.sportsFab.setOnClickListener{

           AddNewSportDialogFragment( object : AddNewSportDialogFragment.AddNewSportDialogCallback{
               override fun onSportAdded(item: Sport) {
                   sports.add(0, item)
                   sportsRecyclerViewAdapter.notifyItemInserted(0)
                   binding.sportsRecyclerView.scrollToPosition(0)


               }
           }).show(parentFragmentManager, "ADD_NEW_SPORT_DIALOG")

        }
        return binding.root
    }



    companion object {
        val sports = mutableListOf<Sport>(
            Sport("swiming", "swimming", "To advance in running, start with dynamic stretches to improve flexibility and prevent injuries. Keep your posture upright and engage your core while maintaining rhythmic breathing. Begin your runs at a manageable pace, progressively increasing your speed. Focus on a soft knee landing to minimize injury risks. Incorporate varied training such as hill sprints and long runs. Cool down with stretching to aid recovery, and ensure you stay hydrated and well-rested."),
            Sport("Measure", "darts", "To enhance your darts skills, maintain a stable stance with feet shoulder-width apart. Grip the dart gently yet firmly, and throw with a consistent motion focusing on your target. Regular practice will sharpen your precision and control. Adjust your throw based on performance insights, and stay composed under pressure to maintain accuracy."),
            Sport("Spectacle", "cheerleading", "To excel in cheerleading, focus on individual techniques and teamwork. Strengthen and increase agility through tailored workouts. Practice routines and stunts with an emphasis on safety. Effective team communication is crucial for executing complex routines. Keep a spirited and positive attitude, and actively seek feedback to refine your performance."),
            Sport("ufc", "ufc", "For ufc proficiency, perfect your dribbling, passing, and shooting with consistent practice. Deepen your tactical knowledge and positioning to be more effective on the field. Enhance physical fitness with exercises that boost speed, agility, and endurance. Develop strong communication to work seamlessly with teammates during matches. Continuously learn from game analyses and coaching to improve.")
        )

        data class Sport(val type:CharSequence, val name: CharSequence, val instruction: CharSequence)

    }
}