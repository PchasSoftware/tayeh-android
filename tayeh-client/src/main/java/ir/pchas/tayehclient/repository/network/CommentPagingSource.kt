package ir.pchas.tayehclient.repository.network

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ir.pchas.tayehclient.model.Comment
import retrofit2.HttpException
import java.io.IOException

private const val STARTING_PAGE_INDEX = 0

public class CommentPagingSource(
    private val tayehAPI: TayehAPI,
    private val token: String,
    private val productId: String,
) : PagingSource<Int, Comment>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Comment> {
        val nextPageNumber = params.key ?: STARTING_PAGE_INDEX

        return try {
            val response = tayehAPI.getProductComments(
                tokenString = token,
                productId = productId,
                page = nextPageNumber,
                perPage = params.loadSize
            )
            val comments = response.comments

            LoadResult.Page(
                data = comments,
                prevKey = if (nextPageNumber == STARTING_PAGE_INDEX) null else nextPageNumber - 1,
                nextKey = if (comments.isEmpty()) null else nextPageNumber + 1
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Comment>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}