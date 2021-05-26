package eas.api_github_android.presentation.repositories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import eas.api_github_android.data.model.repositories.common.ItemsItem
import eas.api_github_android.databinding.FragmentRepositoriesBinding
import eas.api_github_android.extension.observeResourceResponse
import org.koin.android.ext.android.inject

class RepositoriesFragment : Fragment() {

    private val viewModel: RepositoriesViewModel by inject()
    private var repositories: ArrayList<ItemsItem>? = null
    private lateinit var binding: FragmentRepositoriesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRepositoriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setBinding()
        initUi()
        initObservers()
        binding.viewModel?.getRepositories()
    }

    private fun initUi() {
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
    }

    private fun setBinding() {
        binding.viewModel = viewModel
    }

    private fun initObservers() {

        viewModel.loadingStateLiveData.observe(viewLifecycleOwner, Observer {
            if (it) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
            }
        })

        viewModel.repositoriesLiveData.observeResourceResponse(this,
            onSuccess = { status ->
                if (status.data != null) {
                    repositories = status.data.items
                    binding.recyclerView.adapter =
                        RepositoriesAdapter(status.data.items, onClickItemProduct())
                }
            }, onError = {
                if (it.message != -1) {
                    Snackbar.make(binding.rootLayout, it.message, Snackbar.LENGTH_SHORT).show()
                }
            })
    }

    private fun onClickItemProduct(): RepositoriesAdapter.CallbackClick {
        return object : RepositoriesAdapter.CallbackClick {
            override fun onClick(position: Int) {
                /*val intent = Intent(activity, PullsActivity::class.java)
                val args = Bundle()

                args.putString(PullsFragment.ARG_CREATOR, repositories?.get(position)?.full_name?.split("/")?.first())
                args.putString(PullsFragment.ARG_REPOSITORY, repositories?.get(position)?.name)
                intent.putExtras(args)
                startActivity(intent)*/
                Toast.makeText(activity, "Teste " + position, Toast.LENGTH_SHORT).show()
            }
        }
    }
}