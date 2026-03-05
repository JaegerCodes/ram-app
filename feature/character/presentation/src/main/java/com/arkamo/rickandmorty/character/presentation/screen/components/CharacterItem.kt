package com.arkamo.rickandmorty.character.presentation.screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import com.arkamo.rickandmorty.designsystem.theme.RamTheme
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.arkamo.rickandmorty.character.domain.model.Character
import com.arkamo.rickandmorty.character.domain.model.CharacterStatus
import com.arkamo.rickandmorty.feature.character.presentation.R

@Composable
fun CharacterItem(
    character: Character,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AsyncImage(
                model = character.imageUrl,
                contentDescription = "Avatar of ${character.name}",
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.ic_placeholder),
                error = painterResource(id = R.drawable.ic_error_image),
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape),
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = character.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface,
                )

                StatusBadge(
                    status = character.status,
                    modifier = Modifier.padding(top = 4.dp),
                )

                Text(
                    text = character.species,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(top = 2.dp),
                    fontSize = 12.sp,
                )
            }
        }
    }
}

@Composable
private fun StatusBadge(
    status: CharacterStatus,
    modifier: Modifier = Modifier,
) {
    val colors = RamTheme.colors
    val (dotColor, label) = when (status) {
        CharacterStatus.ALIVE -> colors.support.positive.medium to "Alive"
        CharacterStatus.DEAD -> colors.brand.primary.medium to "Dead"
        CharacterStatus.UNKNOWN -> colors.neutral.grayscale.dark to "Unknown"
    }

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .size(8.dp)
                .background(color = dotColor, shape = CircleShape),
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
    }
}
