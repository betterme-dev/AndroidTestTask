package app.bettermetesttask.movies.sections

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import app.bettermetesttask.domainmovies.entries.Movie
import app.bettermetesttask.featurecommon.utils.images.GlideApp
import app.bettermetesttask.movies.R
import app.bettermetesttask.movies.databinding.MovieItemBinding
import javax.inject.Inject

class MoviesAdapter @Inject constructor() : ListAdapter<Movie, MoviesAdapter.MoviesHolder>(MovieItemDiffCallback()) {

    var onItemClicked: ((movie: Movie) -> Unit)? = null
    var onItemLiked: ((movie: Movie) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesHolder {
        return MoviesHolder(MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MoviesHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class MoviesHolder(private val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Movie) {
            with(binding) {
                titleTv.text = item.title
                descriptionTv.text = item.description
                GlideApp.with(binding.rootLayout)
                    .load(item.posterPath)
                    .into(posterIv)
                btnLike.setImageDrawable(
                    ContextCompat.getDrawable(
                        binding.rootLayout.context,
                        if (item.liked) {
                            R.drawable.ic_favorite_liked
                        } else {
                            R.drawable.ic_favorite_not_liked
                        }
                    )
                )
                btnLike.setOnClickListener {
                    onItemLiked?.invoke(item)
                }
                rootLayout.setOnClickListener {
                    onItemClicked?.invoke(item)
                }
            }
        }
    }
}

class MovieItemDiffCallback : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }
}
