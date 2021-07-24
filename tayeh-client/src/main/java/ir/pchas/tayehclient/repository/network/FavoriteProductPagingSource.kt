package ir.pchas.tayehclient.repository.network

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ir.pchas.tayehclient.model.Product
import retrofit2.HttpException
import java.io.IOException

private const val STARTING_PAGE_INDEX = 0

public class FavoriteProductPagingSource(
    private val tayehAPI: TayehAPI,
    private val token: String,
) : PagingSource<Int, Product>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Product> {
        val nextPageNumber = params.key ?: STARTING_PAGE_INDEX

        return try {
            val products =
                tayehAPI.getCustomerFavoriteProductList(
                    tokenString = token,
                    page = nextPageNumber,
                    perPage = params.loadSize
                )

            LoadResult.Page(
                data = products,
                prevKey = if (nextPageNumber == STARTING_PAGE_INDEX) null else nextPageNumber - 1,
                nextKey = if (products.isEmpty()) null else nextPageNumber + 1
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Product>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}