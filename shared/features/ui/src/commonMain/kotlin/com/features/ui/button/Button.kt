package com.features.ui.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.features.ui.Res
import com.features.ui.ic_back
import com.features.ui.theme.MainTheme
import com.features.ui.theme.invert
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MainButton(
    modifier: Modifier = Modifier,
    text: String,
    contentColor: Color = MainTheme.colors.white,
    textStyle: TextStyle = MainTheme.typography.main.buttonText,
    backgroundColor: Color = MainTheme.colors.secondary,
    disabledColor: Color = MainTheme.colors.gray,
    disabledContentColor: Color = contentColor.invert(),
    isLoading: Boolean = false,
    isEnabled: Boolean = true,
    leadingIcon: (@Composable () -> Unit)? = null,
    traillingIcon: (@Composable () -> Unit)? = null,
    onClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(5.dp))
            .background(if (isEnabled) backgroundColor else disabledColor)
            .fillMaxWidth()
            .height(48.dp)
            .clickable {
                if (isEnabled && !isLoading) {
                    onClick()
                }
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(22.dp),
                color = if (isEnabled) MainTheme.colors.white else MainTheme.colors.thirdly,
                trackColor = MainTheme.colors.transparent,
                strokeWidth = 2.dp,
                strokeCap = StrokeCap.Square
            )
        } else {
            leadingIcon?.invoke()

            Text(
                text = text,
                style = textStyle,
                color = if (isEnabled) contentColor else disabledContentColor,
                textAlign = TextAlign.Center
            )

            traillingIcon?.invoke()
        }
    }
}

@Preview
@Composable
internal fun MainButton_Preview() {
    MainTheme {
        Column(
            modifier = Modifier
                .background(MainTheme.colors.primary)
                .padding(32.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            MainButton(
                text = "First Button", onClick = {})
            MainButton(
                modifier = Modifier
                    .shadow(elevation = 5.dp),
                text = "Second button",
                backgroundColor = MainTheme.colors.white,
                contentColor = MainTheme.colors.thirdly,
                textStyle = MainTheme.typography.main.secondButtonText
            ) {

            }

            Row(modifier = Modifier) {
                Spacer(
                    modifier = Modifier
                        .weight(1.0f)
                )

                MainButton(
                    modifier = Modifier
                        .weight(1.0f),
                    text = "3000",
                    backgroundColor = MainTheme.colors.secondary,
                    contentColor = MainTheme.colors.white,
                    disabledColor = MainTheme.colors.secondary.copy(0.6f),
                    disabledContentColor = MainTheme.colors.white.copy(0.6f),
                    isEnabled = true,
                    leadingIcon = {
                        Image(
                            modifier = Modifier
                                .padding(vertical = 4.dp, horizontal = 4.dp)
                                .size(24.dp),
                            painter = painterResource(Res.drawable.ic_back),
                            contentDescription = null,
                            alpha = 1.0f
                        )
                    }, onClick = {})
                Spacer(
                    modifier = Modifier
                        .weight(1.0f)
                )
            }

            MainButton(
                modifier = Modifier
                    .padding(),
                text = "Loading Button", onClick = {},
                isLoading = true
            )
        }
    }
}