package binar.ganda.challengech3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_fourth.*


class FourthFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fourth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        gotoscreen3_btn.setOnClickListener {
            val name = arguments?.getString("NAME").toString()
            val age = et_age.text.toString().toInt()
            val address = et_address.text.toString()
            val job = et_job.text.toString()
            val person = Person(name, age, address, job)
            val personBundle = bundleOf("PERSON" to person)

            Navigation.findNavController(view).navigate(R.id.action_fourthFragment_to_thirdFragment, personBundle)


        }
    }


}