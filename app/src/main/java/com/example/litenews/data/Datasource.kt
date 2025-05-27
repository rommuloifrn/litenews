import com.example.litenews.model.Post
import com.example.litenews.R

class Datasource() {

    fun loadPosts(): List<Post> {
        return listOf<Post>(
            Post(R.string.autorDePost1, R.string.tituloDePost1, R.string.conteudoDePost1),
            Post(R.string.autorDePost2, R.string.tituloDePost2, R.string.conteudoDePost2),
            Post(R.string.autorDePost3, R.string.tituloDePost3, R.string.conteudoDePost3),
            Post(R.string.autorDePost4, R.string.tituloDePost4, R.string.conteudoDePost4),
        )
    }
}
