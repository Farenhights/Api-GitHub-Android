package eas.api_github_android.presentation.repositories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import eas.api_github_android.R
import kotlinx.android.synthetic.main.repositories_fragment.*

class RepositoriesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.repositories_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textViewRepositories.setOnClickListener {
            view.findNavController()
                .navigate(R.id.actionRepositoriesFragmentToRepositoryDescriptionFragment)
        }
    }
}