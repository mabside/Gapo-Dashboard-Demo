package com.kienht.gapo.dashboard.news_feed.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import com.kienht.gapo.dashboard.domain.usecase.news.model.FriendRequest
import kotlinx.android.parcel.Parcelize

/**
 * @author kienht
 * @company OICSoft
 * @since 16/05/2020
 */
@Parcelize
data class FriendRequestViewData(
    val id: Long,
    val friendName: String,
    val friendAvatar: String,
    val mutualFriendsCount: Int
) : Parcelable {

    object DiffItemCallback : DiffUtil.ItemCallback<FriendRequestViewData>() {
        override fun areItemsTheSame(
            oldItem: FriendRequestViewData,
            newItem: FriendRequestViewData
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: FriendRequestViewData,
            newItem: FriendRequestViewData
        ): Boolean {
            return oldItem.mutualFriendsCount == newItem.mutualFriendsCount
        }
    }
}

internal fun FriendRequest.mapToViewData() =
    FriendRequestViewData(id, friendName, friendAvatar, mutualFriendsCount)

internal fun List<FriendRequest>?.mapToViewData() = this?.map { it.mapToViewData() }