package com.example.githup.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.githup.data.models.RepoModel
import com.example.githup.data.source.remote.EndPoints

class RepoDataSource (
    val backend: EndPoints
) : PagingSource<Int, RepoModel>() {
    override suspend fun load(
        params: LoadParams<Int>
    ): LoadResult<Int, RepoModel> {
        try {
            // Start refresh at page 1 if undefined.
//            val nextPageNumber = params.key ?: 1
            val currentPageNumber = params.key ?: 1
            val prevKey = if (currentPageNumber == 1) null else currentPageNumber - 1
            val nextKey = if (currentPageNumber == 1) null else currentPageNumber + 1

            val response = backend.callHome( currentPageNumber )

            return LoadResult.Page(
                data = response,
                prevKey = prevKey, // Only paging forward.
                nextKey = null
            )
        } catch (e: Exception) {
            // Handle errors in this block and return LoadResult.Error if it is an
            // expected error (such as a network failure).
            return LoadResult.Error(e)
        }

    }

    override fun getRefreshKey(state: PagingState<Int, RepoModel>): Int? {
        // Try to find the page key of the closest page to anchorPosition, from
        // either the prevKey or the nextKey, but you need to handle nullability
        // here:
        //  * prevKey == null -> anchorPage is the first page.
        //  * nextKey == null -> anchorPage is the last page.
        //  * both prevKey and nextKey null -> anchorPage is the initial page, so
        //    just return null.
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}