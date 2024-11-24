package io.github.masamune.ui.model

import com.badlogic.gdx.utils.I18NBundle
import com.github.quillraven.fleks.Entity
import com.github.quillraven.fleks.World
import io.github.masamune.component.Experience
import io.github.masamune.component.Inventory
import io.github.masamune.component.Stats
import io.github.masamune.event.EventListener
import ktx.app.gdxError
import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

abstract class ViewModel(val bundle: I18NBundle) : EventListener {

    @PublishedApi
    internal val actionsMap = mutableMapOf<KProperty<*>, MutableList<(Any) -> Unit>>()

    inline fun <reified T : Any> propertyNotify(initialValue: T): ReadWriteProperty<ViewModel, T> =
        Delegates.observable(initialValue) { property, _, newValue -> notify(property, newValue) }

    @Suppress("UNCHECKED_CAST")
    inline fun <reified T> onPropertyChange(property: KProperty<T>, noinline action: (T) -> Unit) {
        val actions = actionsMap.getOrPut(property) { mutableListOf() } as MutableList<(T) -> Unit>
        actions += action
    }

    fun notify(property: KProperty<*>, value: Any) {
        actionsMap[property]?.forEach { action -> action(value) }
    }

    fun Stats.toUiMap(): MutableMap<UIStats, String> {
        val stats = this.tiledStats
        return mutableMapOf(
            UIStats.AGILITY to "${stats.agility.toInt()}",
            UIStats.ARCANE_STRIKE to "${(stats.arcaneStrike * 100).toInt()}%",
            UIStats.ARMOR to "${stats.armor.toInt()}",
            UIStats.CONSTITUTION to "${stats.constitution.toInt()}",
            UIStats.CRITICAL_STRIKE to "${(stats.criticalStrike * 100).toInt()}%",
            UIStats.DAMAGE to "${stats.damage.toInt()}",
            UIStats.INTELLIGENCE to "${stats.intelligence.toInt()}",
            UIStats.LIFE to "${stats.life.toInt()}",
            UIStats.LIFE_MAX to "${stats.lifeMax.toInt()}",
            UIStats.MAGICAL_EVADE to "${(stats.magicalEvade * 100).toInt()}%",
            UIStats.MANA to "${stats.mana.toInt()}",
            UIStats.MANA_MAX to "${stats.manaMax.toInt()}",
            UIStats.PHYSICAL_EVADE to "${(stats.physicalEvade * 100).toInt()}%",
            UIStats.RESISTANCE to "${stats.resistance.toInt()}",
            UIStats.STRENGTH to "${stats.strength.toInt()}",
        )
    }

    fun Experience.toUiMap(): MutableMap<UIStats, String> {
        return mutableMapOf(
            UIStats.LEVEL to "${this.level}",
            UIStats.XP to "${this.current}",
            UIStats.XP_NEEDED to "${this.forLevelUp}",
        )
    }

    fun Inventory.toUiMap(): MutableMap<UIStats, String> {
        return mutableMapOf(
            UIStats.TALONS to "${this.talons}",
        )
    }

    infix fun MutableMap<UIStats, String>.and(other: Map<UIStats, String>): MutableMap<UIStats, String> {
        this.putAll(other)
        return this
    }

    fun i18nTxt(key: I18NKey): String = bundle[key]

    // function to get game object descriptions like for items.
    // It detects special strings like %STAT.MANA% and replaces it with the proper entity data
    fun description(key: String, entity: Entity, world: World): String {
        // user format method of bundle to correctly replace colors like {{COLOR=ROYAL}}
        val description = bundle.format(key)
        return description.replace(DESCR_TOKEN_REGEX) {
            when (it.groupValues[1]) {
                "STAT" -> replaceStatToken(it.groupValues[2], entity, world)
                else -> gdxError("Unsupported description token in key $key: ${it.groupValues.first()}")
            }
        }
    }

    private fun replaceStatToken(statName: String, entity: Entity, world: World): String = with(world) {
        val stats = entity[Stats].tiledStats
        when (statName) {
            "AGI" -> "${stats.agility.toInt()}"
            "ARCSTR" -> "${(stats.arcaneStrike * 100).toInt()}%"
            "ARMOR" -> "${stats.armor.toInt()}"
            "CONST" -> "${stats.constitution.toInt()}"
            "CRISTR" -> "${(stats.criticalStrike * 100).toInt()}%"
            "DAMAGE" -> "${stats.damage.toInt()}"
            "INT" -> "${stats.intelligence.toInt()}"
            "LIFE" -> "${stats.life.toInt()}"
            "MAXLIFE" -> "${stats.lifeMax.toInt()}"
            "MAGEVA" -> "${(stats.magicalEvade * 100).toInt()}%"
            "MANA" -> "${stats.mana.toInt()}"
            "MAXMANA" -> "${stats.manaMax.toInt()}"
            "PHYEVA" -> "${(stats.physicalEvade * 100).toInt()}%"
            "RES" -> "${stats.resistance.toInt()}"
            "STR" -> "${stats.strength.toInt()}"
            else -> gdxError("Unsupported stat: $statName")
        }
    }

    companion object {
        // format example: %STAT.MANA%
        private val DESCR_TOKEN_REGEX = "%([A-Z]+)\\.([A-Z]+)%".toRegex()
    }
}
