import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.displayjsondata.Article
import com.example.displayjsondata.ArticleRepository
import kotlinx.coroutines.launch

class ArticleViewModel(private val repository: ArticleRepository) : ViewModel() {

    private val _articleList = MutableLiveData<List<Article>>()

    val articles: LiveData<List<Article>> = _articleList

    fun getArticles() {
        viewModelScope.launch {
            _articleList.value = repository.getArticles();
        }
    }
}