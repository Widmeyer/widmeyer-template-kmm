package com.features.ui.button

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.features.ui.theme.MainTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun TextButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    normalTextColor: Color = MainTheme.colors.primary,
    textStyle: TextStyle = MainTheme.typography.main.buttonText,
) {
    val isPressed = remember { mutableStateOf(false) }

    BasicText(
        text = text,
        modifier = modifier
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        isPressed.value = true
                        tryAwaitRelease()
                        isPressed.value = false
                        onClick()
                    }
                )
            },
        style = textStyle.copy(
            color = if (isPressed.value) normalTextColor.copy(alpha = 0.7f) else normalTextColor
        )
    )
}


@Preview
@Composable
internal fun TextButton_Preview() {
    Column(
        modifier = Modifier
            .padding(2.dp)
    ) {
        TextButton(
            text = "Click Me",
            onClick = { },
        )
    }
}