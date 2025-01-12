package io.github.masamune.tiledmap

import io.github.masamune.combat.action.*

// This is an autogenerated class by gradle's 'genTiledEnumsAndExtensions' task. Do not touch it!
enum class ActionType(private val actionFactory: () -> Action) {
    ATTACK_SINGLE(::AttackSingleAction),
    FIREBALL(::FireballAction),
    FIREBOLT(::FireboltAction),
    HEAL(::HealAction),
    ITEM_HEALTH_RESTORE(::ItemHealthRestoreAction),
    ITEM_MANA_RESTORE(::ItemManaRestoreAction),
    SCROLL_INFERNO(::ScrollInfernoAction),
    TRANSFORM(::TransformAction),
    UNDEFINED({ DefaultAction }),
    USE_ITEM(::UseItemAction),
    ;

    operator fun invoke() = actionFactory()
}
