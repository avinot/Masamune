package io.github.masamune.component

import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.math.Vector3
import com.github.quillraven.fleks.Component
import com.github.quillraven.fleks.ComponentType

/**
 * Component for [position], [size], [scale] and [rotation] values of an entity.
 * The default scale value is one world unit (=1).
 * The rotation is in degrees.
 */
data class Transform(
    val position: Vector3,
    val size: Vector2,
    var scale: Float = 1f,
    var rotation: Float = 0f,
) : Component<Transform>, Comparable<Transform> {

    fun centerTo(result: Vector2) {
        result.x = position.x + size.x * 0.5f
        result.y = position.y + size.y * 0.5f
    }

    operator fun contains(location: Vector2): Boolean {
        return TMP_RECT
            .set(position.x, position.y, size.x, size.y)
            .contains(location)
    }

    override fun type() = Transform

    override fun compareTo(other: Transform): Int {
        return when {
            position.z > other.position.z -> 1
            position.z < other.position.z -> -1
            position.y > other.position.y -> -1
            position.y < other.position.y -> 1
            position.x > other.position.x -> 1
            position.x < other.position.x -> -1
            else -> 0
        }
    }

    companion object : ComponentType<Transform>() {
        private val TMP_RECT = Rectangle()
    }
}
