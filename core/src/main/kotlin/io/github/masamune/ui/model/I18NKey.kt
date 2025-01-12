package io.github.masamune.ui.model

import com.badlogic.gdx.utils.I18NBundle

// This is an autogenerated class by gradle's 'genI18nKeys' task. Do not touch it!
enum class I18NKey(val key: String) {
    COMBAT_DEFEAT("combat.defeat"),
    COMBAT_DEFEATED_ENEMIES("combat.defeatedEnemies"),
    COMBAT_LEVEL_UPS("combat.levelUps"),
    COMBAT_MISS("combat.miss"),
    COMBAT_TOTAL_TALONS("combat.totalTalons"),
    COMBAT_TOTAL_XP("combat.totalXp"),
    DIALOG_ELDER_00_PAGE1("dialog.elder_00.page1"),
    DIALOG_ELDER_00_PAGE2("dialog.elder_00.page2"),
    DIALOG_ELDER_00_PAGE3("dialog.elder_00.page3"),
    DIALOG_ELDER_10_PAGE1("dialog.elder_10.page1"),
    DIALOG_FLOWER_GIRL_00_PAGE1("dialog.flower_girl_00.page1"),
    DIALOG_FLOWER_GIRL_00_PAGE2("dialog.flower_girl_00.page2"),
    DIALOG_FLOWER_GIRL_00_PAGE3("dialog.flower_girl_00.page3"),
    DIALOG_FLOWER_GIRL_00_PAGE4("dialog.flower_girl_00.page4"),
    DIALOG_FLOWER_GIRL_10_PAGE1("dialog.flower_girl_10.page1"),
    DIALOG_MERCHANT_00_PAGE1("dialog.merchant_00.page1"),
    DIALOG_OPTION_BUY("dialog.option.buy"),
    DIALOG_OPTION_EXIT("dialog.option.exit"),
    DIALOG_OPTION_NEXT("dialog.option.next"),
    DIALOG_OPTION_OK("dialog.option.ok"),
    DIALOG_SMITH_00_PAGE1("dialog.smith_00.page1"),
    DIALOG_VILLAGE_EXIT_PAGE1("dialog.villageExit.page1"),
    ENEMY_BUTTERFLY_NAME("enemy.butterfly.name"),
    ENEMY_LARVA_NAME("enemy.larva.name"),
    ENEMY_MUSHROOM_NAME("enemy.mushroom.name"),
    GENERAL_NO("general.no"),
    GENERAL_TOTAL("general.total"),
    GENERAL_YES("general.yes"),
    ITEM_BOOTS_DESCRIPTION("item.boots.description"),
    ITEM_BOOTS_NAME("item.boots.name"),
    ITEM_CATEGORY_ACCESSORY("item.category.accessory"),
    ITEM_CATEGORY_ARMOR("item.category.armor"),
    ITEM_CATEGORY_BOOTS("item.category.boots"),
    ITEM_CATEGORY_HELMET("item.category.helmet"),
    ITEM_CATEGORY_WEAPON("item.category.weapon"),
    ITEM_ELDER_SWORD_DESCRIPTION("item.elder_sword.description"),
    ITEM_ELDER_SWORD_NAME("item.elder_sword.name"),
    ITEM_HELMET_DESCRIPTION("item.helmet.description"),
    ITEM_HELMET_NAME("item.helmet.name"),
    ITEM_INFO_CONSUMABLE("item.info.consumable"),
    ITEM_RING_DESCRIPTION("item.ring.description"),
    ITEM_RING_NAME("item.ring.name"),
    ITEM_SCROLL_INFERNO_DESCRIPTION("item.scroll_inferno.description"),
    ITEM_SCROLL_INFERNO_NAME("item.scroll_inferno.name"),
    ITEM_SMALL_HEALTH_POTION_DESCRIPTION("item.small_health_potion.description"),
    ITEM_SMALL_HEALTH_POTION_NAME("item.small_health_potion.name"),
    ITEM_SMALL_MANA_POTION_DESCRIPTION("item.small_mana_potion.description"),
    ITEM_SMALL_MANA_POTION_NAME("item.small_mana_potion.name"),
    ITEM_STUDDED_LEATHER_DESCRIPTION("item.studded_leather.description"),
    ITEM_STUDDED_LEATHER_NAME("item.studded_leather.name"),
    LOADING_ASSETS("loading.assets"),
    LOADING_DONE("loading.done"),
    MAGIC_FIREBALL_NAME("magic.fireball.name"),
    MAGIC_FIREBOLT_NAME("magic.firebolt.name"),
    MAGIC_HEAL_NAME("magic.heal.name"),
    MAGIC_TARGET_ALL("magic.target.all"),
    MAGIC_TARGET_MULTI("magic.target.multi"),
    MAGIC_TARGET_SINGLE("magic.target.single"),
    MENU_OPTION_ACCESSORY("menu.option.accessory"),
    MENU_OPTION_ARMOR("menu.option.armor"),
    MENU_OPTION_CLEAR_ITEM("menu.option.clearItem"),
    MENU_OPTION_EQUIPMENT("menu.option.equipment"),
    MENU_OPTION_INVENTORY("menu.option.inventory"),
    MENU_OPTION_ITEM("menu.option.item"),
    MENU_OPTION_QUESTS("menu.option.quests"),
    MENU_OPTION_QUIT("menu.option.quit"),
    MENU_OPTION_SAVE("menu.option.save"),
    MENU_OPTION_SELL("menu.option.sell"),
    MENU_OPTION_STATS("menu.option.stats"),
    MENU_OPTION_WEAPON("menu.option.weapon"),
    NPC_ELDER_TITLE("npc.elder.title"),
    NPC_FLOWER_GIRL_TITLE("npc.flower_girl.title"),
    NPC_MERCHANT_TITLE("npc.merchant.title"),
    NPC_SMITH_TITLE("npc.smith.title"),
    SHOP_CONFIRM_BUY("shop.confirmBuy"),
    SHOP_CONFIRM_SELL("shop.confirmSell"),
    STATS_AGILITY("stats.agility"),
    STATS_ARCANE_STRIKE("stats.arcaneStrike"),
    STATS_ARMOR("stats.armor"),
    STATS_ATTACK("stats.attack"),
    STATS_CONSTITUTION("stats.constitution"),
    STATS_CRITICAL_STRIKE("stats.criticalStrike"),
    STATS_INTELLIGENCE("stats.intelligence"),
    STATS_LEVEL("stats.level"),
    STATS_LIFE("stats.life"),
    STATS_LIFE_MAX("stats.lifeMax"),
    STATS_MAGICAL_EVADE("stats.magicalEvade"),
    STATS_MANA("stats.mana"),
    STATS_MANA_MAX("stats.manaMax"),
    STATS_PHYSICAL_EVADE("stats.physicalEvade"),
    STATS_RESISTANCE("stats.resistance"),
    STATS_STRENGTH("stats.strength"),
    STATS_TALONS("stats.talons"),
    STATS_XP("stats.xp"),
    STATS_XP_NEEDED("stats.xpNeeded"),
}

operator fun I18NBundle.get(key: I18NKey): String = this[key.key]
