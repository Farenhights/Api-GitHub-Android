package eas.api_github_android.presentation.repositories

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import eas.api_github_android.R
import eas.api_github_android.data.model.repositories.common.ItemsItem
import eas.api_github_android.databinding.ItemRepositoryBinding

class RepositoriesAdapter(
    val repositories: ArrayList<ItemsItem>,
    val clickCallback: CallbackClick
) : RecyclerView.Adapter<RepositoriesAdapter.RepositoryViewHolder>() {

    private lateinit var binding: ItemRepositoryBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = ItemRepositoryBinding.inflate(inflater)

        return RepositoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.bindItems(repositories[position])
    }

    override fun getItemCount(): Int {
        return repositories.size
    }

    inner class RepositoryViewHolder(private val binding: ItemRepositoryBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        fun bindItems(items: ItemsItem) {
            with(binding) {
                repositoryNameTextView.text = items.name
                repositoryDescriptionTextView.text = items.description
                forkCountTextView.text = items.forks_count.toString()
                starCountTextView.text = items.stargazers_count.toString()
                userNameTextView.text = items.owner?.login
                fullNameTextView.text = items.full_name

                Picasso.get()
                    .load(items.owner?.avatar_url)
                    .error(R.drawable.ic_person)
                    .resize(50, 50)
                    .centerCrop()
                    .into(avatarImage)
            }

            binding.root.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            clickCallback.onClick(adapterPosition)
        }
    }

    interface CallbackClick {
        fun onClick(position: Int)
    }
}