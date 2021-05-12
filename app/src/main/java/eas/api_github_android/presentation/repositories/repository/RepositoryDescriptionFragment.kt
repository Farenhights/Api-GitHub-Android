package eas.api_github_android.presentation.repositories.repository

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import eas.api_github_android.R
import kotlinx.android.synthetic.main.fragment_repository_description.*

class RepositoryDescriptionFragment : Fragment() {

    private var mView: View? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mView = inflater.inflate(R.layout.fragment_repository_description, container, false)
        return mView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        test2.setOnClickListener {
            view.findNavController()
                .navigate(R.id.actionRepositoryDescriptionFragmentToRepositoriesFragment)
        }
    }
}