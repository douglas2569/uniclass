package com.example.uniclass.compoments

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uniclass.R

@Composable
fun ProfileImagem(
    @DrawableRes drawable: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(painter = painterResource(id = drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape),
        )
        Text(
            text = "Victoria Robertson" ,
            modifier = Modifier.paddingFromBaseline(
                top = 24.dp, bottom = 8.dp)
        )

        Text(
            text = "A mantra goes here",
            modifier = Modifier.paddingFromBaseline(
                top = 24.dp, bottom = 8.dp
            )
        )
    }

}

@Preview (showBackground = true, backgroundColor = 0xFFF0EAE2 )
@Composable
fun ProfileImagemPreview() {
    //ProfileImagem(drawable = R.drawable.picture, Text(text = "Douglas Senior ")
}

