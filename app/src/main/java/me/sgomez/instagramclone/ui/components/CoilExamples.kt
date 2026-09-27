package me.sgomez.instagramclone.ui.components

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import me.sgomez.instagramclone.model.Post

@Composable
fun BasicCoilImage() {
    AsyncImage(
        model = "https://picsum.photos/seed/post1/800/800",
        contentDescription = "Foto del post",
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun AdvancedCoilImage(post: Post) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(post.imageUrl)
            .crossfade(true)
            .build(),
        contentDescription = "Post de ${post.username}",
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f),
        contentScale = ContentScale.Crop,
        placeholder = painterResource(R.drawable.placeholder),
        error = painterResource(R.drawable.ic_error)
    )
}

@Composable
fun CircularAvatar(post: Post) {
    AsyncImage(
        model = post.profileImageUrl,
        contentDescription = "Avatar",
        modifier = Modifier
            .size(36.dp)
            .clip(CircleShape),
        contentScale = ContentScale.Crop
    )
}