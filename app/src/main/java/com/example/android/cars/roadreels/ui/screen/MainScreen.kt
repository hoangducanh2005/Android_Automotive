/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.cars.roadreels.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.android.cars.roadreels.R

private const val NUM_ROWS = 1
private const val NUM_ITEMS_PER_ROW = 6

data class MovieItem(
    val id: Int,
    val title: String,
    val thumbnailResId: Int,
    val videoResId: Int
)

private val MOVIE_LIST = listOf(
    MovieItem(1, "Đóa Hồng", R.drawable.doahong, R.raw.doahong),
    MovieItem(2, "Khách Thơ", R.drawable.khach_tho, R.raw.khachtho),
    MovieItem(3, "Chưa Bao Giờ", R.drawable.chuabaogio, R.raw.chuabaogio),
    MovieItem(4, "LK Dạ Vàng", R.drawable.lkdavang, R.raw.lkdavang),
    MovieItem(5, "Cô Gái Đến Từ Hôm Qua", R.drawable.cogaidentuhomqua, R.raw.cogaidentuhomqua),
    MovieItem(6, "Vẹn Nguyên", R.drawable.vennguyen, R.raw.vennguyen),
    MovieItem(7, "Ending Đà Lạt", R.drawable.endingdalat, R.raw.endingdalat)
)

private val THUMBNAIL_IDS = listOf(
    R.drawable.doahong
)

@Composable
fun MainScreen(
    onItemSelected: (thumbnailId: Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier,
        contentPadding = PaddingValues(bottom = dimensionResource(R.dimen.screen_edge_padding))
    ) {
        items(NUM_ROWS) {
            Text(
                "My Videos", // Tiêu đề danh sách phim
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .padding(
                        horizontal = dimensionResource(R.dimen.screen_edge_padding),
                        vertical = dimensionResource(R.dimen.row_header_vertical_padding)
                    )
            )

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.list_item_spacing)),
                contentPadding = PaddingValues(horizontal = dimensionResource(R.dimen.screen_edge_padding))
            ) {
                items(NUM_ITEMS_PER_ROW) {
                    val thumbnailId = THUMBNAIL_IDS[0]

                    Image(
                        painter = painterResource(thumbnailId),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clickable { onItemSelected(thumbnailId) }
                            .size(width = 320.dp, height = 180.dp)
                            .clip(MaterialTheme.shapes.medium)
                    )
                }
            }
        }
    }
}
