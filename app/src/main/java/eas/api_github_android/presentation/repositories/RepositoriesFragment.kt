package eas.api_github_android.presentation.repositories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import eas.api_github_android.R
import eas.api_github_android.extension.observeResourceResponse
import kotlinx.android.synthetic.main.repositories_fragment.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class RepositoriesFragment : Fragment() {

    private val viewModel: RepositoriesViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.repositories_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getRepositories()
        initObservers()
        textViewRepositories.setOnClickListener {
            view.findNavController()
                .navigate(R.id.actionRepositoriesFragmentToRepositoryDescriptionFragment)

        }
    }

    private fun initObservers() {

        viewModel.repositoriesLiveData.observeResourceResponse(this,
            onSuccess = { status ->
                if (status.data != null) {
                    repositories = status.data.items
                    recyclerView.adapter = RepositoriesAdapter(status.data.items, onClickItemProduct())
                }
            }, onError = {
                if (it.message != -1) {
                    Snackbar.make(rootLayout, it.message, Snackbar.LENGTH_SHORT).show()
                }
            })
    }
}